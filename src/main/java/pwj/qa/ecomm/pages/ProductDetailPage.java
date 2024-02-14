package pwj.qa.ecomm.pages;

import com.microsoft.playwright.Page;

import pwj.qa.ecomm.playwrightfactory.PlaywrightFactory;

public class ProductDetailPage {
	private Page page;
	private String loc_proddetailSec = "//div[@id='content']//div[@class='col-sm-4']";
	private String loc_prodnameTxt = loc_proddetailSec+"//h1";
	private String loc_prodbrandTxt = loc_proddetailSec+ "//ul[1]//li[1]";
	private String loc_productpriceTxt = loc_proddetailSec+ "//ul[2]//h2";
	
	protected PlaywrightFactory pf;
	
	public ProductDetailPage(Page page) {
		this.page = page;
	}
	
	public String getproductPageTitle() {
		return page.title();
	}
	
	public String getProductName() {
		return page.textContent(loc_prodnameTxt);
	}
	

}
