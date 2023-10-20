import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class ReversedSearch extends TestBase{
	
	@Test // FÄRDIG TESTFALL 
	void SearchTest() {
	    String loginUrl = "https://sl.se";
	    page.navigate(loginUrl);

	    // Locators
	    Locator acceptCookies = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Acceptera alla kakor"));
	    Locator inputFieldFrom = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Från"));
	    Locator inputFieldTo = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Till"));
	    Locator pathElement = page.locator("path[d='M10.5 15H20.6M16.1 19.5L20.6 15 16.1 10.5M13.5 9H3.4M7.9 13.5L3.4 9 7.9 4.5']");


	    
	    // Click Accept Cookies button if it's visible
	    if (acceptCookies.isVisible()) {
	        acceptCookies.click();
	    }
	    
	    // INPUT FIELD
	    inputFieldFrom.fill("Jakobsberg station");
	    inputFieldTo.fill("Odenplan station");
	    pathElement.click();
	    
	 // Assertions 
	    String expectedValue = "Odenplan (Stockholm)";
	    String fromFieldValue = inputFieldFrom.getAttribute("value");
	    if (!expectedValue.equals(fromFieldValue)) {
	        System.out.println("Expected value: " + expectedValue);
	        System.out.println("Actual value: " + fromFieldValue);
	    }
	    assertEquals(expectedValue, fromFieldValue, "Expected 'From' field value to be 'Stockholm Odenplan (Stockholm)'");

    }
	}
