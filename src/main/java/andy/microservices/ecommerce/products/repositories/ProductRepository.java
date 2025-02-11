package andy.microservices.ecommerce.products.repositories;

import andy.microservices.ecommerce.products.models.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ListCrudRepository<Product, Long> {

    @Query(nativeQuery = true, value = "SELECT nextval(:seqName)")
    Long getSequence(@Param("sequenceName") String sequenceName);
}
