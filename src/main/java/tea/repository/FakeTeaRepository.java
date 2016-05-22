package tea.repository;

import org.springframework.stereotype.Service;

import tea.domain.BlackTea;
import tea.domain.GreenTea;
import tea.domain.Item;
import tea.domain.OolongTea;
import tea.domain.PropertyValue;
import tea.domain.User;
import tea.domain.UserAccountType;
import tea.domain.WhiteTea;
import tea.domain.YellowTea;


/**
 * @author nefarius, <a href="mailto:Konstantin.Molodtsov@returnonintelligence.com">Konstantin Molodtsov</a>
 * @since 29 March 2016
 */
@Service
public class FakeTeaRepository {

    private PropertyValue createPropertyValue(String state, String value){

        PropertyValue propertyValue = new PropertyValue();

        propertyValue.setState(state);

        propertyValue.setValue(value);

        return  propertyValue;

    }

    public YellowTea findOneYellowTea(Long id) {

        User user = new User("Andrey", UserAccountType.CUSTOMER);

        YellowTea tea = new YellowTea( "description", "content", user);

        tea.getPropValues().put("primaryProperties", createPropertyValue("In Active", "value 1"));

        tea.getPropValues().put("secondaryProperties", createPropertyValue("In Active", "value 2"));

        return tea;
    }

    public Item findOne(Long id) {

        User user = new User("Andrey", UserAccountType.CUSTOMER);

        WhiteTea tea = new WhiteTea( "description", "content", user);

        return tea;
    }
    
    public GreenTea findOneGreenTea(Long id) {

        User user = new User("Andrey", UserAccountType.CUSTOMER);

        GreenTea tea = new GreenTea("description", "content", user).withVariety("Gunpowder")
        		.withSourceCountry("China").withSourceRegion("Zhejian Province");

        return tea;
    }

    public OolongTea findOneOolongTea(Long id) {

        User user = new User("Andrey", UserAccountType.CUSTOMER);

        OolongTea tea = new OolongTea("a dark tea with a spicy aroma", "content", user).withVariety("Cassia")
                .withSourceCountry("China").withSourceRegion("Fujian. Wuyi Mountains");

        return tea;
    }

    public BlackTea findOneBlackTea(Long id) {

        User user = new User("Andrey", UserAccountType.CUSTOMER);

        BlackTea tea = new BlackTea("Silver Steed Eyebrow", "Fujian Province", "China",
                "description", "content", user);

        return tea;
    }

}
