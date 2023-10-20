import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Locator;

public class textInput extends TestBase {
	@Test //FÄRDIG VG TEST
    void TextInput() {
        
        String loginUrl = "http://uitestingplayground.com/home";
        page.navigate(loginUrl);
        
        // LOCATORS 
        Locator linkPage = page.getByText("Text Input");
        linkPage.click();
        
        page.type("#newButtonName", "Jennas Knapp");
        
        page.click("#updatingButton");
        
        // Denna string hämtar värdet av knappen och sedan assertar att den heter Jennas knapp
        String buttonName = page.textContent("#updatingButton");
        assertEquals("Jennas Knapp", buttonName);
	}
}
	
