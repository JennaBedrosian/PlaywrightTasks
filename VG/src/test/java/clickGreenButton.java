
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.PlaywrightException;

    public class clickGreenButton extends TestBase {
	@Test // FÄRDIG VG TEST
    void GreenButton() {
		String loginUrl = "http://uitestingplayground.com/home";
        page.navigate(loginUrl);
        
        Locator linkPage = page.getByText("Hidden Layers");
        linkPage.click();
        
        page.click("#greenButton");

       
        assertTrue(page.isVisible("#blueButton"));

        
        try {
            page.click("#greenButton");
            fail("Should not be able to click the green button a second time.");
        } catch (PlaywrightException e) {
            
            System.out.println("Second click on the green button failed as expected.");
        }
    }
}