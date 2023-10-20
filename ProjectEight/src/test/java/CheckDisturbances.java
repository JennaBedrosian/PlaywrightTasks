import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class CheckDisturbances extends TestBase{
	@Test // FÄRDIG TESTFALL 
    void disturbances() {
        
        String loginUrl = "https://sl.se";
        page.navigate(loginUrl);
        
        //Locators
        Locator acceptCookies = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Acceptera alla kakor"));
        if (acceptCookies.isVisible()) {
            acceptCookies.click();
              }
        
        Locator travelLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Reseplanering"));
        Locator trafficStatus = page.getByTestId("teaser-link-teasers1-1").nth(1);
        Locator busLabel = page.locator("label[aria-label='Buss']");
        
        
        //Input fields 
        travelLink.click();
        trafficStatus.click();
        busLabel.click();
        
        // ASSERTIONS 
        assertTrue(page.locator("h3.heading-s:has-text('Översikt störningar')").isVisible(), 
                "Header with 'Översikt störningar' is not visible or not present");

        assertTrue(page.locator("span.body[data-test-id='breadcrumb-test-id-2']:has-text('Trafikläget')").isVisible(), 
                "Element with text 'Trafikläget' is not visible or not present");
}

	private void nth(int i) {
		// TODO Auto-generated method stub
		
	}
}
