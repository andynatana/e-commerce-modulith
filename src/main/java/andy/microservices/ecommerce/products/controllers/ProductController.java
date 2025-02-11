package andy.microservices.ecommerce.products.controllers;

import andy.microservices.ecommerce.products.ProductManagement;
import andy.microservices.ecommerce.products.presentation.ProductRequestDto;
import andy.microservices.ecommerce.products.presentation.ProductResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        productManagement.fillStock(productRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getAll() {
        return ResponseEntity.ok(productManagement.getAll());
    }
}
