package tea.modelmapper;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.FactoryBean;

import tea.domain.User;


/**
 * Created by adelfiri on 4/7/15.
 */
public class ModelMapperFactory implements FactoryBean<ModelMapper> {

    private ModelMapper modelMapper = null;

    private ModelMapper getModelMapper() {
        if (modelMapper == null) {
            modelMapper = new ModelMapper();
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
