package tea.service.impl;

import java.util.HashMap;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.glasnost.orika.MapperFacade;
import tea.domain.BlackTea;
import tea.domain.GreenTea;
import tea.domain.OolongTea;
import tea.domain.WhiteTea;
import tea.repository.FakeTeaRepository;
import tea.service.TeaService;
import view.BlackTeaView;
import view.GreenTeaView;
import view.OolongTeaView;
import view.WhiteTeaView;
import view.YellowTeaView;

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

    public OolongTeaView findOolongTea(Long id){

        OolongTea oolongTea = fakeTeaRepository.findOneOolongTea(35l);

        return  null;
        //return mapperFacade.map(whiteTea, WhiteTeaView.class);
    }

    @Override
    public YellowTeaView findYellowTea(Long id) {
        return null;
    }

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

        GreenTea greenTea = fakeTeaRepository.findOneGreenTea(id);

        return mapperFacade.map(greenTea, GreenTeaView.class);
   	}

}
