package com.drupal.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import com.drupal.pages.account.RegistrationPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import tools.RandomData;

public class RegistrationSteps extends AbstractSteps {
	private static final long serialVersionUID = 816308171341383739L;
	RegistrationPage registration = new RegistrationPage();
	RandomData random = new RandomData();
	

	@Step
	public void typeUsername(String userName) {
		registration.typeUsername(userName);

	}

	@Step
	public void typeEmail(String userEmail) {
		registration.typeEmail(userEmail);

	}

	@Step
	public void typePassword(String userPassword) {
		registration.typePassword(userPassword);

	}

	@Step
	public void typeConfirmPassword(String userPassword) {
		registration.typeConfirmPassword(userPassword);

	}
	
	@Step
	public void clickCreateNewAccountButton() {
		registration.clickCreateAccountButton();
	}
	@Step
	public String getRegistrationSuccesfulText() {
		// TODO Auto-generated method stub
		return registration.getRegistrationSuccesfulText();
	}
	
	@Step
	public String getEmailSentSuccesfullyMessage(){
		return registration.getEmailSentSuccesfullyText();
	}
	
	@Step
	public void assertAccountIsCreatedSuccessfuly(){
		registration.accountIsSuccessfulyRegistered();
	}
	
	
	
	@StepGroup
	public void performRegistration(){
		String userName = random.getUniqueString(5, 9);
		String email = random.getUniqueGmail("victortomaciprian");
		String password = random.getUniquePassword();
		
		typeUsername(userName);
		typeEmail(email);
		typePassword(password);
		typeConfirmPassword(password);
		
		clickCreateNewAccountButton();
		getRegistrationSuccesfulText();
		getEmailSentSuccesfullyMessage();
		assertAccountIsCreatedSuccessfuly();
	}
	
	@Step
	public void assertUsernameAlreadyExists(){
		registration.usernameAlreadyExists();
	}
	
	@Step
	public void assertEmailAlreadyExists(){
		registration.emailAlreadyExists();
	}
	
	@Step
	public void clickRecoverPasswordLink(){
		registration.clickRecoverPasswordLink();
	}
	
	@Step
	public void typeEmailForPasswordRecovery(String recoveryEmail){
		registration.typeEmailForPasswordRecovery(recoveryEmail);
	}
	
	@Step 
	public void clickSendEmailForPasswordRecoveryButton(){
		registration.clickSendPasswordToEmailButton();
	}
	
	@Step
	public void assertEmailIsSent(){
		registration.unableToSendEmailErrorMessage();
	}

}
