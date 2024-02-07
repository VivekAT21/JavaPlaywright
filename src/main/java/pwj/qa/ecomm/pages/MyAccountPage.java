package pwj.qa.ecomm.pages;

import com.microsoft.playwright.Page;

public class MyAccountPage {
	private Page page;
	
	private String loc_logoutTxt = "//a[@class='list-group-item'][normalize-space()='Logout']";
	
		
	public MyAccountPage(Page page) {
		this.page = page;
	}
	
	public String getLogoutLinkText() {
		return page.textContent(loc_logoutTxt);		
	}


}
