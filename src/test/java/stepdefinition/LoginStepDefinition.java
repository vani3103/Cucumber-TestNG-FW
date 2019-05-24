package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinition {
WebDriver driver;

@Given("^open the browser$")
public void open_the_browser() throws Throwable {
	System.setProperty("webdriver.chrome.driver", "D:\\selenium libraries\\Jan 2018\\chromedriver.exe");
	 driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	
}

@Then("^enter the url$")
public void enter_the_url() throws Throwable {
	driver.get("http://localhost/vani3103");
	System.out.println("HomePage Title is :"+driver.getTitle());
}

@Then("^enter the valid emailid and password$")
public void enter_the_valid_emailid_and_password()   {
	driver.findElement(By.id("inputEmail")).sendKeys("admin@gmail.com");
	driver.findElement(By.id("inputPassword")).sendKeys("admin");
}

@When("^i click on login button$")
public void i_click_on_login_button() throws Throwable {
	driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();;
}

@Then("^user should logged to Admin dashboard page$")
public void user_should_logged_to_Admin_dashboard_page()   {
	System.out.println("DashBoard PageTitle is :"+driver.getTitle());
}
@Then("^enter the invalid emailid and password$")
public void enter_the_invalid_emailid_and_password()   {
	driver.findElement(By.id("inputEmail")).sendKeys("sai@admin.com");
	driver.findElement(By.id("inputPassword")).sendKeys("admin");
	
}

@Then("^user shouldnot  logged into Admin dashboard page$")
public void user_shouldnot_logged_into_Admin_dashboard_page()   {
	boolean flag=driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-exclamation-sign']/following::font")).isDisplayed();
	Assert.assertTrue(flag);
	System.out.println(driver.getTitle());
}


}
