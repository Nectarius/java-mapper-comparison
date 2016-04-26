package tea.dozer.converters;

import org.dozer.DozerConverter;

import tea.domain.GreenTea;
import view.GreenTeaView;

/**
 * @author adelfiri, <a href="mailto:Konstantin.Molodtsov@returnonintelligence.com">Konstantin Molodtsov</a>
 * @since 27 April 2016
 */
public class GreenTeaConverter  extends DozerConverter<GreenTea, GreenTeaView> {


    public GreenTeaConverter() {
        super(GreenTea.class, GreenTeaView.class);
    }

    @Override
    public GreenTeaView convertTo(GreenTea source, GreenTeaView destination) {

        if (source == null) {
            return null;
        }

        GreenTeaView dest = null;

        if (destination == null) {
            dest = new GreenTeaView();
        } else {
            dest = destination;
        }

        dest.setDescription(source.getDescription() + source.getContent());

        return  dest;
    }

    @Override
    public GreenTea convertFrom(GreenTeaView source, GreenTea destination) {
        return null;
    }
}



