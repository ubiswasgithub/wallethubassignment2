package ub.wallethub.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(name = "em")
	private static WebElement element_username;	
	@FindBy(name= "pw")
	private static WebElement element_password;
	
	@FindBy(xpath = "//button[contains(.,'Login')]")
	private static WebElement element_login_button;
	
	
	
	WebDriver driver;
	UiHelper uihelper = new UiHelper();
	
	private String url = "http://wallethub.com/profile/test_insurance_company/";
	private String username = "testeruttam@gmail.com";
	private String password = "Abcd123*";
	
	
	
	

	public LoginPage(WebDriver driver){
		this.driver = driver;		
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	public void loginToWalletHub(){
		uihelper.waitUntilElementIsClickable(element_username);
		element_username.clear();
		element_username.sendKeys(username);
		uihelper.waitUntilElementIsClickable(element_password);
		element_password.clear();
		element_password.sendKeys(password);
		uihelper.waitUntilElementIsClickable(element_login_button);
		element_login_button.click();
		uihelper.waitForElementTorender();
	}
	
	public void goToInsuranceCompanyPage(){
		Nav.toURL(url);
	}

}
