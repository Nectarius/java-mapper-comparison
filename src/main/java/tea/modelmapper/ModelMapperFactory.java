package tea.modelmapper;

import java.util.HashMap;
import java.util.Map;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.FactoryBean;

import tea.domain.GreenTea;
import tea.domain.PropertyValue;
import tea.domain.User;
import tea.domain.WhiteTea;
import tea.domain.YellowTea;
import tea.modelmapper.converters.GreenTeaConverter;
import view.GreenTeaView;
import view.PropertyValueView;
import view.WhiteTeaView;
import view.YellowTeaView;


/**
 * Created by nefarius on 4/7/15.
 */
public class ModelMapperFactory implements FactoryBean<ModelMapper> {

    private ModelMapper modelMapper = null;
    
    private final String  whiteTeaVariety = "White Peony";
    
    private Converter<GreenTea, GreenTeaView> greenTeaConverter = new GreenTeaConverter() ;

    private ModelMapper getModelMapper() {

        if (modelMapper == null) {
            modelMapper = new ModelMapper();
            // for constants example
            modelMapper.addMappings(new PropertyMap<WhiteTea, WhiteTeaView>() {
                @Override
                protected void configure() {
                    map().setVariety(whiteTeaVariety);
                }
            });

            TypeMap<PropertyValueView, HashMap> typeMap = modelMapper.createTypeMap(PropertyValueView.class, HashMap.class, "mapWithProperties");

        /*    HashMap<String, PropertyValue> map = new HashMap<String, PropertyValue>();



            TypeMap<PropertyValueView, HashMap> typeMap = modelMapper.createTypeMap(PropertyValueView.class, HashMap.class, "mapWithProperties");

        });
            // for HashMap example
            typeMap.addMappings(new PropertyMap<PropertyValueView, HashMap>() {

                @Override
                protected void configure() {
                   source.map().get("primaryProperties")
                }*/
            
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
