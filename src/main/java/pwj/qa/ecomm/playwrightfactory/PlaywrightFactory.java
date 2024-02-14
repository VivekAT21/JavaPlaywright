package pwj.qa.ecomm.playwrightfactory;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {
	
	Playwright playwright;
	Browser browser;
	BrowserContext browsercontext;
	Page page;
	Properties prop;
	
	private static ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
	private static ThreadLocal<BrowserContext> tlBrowserContext = new ThreadLocal<>();
	private static ThreadLocal<Page> tlPage = new ThreadLocal<>();
	private static ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();
	 
	
	public static Playwright getPlayWright() {
		return tlPlaywright.get();
	}
	
	public static Page getPage() {
		return tlPage.get();
	}
	
	public static BrowserContext getBrowserContext() {
		return tlBrowserContext.get();
	}
	public static Browser getBrowser() {
		return tlBrowser.get();
	}
	
	public Page initBrowser(Properties prop ) {
		System.out.println("Execution started.......");
		
		ArrayList<String> winMax = new ArrayList<>();
		winMax.add("--start-maximized");
		 
		String browserName = prop.getProperty("browser").trim();
		tlPlaywright.set(Playwright.create());
		
		switch (browserName.toLowerCase()) {
		case "chromium":
			tlBrowser.set(getPlayWright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)));
			break;
		case "firefox":
			tlBrowser.set(getPlayWright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false)));
			break;
		case "safari":
			tlBrowser.set(getPlayWright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false)));
			break;
		case "chrome":
			tlBrowser.set(getPlayWright().chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(winMax)));
			//maxmizing only chrome browser for now by passing setArgs
			break;
		case "edge":
			tlBrowser.set(getPlayWright().chromium().launch(new LaunchOptions().setChannel("msedge").setHeadless(false).setArgs(winMax)));
			tlBrowserContext.set(getBrowser().newContext(new NewContextOptions().setViewportSize(null)));
			//maxmizing only edge browser for now by passing setArgs
			break;
		default:
			System.out.println("ENTER CORRECT BROWSER NAME.....");
			break;
		}
		tlBrowserContext.set(getBrowser().newContext(new NewContextOptions().setViewportSize(null)));
		tlPage.set(getBrowserContext().newPage());
		
		getPage().navigate(prop.getProperty("url").trim());
		
		return getPage();
	}

	public Properties init_prop() {
	try {
		FileInputStream ip = new FileInputStream("./resources/config/config.properties");
		prop = new Properties();
		try {
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	return prop;
	}
	
	public static String takeScreenshot() {
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		//getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
		
		byte[] buffer = getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
		String base64Path = Base64.getEncoder().encodeToString(buffer);
		
		return base64Path;
	}
	
	
	public void jsDialogAccept() {
		page.onDialog(dialog ->{
			dialog.accept();
		});
	}
	
	public Page newTab(String loc, int index) {
		Page popup = page.waitForPopup(() -> {
				page.locator(loc).nth(index).click();
				});
		return popup;
	}
	
	
	/**
	 * 	
	 * Initializing browser without thread safe
	 * @return
	 */
//		public Page initBrowser(Properties prop ) {
//			System.out.println("Execution started.......");
//			
//			playwright = Playwright.create();
//			tlPlaywright.set(Playwright.create());
//			String browserName = prop.getProperty("browser").trim();
//			
//			switch (browserName.toLowerCase()) {
//			case "chromium":
//				browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//				break;
//			case "firefox":
//				browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
//				break;
//			case "safari":
//				browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
//				break;
//			case "chrome":
//				browser = playwright.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
//				break;
//			default:
//				System.out.println("ENTER CORRECT BROWSER NAME.....");
//				break;
//			}
//			browsercontext = browser.newContext();
//			page = browsercontext.newPage();
//			
//			page.navigate(prop.getProperty("url").trim());
//			
//			return page;
//		}
		

}
