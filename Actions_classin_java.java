package Selenium_Practies.Selenium_java;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Actions_classin_java {

	WebDriver driver;

	@BeforeMethod
	void lanch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://omayo.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3000));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
	}
	
	@Test
	void Scroll() {
		
		driver.findElement(By.xpath("//input[@name='userid']")).sendKeys("jhgfh"); // clicking the Element with out using Actions class Why ?
		
		driver.findElement(By.linkText("jqueryui")).click();
		driver.findElement(By.linkText("Draggable")).click();
		
		Actions action=new Actions(driver);  //Actions class used for Automate the Keyboard and Mouse
		driver.switchTo().frame(1);    //Element in side the iframe 
		
		
		
		
		
		
		driver.findElement(By.)
		
		
		
		
		
	}
      
}
