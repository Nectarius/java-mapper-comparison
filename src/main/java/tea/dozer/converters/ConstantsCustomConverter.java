package tea.dozer.converters;

import org.dozer.ConfigurableCustomConverter;

/**
 * @author nefarius, <a href="mailto:Konstantin.Molodtsov@returnonintelligence.com">Konstantin Molodtsov</a>
 * @since 28 April 2016
 */
public class ConstantsCustomConverter implements ConfigurableCustomConverter {

    private String pararamter;


    @Override
    public void setParameter(String parameter) {
        this.pararamter = parameter;
    }

    @Override
    public Object convert(Object existingDestinationFieldValue, Object sourceFieldValue, Class<?> destinationClass, Class<?> sourceClass) {
        return pararamter;
    }
}
