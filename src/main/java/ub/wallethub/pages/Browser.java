package ub.wallethub.pages;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
	private static WebDriver driver;

	public Browser(String browser) {

		switch (browser) {

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "ie":
			/*
			 * System.setProperty("webdriver.ie.driver",
			 * "drivers\\ie\\IEDriverServer_win32.exe"); DesiredCapabilities
			 * caps = DesiredCapabilities.internetExplorer();
			 * caps.setCapability("ignoreZoomSetting", true);
			 */
			// WebDriverManager.iedriver().setup();
			InternetExplorerDriverManager.getInstance().setup();
			driver = new InternetExplorerDriver();
			break;
		default:
			/*
			 * System.setProperty("webdriver.chrome.driver",
			 * "drivers\\chromedriver.exe"); ChromeOptions options = new
			 * ChromeOptions(); options.addArguments("--disable-extensions");
			 * driver = new ChromeDriver(options);
			 */

			ChromeOptions options = new ChromeOptions();
	//		options.addExtensions(new File("E:/WalletHub/extension_3_3_0_0.crx"));
			options.addArguments("--disable-notifications");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
			break;
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	public static WebDriver getDriver() {
		return driver;
	}

	/**
	 * Close the browser.
	 *
	 */
	public void quit() {

		getDriver().quit();
	}

	public static String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public static String getPageTitle() {
		return driver.getTitle();
	}

	public static void resetTimeOuts() {

		int timeout = 15;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(timeout, TimeUnit.SECONDS);
	}
	
	
}
