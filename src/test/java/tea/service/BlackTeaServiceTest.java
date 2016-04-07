package tea.service;

import static org.mockito.Mockito.when;

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

import tea.service.impl.FakeService;
import view.BlackTeaView;

/**
 * @author adelfiri,
 *         <a href="mailto:Konstantin.Molodtsov@returnonintelligence.com">
 *         Konstantin Molodtsov</a>
 * @since 03 April 2016
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context.xml" })
public class BlackTeaServiceTest {

	@Autowired
	@Qualifier("teaServiceMapStructImpl")
	@InjectMocks
	private TeaService teaService;

	/*
	 * @Autowired
	 * 
	 * @Qualifier("teaServiceJMapperImpl")
	 * 
	 * @InjectMocks private TeaService teaService;
	 */

	/*
	 * @Autowired
	 * 
	 * @Qualifier("teaServiceModelMapperImpl")
	 * 
	 * @InjectMocks private TeaService teaService;
	 */

	/*
	 * @Autowired
	 * 
	 * @Qualifier("teaServiceOrikaImpl")
	 * 
	 * @InjectMocks private TeaService teaService;
	 */

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
	public void externalConditionTest() {

		// http://stackoverflow.com/questions/858519/constants-in-dozer-mappings

		BlackTeaView blackTeaView = teaService.findBlackTeaView(25l);

		Assert.assertEquals(blackTeaView.getRegisteredBy(), "Andrey");

		Assert.assertEquals(blackTeaView.getContent(), "content");

		Assert.assertEquals(blackTeaView.getDescription(), "description");

		Assert.assertEquals(blackTeaView.getSourceCountry(), "China");

		Assert.assertEquals(blackTeaView.getSourceRegion(), "Fujian Province");

		Assert.assertEquals(blackTeaView.getVariety(), "Silver Steed Eyebrow");

	}

}
