package andy.microservices.ecommerce;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;

@SpringBootTest
class ECommerceApplicationTests {

    ApplicationModules applicationModules = ApplicationModules.of(ECommerceApplication.class);

    @Test
    void shouldVerifyArchitecture() {
        applicationModules.forEach(System.out::println);
        applicationModules.verify();
    }

}
