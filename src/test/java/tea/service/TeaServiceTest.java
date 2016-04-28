package tea.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import view.WhiteTeaView;

/**
 * @author nefarius, <a href="mailto:Konstantin.Molodtsov@returnonintelligence.com">Konstantin Molodtsov</a>
 * @since 29 March 2016
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/application-context.xml"})
public class TeaServiceTest {

 /*   @Autowired
    @Qualifier("teaServiceDozerImpl")
    private TeaService teaService;*/

    @Autowired
    @Qualifier("teaServiceMapStructImpl")
    private TeaService teaService;


    @Test
    public void twoInOne() {


        WhiteTeaView whiteTeaView = teaService.findWhiteTea(25l);

        //System.out.println("whiteTeaView.getType().getDescription() = " + whiteTeaView.getType().getDescription());



    }

}
