package pwj.qa.ecomm.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pwj.qa.ecomm.basetest.BaseTest;
import pwj.qa.ecomm.constants.AppConstants;

public class LandingPageTest extends BaseTest {
	
	
	@Test
	public void verify_landingpageTitle() {
		assertEquals(landingpage.getLandingPageTitle(), AppConstants.LANDING_PAGE_TITLE);
		
	}
	
	@Test
	public void verify_url() {
		assertEquals(landingpage.getUrl(), prop.getProperty("url"));
	}
	
	@Test
	public void verify_productName() {
		assertEquals(landingpage.getProdName(AppConstants.ADD_TO_CART_PROD), AppConstants.ADD_TO_CART_PROD);
	}
	
	
	

}
