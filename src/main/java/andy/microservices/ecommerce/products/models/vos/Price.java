package andy.microservices.ecommerce.products.models.vos;

import java.math.BigDecimal;

public record Price(BigDecimal value, String currency) {
}
