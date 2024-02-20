package pwj.qa.ecomm.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import pwj.qa.ecomm.playwrightfactory.PlaywrightFactory;

public class LandingPage {
	
	private Page page;
	private PlaywrightFactory pf;
	
	private String loc_searchTxtBx = "//input[@placeholder='Search']";
	private String loc_searchTxtBtn = "//button[@class='btn btn-default btn-lg']";
	private String loc_myacntLink = "//a[@title='My Account']";
	private String loc_loginLink = "//a[normalize-space()='Login']";
	private String loc_prodBx = "//div[@class='product-thumb transition']";
	private String loc_addtocartIcon = loc_prodBx + "//span[contains(text(),'Add to Cart')]";
	private String loc_addtowishlistIcon = loc_prodBx + "//span[contains(text(),'Add to Wish List')]";
	
	
	private String loc_proddetailTxt(String prodName) {
		String proddetailTxt = "//a[contains(text(),'" 
				+ prodName 
				+ "')]/parent::h4/parent::div";
		return proddetailTxt;
	}
	
	private String loc_prodnameTxt(String prodName) {
		String prodnameTxt = loc_proddetailTxt(prodName) + "//h4";
		return prodnameTxt;
	}
		
	private String loc_prodaddtocartIcon(String prodName) {
		String prodAddtoCartIcon = loc_proddetailTxt(prodName) + "/following-sibling::div[@class='button-group']";
		return prodAddtoCartIcon;
	}
	
	public LandingPage (Page page) {
		this.page = page;
	}
	
	public String getLandingPageTitle() {
		return page.title();
	}
	
	public String getUrl() {
		return page.url();
	}
	
	public SearchPage doSearch(String prodName) {
		page.fill(loc_searchTxtBx, prodName);
		page.click(loc_searchTxtBtn);
		return new SearchPage(page);
	}
	
	public LoginPage navigatetoLogin() {
		page.click(loc_myacntLink);
		page.click(loc_loginLink);
		return new LoginPage(page);
	}
	
	public String getProdName(String prodName) {
		return page.textContent(loc_prodnameTxt(prodName));
	}
	
	public void addtoCart(String prodName) {
		page.hover(loc_prodaddtocartIcon(prodName));
	}

	public int getProdCnt() {
		Locator prodCnt = page.locator(loc_prodBx);
		return prodCnt.count();
	}
	
	//this is for test only, because clicking on 3rd and 4th will redirect to next page
	public void addAllProdtoCart() {
		int prodBox = getProdCnt();
		for (int i=0; i< prodBox; i++) {
			page.click(loc_addtocartIcon);
		}
	}
	
	public ProductDetailPage clickon3rdProdBox() {
		page.locator(loc_addtocartIcon).nth(2).click();
		return new ProductDetailPage(page);
	}
	
}
