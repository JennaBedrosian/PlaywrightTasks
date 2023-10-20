

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class SearchFilter extends TestBase{
	
	@Test // FÄRDIG TESTFALL
	void SearchTest() {
	    String loginUrl = "https://sl.se";
	    page.navigate(loginUrl);

	    // Locators
	    Locator acceptCookies = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Acceptera alla kakor"));
	    Locator inputFieldFrom = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Från"));
	    Locator inputFieldTo = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Till"));
	    Locator filterView = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Anpassa resefilter"));
	    Locator labelToClick = page.locator("label[data-test-id='transport-types-checkbox-TRAIN']");
	    Locator clickButton = page.locator("[data-test-id='button-search-trip-button']");

	  
	    // Click Accept Cookies button if it's visible
	    if (acceptCookies.isVisible()) {
	        acceptCookies.click();
	    }

	    // Filling in the input fields
	    inputFieldFrom.fill("Jakobsberg station");
	    inputFieldTo.fill("Odenplan station");
	    filterView.click();
	    labelToClick.click();
	    clickButton.click();

	   
	    Locator textElement = page.locator("p.JTWCYIrwMzwE9egdjHKZ");
	    assertTrue(textElement.textContent().equals("Välj färdsätt"), "Expected text not found!");
	    

	    
	    
	   
	
	}
}

