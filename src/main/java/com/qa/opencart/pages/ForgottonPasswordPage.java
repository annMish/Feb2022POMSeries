package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgottonPasswordPage {

	private WebDriver driver;

	private By forgotYourPasswordtext = By.cssSelector("div#content h1");
	private By emailAddress = By.xpath("//input[@id='input-email']");
	private By clickContinue = By.xpath("//div[@class='pull-right']/input");

	public ForgottonPasswordPage(WebDriver driver) {
		this.driver = driver;
	}

	

	public String verifyforgotYourPasswordTextdisplayed() {
		String text = driver.findElement(forgotYourPasswordtext).getText();
		return text;
	}

	public void enterEmail() {
	 driver.findElement(emailAddress).sendKeys("abc@gmail.com");
	
		
		}

	public void clickContinue() {
		driver.findElement(clickContinue).click();
	//	return landing page obj;
	}

}
