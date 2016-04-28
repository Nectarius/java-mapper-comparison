package tea.repository;

import org.springframework.stereotype.Service;

import tea.domain.BlackTea;
import tea.domain.GreenTea;
import tea.domain.Item;
import tea.domain.User;
import tea.domain.UserAccountType;
import tea.domain.WhiteTea;


/**
 * @author nefarius, <a href="mailto:Konstantin.Molodtsov@returnonintelligence.com">Konstantin Molodtsov</a>
 * @since 29 March 2016
 */
@Service
public class FakeTeaRepository {

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

    public BlackTea findOneBlackTea(Long id) {

        User user = new User("Andrey", UserAccountType.CUSTOMER);

        BlackTea tea = new BlackTea("Silver Steed Eyebrow", "Fujian Province", "China",
                "description", "content", user);

        return tea;
    }

}
