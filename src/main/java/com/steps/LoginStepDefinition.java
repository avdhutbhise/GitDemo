package com.steps;

import com.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {
	
	public LoginPage lp=new LoginPage();
	
	@Given("Launch Browser and navigate to URL")
	public void launch_browser_and_navigate_to_url() {
	    // Write code here that turns the phrase above into concrete actions
	    lp.launch_browser();
	}
	
	/*
	@When("Enter Username")
	public void enter_username() {
	    // Write code here that turns the phrase above into concrete actions
	    lp.enter_username();
	}

	@When("Enter Password")
	public void enter_password() {
	    // Write code here that turns the phrase above into concrete actions
	    lp.enter_password();
	}
	*/
	
	@When("Click on LoginButton")
	public void click_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions
	    lp.click_login();
	}

	@Then("Verify Home Page is displayed")
	public void verify_home_page_is_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    lp.verify_home_page();
	}

	@When("Enter Username {string}")
	public void enter_username(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    lp.enter_username(string);
	}

	@When("Enter Password {string}")
	public void enter_password(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    lp.enter_password(string);
	}
	
	@Then("Close the browser")
	public void close_the_browser() {
	    // Write code here that turns the phrase above into concrete actions
	    lp.close();
	}
}
