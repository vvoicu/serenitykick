package com.drupal.pages.header;

import com.drupal.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.annotations.findby.FindBy;

public class MenuNavigationPage extends AbstractPage{


    @FindBy(css = "#main-menu")
    private WebElement mainMenuItems;


    public void selectACategoryFromMainMenu(){
        clickAMenuItemFromList(mainMenuItems,"All Products");
    }
}
