package commonLibs.implementation;

import org.openqa.selenium.WebElement;

public class Interactions {
	
	public String getText(WebElement element) throws Exception
	{
		return element.getText();
	}

	public void clickElement(WebElement element) throws Exception
	{
		element.click();
	}
	
	public String getAttribute(WebElement element, String attribute)throws Exception
	{
		return element.getAttribute(attribute);
	}
	
	public void setText(WebElement element, String text)throws Exception
	{
		element.sendKeys(text);
	}
}
