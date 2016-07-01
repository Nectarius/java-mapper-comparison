package performance;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.dozer.DozerBeanMapper;
import org.modelmapper.ModelMapper;
import org.testng.Assert;

import com.googlecode.jmapper.JMapper;

import ma.glasnost.orika.MapperFacade;
import performance.configuration.OrderMapStructMapper;
import performance.configuration.OrderModelMapperFactory;
import performance.configuration.OrderOrikaMapperFactory;
import performance.configuration.OrderSelmaMapper;
import performance.configuration.SmooksMapper;
import performance.domain.Address;
import performance.domain.Customer;
import performance.domain.Order;
import performance.domain.Product;
import performance.dto.OrderDTO;

/**
 * Semi-useless micro-benchmark comparing object mapping performance in ModelMapper to Dozer and
 * Orika. Based on Bob Lee's Guice micro-benchmark.
 *
 * @author Jonathan Halterman
 */
public class Comparison {
    static final DecimalFormat format = new DecimalFormat();

    interface OrderMapper {
        OrderDTO map(Order source);
    }

    public static void main(String... args) throws Exception {
        Order order = buildOrder();

        // Warm up to initialize mapper internals
        validate(modelMapper, order);
        validate(dozerMapper, order);
        validate(orikaMapper, order);
        validate(jMapperMapper, order);
        validate(mapStructMapper, order);
        validate(selmaMapper, order);
     /*   validate(smooksMapper, order);*/

       for (int i2 = 0; i2 < 10; i2++) {
            iterate(modelMapper, "ModelMapper:  ", order);
            iterate(dozerMapper, "Dozer:   ", order);
            iterate(orikaMapper, "Orika:   ", order);
            iterate(jMapperMapper, "jMapper:   ", order);
            iterate(mapStructMapper, "MapStruct:   ", order);
           iterate(selmaMapper, "Selma:   ", order);
          /*  iterate(smooksMapper, "SmooksMapper:   ", order);*/
            System.out.println();
        }
/*
        System.out.println("Concurrent:");

        for (int i2 = 0; i2 < 10; i2++) {
            concurrentlyIterate(modelMapper, "ModelMapper:  ", order);
            concurrentlyIterate(dozerMapper, "Dozer:   ", order);
            concurrentlyIterate(orikaMapper, "Orika:   ", order);
            concurrentlyIterate(jMapperMapper, "jMapper:   ", order);
            concurrentlyIterate(mapStructMapper, "MapStruct:   ", order);
            System.out.println();
        }*/
    }

    static final OrderMapper smooksMapper = new OrderMapper() {

        public OrderDTO map(Order source) {

            return SmooksMapper.getInstance().map(source);

        }

    };

    static final OrderMapper jMapperMapper = new OrderMapper() {

        final JMapper<OrderDTO, Order> mapper;

        {
            mapper = new JMapper<OrderDTO, Order>(OrderDTO.class, Order.class, "performance/jmapperPerformanceComparison.xml");

        }

        public OrderDTO map(Order source) {
            return mapper.getDestination(source);
        }

    };

    static final OrderMapper selmaMapper = new OrderMapper() {

        public OrderDTO map(Order source) {
            return OrderSelmaMapper.INSTANCE.map(source);
        }
    };

    static final OrderMapper mapStructMapper = new OrderMapper() {

        public OrderDTO map(Order source) {
            return OrderMapStructMapper.INSTANCE.map(source);
        }
    };

    static final OrderMapper modelMapper = new OrderMapper() {
        ModelMapper modelMapper;
        {
            modelMapper =  new OrderModelMapperFactory().getObject();
        }

        public OrderDTO map(Order source) {
            return modelMapper.map(source, OrderDTO.class);
        }
    };

    static final OrderMapper dozerMapper = new OrderMapper() {
        final DozerBeanMapper beanMapper;
        {
            beanMapper = new DozerBeanMapper();
            beanMapper.setMappingFiles(Arrays.asList("performance/dozerPerformanceComparison.xml"));
        }

        public OrderDTO map(Order source) {
            return beanMapper.map(source, OrderDTO.class);
        }
    };

    static final OrderMapper orikaMapper = new OrderMapper() {
        final MapperFacade facade;
        {

            facade = new OrderOrikaMapperFactory().getObject();
        }

        public OrderDTO map(Order source) {
            return facade.map(source, OrderDTO.class);
        }
    };

    static void iterate(OrderMapper orderMapper, String label, Order order) {
        int count = 100000;

        long time = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            try {
                orderMapper.map(order);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        time = System.currentTimeMillis() - time;

        System.out.println(label + format.format(count * 1000 / time) + " map operations / second");
    }

    static void concurrentlyIterate(final OrderMapper orderMapper, String label, final Order order) {
        int threadCount = 10;
        final int count = 10000;

        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread() {
                public void run() {
                    for (int i = 0; i < count; i++) {
                        try {
                            validate(orderMapper, order);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            };
        }

        long time = System.currentTimeMillis();

        for (int i = 0; i < threadCount; i++) {
            threads[i].start();
        }

        for (int i = 0; i < threadCount; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        time = System.currentTimeMillis() - time;

        System.out.println(label + format.format(count * 1000 / time) + " map operations / second");
    }

    static Order buildOrder() {
        Order order = new Order();
        order.setCustomer(new Customer());
        order.getCustomer().setName("Joe Smith");
        order.getCustomer().setBillingAddress(new Address());
        order.getCustomer().getBillingAddress().setStreet("1234 Market Street");
        order.getCustomer().getBillingAddress().setCity("San Fran");
        order.getCustomer().setShippingAddress(new Address());
        order.getCustomer().getShippingAddress().setStreet("1234 West Townsend");
        order.getCustomer().getShippingAddress().setCity("Boston");
        order.setProducts(new ArrayList<Product>());
        order.getProducts().add(new Product("socks"));
        order.getProducts().add(new Product("shoes"));
        return order;
    }

    static void validate(OrderMapper orderMapper, Order source) throws Exception {
        OrderDTO dto = orderMapper.map(source);
        Assert.assertEquals(dto.getCustomerName(), "Joe Smith");
        Assert.assertEquals(dto.getBillingStreetAddress(), "1234 Market Street");
        Assert.assertEquals(dto.getBillingCity(), "San Fran");
        Assert.assertEquals(dto.getShippingStreetAddress(), "1234 West Townsend");
        Assert.assertEquals(dto.getShippingCity(), "Boston");
        Assert.assertEquals(dto.getProducts().get(0).getName(), "socks");
        Assert.assertEquals(dto.getProducts().get(1).getName(), "shoes");
    }



}
