package andy.microservices.ecommerce.products;

import andy.microservices.ecommerce.products.presentation.ProductRequestDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductManagementTest {

    @Autowired
    private ProductManagement productManagement;

    @Test
    @Transactional
    void createProduct() {
        productManagement.createProduct(new ProductRequestDto("test","test", BigDecimal.ONE, BigInteger.ONE));
    }
}