package com.QA.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.Base.TestBase;

public class Loginpage{

	WebDriver driver;
	
	@FindBy(xpath="//*[@name='username']")
	private WebElement user_name;
	
	@FindBy(id="password")
	private WebElement pass_word;
     
	@FindBy(xpath="//ul[@id='sessionLocation']//li")
	private List <WebElement> locations;
	
	@FindBy(id="loginButton")
	private WebElement login_button;
	
	@FindBy(xpath="//div[@class='logo']/a/img")
	private WebElement logo_on_loginpage;
	
	public Loginpage(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	public String username(String usernameData) {
		user_name.sendKeys(usernameData);
		return usernameData;
	}
	
	public String password(String passwordData) {
		pass_word.sendKeys(passwordData);
		return passwordData;
	}
	
	public void selectlocation(String opt) {
		
		for(WebElement wb :locations) {
			
			if(wb.getText().equals(opt)) {
				wb.click();
			}
		}
	}
	
	public void loginButton() {
		login_button.click();
	}
	
	
}
