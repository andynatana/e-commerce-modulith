package andy.microservices.ecommerce.products.mappers;

import andy.microservices.ecommerce.products.models.Product;
import andy.microservices.ecommerce.products.models.vos.Price;
import andy.microservices.ecommerce.products.models.vos.ProductDescription;
import andy.microservices.ecommerce.products.models.vos.ProductName;
import andy.microservices.ecommerce.products.presentation.ProductRequestDto;
import andy.microservices.ecommerce.products.presentation.ProductResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.math.BigDecimal;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "lastUpdateTimestamp", ignore = true)
    @Mapping(target = "creationTimestamp", ignore = true)
    Product toEntity(ProductRequestDto productRequestDto);

    @Mapping(target = "productId", source = "id")
    @Mapping(target = "description", source ="description.value")
    @Mapping(target = "price", source = "price.value")
    ProductResponseDto toResponseDto(Product product);

    default ProductName toProductName(String value) {
        return new ProductName(value);
    }

    default ProductDescription toDescription(String value) {
        return new ProductDescription(value);
    }

    default Price toPrice(BigDecimal value) {
        return new Price(value, "USD");
    }
}
