package ub.wallethub.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsuranceCompanyPage {
	
	@FindBy(xpath="//span[@class='wh-rating rating_4_5']")
	private static WebElement element_hover_stars;
	
	@FindBy(id = "footer_cta")
	private static WebElement element_footer_contact;
	
	
	By element_hover_star_selected = new By.ByXPath("//div[@class='wh-rating-choices-holder']/a");
	By element_policy_drop = new By.ByXPath("//span[@class='drop-arrow']");
	
	WebDriver driver;
	UiHelper uihelper;

	public InsuranceCompanyPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectFiveStars(){
		uihelper = new UiHelper();
		uihelper.moveToElement(element_hover_stars);
		uihelper.waitUntilElementIsClickable(element_hover_star_selected);
		uihelper.clickToFiveStar(element_hover_star_selected,4);
		uihelper.waitUntilElementIsClickable(element_policy_drop);
		
	}	
	

	public static void hideContactPanel(){
		element_footer_contact.click();
	}
	
	

}
