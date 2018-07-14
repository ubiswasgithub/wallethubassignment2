package ub.wallethub.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * 
 * @author Uttam
 *
 */

public class UiHelper {
	public void click(By element_post_button, int index) {
		WebElement el = Browser.getDriver().findElements(element_post_button).get(index);
		if (el.isEnabled() ) {
			el.click();

		}
	}

	public void enterText(WebElement el, String txt) {

		if (el.isEnabled()) {

			el.sendKeys(txt);
		}
	}

	public String getText(By element_posted_text) {	
		return Browser.getDriver().findElement(element_posted_text).getText().toString();
	}

	public void waitForElementTorender() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void moveToElement(WebElement el) {
		Actions actions = new Actions(Browser.getDriver());
		actions.moveToElement(el).perform();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void navigateLeftToRight() {
		Actions action = new Actions(Browser.getDriver());
		action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();
		String url = Browser.getCurrentUrl();
		Browser.getDriver().get(url);
	}

	public void navigateRightToLeft() {
		Actions action = new Actions(Browser.getDriver());
		action.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys(Keys.TAB).build().perform();
	}

	public void scrollTillEnd() {
		((JavascriptExecutor) Browser.getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void switchToNewWindow() {

//		String Tab1 = Browser.getDriver().getWindowHandle();
		ArrayList<String> availableWindows = new ArrayList<String>(Browser.getDriver().getWindowHandles());
		if (!availableWindows.isEmpty()) {
			Browser.getDriver().switchTo().window(availableWindows.get(1));
		}
	}

	public void refreshCurrentPage() {
		// TODO Auto-generated method stub
		Browser.getDriver().navigate().to(Browser.getCurrentUrl());

	}

	public String getCureentUrl() {
		// TODO Auto-generated method stub
		return Browser.getDriver().getCurrentUrl().toString();
	}

	public void getBackToPreviousPage() {
		Browser.getDriver().navigate().back();
		waitForElementTorender();

	}

	public void checkHomePageLink(By el, int pos) {
		List<WebElement> els = Browser.getDriver().findElements(el);
		String link = els.get(pos).getAttribute("href");
		Browser.getDriver().get(link);
	}

	public void waitUntilElementIsClickable(WebElement el) {
		WebDriverWait wait = new WebDriverWait(Browser.getDriver(), 30);
		wait.until(ExpectedConditions.elementToBeClickable(el));

	}

	public void getPageReresh() {
		Browser.getDriver().navigate().refresh();
	}

	public void moveToActiveElement() {
		Browser.getDriver().switchTo().activeElement();

	}

	public void waitUntilElementIsClickable(By element_posted_text) {
		WebDriverWait wait = new WebDriverWait(Browser.getDriver(), 30);
		wait.until(ExpectedConditions.elementToBeClickable(element_posted_text));
	}

	public void clickToFiveStar(By element_hover_star_selected,int index) {
		WebDriverWait wait = new WebDriverWait(Browser.getDriver(), 30);
		WebElement el = Browser.getDriver().findElements(element_hover_star_selected).get(index);
		wait.until(ExpectedConditions.elementToBeClickable(el)).click();
		
	}

	public void selectItemFromList(List<WebElement> element_drop_down_item_list, String policy) {
	
		for(int i = 0; i <element_drop_down_item_list.size(); i ++){
			if(element_drop_down_item_list.get(i).getText().toString().equalsIgnoreCase(policy)){
				element_drop_down_item_list.get(i).click();
				break;
			}
		}
		
	}

	public void clickToFiveStar(List<WebElement> element_rating_stars, int index) {
		
		WebDriverWait wait = new WebDriverWait(Browser.getDriver(), 30);
		WebElement el = element_rating_stars.get(index);
		wait.until(ExpectedConditions.elementToBeClickable(el)).click();
	}

	public void moveToElement(By element_user_menu) {
		Actions actions = new Actions(Browser.getDriver());
		WebElement el = Browser.getDriver().findElement(element_user_menu);
		actions.moveToElement(el).perform();
		
	}

	public void waitUntilElementIsClickable(
			List<WebElement> element_drop_down_item_list) {
		// TODO Auto-generated method stub
		
	}

}
