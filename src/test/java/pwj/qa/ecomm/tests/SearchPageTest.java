package pwj.qa.ecomm.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pwj.qa.ecomm.basetest.BaseTest;
import pwj.qa.ecomm.constants.AppConstants;

public class SearchPageTest extends BaseTest {
	
	@BeforeTest
	public void createspInstance() {
		searchpage = landingpage.doSearch(AppConstants.SEARCH_PROD_NAME);
	}

	@Test
	public void verify_searchedProduct() {
		assertEquals(searchpage.getSearchedText(), AppConstants.SEARCHED_PROD_NAME);
		
	}
	
	@Test
	public void verify_searchedProduct01() {
		assertEquals(searchpage.getSearchedText01(AppConstants.SEARCHED_PROD_NAME), AppConstants.SEARCHED_PROD_NAME);
		
	}
}
