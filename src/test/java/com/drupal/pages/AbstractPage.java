package com.drupal.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.pages.PageObject;

public class AbstractPage extends PageObject {


	WebDriver driver;

	protected WebElement findElementInList(List<WebElement> listElements, String searchTerm) {
		for (WebElement webElement : listElements) {
			if (webElement.getText().trim().contentEquals(searchTerm)) {
				return webElement;
			}
		}
		return null;
	}

	protected void waitForPageToLoad() {
		new WebDriverWait(driver, 30)
				.until(ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";"));
	}

	

}