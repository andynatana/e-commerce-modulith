package andy.microservices.ecommerce.products.repositories;

import andy.microservices.ecommerce.products.models.Product;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends ListCrudRepository<Product, UUID> {
}
