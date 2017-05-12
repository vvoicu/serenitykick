package com.gourmondo.tests;

import com.gourmondo.steps.HeaderSteps2;
import com.gourmondo.steps.LoginAndRegistrationSteps2;
import gherkin.lexer.He;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import tools.Constants;
import tools.Helpers;

@RunWith(SerenityRunner.class)
public class RegisterAnAccountTest2 extends BaseTest {



    @Before
    public void setup(){
        webdriver.manage().window().maximize();
    }

    @Steps
    public HeaderSteps2 headerSteps2;
    @Steps
    public LoginAndRegistrationSteps2 loginAndRegistrationSteps2;

    @Test
    public void createANewAccount(){
        webdriver.get(Constants.GOURMONDO_HOST);
        headerSteps2.clickLoginAndRegisterButton();
        loginAndRegistrationSteps2.clickSwitchToRegistrationFormButton();
        loginAndRegistrationSteps2.setFirstNameInput("FirstName");
        loginAndRegistrationSteps2.setLastNameInput("LastName");
        loginAndRegistrationSteps2.setEmailInput("asgass" + Helpers.date() + "@adsgacc.com");
        loginAndRegistrationSteps2.setDayDropDown("11");
        loginAndRegistrationSteps2.setMonthDropDown("05");
        loginAndRegistrationSteps2.setYearDropDown("2000");
        loginAndRegistrationSteps2.setPasswordInput("12345678");
        loginAndRegistrationSteps2.setConfirmPasswordInput("12345678");
        loginAndRegistrationSteps2.clickCheckboxForPa();
        loginAndRegistrationSteps2.clickConfirmRegistrationButton();
        loginAndRegistrationSteps2.assertTheAccountWasCreated("Vielen Dank für Ihre Registrierung.");
    }

}
