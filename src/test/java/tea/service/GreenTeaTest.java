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
import view.GreenTeaView;

/**
 * @author nefarius,
 *         <a href="mailto:Konstantin.Molodtsov@returnonintelligence.com">
 *         Konstantin Molodtsov</a>
 *         
 *         One to several
 *         
 * @since 03 April 2016
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context.xml" })
public class GreenTeaTest {

	/*  @Autowired
	  @Qualifier("teaServiceJMapperImpl")
	  @InjectMocks private TeaService teaService;*/

	/* @Autowired
	@Qualifier("teaServiceMapStructImpl")
	@InjectMocks
    private TeaService teaService;*/



  /*  @Autowired
	@Qualifier("teaServiceDozerImpl")
    @InjectMocks
    private TeaService teaService;*/

/*     @Autowired
      @Qualifier("teaServiceModelMapperImpl")
      @InjectMocks 
      private TeaService teaService;*/

    @Autowired
    @Qualifier("teaServiceSelmaImpl")
    @InjectMocks
    private TeaService teaService;
	

	/*   @Autowired

	  @Qualifier("teaServiceOrikaImpl")

	  @InjectMocks private TeaService teaService*/;


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
	public void severalFieldsToOneTest() {
		
		// http://stackoverflow.com/questions/34297791/with-dozer-is-it-possible-to-map-several-fields-to-one-field

        // If you have control over your legacy data, you could create a type to wrap the individual date fields:
		
		// http://www.talangsoft.org/2015/04/20/domain_mapping_with_modelmapper/
		
		// http://stackoverflow.com/questions/29070118/modelmapper-mapping-from-multi-flat-object-to-hierarchy-object

		GreenTeaView greenTeaView = teaService.findGreenTea(25l);

		Assert.assertEquals(greenTeaView.getDescription(), "descriptioncontent");

	}

}
