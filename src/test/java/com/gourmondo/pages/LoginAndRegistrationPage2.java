package com.gourmondo.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import tools.CustomerAccountModel;
import tools.EmailModel;
import tools.Helpers;

import java.util.List;

/**
 * Created by sebastianciocan on 5/11/2017.
 */
public class LoginAndRegistrationPage2 extends AbstractPage {

    @FindBy(css = "#switch-to-register div")
    private WebElement switchToRegistrationButton;

    @FindBy(css = "input[id='registerClientForm-firstName']")
    private WebElement firstNameInput;

    @FindBy(css = "input[id='registerClientForm-lastName']")
    private WebElement lastNameInput;

    @FindBy(css = "input[id='registerClientForm-email']")
    private WebElement emailInput;

    @FindBy(css = "#registerClientForm-birthDay .SelectDate:nth-of-type(1)")
    private WebElement dayDropDown;

    @FindBy(css = "#registerClientForm-birthDay .SelectDate:nth-of-type(2)")
    private WebElement monthDropDown;

    @FindBy(css = "#registerClientForm-birthDay .SelectDate:nth-of-type(3)")
    private WebElement yearDropDown;

    @FindBy(css = "input[id='registerClientForm-password']")
    private WebElement passwordInput;

    @FindBy(css = "input[id='registerClientForm-checkPwd']")
    private WebElement confirmPasswordInput;

    @FindBy(css = "label[for='registerClientForm-termsConditionsCheck'] span")
    private WebElement checkBoxForPa;

    @FindBy(css = "#registerClientForm button[class='btn btn-lg btn-primary text-uppercase']")
    private WebElement confirmRegistrationButton;

    @FindBy(css = ".alert.positive div")
    private WebElement registrationSuccessfulMessage;


    public void clickSwitchToRegistrationButton(){
        element(switchToRegistrationButton).waitUntilVisible();
        switchToRegistrationButton.click();
    }
    public void setFirstNameInput(String firstName){
        element(firstNameInput).waitUntilVisible();
        typeInto(firstNameInput,firstName);
    }
    public void setLastNameInput(String lastName){
        element(lastNameInput).waitUntilVisible();
        typeInto(lastNameInput,lastName);
    }
    public void setEmailInput(String email){
        element(emailInput).waitUntilVisible();
        typeInto(emailInput,email);
    }
    public void setDayDropDown(String day){
        dayDropDown.click();
        List<WebElement> daysLists = dayDropDown.findElements(By.cssSelector("ul li"));
        for(WebElement selectDay : daysLists){
            if(selectDay.findElement(By.cssSelector("a span")).getText().contentEquals(day)){
                selectDay.click();
            }
        }

    }
    public void setMonthDropDown(String month){
        monthDropDown.click();
        List<WebElement> monthsLists = monthDropDown.findElements(By.cssSelector("ul li"));
        for(WebElement months : monthsLists){
            if(months.findElement(By.cssSelector("a span")).getText().contentEquals(month)){
                months.click();
            }
        }
    }
    public void setYearDropDown(String year){
        yearDropDown.click();
        List<WebElement> yearsLists = yearDropDown.findElements(By.cssSelector("ul li"));
        for(WebElement years : yearsLists){
            if(years.findElement(By.cssSelector("a span")).getText().trim().contentEquals(year)){
                years.click();
            }
        }
    }
    public void setPasswordInput(String password){
        element(passwordInput).waitUntilVisible();
        typeInto(passwordInput,password);
    }
    public void setConfirmPasswordInput(String confirmPassword){
        element(confirmPasswordInput).waitUntilVisible();
        typeInto(confirmPasswordInput,confirmPassword);
    }
    public void clickCheckboxForPa(){
        element(checkBoxForPa).waitUntilVisible();
        checkBoxForPa.click();
    }
    public void clickConfirmRegistrationButton(){
        element(confirmRegistrationButton).waitUntilVisible();
        confirmRegistrationButton.click();
    }
    public void assertTheAccountWasCreated(String message){
        element(registrationSuccessfulMessage).waitUntilVisible();
        Assert.assertTrue("The account was created message is not displayed!",registrationSuccessfulMessage.getText().contentEquals(message));
    }
    public void validateEmailData(EmailModel emailModel, CustomerAccountModel customerAccountModel){

        waitABit(5000);

        Assert.assertTrue("The title does not match!",emailModel.getContent().contains(customerAccountModel.getTitle()));

        Assert.assertTrue("First name does not match!",emailModel.getContent().contains(customerAccountModel.getFirstName()));

        Assert.assertTrue("Last name does not match!",emailModel.getContent().contains(customerAccountModel.getLastName()));

        Assert.assertTrue("The Date is incorrect!",emailModel.getContent().contains(Helpers.getDate(customerAccountModel)));

    }
}
