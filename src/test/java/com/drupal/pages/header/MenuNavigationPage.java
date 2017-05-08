package com.drupal.pages.header;

import org.openqa.selenium.WebElement;

import com.drupal.pages.AbstractPage;

import net.serenitybdd.core.annotations.findby.FindBy;

public class MenuNavigationPage extends AbstractPage{

	@FindBy(css = ".menu-633.first>a")
	WebElement toCarryMenuItem;
	

	@FindBy(css = ".menu-634>a")
	WebElement toDrinkWithItem;
}
