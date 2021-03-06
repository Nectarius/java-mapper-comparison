package tea.orika;

import org.springframework.beans.factory.FactoryBean;

import ma.glasnost.orika.CustomConverter;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.Type;
import tea.domain.BlackTea;
import tea.domain.User;
import tea.domain.WhiteTea;
import view.BlackTeaView;
import view.WhiteTeaView;


/**
 * Created by nefarius on 5/28/15.
 */
public class OrikaMapperFactory implements FactoryBean<MapperFacade> {

    private MapperFactory mapperFactory = null;

    private MapperFacade mapperFacade = null;

    public class RegisteredByConverter extends CustomConverter<User, String> {

        @Override
        public String convert(User source, Type<? extends String> destinationType, MappingContext mappingContext) {
                return source == null ? "Unknown user" : source.getName();
        }
    }

  /*  public class ConstantsConverter extends CustomConverter<String, String> {


        @Override
        public String convert(String source, Type<? extends String> destinationType, MappingContext mappingContext) {

            return "White Peony";
        }
    }*/

    private MapperFacade getMapperFacade() {
        if(mapperFacade == null) {
            mapperFacade = getMapperFactory().getMapperFacade();
        }
        return mapperFacade;
    }

    private MapperFactory getMapperFactory() {
        if (mapperFactory == null) {
            mapperFactory = new DefaultMapperFactory.Builder().build();


            //mapperFactory.getConverterFactory().registerConverter("constantConverter", new ConstantsConverter());

           // mapperFactory.classMap( WhiteTea.class, WhiteTeaView.class ).fieldMap("description", "variety").converter("constantConverter").add();

            mapperFactory.getConverterFactory().registerConverter(new RegisteredByConverter());
        }
        return mapperFactory;
    }

    @Override
    public MapperFacade getObject() throws Exception {
        return getMapperFacade();
    }

    @Override
    public Class<?> getObjectType() {
        return MapperFacade.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
