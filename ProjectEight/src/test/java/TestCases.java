import org.junit.jupiter.api.Test;

public class TestCases extends TestBase {
	@Test // FÄRDIG TESTFALL
	void Test1() {
		PageBase base = new PageBase(page);
		base.searchButton();;
	}
	@Test
	void Test2 () {
		PageBase base = new PageBase(page);
		base.searchTrip();
	}
    @Test
	void Test3 () {
		PageBase base = new PageBase(page);
		base.advancedTrip();
	}
	
}
