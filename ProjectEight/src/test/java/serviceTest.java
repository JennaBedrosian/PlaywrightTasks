import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;


public class serviceTest extends TestBase {
	@Test  //FÄRDIG TESTFALL
	void customerService() {
	    String loginUrl = "https://sl.se";
	    page.navigate(loginUrl);

	    Locator acceptCookies = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Acceptera alla kakor"));

	    // Accept cookies if the button is visible
	    if (acceptCookies.isVisible()) {
	        acceptCookies.click();
	    }

	    // LOCATORS
	    Locator linkBox = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Kundservice"));
	    linkBox.click();

	    
	    Locator chattBox = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Chatta för snabb service"));
	    chattBox.click();

	    Locator chatEntry = page.locator(".humany-conversation-entry:has-text('Hejsan! Jag är SL:s chattbot.')");

	    Locator inputWithPlaceholder = page.getByPlaceholder("Vad behöver du hjälp med?");
	    inputWithPlaceholder.fill("Hej, jag behöver hjälp");

	    
	    // ASSERTIONS
	    assertTrue(chatEntry.isVisible(), "Chat entry is not visible, indicating the chatbot did not reply.");
	}

}