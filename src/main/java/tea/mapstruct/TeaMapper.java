package tea.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


import tea.domain.BlackTea;
import tea.domain.WhiteTea;

import view.BlackTeaView;
import view.WhiteTeaView;

/**
 * Created by adelfiri on 4/5/15.
 */
@Mapper(config = CentralConfig.class, uses = {AbstractUserMapper.class})
public interface TeaMapper {



    @Mapping(source = "registeredBy", target = "registeredBy")
    BlackTeaView blackTeaToView(BlackTea blackTea);

    @Mapping(target = "registeredBy", expression = "java(abstractUserMapper.getRegisteredBy(blackTea.getRegisteredBy(), isEmployee))")
    BlackTeaView blackTeaToView(BlackTea blackTea, Boolean isEmployee);


}
