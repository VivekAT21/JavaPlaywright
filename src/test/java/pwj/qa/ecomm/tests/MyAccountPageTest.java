package pwj.qa.ecomm.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pwj.qa.ecomm.basetest.BaseTest;
import pwj.qa.ecomm.constants.AppConstants;

public class MyAccountPageTest extends BaseTest {
	
	@BeforeTest
	public void createmyacctInstance() {
		loginpage = landingpage.navigatetoLogin();
	}
	
	@Test
	public void verify_loginisSuccessfully() {
		myaccountpage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		assertEquals(myaccountpage.getLogoutLinkText(), AppConstants.MYACCOUNT_LOGOUT_LINK);
		
	}

}
