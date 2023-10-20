import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Locator;

public class ProgressBar extends TestBase {
	@Test // FÄRDIG VG TEST
	void ProgressBarTest() {
		
	    String loginUrl = "http://uitestingplayground.com/home";
	    page.navigate(loginUrl);
	    
	    Locator linkPage = page.getByText("Progress Bar");
        linkPage.click();
       
        page.click("#startButton");

        page.waitForFunction("() => { let value = parseFloat(document.querySelector('#progressBar').style.width); return value >= 74.5 && value <= 75.5; }");

        page.click("#stopButton");
        
        // Denna string räknar värdet på progress baren när man tryckt på stopp
        String progressBarValueStr = (String) page.evalOnSelector("#progressBar", "el => el.style.width");

        // Här kontrollerar jag om progressbarens värde är 75%
        assertEquals("75%", progressBarValueStr.trim(), "Progress bar value is not 75%. Actual value: " + progressBarValueStr);
    }
}

       
    



	

