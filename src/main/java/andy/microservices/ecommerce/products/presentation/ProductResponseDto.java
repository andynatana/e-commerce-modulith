package andy.microservices.ecommerce.products.presentation;

import java.math.BigDecimal;

public record ProductResponseDto(Long productId, BigDecimal price, String description) {
}
