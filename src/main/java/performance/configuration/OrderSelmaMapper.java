package performance.configuration;

import fr.xebia.extras.selma.Field;
import fr.xebia.extras.selma.Mapper;
import fr.xebia.extras.selma.Selma;
import performance.domain.Order;
import performance.domain.Product;
import performance.dto.OrderDTO;
import performance.dto.ProductDTO;

/**
 * @author adelfiri, <a href="mailto:Konstantin.Molodtsov@returnonintelligence.com">Konstantin Molodtsov</a>
 * @since 01 July 2016
 */
@Mapper(
        withCustomFields = {
                @Field({"customerName", "customer.name"}),
                @Field({"billingStreetAddress", "customer.billingAddress.street"}),
                @Field({"billingCity", "customer.billingAddress.city"}),
        @Field({"shippingStreetAddress", "customer.shippingAddress.street"}),
        @Field({"shippingCity", "customer.shippingAddress.city"})
        }
)
public interface OrderSelmaMapper {

    OrderSelmaMapper INSTANCE = Selma.builder(OrderSelmaMapper.class).build();

    OrderDTO map(Order source);

  //  ProductDTO map(Product source);

}
