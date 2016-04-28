package tea.dozer;

import org.dozer.DozerConverter;

import tea.domain.User;

/**
 * @author nefarius, <a href="mailto:Konstantin.Molodtsov@returnonintelligence.com">Konstantin Molodtsov</a>
 * @since 04 April 2016
 */
public class EmployeeUserCustomConverter extends DozerConverter<User, String> {
    public EmployeeUserCustomConverter() {
        super(User.class, String.class);
    }

    @Override
    public String convertTo(User source, String destination) {
        return source == null ? getParameter() : source.getName();
    }

    @Override
    public User convertFrom(String source, User destination) {
        throw new UnsupportedOperationException();
    }
}


