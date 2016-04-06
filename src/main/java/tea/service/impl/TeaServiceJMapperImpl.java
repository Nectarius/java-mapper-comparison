package tea.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.googlecode.jmapper.JMapper;

import tea.domain.BlackTea;
import tea.domain.WhiteTea;
import tea.repository.FakeTeaRepository;
import tea.service.TeaService;
import view.BlackTeaView;
import view.WhiteTeaView;

/**
 * @author adelfiri, <a href="mailto:Konstantin.Molodtsov@returnonintelligence.com">Konstantin Molodtsov</a>
 * @since 29 March 2016
 */
@Service
public class TeaServiceJMapperImpl implements TeaService {

    @Autowired
    private FakeTeaRepository fakeTeaRepository;

    @Autowired
    private JMapper<BlackTeaView, BlackTea> jMapper;

    @Autowired
    private FakeService fakeService;

    public WhiteTeaView findWhiteTea(Long id){

        WhiteTea whiteTea = (WhiteTea)fakeTeaRepository.findOne(id);

        return null;
    }

    @Override
    public BlackTeaView findBlackTeaView(Long id) {

        boolean isEmployee = fakeService.getUserSession().isEmployee();

        BlackTea blackTea = fakeTeaRepository.findOneBlackTea(id);

        BlackTeaView blackTeaView = jMapper.getDestination(blackTea);

        if(!isEmployee){
            // !!!!!!!
            blackTeaView.setRegisteredBy("");
        }

        return blackTeaView;
    }

}
