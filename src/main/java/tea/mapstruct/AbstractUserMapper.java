package tea.mapstruct;

import org.springframework.stereotype.Component;

import tea.domain.User;

/**
 * @author adelfiri, <a href="mailto:Konstantin.Molodtsov@returnonintelligence.com">Konstantin Molodtsov</a>
 * @since 04 April 2016
 */
@Component
public class AbstractUserMapper {

    private String defaultMessage = "Unknown user";

    public String asString(User user) {
            return user == null ? defaultMessage : user.getName();
    }

    public String getRegisteredBy(User user, Boolean isEmployee) {
        if (isEmployee) {
            return asString(user);
        } else {
            return "";
        }

    }

}
