package andy.microservices.ecommerce.products.events;

public record ProductAddedEvent(Long productId, Integer quantity) {
}
