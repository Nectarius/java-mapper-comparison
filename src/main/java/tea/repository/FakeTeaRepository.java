package tea.repository;

import org.springframework.stereotype.Service;

import tea.domain.BlackTea;
import tea.domain.Item;
import tea.domain.User;
import tea.domain.UserAccountType;
import tea.domain.WhiteTea;


/**
 * @author adelfiri, <a href="mailto:Konstantin.Molodtsov@returnonintelligence.com">Konstantin Molodtsov</a>
 * @since 29 March 2016
 */
@Service
public class FakeTeaRepository {

    public Item findOne(Long id) {



        User user = new User("Andrey", UserAccountType.CUSTOMER);

        WhiteTea tea = new WhiteTea( "description", "content", user);

        return tea;
    }

    public BlackTea findOneBlackTea(Long id) {

        User user = new User("Andrey", UserAccountType.CUSTOMER);

        BlackTea tea = new BlackTea("Silver Steed Eyebrow", "Fujian Province", "China",
                "description", "content", user);

        return tea;
    }

}
