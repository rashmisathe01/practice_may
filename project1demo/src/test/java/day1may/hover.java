package day1may;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class hover {

	public static void main(String[] args) throws Exception {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		
		Thread.sleep(1000);
		WebElement accountLink =driver.findElement(By.id("nav-link-accountList"));
	Actions action= new Actions(driver);
	action.moveToElement(accountLink).perform();

	}

}
