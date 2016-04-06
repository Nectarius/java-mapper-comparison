package performance.configuration;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import performance.domain.Order;
import performance.domain.Product;
import performance.dto.OrderDTO;
import performance.dto.ProductDTO;

/**
 * @author adelfiri, <a href="mailto:Konstantin.Molodtsov@returnonintelligence.com">Konstantin Molodtsov</a>
 * @since 31 March 2016
 */
@Mapper
public interface OrderMapStructMapper {

    OrderMapStructMapper INSTANCE = Mappers.getMapper(OrderMapStructMapper.class);

    @Mappings({
            @Mapping(target = "customerName",
                    source = "customer.name"),
            @Mapping(target = "billingStreetAddress",
                    source = "customer.billingAddress.street"),
            @Mapping(target = "billingCity",
                    source = "customer.billingAddress.city"),
            @Mapping(target = "shippingStreetAddress",
                    source = "customer.shippingAddress.street"),
            @Mapping(target = "shippingCity",
                    source = "customer.shippingAddress.city")
    })
    OrderDTO map(Order source);

    ProductDTO map(Product source);

}
