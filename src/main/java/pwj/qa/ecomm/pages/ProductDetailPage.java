package pwj.qa.ecomm.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;

import pwj.qa.ecomm.playwrightfactory.PlaywrightFactory;

public class ProductDetailPage {
	private Page page;
	private String loc_proddetailSec = "//div[@id='content']//div[@class='col-sm-4']";
	private String loc_prodnameTxt = loc_proddetailSec +"//h1";
	private String loc_prodbrandTxt = loc_proddetailSec + "//ul[1]//li[1]//a";
	private String loc_productpageId = "//div[@id='product-product']";
	
	private String loc_productSec = "//div[@id='product']";
	private String loc_productsecOpt = loc_productSec + "/h3";
	private String loc_productcheckBx = loc_productSec + "/h3";
	private String loc_check3Bx = loc_productSec + "/div[2]/div/div[1]";
	private String loc_textBx = loc_productSec + "/div[3]/input";
	private String loc_select = loc_productSec + "/div[4]/select";
	private String loc_selectValue = loc_select + "/option[@value=3]";
	private String loc_textareaBx = loc_productSec + "/div[5]/textarea";
	private String loc_uploadfile = loc_productSec + "/div[6]/input";
	
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
	
	public String getProductBrand() {
		return page.textContent(loc_prodbrandTxt);
	}
	
	public void addProducttoCartDetails() {
		page.click(loc_check3Bx);
		page.fill(loc_textBx, "vivek");
		page.selectOption(loc_select, new SelectOption().setIndex(2));
		page.fill(loc_textareaBx, "vivek area");
	}
	

}
