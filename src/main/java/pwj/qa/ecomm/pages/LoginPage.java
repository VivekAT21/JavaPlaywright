package pwj.qa.ecomm.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
	
	private Page page;
	
	private String loc_usernameTxt = "//input[@name='email']";
	private String loc_passwordTxt = "//input[@name='password']";
	private String loc_loginBtn = "//input[@value='Login']";
	
	public LoginPage(Page page) {
		this.page = page;
	}
	
	public MyAccountPage doLogin(String username, String password) {
		page.fill(loc_usernameTxt, username);
		page.fill(loc_passwordTxt, password);
		page.click(loc_loginBtn);
		return new MyAccountPage(page);
	}
}
