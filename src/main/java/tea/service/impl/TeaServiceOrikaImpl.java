package tea.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.glasnost.orika.MapperFacade;
import tea.domain.BlackTea;
import tea.domain.WhiteTea;
import tea.repository.FakeTeaRepository;
import tea.service.TeaService;
import view.BlackTeaView;
import view.GreenTeaView;
import view.WhiteTeaView;

/**
 * @author nefarius, <a href="mailto:Konstantin.Molodtsov@returnonintelligence.com">Konstantin Molodtsov</a>
 * @since 29 March 2016
 */
@Service
public class TeaServiceOrikaImpl implements TeaService {

    @Autowired
    private FakeTeaRepository fakeTeaRepository;

    @Autowired
    private FakeService fakeService;

    @Autowired
    private MapperFacade mapperFacade;

    public WhiteTeaView findWhiteTea(Long id){

        WhiteTea whiteTea = (WhiteTea)fakeTeaRepository.findOne(id);

        return mapperFacade.map(whiteTea, WhiteTeaView.class);
    }

    @Override
    public BlackTeaView findBlackTeaView(Long id) {

        boolean isEmployee = fakeService.getUserSession().isEmployee();

        BlackTea blackTea = fakeTeaRepository.findOneBlackTea(id);

        BlackTeaView blackTeaView = mapperFacade.map(blackTea, BlackTeaView.class);

        if(!isEmployee){
            // !!!!!!!
            blackTeaView.setRegisteredBy("");
        }

        return blackTeaView;
    }

    @Override
   	public GreenTeaView findGreenTea(Long id) {
   		
   		
   		return null;
   	}

}
