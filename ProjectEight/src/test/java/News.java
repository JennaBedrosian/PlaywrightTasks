import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class News extends TestBase {
	@Test // FÄRDIG TESTFALL 
    void checkNews() {
        
        String loginUrl = "https://sl.se";
        page.navigate(loginUrl);
        
        //LOCATORS
        Locator acceptCookies = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Acceptera alla kakor"));
        if (acceptCookies.isVisible()) {
            acceptCookies.click();
        }
        
        Locator clickLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Aktuellt"));
        clickLink.click();
        
        Locator newsLink = page.locator("a[href='/aktuellt/nyheter'] > span:has-text('Nyheter')");
        newsLink.click();
        
        Locator firstNews = page.locator("div._20aVJNRTq_umayXWJ33sE9._3awfeoNKBTSPN_m6-hDPxi").nth(0);
        firstNews.click();
        
        // Väldigt klurigt att hitta en bra assert till denna. 
        Locator newsTitle = page.locator("h1.heading-l");
        assertTrue(newsTitle.isVisible(), "News title is not visible");
}
}
