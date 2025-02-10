package andy.microservices.ecommerce.products.controllers;

import andy.microservices.ecommerce.products.ProductManagement;
import andy.microservices.ecommerce.products.presentation.ProductRequestDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    private final ProductManagement productManagement;

    @Autowired
    public ProductController(ProductManagement productManagement) {
        this.productManagement = productManagement;
    }

    @PostMapping
    public ResponseEntity<Void> addProduct(@RequestBody ProductRequestDto productRequestDto) {
        log.info("Adding product {}", productRequestDto);
        productManagement.createProduct(productRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
