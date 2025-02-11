package andy.microservices.ecommerce.inventory.listeners;

import andy.microservices.ecommerce.inventory.models.Inventory;
import andy.microservices.ecommerce.inventory.models.enums.InventoryFlux;
import andy.microservices.ecommerce.inventory.repositories.InventoryRepository;
import andy.microservices.ecommerce.products.ProductManagement;
import andy.microservices.ecommerce.products.events.ProductAddedEvent;
import andy.microservices.ecommerce.products.presentation.ProductResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

@Service
public class ProductAddedEventListener {

    private static final Logger log = LoggerFactory.getLogger(ProductAddedEventListener.class);

    private InventoryRepository inventoryRepository;
    private ProductManagement productManagement;

    public ProductAddedEventListener() {
    }

    @Autowired
    public ProductAddedEventListener(InventoryRepository inventoryRepository, ProductManagement productManagement) {
        this.inventoryRepository = inventoryRepository;
        this.productManagement = productManagement;
    }

    @ApplicationModuleListener
    public void handleProductAdded(final ProductAddedEvent event) {
        ProductResponseDto product = productManagement.getById(event.productId());

        // now add product into inventory
        Inventory inventory = getInventory(event, product);
        inventoryRepository.save(inventory);

        log.info("Inventory updated for  {}, inventory ID : {}", event.productId(), inventory.getId());
    }

    private static Inventory getInventory(ProductAddedEvent event, ProductResponseDto product) {
        Inventory inventory = new Inventory();
        inventory.setProductId(product.productId());
        inventory.setUnitPrice(product.price());
        inventory.setQuantity(event.quantity());
        inventory.setInventoryFlux(InventoryFlux.IN);
        return inventory;
    }
}
