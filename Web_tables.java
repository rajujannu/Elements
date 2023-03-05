package Selenium_Practies.Selenium_java;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Web_tables {

	// static table:- Data is static i.e... Numbers of rows and columns are fixed
	// Dynamic table:- Data is dynamic i.e... Numbers of rows and columns are not
	// fixed
	// <table> tag represent a web table
	// <td> tag represent a columns
	// <tr> tag represent a rows
	// <th> tag represent a heading
	// <thead> tag represent a heading
	// <tbody> tag represent the table body

	// Count No.of tables in web application
	// Count NO.of Rows and columns in a application
	// Get the value of Header fields
	// print the last rows and last column value
	// How to get Particular column value and row value

	WebDriver driver;

	@BeforeMethod
	void lanch() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.timeanddate.com/worldclock/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3000));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));

	}

	@Test
	void check_the_table() {
		List<WebElement> ele1 = driver.findElements(By.tagName("table"));
		System.out.println("No of Tables:-  " + ele1.size());

		List<WebElement> ele2 = driver.findElements(By.tagName("td"));
		System.out.println("No of columns:-  " + ele2.size());

		List<WebElement> ele3 = driver.findElements(By.tagName("tr"));
		System.out.println("No of rows:-   " + ele3.size());

		List<WebElement> ele4 = driver.findElements(By.tagName("th"));
		System.out.println("No of heading:-  " + ele4.size());

		List<WebElement> ele5 = driver.findElements(By.xpath("//table[@class='zebra fw tb-theme']/thead"));
		System.out.println("No of heading's in one table:-  " + ele5.size());

		List<WebElement> ele6 = driver.findElements(By.xpath("//table[@class='zebra fw tb-theme']/tbody/tr/td"));
		System.out.println("No of CEllS in a table:-   " + ele6.size());

		WebElement ele7 = driver.findElement(By.xpath("//table[@class='zebra fw tb-theme']/tbody/tr[1]"));
		System.out.println("Get the First Row Data:-   " + ele7.getText());

		List<WebElement> ele8 = driver.findElements(By.xpath("//table[@class='zebra fw tb-theme']/tbody/tr/td[1]"));
		System.out.println("Last column data:----" + ele8.size());
		
		for(int i=0;i<ele8.size();i++) {
			System.out.println(ele8.get(i).getText());
		}
			

		WebElement ele9 = driver.findElement(By.xpath("//table[@class='zebra fw tb-theme']/tbody/tr/td[8]"));
		System.out.println("Last column data:----" + ele9.getText());
		// 767659
		 WebElement ele10=driver.findElement(By.xpath("//table[@class='zebra fw tb-theme']//td[7]"));
		 System.out.println("Get 7th column Data :--  "+ ele10.getText());

	}

	@AfterMethod
	void close() {
		driver.quit();
	}

}
