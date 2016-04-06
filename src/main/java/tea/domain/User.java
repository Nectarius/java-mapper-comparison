package tea.domain;

/**
 * @author adelfiri, <a href="mailto:Konstantin.Molodtsov@returnonintelligence.com">Konstantin Molodtsov</a>
 * @since 03 April 2016
 */
public class User {

    private UserAccountType userAccountType;

    private String name;

    public User(String name, UserAccountType userAccountType) {
        this.userAccountType = userAccountType;
        this.name = name;
    }

    public UserAccountType getUserAccountType() {
        return userAccountType;
    }

    public void setUserAccountType(UserAccountType userAccountType) {
        this.userAccountType = userAccountType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
