package andy.microservices.ecommerce.products;

import andy.microservices.ecommerce.products.events.ProductAddedEvent;
import andy.microservices.ecommerce.products.mappers.ProductMapper;
import andy.microservices.ecommerce.products.models.Product;
import andy.microservices.ecommerce.products.presentation.ProductRequestDto;
import andy.microservices.ecommerce.products.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductManagement {

    private ProductRepository productRepository;
    private ProductMapper productMapper;
    private ApplicationEventPublisher eventPublisher;

    public ProductManagement() {
    }

    @Autowired
    public ProductManagement(ProductRepository productRepository, ProductMapper productMapper, ApplicationEventPublisher eventPublisher) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.eventPublisher = eventPublisher;
    }

    public void createProduct(ProductRequestDto productRequestDto) {
        Product product = productMapper.toEntity(productRequestDto);
        productRepository.save(product);

        // add the newly created product into the inventory
        eventPublisher.publishEvent(new ProductAddedEvent(product.getId()));
    }
}
