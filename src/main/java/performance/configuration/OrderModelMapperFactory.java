package performance.configuration;


import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import performance.domain.Order;
import performance.dto.OrderDTO;



/**
 * Created by adelfiri on 4/7/15.
 */
public class OrderModelMapperFactory  {

    private ModelMapper modelMapper = null;


    private ModelMapper getModelMapper() {
        if (modelMapper == null) {
            modelMapper = new ModelMapper();
            modelMapper.addMappings(new PropertyMap<Order, OrderDTO>() {
                @Override
                protected void configure() {
                    map().setBillingStreetAddress(source.getCustomer().getBillingAddress().getStreet());
                    map().setBillingCity(source.getCustomer().getBillingAddress().getCity());
                    map().setShippingStreetAddress(source.getCustomer().getShippingAddress().getStreet());
                    map().setShippingCity(source.getCustomer().getShippingAddress().getCity());
                }
            });
        }
        return modelMapper;
    }


    public ModelMapper getObject()  {
        return getModelMapper();
    }

}
