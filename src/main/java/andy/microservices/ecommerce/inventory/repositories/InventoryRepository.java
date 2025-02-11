package andy.microservices.ecommerce.inventory.repositories;

import andy.microservices.ecommerce.inventory.models.Inventory;
import org.springframework.data.repository.ListCrudRepository;

public interface InventoryRepository extends ListCrudRepository<Inventory, Long> {
}
