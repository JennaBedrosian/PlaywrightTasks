import org.junit.jupiter.api.Test;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SearchTrip extends TestBase{
	
	@Test // FÄRDIG TESTFALL
	void SearchTest() {
	    PageBase base = new PageBase(page);

	    // Locators
	    Locator acceptCookies = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Acceptera alla kakor"));
	    Locator inputFieldFrom = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Från"));
	    Locator inputFieldTo = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Till"));
	    Locator clickTravel = page.locator("#travel-planner-datetime-radio-now");
	    Locator clickButton = page.locator("[data-test-id='button-search-trip-button']");

	    // Click Accept Cookies button if it's visible
	    if (acceptCookies.isVisible()) {
	        acceptCookies.click();
	    }

	    // Filling in the input fields
	    inputFieldFrom.fill("Jakobsberg station");
	    inputFieldTo.fill("Odenplan station");

	    // Check if the radio button "Åka nu" is already checked
	    boolean isChecked = clickTravel.getAttribute("checked") != null;
	    if (!isChecked) {
	        clickTravel.click();
	    }

	    
	    clickButton.click();
	    
	 //Assertions Locations
	    Locator tidigareResorButton = page.locator("button#prepend[data-test-id='button-prepend']");

	    // Assertion
	    assertThat(tidigareResorButton).hasText("Tidigare resor");
	    
	
	}
}
