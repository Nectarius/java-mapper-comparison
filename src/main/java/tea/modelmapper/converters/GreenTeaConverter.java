package tea.modelmapper.converters;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import tea.domain.GreenTea;
import view.GreenTeaView;

/**
 * @author adelfiri, <a href="mailto:Konstantin.Molodtsov@returnonintelligence.com">Konstantin Molodtsov</a>
 * @since 27 April 2016
 */
public class GreenTeaConverter implements Converter<GreenTea, GreenTeaView> {

    @Override
    public GreenTeaView convert(MappingContext<GreenTea, GreenTeaView> context) {

        GreenTeaView destination = context.getDestination();

        GreenTea source = context.getSource();

        destination.setDescription(source.getDescription() + source.getContent());

        return destination;
    }
}
