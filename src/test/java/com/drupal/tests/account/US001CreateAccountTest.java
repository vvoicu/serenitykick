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
    

    public String userName;
    public String userEmail;
    public String userPassword;
    
    public String existingUserName;
    public String existingEmail;
    
    
    @Before
    public void dataSetup(){
    	
    	userName = RandomData.getUniqueString(5, 9);
    	userEmail =  RandomData.getUniqueGmail("victortomaciprian") ;
    	userPassword = RandomData.getUniquePassword();
    	
    }
    
    @After
    public void closeDrive(){
    	super.webdriver.quit();
    	super.webdriver.close();
    }
  
    @Test
    public void us001CreateAccountTest(){

    	
    	navigationSteps.navigateTo(Constants.HOST);
    	createAccountSteps.goToRegistrationPage();
    	registrationSteps.typeUsername(userName);
    	registrationSteps.typeEmail(userEmail);
    	registrationSteps.typePassword(userPassword);
    	registrationSteps.typeConfirmPassword(userPassword);
    	registrationSteps.clickCreateNewAccountButton();
    	registrationSteps.assertAccountIsCreatedSuccessfuly();
    	
    }
    

    @Test
    public void us002CreateAccountWithExistingUserNameTest(){
    	navigationSteps.navigateTo(Constants.HOST);
    	createAccountSteps.goToRegistrationPage();
    	registrationSteps.typeUsername("victor");
    	registrationSteps.typeEmail(userEmail);
    	registrationSteps.typePassword(userPassword);
    	registrationSteps.typeConfirmPassword(userPassword);
    	registrationSteps.clickCreateNewAccountButton();
    	registrationSteps.assertUsernameAlreadyExists();
    	
    }
    
   
    @Test
    public void us003CreateAccountWithExistingEmailTest(){
    	navigationSteps.navigateTo(Constants.HOST);
    	createAccountSteps.goToRegistrationPage();
    	registrationSteps.typeUsername(userName);
    	registrationSteps.typeEmail("victortomaciprian@gmail.com");
    	registrationSteps.typePassword(userPassword);
    	registrationSteps.typeConfirmPassword(userPassword);
    	registrationSteps.clickCreateNewAccountButton();
    	registrationSteps.assertEmailAlreadyExists();
    	
    }
    
    @Test 
    public void us004RecoverPasswordTest(){
    	navigationSteps.navigateTo(Constants.HOST);
    	createAccountSteps.goToRegistrationPage();
    	registrationSteps.typeUsername(userName);
    	registrationSteps.typeEmail("victortomaciprian@gmail.com");
    	registrationSteps.typePassword(userPassword);
    	registrationSteps.typeConfirmPassword(userPassword);
    	registrationSteps.clickCreateNewAccountButton();
    	registrationSteps.clickRecoverPasswordLink();
    	registrationSteps.typeEmailForPasswordRecovery("victortomaciprian@gmail.com");
    	registrationSteps.clickSendEmailForPasswordRecoveryButton();
    	registrationSteps.assertEmailIsSent();
    }
    
    
}
