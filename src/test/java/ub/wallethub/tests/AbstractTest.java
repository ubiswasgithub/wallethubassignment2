package ub.wallethub.tests;



import ub.wallethub.pages.Browser;
import ub.wallethub.pages.Log;
import ub.wallethub.pages.Nav;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class AbstractTest {
	
	Browser newBrowser;
	public static WebDriver driver;

	private String appUrl = "https://wallethub.com";
	
	public static String review = "Tested by @ub. The need for a compelling strategy to harness data has"+
	"never been greater. The membership of AcademyHealth recognizes that this plan is"+""
	+ " an important opportunity for"+"the scientific community to embrace new methods, technologies.";
	
	public static Log log = new Log();
	
	@BeforeClass (alwaysRun = true)
	@Parameters("browser")
	public void beforeTest(@Optional("chrome") String browser) {
		log.showInfoLog("Starting "+ browser+ "browser...");
		newBrowser = new Browser(browser);
		log.showInfoLog("Go to "+appUrl);
		Nav.toURL(appUrl);

		driver = Browser.getDriver();
	}

	@AfterClass(alwaysRun = true)
	public void closeAllBrowserAfterTest() {
		log.showInfoLog("Test is completed and browser is closed..");
		if (newBrowser != null) {
			newBrowser.quit();
		}
	}

}
