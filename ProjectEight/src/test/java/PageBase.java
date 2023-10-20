import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class PageBase extends TestBase {
    private Page page;
    private Locator searchBox;
    private Locator clickBox;
    private Locator inputFieldFrom;
    private Locator inputFieldTo;
    private Locator clickTravel;
    private Locator clickButton;
    private Locator avgangstidLabel;
    private Locator dateInput;
    private Locator timeInput;
    private Locator acceptCookies;
    
    
    // Constructor
    public PageBase(Page page) {
        this.page = page;
        initializeLocators();
        String loginUrl = "https://sl.se";
        this.page.navigate(loginUrl);
    }

    private void initializeLocators() {
        searchBox = page.locator("#search-input-input[aria-label='Sök']");
        acceptCookies = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Acceptera alla kakor"));
        clickBox = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sök"));
        inputFieldFrom = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Från"));
	    inputFieldTo = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Till"));
	    clickTravel = page.locator("#travel-planner-datetime-radio-now");
	    clickButton = page.locator("[data-test-id='button-search-trip-button']");
	    avgangstidLabel = page.locator("//label[@aria-label='Avgångstid']");
	    dateInput = page.locator("#travel-planner-datetime-date");
	    
	    timeInput = page.locator("#id-0");
	    
    }
    
    // Method
    public void searchButton() {
        String loginUrl = "https://sl.se";
        page.navigate(loginUrl);
        searchBox.fill("Ramp");
        clickBox.click();
    }
    
    
    public void searchTrip () {
    	String loginUrl = "https://sl.se";
        page.navigate(loginUrl);
        inputFieldFrom.fill("Jakobsberg station");
	    inputFieldTo.fill("Odenplan station");
	    boolean isChecked = clickTravel.getAttribute("checked") != null;
	    if (!isChecked) {
	        clickTravel.click();	    }
	    }
	    
	    
	    public void advancedTrip () {
	    	String loginUrl = "https://sl.se";
	        page.navigate(loginUrl);
	        inputFieldFrom.fill("Jakobsberg station");
		    inputFieldTo.fill("Odenplan station");
		    avgangstidLabel.click();
		    timeInput.fill("20:30");
		    dateInput.fill("2023-11-01");
		    clickButton.click();
		    
		    if (acceptCookies.isVisible()) {
		        acceptCookies.click();
		    }
		    
		    
		    
	}

    }
