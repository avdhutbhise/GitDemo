package com.pages;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class ProductsPage extends LoginPage{
	
	//locators
	By add_to_cart_btn=By.xpath("//div[@class='pricebar']/button");
	By cart_btn=By.cssSelector(".shopping_cart_link");
	By cart_text=By.xpath("//div[@class=\"header_secondary_container\"]/span");
	By checkout_btn=By.id("checkout");
	By checkout_text=By.xpath("//div[@class=\"header_secondary_container\"]/span");
	By first_name=By.id("first-name");
	By last_name=By.id("last-name");
	By postal_code=By.id("postal-code");
	By continue_btn=By.id("continue");
	By finish_btn=By.id("finish");
	
	public void click_on_add_to_cart(int n)
	{
		List<WebElement> add_cart = driver.findElements(add_to_cart_btn);
		
		for(WebElement x:add_cart)
		{
			x.click();
		}
	}
	
	public void click_on_cart()
	{
		driver.findElement(cart_btn).click();
	}
	
	public void verify_cart_page()
	{
		assertEquals("Your Cart", driver.findElement(cart_text).getText());
		System.out.println("Cart Page is verified");
	}
	
	public void click_checkout()
	{
		driver.findElement(checkout_btn).click();
	}
	
	public void verify_checkout_page()
	{
		assertEquals("Checkout: Your Information", driver.findElement(checkout_text).getText());
		System.out.println("Checkout Page is verified");
	}
	
	public void fill_checkout_info()
	{
		driver.findElement(first_name).sendKeys("Avdhut");
		driver.findElement(last_name).sendKeys("Bhise");
		driver.findElement(postal_code).sendKeys("765478");
	}
	
	public void click_on_continue()
	{
		driver.findElement(continue_btn).click();
	}
	
	public void click_on_finish()
	{
		driver.findElement(finish_btn).click();
	}
	
	public void verify_checkout_complete_page()
	{
		assertEquals("Checkout: Complete!", driver.findElement(checkout_text).getText());
		System.out.println("Checkout Complete Page is verified");
	}
}
