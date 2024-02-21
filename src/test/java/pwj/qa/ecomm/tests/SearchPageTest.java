package pwj.qa.ecomm.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pwj.qa.ecomm.basetest.BaseTest;
import pwj.qa.ecomm.constants.AppConstants;

public class SearchPageTest extends BaseTest {

	@Test
	public void verify_searchedProduct() {
		searchpage = landingpage.doSearch(AppConstants.SEARCH_PROD_NAME);
		assertEquals(searchpage.getSearchedText(), AppConstants.SEARCHED_PROD_NAME);
		
	}
	
	@Test
	public void verify_searchedProduct01() {
//		searchpage = landingpage.doSearch(AppConstants.SEARCH_PROD_NAME);
		assertEquals(searchpage.getSearchedText01(AppConstants.SEARCHED_PROD_NAME), AppConstants.SEARCHED_PROD_NAME);
		
	}
}
