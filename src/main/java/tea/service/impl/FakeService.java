package tea.service.impl;

import org.springframework.stereotype.Service;

import tea.service.UserSession;

/**
 * @author nefarius, <a href="mailto:Konstantin.Molodtsov@returnonintelligence.com">Konstantin Molodtsov</a>
 * @since 03 April 2016
 */
@Service
public class FakeService {

    public UserSession getUserSession(){
        return new UserSession();
    }


}
