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
import tea.domain.YellowTea;
import tea.repository.FakeTeaRepository;
import tea.selma.TeaMapper;
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
public class TeaServiceSelmaImpl implements TeaService {

    @Autowired
    private FakeTeaRepository fakeTeaRepository;

    @Autowired
    private TeaMapper teaMapper;

    @Autowired
    private FakeService fakeService;

    public WhiteTeaView findWhiteTea(Long id){

        WhiteTea whiteTea = (WhiteTea)fakeTeaRepository.findOne(id);

        return teaMapper.whiteTeaToView(whiteTea);
    }

    @Override
    public BlackTeaView findBlackTeaView(Long id) {

        boolean isEmployee = fakeService.getUserSession().isEmployee();

        BlackTea blackTea = fakeTeaRepository.findOneBlackTea(id);

        return teaMapper.blackTeaToView(blackTea, isEmployee);
    }

    @Override
    public GreenTeaView findGreenTea(Long id) {

        GreenTea greenTea = fakeTeaRepository.findOneGreenTea(id);

        return teaMapper.greenTeaToView(greenTea);
    }

    @Override
    public OolongTeaView findOolongTea(Long id) {
        return null;
    }

    @Override
    public YellowTeaView findYellowTea(Long id) {
        return null;
    }


}
