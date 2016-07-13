package tea.selma;

import org.springframework.stereotype.Service;

import tea.domain.GreenTea;
import tea.domain.WhiteTea;
import view.GreenTeaView;
import view.WhiteTeaView;

/**
 * @author nefarius, <a href="mailto:Konstantin.Molodtsov@returnonintelligence.com">Konstantin Molodtsov</a>
 * @since 14 July 2016
 */
@Service
public class TeaCustomMapper {

    public void interceptWhiteTeaToView(WhiteTea whiteTea, WhiteTeaView whiteTeaView) {

        whiteTeaView.setVariety("White Peony");

    }

    public void interceptGreenTeaToView(GreenTea greenTea, GreenTeaView greenTeaView) {

        greenTeaView.setDescription(greenTea.getDescription() + greenTea.getContent());

    }

}
