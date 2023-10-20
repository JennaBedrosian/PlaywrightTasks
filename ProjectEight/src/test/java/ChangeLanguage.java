import org.junit.jupiter.api.Test;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChangeLanguage extends TestBase{
    @Test // FÄRDIG TESTFALL 
    void changeLanguage() {
        
        String loginUrl = "https://sl.se";
        page.navigate(loginUrl);
        
        // Locators
        Locator acceptCookies = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Acceptera alla kakor"));
        Locator linkEnglish = page.getByText("English");
        // Header for assertion
        Locator h1Element = page.locator("h1.heading-xl");
        
        // Actions
        if (acceptCookies.isVisible()) {
            acceptCookies.click();
        }
        linkEnglish.click();
        

        // Assertion
        String headerText = h1Element.innerText();
        assertEquals("In English", headerText, "The page is not in English.");
    }
}

