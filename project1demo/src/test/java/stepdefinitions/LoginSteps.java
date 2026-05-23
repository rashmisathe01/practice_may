package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;

public class LoginSteps {
	WebDriver driver;
	@Given("user opens the browser")
	public void user_opens_the_browser() {
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	 
	      
	}

	@And("user navigates to {string}")
	public void user_navigates_to(String url) {
	     driver.get(url);
	   
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
		   
		driver.findElement(By.id("username")).sendKeys(username);
	}

	@And("user enters password {string}")
	public void user_enters_password(String password) {
		 driver.findElement(By.id("password")).sendKeys(password); 
	
	}

	@And("user clicks on login button")
	public void user_clicks_on_login_button() {

	    WebElement btn = driver.findElement(By.id("submit"));

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    // Wait for visibility
	    wait.until(ExpectedConditions.visibilityOf(btn));

	    // Scroll to center (important fix)
	    ((JavascriptExecutor) driver).executeScript(
	        "arguments[0].scrollIntoView({block: 'center'});", btn
	    );

	    // Wait for clickable
	    wait.until(ExpectedConditions.elementToBeClickable(btn));

	    // Click
	    btn.click();
	}
	@Then("user should see message {string}")
	public void user_should_see_message(String expected_message) {
		String actual=driver.findElement(By.id("flash")).getText();
		if(!actual.contains(expected_message)) {
			throw new AssertionError("expected: "+expected_message+" but got:"+actual);
		}
	     driver.quit();
	      
	}




}
