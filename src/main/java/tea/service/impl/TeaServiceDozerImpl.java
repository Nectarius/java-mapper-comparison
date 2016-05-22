package tea.service.impl;

import java.util.HashMap;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tea.domain.BlackTea;
import tea.domain.GreenTea;
import tea.domain.WhiteTea;
import tea.domain.YellowTea;
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
public class TeaServiceDozerImpl implements TeaService {

    @Autowired
    private FakeTeaRepository fakeTeaRepository;

    @Autowired
    private FakeService fakeService;

    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    public WhiteTeaView findWhiteTea(Long id) {

        WhiteTea whiteTea = (WhiteTea) fakeTeaRepository.findOne(id);

        return dozerBeanMapper.map(whiteTea, WhiteTeaView.class);
    }

    public BlackTeaView findBlackTeaView(Long id) {

        boolean isEmployee = fakeService.getUserSession().isEmployee();

        final String mapId = isEmployee ? "for-employee" : "for-customer";

        BlackTea blackTea = fakeTeaRepository.findOneBlackTea(id);

        return dozerBeanMapper.map(blackTea, BlackTeaView.class, mapId);
    }

    @Override
    public GreenTeaView findGreenTea(Long id) {

        GreenTea greenTea = fakeTeaRepository.findOneGreenTea(id);

        return dozerBeanMapper.map(greenTea, GreenTeaView.class);
    }

    @Override
    public OolongTeaView findOolongTea(Long id) {


        return null;
    }

    @Override
    public YellowTeaView findYellowTea(Long id) {

        YellowTea yellowTea = fakeTeaRepository.findOneYellowTea(id);

        return dozerBeanMapper.map(yellowTea, YellowTeaView.class);
    }

}
