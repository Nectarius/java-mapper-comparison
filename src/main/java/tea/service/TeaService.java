package tea.service;

import view.BlackTeaView;
import view.WhiteTeaView;

/**
 * @author adelfiri, <a href="mailto:Konstantin.Molodtsov@returnonintelligence.com">Konstantin Molodtsov</a>
 * @since 29 March 2016
 */
public interface TeaService {

     WhiteTeaView findWhiteTea(Long id);


     BlackTeaView findBlackTeaView(Long id);

}
