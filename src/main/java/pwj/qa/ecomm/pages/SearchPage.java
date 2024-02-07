package pwj.qa.ecomm.pages;

import com.microsoft.playwright.Page;

public class SearchPage {
	private Page page;
	
	private String loc_searchedproductTxt = "//a[normalize-space()='Apple Cinema 30\"']";
	
	private String loc_searchedproductTxt01(String productName) {
		String loc = "//a[normalize-space()='"+ productName +"']";
		return loc;
	}
	
	
	public SearchPage(Page page) {
		this.page = page;
	}
	
	public String getSearchedText() {
		return page.textContent(loc_searchedproductTxt);
	}
	
	public String getSearchedText01(String productName) {
		return page.textContent(loc_searchedproductTxt01(productName));
	}

}
