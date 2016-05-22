package tea.service;

import java.util.HashMap;

import view.BlackTeaView;
import view.GreenTeaView;
import view.OolongTeaView;
import view.WhiteTeaView;
import view.YellowTeaView;

/**
 * @author nefarius, <a href="mailto:Konstantin.Molodtsov@returnonintelligence.com">Konstantin Molodtsov</a>
 * @since 29 March 2016
 */
public interface TeaService {

     WhiteTeaView findWhiteTea(Long id);


     BlackTeaView findBlackTeaView(Long id);

     GreenTeaView findGreenTea(Long id);

     OolongTeaView findOolongTea(Long id);

     YellowTeaView findYellowTea(Long id);


}
