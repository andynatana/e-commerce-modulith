package andy.microservices.ecommerce.products.models.vos;

public record ProductId(Long id) {
    public ProductId() {
        this(null);
    }
}
