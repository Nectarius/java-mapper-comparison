package performance.configuration;

import java.io.IOException;

import org.milyn.Smooks;
import org.milyn.container.ExecutionContext;
import org.milyn.payload.JavaResult;
import org.milyn.payload.JavaSource;
import org.xml.sax.SAXException;

import performance.domain.Order;
import performance.dto.OrderDTO;

/**
 * @author nefarius, <a href="mailto:Konstantin.Molodtsov@returnonintelligence.com">Konstantin Molodtsov</a>
 * @since 02 April 2016
 */
public class SmooksMapper {

    private static volatile SmooksMapper instance;

    private Smooks smooks = null;

    private ExecutionContext executionContext = null;

    private SmooksMapper(){

        try {
            smooks = new Smooks("performance/smooks-config.xml");
            //executionContext = smooks.createExecutionContext();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }


    }

    public OrderDTO map(Order source){

        JavaSource javaSource = new JavaSource(source);
        final JavaResult result = new JavaResult();

        smooks.filterSource( javaSource, result);

        return (OrderDTO) result.getBean("orderDTO");

    }

    public static SmooksMapper getInstance() {
        SmooksMapper localInstance = instance;
        if (localInstance == null) {
            synchronized (SmooksMapper.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new SmooksMapper();
                }
            }
        }
        return localInstance;
    }

}
