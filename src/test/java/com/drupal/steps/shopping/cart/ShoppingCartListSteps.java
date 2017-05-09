package com.drupal.steps.shopping.cart;

import com.drupal.pages.cart.ShoppingCartPage;
import com.drupal.steps.AbstractSteps;

import net.thucydides.core.annotations.Step;

public class ShoppingCartListSteps extends AbstractSteps {

	
	
	private ShoppingCartPage shoppingCartPage;
	
	@Step
	public String getPropertyValue(String productCode, String propertyName) {
		 return shoppingCartPage.getPropertyValue(productCode, propertyName);
	}

}
