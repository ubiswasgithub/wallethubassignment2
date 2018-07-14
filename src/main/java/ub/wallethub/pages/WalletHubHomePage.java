package ub.wallethub.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WalletHubHomePage {
	
	@FindBy(xpath = "//a[@class='login']")
	private static WebElement element_login_menu;
	
	WebDriver driver;
	
	public WalletHubHomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void goToLoginPage(){
		element_login_menu.click();
	}
	

}
