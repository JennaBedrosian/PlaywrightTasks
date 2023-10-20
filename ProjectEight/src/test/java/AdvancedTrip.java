import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class AdvancedTrip extends TestBase{
	@Test // FÄRDIG TESTFALL
	void advancedTrip () {
		String loginUrl = "https://sl.se";
	    page.navigate(loginUrl);

		
		// LOCATORS
		Locator acceptCookies = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Acceptera alla kakor"));
	    Locator inputFieldFrom = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Från"));
	    Locator inputFieldTo = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Till"));
	    Locator avgangstidLabel = page.locator("//label[@aria-label='Avgångstid']");
	    Locator dateInput = page.locator("#travel-planner-datetime-date");
	    
	    Locator timeInput = page.locator("#id-0");
	    Locator clickButton = page.locator("[data-test-id='button-search-trip-button']");
	    

	    
	    // INPUT
	    inputFieldFrom.fill("Jakobsberg station");
	    inputFieldTo.fill("Odenplan station");
	    avgangstidLabel.click();
	    timeInput.fill("20:30");
	    dateInput.fill("2023-11-01");
	    clickButton.click();


	    
	    if (acceptCookies.isVisible()) {
	        acceptCookies.click();
	    }
	    
	    String actualDateValue = dateInput.getAttribute("value");
	    assertEquals("2023-11-01", actualDateValue, "Expected date value to be set to '2023-11-01'");
	    
	    Locator h3Element = page.locator("h3.heading-s");
	    String actualText = h3Element.textContent();
	    assertEquals("Onsdag 1 november", actualText, "Resultat stämmer inte ");
	}
}
