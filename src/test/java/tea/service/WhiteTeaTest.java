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
import view.WhiteTeaView;

/**
 * @author nefarius,
 *         <a href="mailto:Konstantin.Molodtsov@returnonintelligence.com">
 *         Konstantin Molodtsov</a>
 *         
 *         Constant test
 *         
 * @since 03 April 2016
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context.xml" })
public class WhiteTeaTest {

    @Autowired
    @Qualifier("teaServiceMapStructImpl")
    @InjectMocks
    private TeaService teaService;

   /* @Autowired
    @Qualifier("teaServiceJMapperImpl")
    @InjectMocks/*







	

	 @Autowired

	  @Qualifier("teaServiceDozerImpl")

	  @InjectMocks private TeaService teaService; */


     /* @Autowired
      @Qualifier("teaServiceModelMapperImpl")
      @InjectMocks 
      private TeaService teaService; */
	
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
	public void constantTest() {

		// http://stackoverflow.com/questions/858519/constants-in-dozer-mappings

		WhiteTeaView whiteTeaView = teaService.findWhiteTea(25l);
		
		String variety = whiteTeaView.getVariety();

		Assert.assertEquals(variety, "White Peony");



	}

}
