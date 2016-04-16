package tea.modelmapper;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.FactoryBean;

import tea.domain.GreenTea;
import tea.domain.User;
import tea.domain.WhiteTea;
import view.GreenTeaView;
import view.WhiteTeaView;


/**
 * Created by adelfiri on 4/7/15.
 */
public class ModelMapperFactory implements FactoryBean<ModelMapper> {

    private ModelMapper modelMapper = null;
    
    private final String  whiteTeaVariety = "White Peony";
    
    private Converter<GreenTea, GreenTeaView> greenTeaConverter = new Converter<GreenTea, GreenTeaView>() {
		
		@Override
		public GreenTeaView convert(MappingContext<GreenTea, GreenTeaView> context) {
			
			GreenTeaView destination = context.getDestination();
			
			GreenTea source = context.getSource();
			
			destination.setDescription(source.getDescription()+source.getContent());
			
			return destination;
		}
	};

    private ModelMapper getModelMapper() {
        if (modelMapper == null) {
            modelMapper = new ModelMapper();
            modelMapper.addMappings(new PropertyMap<WhiteTea, WhiteTeaView>() {
                @Override
                protected void configure() {
                    map().setVariety(whiteTeaVariety);
                }
            });
            
            modelMapper.addConverter(greenTeaConverter);
            modelMapper.addConverter(registeredByConverter);
        }
        return modelMapper;
    }


    Converter<User, String> registeredByConverter = new AbstractConverter<User, String>() {
        protected String convert(User user) {
            return user == null ? null : user.getName();
        }
    };

    @Override
    public ModelMapper getObject() throws Exception {
        return getModelMapper();
    }

    @Override
    public Class<?> getObjectType() {
        return ModelMapper.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
