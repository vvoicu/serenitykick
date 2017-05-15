package com.gourmondo.tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.gourmondo.steps.RegisterSteps1;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import tools.CustomerAccountModel;
import tools.EmailConstants;
import tools.EmailModel;
import tools.JavaMailAPIConnector;

@RunWith(SerenityRunner.class)

public class RegisterTest1 {

	@Managed(uniqueSession = true)
	WebDriver webdriver;

	String subject;
	String sender;
	JavaMailAPIConnector javaMailAPIConnector = new JavaMailAPIConnector(EmailConstants.MAIL_STORE_PROTOCOL,
			EmailConstants.IMAPS, EmailConstants.IMAP_GMAIL, "gourmondoevotest@gmail.com", "Gourmondo.test");
	EmailModel emailModel;
	CustomerAccountModel customerAccountModel;

	@Before
	public void dataSetup() {
		webdriver.get("https://test-de.gourmondo.evozon.com:9002/");
		emailModel = new EmailModel();
		customerAccountModel = new CustomerAccountModel();
		customerAccountModel.setFirstName("firstname");
		customerAccountModel.setLastName("lastname");
		customerAccountModel.setMonth("12");
		customerAccountModel.setTitle("Frau");
		customerAccountModel.setYear("1980");
		customerAccountModel.setDay("10");

		subject = "www.gourmondo.de - erfolgreiche Registrierung als Kunde";
		sender = "info@gourmondo.de";
	}

	@Steps
	public RegisterSteps1 registerSteps1;

	@Test
	public void createAnAccountTest() {

		registerSteps1.clickToLoginItem();
		registerSteps1.clicktoSwichtoRegisterItem();
		// registerSteps1.clickToPrivateClient();
		// registerSteps1.selectGender();
		registerSteps1.typeFirstName(customerAccountModel.getFirstName());
		registerSteps1.typeLastName(customerAccountModel.getLastName());
		registerSteps1.typeEmail("gourmondoevotest@gmail.com");

		registerSteps1.selectDay(customerAccountModel.getDay());
		registerSteps1.selectMonth(customerAccountModel.getMonth());
		registerSteps1.selectYear(customerAccountModel.getYear());
		registerSteps1.setThePassword("Gourmondo.test");
		registerSteps1.confirmPassword("Gourmondo.test");
		registerSteps1.checkTheJaCheckBox();
		registerSteps1.clickTSubmit();

		emailModel = javaMailAPIConnector.searchEmail(sender,subject);
		registerSteps1.validateDate(emailModel, customerAccountModel);
	}

}
