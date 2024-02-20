package pwj.qa.ecomm.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pwj.qa.ecomm.basetest.BaseTest;
import pwj.qa.ecomm.constants.AppConstants;

public class ProductDetailPageTest extends BaseTest {

//	@Test
//	public void verify_productDetialPageTitle() {
//		productdetailpage = landingpage.clickon3rdProdBox();
//		assertEquals(productdetailpage.getproductPageTitle(), "Apple Cinema 30");
//	}

	@Test
	 public void verify_productBrand() {
		 productdetailpage = landingpage.clickon3rdProdBox();
		 assertEquals(productdetailpage.getProductBrand(), "Apple");
	  }

	@Test
	public void verify_productName() {
//		productdetailpage = landingpage.clickon3rdProdBox();
		assertEquals(productdetailpage.getProductName(), AppConstants.SEARCHED_PROD_NAME);
	}
	 	
}
