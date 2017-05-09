package com.drupal.tests.shopping.cart;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.drupal.steps.product.AllProductsSteps;
import com.drupal.steps.shopping.cart.ShoppingCartListSteps;
import com.drupal.tests.BaseTest;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class US010ShoppingCartListTest extends BaseTest {

	public String url = "";

	@Before
	public void setup() {
		url = "http://172.22.120.86:8080/";
		webdriver.manage().window().maximize();
	}

	@Steps
	private AllProductsSteps allProductsSteps;

	@Steps
	private ShoppingCartListSteps shoppingCartListSteps;

	@Test
	public void testName() {
	}

}
