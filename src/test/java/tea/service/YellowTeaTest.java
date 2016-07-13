package tea.service;

import static org.mockito.Mockito.when;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testng.Assert;

import tea.domain.YellowTea;
import tea.service.impl.FakeService;
import view.PropertyValueView;
import view.YellowTeaView;

/**
 * @author nefarius, <a href="mailto:Konstantin.Molodtsov@returnonintelligence.com">Konstantin Molodtsov</a>
 * @since 01 May 2016
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context.xml" })
public class YellowTeaTest {

     /* @Autowired
    @Qualifier("teaServiceMapStructImpl")
    @InjectMocks
    private TeaService teaService; */

   /* @Autowired
    @Qualifier("teaServiceJMapperImpl")
    @InjectMocks/*

	 @Autowired

	  @Qualifier("teaServiceDozerImpl")

	  @InjectMocks private TeaService teaService; */

    @Autowired
    @Qualifier("teaServiceModelMapperImpl")
    @InjectMocks
    private TeaService teaService;


	 /* @Autowired
	  @Qualifier("teaServiceOrikaImpl")
	  @InjectMocks
      private TeaService teaService;*/


    @Mock
    private FakeService fakeService;

    @Before
    public void initMocks() {

        MockitoAnnotations.initMocks(this);

        UserSession userSession = new UserSession();
        userSession.setEmployee(true);
        when(fakeService.getUserSession()).thenReturn(userSession);
    }

    @Test
    public void propertyTest() {

        YellowTeaView yellowTea = teaService.findYellowTea(35l);

        PropertyValueView primaryProperties = yellowTea.getPrimaryProperties();

        PropertyValueView secondaryProperties = yellowTea.getSecondaryProperties();

        Assert.assertEquals(primaryProperties.getValue(), "value 1");

        Assert.assertEquals(secondaryProperties.getValue(), "value 2");

    }

}
