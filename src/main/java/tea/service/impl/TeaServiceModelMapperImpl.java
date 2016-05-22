package tea.service.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class TeaServiceModelMapperImpl implements TeaService {

    @Autowired
    private FakeTeaRepository fakeTeaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private FakeService fakeService;

    public WhiteTeaView findWhiteTea(Long id){

        WhiteTea whiteTea = (WhiteTea)fakeTeaRepository.findOne(id);

        return modelMapper.map(whiteTea, WhiteTeaView.class);
    }

    @Override
    public BlackTeaView findBlackTeaView(Long id) {

        boolean isEmployee = fakeService.getUserSession().isEmployee();

        BlackTea blackTea = fakeTeaRepository.findOneBlackTea(id);

        BlackTeaView blackTeaView = modelMapper.map(blackTea, BlackTeaView.class);

        if(!isEmployee){
            // !!!!!!!
            blackTeaView.setRegisteredBy("");
        }

        return blackTeaView;
    }

	@Override
	public GreenTeaView findGreenTea(Long id) {
		
		GreenTea greenTea = fakeTeaRepository.findOneGreenTea(id);
		
		return modelMapper.map(greenTea, GreenTeaView.class);
	}

    @Override
    public OolongTeaView findOolongTea(Long id) {

        OolongTea oolongTea = fakeTeaRepository.findOneOolongTea(35l);

        HashMap hashMap = modelMapper.map(oolongTea, LinkedHashMap.class);

        OolongTeaView oolongTeaView = new OolongTeaView();

        oolongTeaView.setMap(hashMap);

        return oolongTeaView;
    }

    @Override
    public YellowTeaView findYellowTea(Long id) {
        return null;
    }

}
