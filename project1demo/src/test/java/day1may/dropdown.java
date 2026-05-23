package day1may;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropdown {

	public static void main(String[] args) throws Exception {
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Dropdown")).click();
		Thread.sleep(2000);
		WebElement dropdown= driver. findElement(By.id("dropdown"));
		dropdown.click();
		Thread.sleep(1000);
		
		Select select=new Select(dropdown);
		
		//select.selectByIndex(1);
		//select.selectByValue("1");
		select.selectByVisibleText("Option 2");
		driver.quit();

}
}