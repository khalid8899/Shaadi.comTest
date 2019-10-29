package com.pageobject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

//import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.utility.utilityfunctions;

import java.util.Iterator;
import java.util.List;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class shaadiPageObject {
	protected WebDriver driver;
    static Logger log = Logger.getLogger(shaadiPageObject.class);
   
	
	public shaadiPageObject(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	@FindBy(xpath="//a[@id='sign_up_link']")
	private WebElement signupLink;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement emailIDField;
	
	@FindBy(xpath="//input[@name='password1']")
	private WebElement passwordField;
	
	@FindBy(xpath="//div[text()='Select']")
	private WebElement selectField;
	
	@FindBy(xpath="//input[@value='Male']")
	private WebElement SelectGender;
	
	@FindBy(xpath="(//button[text()='Next'])[2]")
	private WebElement nxtButton;
	
	@FindBy(xpath="//label[text()='Mother tongue']/following::div[3]//div")
	private WebElement motherTongue;
	
	public String selectFieldOpt= "//div[@class='Dropdown-option' and text()='%temp%']";
	

	
	
	public void CommunityRegistrationPage(String url) throws InterruptedException
	{
		Thread.sleep(2000);
	    driver.get(url);
		Thread.sleep(2000);
		driver.manage().window().maximize();
		System.out.println("Current Url is:" +driver.getCurrentUrl());
		
	}

	
	public void clicksignupOption()
	{
		
		try
		{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		utilityfunctions.waitForElementVisible(driver, signupLink);
		signupLink.click();
		Thread.sleep(2000);
		}
		catch(Exception e)
		{
		Assert.fail();
		}
		
		
	}

	public void enterbelowDetails(List<List<String>> data)
	{
		
		try
		{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//enter email id
		utilityfunctions.waitForElementVisible(driver, emailIDField);
		emailIDField.sendKeys(data.get(1).get(0));
		Thread.sleep(2000);
		
		//enter password
		utilityfunctions.waitForElementVisible(driver, passwordField);
		passwordField.sendKeys(data.get(1).get(1));
		Thread.sleep(1000);
		}
		catch(Exception e)
		{
		Assert.fail("unable to enter credentials");
		}
		
		
	}
	

	public void createProfileDD(String optdd) throws InterruptedException
	{
		
		//select profile from drop down 
		utilityfunctions.waitForElementVisible(driver, selectField);
		selectField.click();
		Thread.sleep(1000);
		//select opt 
		String opt=selectFieldOpt.replace("%temp%",optdd);
		driver.findElement(By.xpath(opt)).click();
		Thread.sleep(1000);
	
	}

	public void SelectGender() 
	{
		
		try
		
		{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		SelectGender.click();
		Thread.sleep(1000);
		utilityfunctions.waitForElementVisible(driver, nxtButton);
		nxtButton.click();
		}
		catch(Exception e)
		{
		Assert.fail();
		}
		
		
	}

	public void verifyMotherTongue(String url) {
		try
		{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//validate mother tongue for marathi community
		if(motherTongue.getText().equalsIgnoreCase(url))
		{
			System.out.println("Mother Tongue for"+ url + "community is:"+motherTongue.getText());
		}
		else
		{
			Assert.fail("Mother tongue is incorrect"+motherTongue.getText());
		}
		
		}
		catch(Exception e)
		{
		Assert.fail();
		}
		
	}
	
	
		
		
}
