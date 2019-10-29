package com.stepdefn;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.pageobject.shaadiPageObject;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;


public class shaadiStepdefinition
{
	private Logger log = Logger.getLogger(shaadiStepdefinition.class.getName());
	protected WebDriver driver;
	private shaadiPageObject pageObject;
	public String community;

	
	// Initialize browser
	@Before
	public void setDriver()
	{
		
		try
		{
			System.setProperty("webdriver.chrome.driver","webdriver/chromedriver_win.exe");
			driver=new ChromeDriver();
		}
		catch(Exception e)
		{
			Assert.fail("unable to launch webdriver");
		}

	}

	
	@Given("^Navigate to Community Registration Page \"([^\"]*)\"$")
	public void registrationPage(String url)
	{
		try
		{
			pageObject = new shaadiPageObject(driver);
			pageObject.CommunityRegistrationPage(url);
		}
		catch (Exception e) 
		{
			Assert.fail(e.getMessage());
		}
		
	}
	
	
	@And("^Click SignUp option$")
	public void clicksignupOption()
	{
		try
		{
			pageObject = new shaadiPageObject(driver);
			pageObject.clicksignupOption();
		}
		catch (Exception e) 
		{
			Assert.fail(e.getMessage());
		}

	}
	
	
	@And("^Enter Below Details$")
	public void enterbelowDetails(DataTable table) throws Throwable
	{
		try
		{
			Thread.sleep(2000);
			List<List<String>> data = table.asLists(String.class);
			Thread.sleep(3000);
			pageObject = new shaadiPageObject(driver);
			pageObject.enterbelowDetails(data);
		}
		catch(Exception e)
		{
			Assert.fail(e.getMessage());
		}
		
	}

	
	@Given("^Create Profile for \"([^\"]*)\"$")
	public void createProfileDD(String url)
	{
		try
		{
			pageObject = new shaadiPageObject(driver);
			pageObject.createProfileDD(url);
		}
		catch (Exception e) 
		{
			Assert.fail(e.getMessage());
		}

	}
	
		
	@And("^Select Gender$")
	public void SelectGender()
	{
		try
		{
			pageObject = new shaadiPageObject(driver);
			pageObject.SelectGender();
		}
		catch (Exception e) 
		{
			Assert.fail(e.getMessage());
		}

	}
	
	@Given("^Verify MotherTongue for \"([^\"]*)\"$")
	public void verifyMotherTongue(String url)
	{
		try
		{
			pageObject = new shaadiPageObject(driver);
			pageObject.verifyMotherTongue(url);
		}
		catch (Exception e) 
		{
			Assert.fail(e.getMessage());
		}
	}
	
	
	//closing all browser instances 
	@After
	public void closebrowser()
	{	
		try
		{
			driver.quit();
			System.out.println("browser closed successfully");
		}
		catch(Exception e)
		{
			Assert.fail("unable to close browser");
		}

	}



}







