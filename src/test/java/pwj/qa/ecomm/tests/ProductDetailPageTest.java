package pwj.qa.ecomm.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pwj.qa.ecomm.basetest.BaseTest;
import pwj.qa.ecomm.constants.AppConstants;

public class ProductDetailPageTest extends BaseTest {
	
	@BeforeTest
	public void createInstance() {
		productdetailpage = landingpage.clickon3rdProdBox();
	}
	
	@Test
	public void verify_productDetialPageTitle() {
		assertEquals(productdetailpage.getproductPageTitle(), "Apple Cinema 30");
	}

	@Test
	 public void verify_productBrand() {
		assertEquals(productdetailpage.getProductBrand(), "Apple");
	  }

	@Test
	public void verify_productName() {
		assertEquals(productdetailpage.getProductName(), AppConstants.SEARCHED_PROD_NAME);
	}
	 	
}
