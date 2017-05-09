package com.drupal.tests.account;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;

import com.beust.jcommander.Parameterized;
import com.drupal.pages.account.RegistrationPage;
import com.drupal.pages.header.UserZonePage;
import com.drupal.steps.RegistrationSteps;
import com.drupal.steps.UserZoneSteps;
import com.drupal.steps.navigation.NavigationSteps;
import com.drupal.tests.BaseTest;
import com.wiki.steps.EndUserSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import tools.Constants;

import tools.RandomData;

@RunWith(SerenityRunner.class)
public class US001CreateAccountTest extends BaseTest{
	

    @Steps
    public RegistrationSteps registrationSteps;
    @Steps
    public UserZoneSteps createAccountSteps;
    @Steps
    public NavigationSteps navigationSteps;
    

    public String url;
    public String userName;
    public String userEmail;
    public String userPassword;
    
    public String existingUserName;
    public String existingEmail;
    
    
    @Before
    public void dataSetup(){
    	url = Constants.HOST;
    	
    	userName = RandomData.getUniqueString(5, 9);
    	userEmail =  RandomData.getUniqueGmail("victortomaciprian") ;
    	userPassword = RandomData.getUniquePassword();
    	
    	existingUserName = "victor";
    	existingEmail = "victortomaciprian@gmail.com";
    	
    }
    @After
    public void closeDrive(){
    	super.webdriver.quit();
    	super.webdriver.close();
    }
    
    @Test
    public void us001CreateAccountTest(){

    	
    	navigationSteps.navigateTo(url);
    	createAccountSteps.goToRegistrationPage();
    	registrationSteps.typeUsername(userName);
    	registrationSteps.typeEmail(userEmail);
    	registrationSteps.typePassword(userPassword);
    	registrationSteps.typeConfirmPassword(userPassword);
    	registrationSteps.clickCreateNewAccountButton();
    	
   // 	assertEquals("Not the expected message","Status messageRegistration successful. You are now logged in.",
  	//		  registrationSteps.getRegistrationSuccesfulText());
    	assertTrue("Registration was unsuccesful", registrationSteps.getRegistrationSuccesfulText().contains("Registration successful. You are now logged in."));
    	assertFalse("Unable to send e-mail",registrationSteps.getEmailSentSuccesfullyMessage().contains("Unable to send e-mail. Contact the site administrator if the problem persists."));
    }
    
    
    @Ignore
    @Test
    public void us002CreateAccountWithExistingUserNameTest(){
    	navigationSteps.navigateTo(url);
    	createAccountSteps.goToRegistrationPage();
    	registrationSteps.typeUsername(existingUserName);
    	registrationSteps.typeEmail(userEmail);
    	registrationSteps.typePassword(userPassword);
    	registrationSteps.typeConfirmPassword(userPassword);
    	registrationSteps.clickCreateNewAccountButton();
    }
}
