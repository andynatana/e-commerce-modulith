package andy.microservices.ecommerce.products.models.vos;

import java.util.UUID;

public record ProductId(UUID id) {
    public ProductId() {
        this(UUID.randomUUID());
    }
}
