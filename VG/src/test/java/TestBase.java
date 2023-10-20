
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;



 public class TestBase {
	protected static Playwright playwright;
	protected static Browser browser;
	
	protected BrowserContext context;
	protected Page page;
	


	@BeforeAll
	static public void setup() {
		playwright = Playwright.create();
		browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(5000));
	}
	
	@BeforeEach
	public void createContexAndPage() {
		context = browser.newContext();
		page = context.newPage();
	}
	@AfterEach
	public void closeContext() {
		context.close();
	}
	
	@AfterAll
	static public void closeBrowser() {
		browser.close();
		playwright.close();
	}

}