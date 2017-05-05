package com.drupal.tests.account;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.drupal.steps.navigation.NavigationSteps;
import com.drupal.tests.BaseTest;
import com.wiki.steps.EndUserSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;



@RunWith(SerenityRunner.class)
public class US001CreateAccountTest extends BaseTest{
	

    @Steps
    public EndUserSteps endUserSteps;
    @Steps
    public NavigationSteps navigationSteps;
    

    public String url;
    public String userName;
    public String userEmail;
    public String userPassword;
    
    
    @Before
    public void dataSetup(){
    	url = "http://172.22.201.38:8080/";
    	userName = "";
    	userEmail = "";
    	userPassword = "";
    	
    }

    
    @Test
    public void us001CreateAccountTest(){
    	navigationSteps.navigateTo(url);
    }
}
