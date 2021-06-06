package com.stepdefination;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepdefinition {
	public WebDriver driver = null;
	/*@Before("@run")//tag hooks in cucumber
	public void setUpforAll() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///D:/software/selenium/Offline%20website/index.html");
	}*/
	@Before("@run")//hooks in cucumber
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();	
	}
	/*@After
	public void tearDown() {
		driver.close();
	}*/
	

	@Given("User enters {string}")
	public void user_enters(String url) {
	   driver.get(url);
	}
	@When("user enter {string} and {string}")
	public void user_enter_and(String uname, String pass) {
		driver.findElement(By.id("email")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pass);
	}

	@When("click login button")
	public void click_login_button() {
		driver.findElement(By.xpath("//button")).click();
	}

	@Then("user will be on homepage")
	public void user_will_be_on_homepage() {
		Assert.assertEquals("JavaByKiran | Dashboard", driver.getTitle());

	}
	
	
	@Then("User should see the Logo")
	public void user_should_see_the_logo() {
		 WebElement logo = driver.findElement(By.tagName("img"));
	   Assert.assertTrue(logo.isDisplayed());
	}
	
	
	@When("User enter username,password and click on login button")
	public void user_enter_username_password_and_click_on_login_button() {
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
	}
	@When("User click on user sidemenu bar")
	public void user_click_on_user_sidemenu_bar() {
		driver.findElement(By.xpath("//span[text()='Users']")).click();
	}
	
	@Then("User will check the statelists in userpage")
	public void user_will_check_the_statelists_in_userpage() {
		List<WebElement> actStates = driver.findElements(By.xpath("//td[7]"));// address of gender
		for (WebElement actStateName : actStates) {
			String actualStateName = actStateName.getText();// male or female
			boolean flag = actualStateName.equals("Maharashtra") || actualStateName.equals("Punjab");
			System.out.println(actualStateName);
			Assert.assertTrue(flag);
		}
	}
}








	
	

	


