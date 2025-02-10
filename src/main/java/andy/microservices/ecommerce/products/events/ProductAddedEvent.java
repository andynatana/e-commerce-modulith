package andy.microservices.ecommerce.products.events;

import andy.microservices.ecommerce.products.models.vos.ProductId;

public record ProductAddedEvent(ProductId productId) {
}
