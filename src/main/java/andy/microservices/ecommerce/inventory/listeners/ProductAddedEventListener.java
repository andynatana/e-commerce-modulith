package andy.microservices.ecommerce.inventory.listeners;

import andy.microservices.ecommerce.inventory.repositories.InventoryRepository;
import andy.microservices.ecommerce.products.events.ProductAddedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

@Service
public class ProductAddedEventListener {

    private InventoryRepository inventoryRepository;

    private static final Logger log = LoggerFactory.getLogger(ProductAddedEventListener.class);

    @ApplicationModuleListener
    public void handleProductAdded(final ProductAddedEvent event) {
        log.info("Product created");

        // now add product into inventory
    }
}
