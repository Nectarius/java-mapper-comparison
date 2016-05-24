package tea.mapstruct;

import java.util.Map;

import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ValueMapping;
import org.mapstruct.ValueMappings;


import tea.domain.BlackTea;
import tea.domain.GreenTea;
import tea.domain.PropertyValue;
import tea.domain.WhiteTea;

import tea.domain.YellowTea;
import view.BlackTeaView;
import view.GreenTeaView;
import view.PropertyValueView;
import view.WhiteTeaView;
import view.YellowTeaView;

/**
 * Created by nefarius on 4/5/15.
 */
@Mapper(config = CentralConfig.class, uses = {AbstractUserMapper.class})
public interface TeaMapper {



    @Mapping(source = "registeredBy", target = "registeredBy")
    BlackTeaView blackTeaToView(BlackTea blackTea);

    @Mapping(target = "registeredBy", expression = "java(abstractUserMapper.getRegisteredBy(blackTea.getRegisteredBy(), isEmployee))")
    BlackTeaView blackTeaToView(BlackTea blackTea, Boolean isEmployee);

    @Mapping(target = "variety", constant = "White Peony")
    WhiteTeaView whiteTeaToView(WhiteTea whiteTea);

    @Mapping(target = "description", expression = "java(greenTea.getDescription() + greenTea.getContent())")
    GreenTeaView greenTeaToView(GreenTea greenTea);

    PropertyValueView propertyValueToView(PropertyValue propertyValue);

    @Mappings({
    @Mapping(target = "primaryProperties", expression = "java(propertyValueToView(yellowTea.getPropValues().get(\"primaryProperties\")))"),
    @Mapping(target = "secondaryProperties", expression = "java(propertyValueToView(yellowTea.getPropValues().get(\"secondaryProperties\")))")})
    YellowTeaView yellowTeaToView(YellowTea yellowTea);




}
