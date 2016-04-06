package performance.configuration;


import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import performance.domain.Order;
import performance.dto.OrderDTO;


/**
 * Created by adelfiri on 4/7/15.
 */
public class OrderOrikaMapperFactory {

    private MapperFacade mapperFacade = null;


    private MapperFacade getMapperFacade() {

        MapperFactory factory = new DefaultMapperFactory.Builder().build();

        factory.classMap(Order.class, OrderDTO.class).field("customer.name", "customerName")
                .field("customer.billingAddress.street",
                        "billingStreetAddress")
                .field("customer.billingAddress.city", "billingCity")
                .field("customer.shippingAddress.street",
                        "shippingStreetAddress")
                .field("customer.shippingAddress.city",
                        "shippingCity")
                .field("products", "products").register();


        mapperFacade = factory.getMapperFacade();
        return mapperFacade;
    }


    public MapperFacade getObject()  {
        return getMapperFacade();
    }

}
