package tea.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


import tea.domain.BlackTea;
import tea.domain.GreenTea;
import tea.domain.WhiteTea;

import view.BlackTeaView;
import view.GreenTeaView;
import view.WhiteTeaView;

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



}
