import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class SearchButton extends TestBase{
	
	@Test // FÄRDIG TESTFALL
	void SearchRandom() {
		PageBase base = new PageBase(page);
	

	    String loginUrl = "https://sl.se";
	    page.navigate(loginUrl);

	    //Locators
	    Locator acceptCookies = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Acceptera alla kakor"));
	    if (acceptCookies.isVisible()) {
	        acceptCookies.click();
	    }

	    Locator searchBox = page.locator("#search-input-input[aria-label='Sök']");

	    Locator clickBox = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sök"));

	    // Inmatning
	    searchBox.fill("Ramp");
	    clickBox.click();

	    // Assert that the heading element is visible after the search
	    Locator headingElement = page.locator("[data-test-id='heading']");
	    assertTrue(headingElement.isVisible(), "Heading element is not visible.");

	    // Optionally, if you want to check its content
	    String text = headingElement.textContent();
	    assertEquals("Sökresultat", text, "Unexpected heading text.");
	}
}