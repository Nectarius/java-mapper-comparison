package tea.service;

/**
 * @author nefarius, <a href="mailto:Konstantin.Molodtsov@returnonintelligence.com">Konstantin Molodtsov</a>
 * @since 03 April 2016
 */
public class UserSession {

    private boolean employee = true;

    public void setEmployee(boolean employee) {
        this.employee = employee;
    }

    public Boolean isEmployee(){
        return employee;
    }

}
