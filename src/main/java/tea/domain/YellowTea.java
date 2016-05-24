package tea.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author nefarius, <a href="mailto:Konstantin.Molodtsov@returnonintelligence.com">Konstantin Molodtsov</a>
 * @since 22 May 2016
 */
public class YellowTea extends Item {

    private Map<String, PropertyValue> propValues = new HashMap<String, PropertyValue>();

    public void setPropValues(Map<String, PropertyValue> propValues) {
        this.propValues = propValues;
    }

    public Map<String,PropertyValue> getPropValues() {
        return propValues;
    }

    /**
     *  for dozer only
     *
     *
     * @param value
     * @param key
     */
    public void addPropValue(PropertyValue value, String key) {
        propValues.put(key, value);
    }

    public YellowTea(String description, String content, User registeredBy) {
        super(description, content, registeredBy);
    }
}
