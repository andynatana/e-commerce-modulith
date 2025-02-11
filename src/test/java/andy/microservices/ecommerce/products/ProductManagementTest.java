package andy.microservices.ecommerce.products;

import andy.microservices.ecommerce.products.presentation.ProductRequestDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;

@SpringBootTest
class ProductManagementTest {

    @Autowired
    private ProductManagement productManagement;

    @Test
    @Transactional
    void fillStock() {
        productManagement.fillStock(new ProductRequestDto("test","test", BigDecimal.ONE, BigInteger.ONE));
    }
}