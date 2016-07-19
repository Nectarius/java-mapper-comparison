package tea.mapstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import tea.domain.BlackTea;
import view.BlackTeaView;

/**
 * @author nefarius,
 * @since 20 July 2016
 */
public abstract class TeaMapperDecorator implements TeaMapper{

    @Autowired
    @Qualifier("delegate")
    private TeaMapper delegate;

    @Autowired
    private AbstractUserMapper abstractUserMapper;

    public BlackTeaView blackTeaToView(BlackTea blackTea, Boolean isEmployee){

        BlackTeaView blackTeaView =  delegate.blackTeaToView(blackTea);

        blackTeaView.setRegisteredBy( abstractUserMapper.getRegisteredBy(blackTea.getRegisteredBy(), isEmployee) );

        return blackTeaView;
    }

}
