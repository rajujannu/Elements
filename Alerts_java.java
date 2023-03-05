package Selenium_Practies.Selenium_java;

import java.time.Duration;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts_java {

	WebDriver driver;

	@BeforeMethod
	void lanch() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();

		driver.get("http://omayo.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3000));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));

	}

	@Test
	void Popups() throws InterruptedException {

		driver.findElement(By.id("alert1")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept(); // Simple Alert

		driver.findElement(By.id("prompt")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().sendKeys("raju"); // prompt Alert
		Thread.sleep(2000);
		driver.switchTo().alert().accept();

		driver.findElement(By.id("confirm")).click(); // Confirm alert
		Thread.sleep(2000);
		String ele = driver.switchTo().alert().getText();
		System.out.println(ele);
		driver.switchTo().alert().accept();

		System.out.println();

	}

}
