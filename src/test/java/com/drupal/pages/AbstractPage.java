package com.drupal.pages;

import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class AbstractPage extends PageObject {

    public AbstractPage() {

    }

    public static void clickAMenuItemFromList(WebElement webElement, String setTextSearch) {
        List<WebElement> itemList = webElement.findElements(By.tagName("li"));

        for (WebElement element : itemList) {
            if (element.findElement(By.cssSelector("a")).getText().contains(setTextSearch)) {
                element.findElement(By.cssSelector("a")).click();
                break;
            }
        }
    }
}
