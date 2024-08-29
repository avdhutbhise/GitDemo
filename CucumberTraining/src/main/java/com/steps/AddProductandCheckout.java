package com.steps;

import com.pages.ProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddProductandCheckout {
	
	
	ProductsPage p=new ProductsPage();
	
	@Given("Login is successful")
	public void login_is_successful() {
	    // Write code here that turns the phrase above into concrete actions
		p.launch_browser();
		p.enter_username("standard_user");
		p.enter_password("secret_sauce");
		p.click_login();
		p.verify_home_page();
	}

	@When("I add products to cart")
	public void i_add_products_to_cart() {
	    // Write code here that turns the phrase above into concrete actions
	    p.click_on_add_to_cart(2);
	    p.click_on_cart();
	}

	@When("I proceed to checkout")
	public void i_proceed_to_checkout() {
	    // Write code here that turns the phrase above into concrete actions
	    p.verify_cart_page();
	    p.click_checkout();
	    p.verify_checkout_page();
	}

	@When("I confirm First Name, Last Name,Postal Code")
	public void i_confirm_first_name_last_name_postal_code() {
	    // Write code here that turns the phrase above into concrete actions
	    p.fill_checkout_info();
	    p.click_on_continue();
	}

	@Then("The products are bought")
	public void the_products_are_bought() {
	    // Write code here that turns the phrase above into concrete actions
	    p.click_on_finish();
	    p.verify_checkout_complete_page();
	}

}
