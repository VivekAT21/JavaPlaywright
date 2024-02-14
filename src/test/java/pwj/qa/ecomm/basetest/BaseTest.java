package pwj.qa.ecomm.basetest;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;

import pwj.qa.ecomm.pages.LandingPage;
import pwj.qa.ecomm.pages.LoginPage;
import pwj.qa.ecomm.pages.MyAccountPage;
import pwj.qa.ecomm.pages.ProductDetailPage;
import pwj.qa.ecomm.pages.SearchPage;
import pwj.qa.ecomm.playwrightfactory.PlaywrightFactory;

public class BaseTest {
	
	protected PlaywrightFactory pf;
	Page page;
	protected Properties prop;
	protected LandingPage landingpage;
	protected SearchPage searchpage;
	protected LoginPage loginpage;
	protected MyAccountPage myaccountpage;
	protected ProductDetailPage productdetailpage;
	
	
	@BeforeTest
	public void setup() {
		pf = new PlaywrightFactory();
		prop = pf.init_prop();
		page = pf.initBrowser(prop);
		landingpage =  new LandingPage(page);
	}
	
	@AfterTest
	public void TearDown() {
		page.context().browser().close();
	}

}
