package andy.microservices.ecommerce.products.mappers;

import andy.microservices.ecommerce.products.models.Product;
import andy.microservices.ecommerce.products.models.vos.Price;
import andy.microservices.ecommerce.products.models.vos.ProductDescription;
import andy.microservices.ecommerce.products.models.vos.ProductId;
import andy.microservices.ecommerce.products.models.vos.ProductName;
import andy.microservices.ecommerce.products.presentation.ProductRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.math.BigDecimal;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "quantityInStock", source = "quantity")
    @Mapping(target = "lastUpdateTimestamp", ignore = true)
    @Mapping(target = "creationTimestamp", ignore = true)
    @Mapping(target = "id", source = "productRequestDto", qualifiedByName = "initProductId")
    Product toEntity(ProductRequestDto productRequestDto);

    default ProductName toProductName(String value) {
        return new ProductName(value);
    }

    default ProductDescription toDescription(String value) {
        return new ProductDescription(value);
    }

    default Price toPrice(BigDecimal value) {
        return new Price(value, "USD");
    }

    @Named("initProductId")
    default ProductId initProductId(ProductRequestDto productRequestDto) {
        return new ProductId();
    }
}
