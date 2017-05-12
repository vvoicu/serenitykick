package com.gourmondo.tests;

import com.gourmondo.steps.HeaderSteps2;
import com.gourmondo.steps.LoginAndRegistrationSteps2;
import gherkin.lexer.He;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import tools.*;

@RunWith(SerenityRunner.class)
public class RegisterAnAccountTest2 extends BaseTest {


    EmailModel emailModel = new EmailModel();
    CustomerAccountModel customerAccountModel = new CustomerAccountModel();
    JavaMailAPIConnector javaMailAPIConnector = new JavaMailAPIConnector(EmailConstants.MAIL_STORE_PROTOCOL,EmailConstants.IMAPS,EmailConstants.IMAP_GMAIL,"mail@mail.com","password");
    @Before
    public void setup(){
        webdriver.manage().window().maximize();
        customerAccountModel.setDay("11");
        customerAccountModel.setMonth("05");
        customerAccountModel.setYear("2000");
        emailModel.setSender("info@gourmondo.de");
        emailModel.setSubject("www.gourmondo.de - erfolgreiche Registrierung als Kunde");
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
        loginAndRegistrationSteps2.setDayDropDown(customerAccountModel.getDay());
        loginAndRegistrationSteps2.setMonthDropDown(customerAccountModel.getMonth());
        loginAndRegistrationSteps2.setYearDropDown(customerAccountModel.getYear());
        loginAndRegistrationSteps2.setPasswordInput("12345678");
        loginAndRegistrationSteps2.setConfirmPasswordInput("12345678");
        loginAndRegistrationSteps2.clickCheckboxForPa();
        loginAndRegistrationSteps2.clickConfirmRegistrationButton();
        loginAndRegistrationSteps2.assertTheAccountWasCreated("Vielen Dank für Ihre Registrierung.");
        emailModel = javaMailAPIConnector.searchEmail(emailModel.getSender(),emailModel.getSubject());
        loginAndRegistrationSteps2.validateEmailData(emailModel,customerAccountModel);
    }

}
