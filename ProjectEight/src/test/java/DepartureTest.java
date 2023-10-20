import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class DepartureTest extends TestBase {

	@Test //FÄRDIG TESTFALL
    void SearchDeparture() {
        
        String loginUrl = "https://sl.se";
        page.navigate(loginUrl);
        
        // Locators
        Locator acceptCookies = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Acceptera alla kakor"));
        Locator elementDeparture = page.getByText("Sök avgångar");
        Locator typeDeparture = page.locator("#travel-planner-typeahead-departure-origin-input");
        Locator clickSearch = page.locator("#search-departures-button");
        
        
        // Interactions
        if (acceptCookies.isVisible()) {
            acceptCookies.click();
        }
        elementDeparture.click();
        typeDeparture.fill("Jakobsberg station");
        clickSearch.click();

        // Assertion
        String inputValue = typeDeparture.getAttribute("value");
        assertEquals("Jakobsbergs station (Järfälla)", inputValue, "Unexpected input value.");
    }
}