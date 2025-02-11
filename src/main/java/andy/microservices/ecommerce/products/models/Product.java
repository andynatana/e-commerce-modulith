package andy.microservices.ecommerce.products.models;

import andy.microservices.ecommerce.products.models.vos.Price;
import andy.microservices.ecommerce.products.models.vos.ProductDescription;
import andy.microservices.ecommerce.products.models.vos.ProductName;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @AttributeOverride(name = "name", column = @Column(name = "product_name"))
    private ProductName name;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "description"))
    private ProductDescription description;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "price"))
    private Price price;

    @CreationTimestamp
    private LocalDateTime creationTimestamp;

    @UpdateTimestamp
    private LocalDateTime lastUpdateTimestamp;

    public ProductName getName() {
        return name;
    }

    public void setName(ProductName name) {
        this.name = name;
    }

    public ProductDescription getDescription() {
        return description;
    }

    public void setDescription(ProductDescription description) {
        this.description = description;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public LocalDateTime getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(LocalDateTime creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public LocalDateTime getLastUpdateTimestamp() {
        return lastUpdateTimestamp;
    }

    public void setLastUpdateTimestamp(LocalDateTime lastUpdateTimestamp) {
        this.lastUpdateTimestamp = lastUpdateTimestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
