package ub.wallethub.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class WriteReview {

	@FindBy(xpath = "//span[@class='drop-arrow']")
	@CacheLookup
	private WebElement element_drop_down_menu;

	@FindBy(xpath = "//ul[@class='drop-el']/li")
	@CacheLookup
	private List<WebElement> element_drop_down_item_list;

	@FindBy(xpath = "//textarea[@name='review']")
	@CacheLookup
	private WebElement element_review_content_editor;

	@FindBy(xpath = "//input[@value='Submit']")
	@CacheLookup
	private WebElement element_submit_review;

	@FindBy(xpath = "//span[@id='overallRating']")
	@CacheLookup
	private WebElement element_rating;


	By element_drop_down_items = new By.ByXPath("//ul[@class='drop-el']");
	By element_review_content_editor2 = new By.ByXPath(
			"//div[@id ='review-content']");
	By element_confirm_review_message = new By.ByXPath(
			"//div[@class='big-title small']/h1/span");
	By element_user_menu = new By.ByXPath("//a[@class='user']");
	By element_user_profile = new By.ByXPath(
			"//nav//a[@class='user']//li[@class='dashboard-user']");
	By element_review_nav = new By.ByXPath("//div[@class='profilenav']/ul/li");
	By element_review_text = new By.ByXPath("//div[@class='reviews']//p");
	By element_rating_stars = new By.ByXPath("//span[@id='overallRating']/a");
	
	

	WebDriver driver;
	UiHelper uihelper = new UiHelper();
	String userProfile = "https://wallethub.com/profile/";

	public WriteReview(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectYourPolicy(String policy) {
		element_drop_down_menu.click();
		uihelper.waitUntilElementIsClickable(element_drop_down_item_list);
		uihelper.selectItemFromList(element_drop_down_item_list, policy);
		uihelper.waitUntilElementIsClickable(element_review_content_editor);
	}

	public void selectYourRating() {
		uihelper.waitUntilElementIsClickable(element_rating);
		uihelper.moveToElement(element_rating);
		uihelper.waitUntilElementIsClickable(element_rating_stars);
		uihelper.moveToElement(element_rating_stars);
		uihelper.clickToFiveStar(element_rating_stars, 4);
		uihelper.waitUntilElementIsClickable(element_review_content_editor);
	}

	public void writeYourReview(String review) {
		element_review_content_editor.clear();
		element_review_content_editor.sendKeys(review);
		uihelper.moveToElement(element_submit_review);
		uihelper.waitUntilElementIsClickable(element_submit_review);
		element_submit_review.click();
	}

	public void confirmYourReview(String reviewmessage) {
		uihelper.waitUntilElementIsClickable(element_confirm_review_message);		 
		String txt = uihelper.getText(element_confirm_review_message);
		boolean  bol = reviewmessage.equalsIgnoreCase(txt);
		Assert.assertTrue(bol);			

	}

	public void goToYourProfile() {
		uihelper.waitUntilElementIsClickable(element_user_menu);
		String userid = uihelper.getText(element_user_menu);
		Nav.toURL(userProfile + userid);

	}

	public void goToReviewTab() {
		uihelper.waitUntilElementIsClickable(element_review_nav);
		uihelper.click(element_review_nav, 2);
		uihelper.waitUntilElementIsClickable(element_review_text);

	}

	public void displayReviewFeedWithYourText(String message) {
		Assert.assertTrue(uihelper.getText(element_review_text).toString().toLowerCase().equals(message.toLowerCase()));
	}

}
