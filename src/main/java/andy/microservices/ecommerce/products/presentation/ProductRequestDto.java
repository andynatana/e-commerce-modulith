package andy.microservices.ecommerce.products.presentation;

import java.math.BigDecimal;
import java.math.BigInteger;

public record ProductRequestDto(String name, String description, BigDecimal price, BigInteger quantity) {

}
