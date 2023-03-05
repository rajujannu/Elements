package Selenium_Practies.Selenium_java;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Links_in_webapplication {

	WebDriver driver; // displayed

	@BeforeMethod
	void Launch_web_application() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://omayo.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3000));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));

	}

	@Test(priority = 1)
	void count_of_links() {
		List<WebElement> nooflinks = driver.findElements(By.tagName("a"));

		int displayed = 0;

		for (int i = 0; i < nooflinks.size(); i++) {
			if (nooflinks.get(i).isDisplayed()) {
				displayed++;

			}
			System.out.println("No of Displayed" + displayed);
			System.out.println("No of links in web page " + nooflinks.size());
			System.out.println("No of invisible links" + (nooflinks.size() - displayed));
			System.out.println("Name of links " + nooflinks.get(displayed).getText());

		}
	}

	@Test(priority = 2)
	void header() {
		List<WebElement> tittle = driver.findElements(By.tagName("h1"));
		System.out.println(tittle.size());
		Assert.assertEquals(tittle.get(0).getText(), "omayo (QAFox.com)");

//		for (int j = 0; j < tittle.size(); j++) {
//		System.out.println(tittle.get(j).getText());
//
//		}

	}

	@Test(priority = 3)
	void radio_buttons() {
		List<WebElement> button = driver.findElements(By.xpath("//input[@type='radio']"));
		System.out.println(button.size());

		for (int k = 0; k < button.size(); k++)

		// Statement , condensation statement , incremantal statement
		{
			System.out.println(button.get(k).getAttribute("value"));

			if (button.get(k).isSelected()) 
			{
				System.out.println("Active");
			}

			else {
				System.out.println("inactive");
			}

		}

	}

	@Test(priority = 4)
	void Dropdwons() throws InterruptedException {

		List<WebElement> drop = driver.findElements(By.tagName("select"));
		System.out.println("No of Dropdwons" + drop.size()); // Count the number of dropD in a web application

		Thread.sleep(3000);

		WebElement qaz = driver.findElement(By.id("drop1"));
		List<WebElement> ele1 = qaz.findElements(By.tagName("option")); // count the numbers of opp in one dropwon i one
																		// ele
		System.out.println("No of Values in dropdwons" + ele1.size());

		for (int a = 0; a < ele1.size(); a++) {
			System.out.println(ele1.get(a).getAttribute("value")); // print the value

			if (ele1.get(a).isSelected()) {
				System.out.println("Isselected");
			} else {
				System.out.println("Un selected");
			}
		}
		// driver.findElement(By.id("drop1")).sendKeys("fghgc4");

		Select st1 = new Select(driver.findElement(By.id("drop1")));
		// st1.selectByIndex(2); // 0123
		st1.selectByVisibleText("doc 2");
		// st1.selectByValue("doc 1");
		// and selectByvalue
		Thread.sleep(3000);
		

		WebElement wsx = st1.getFirstSelectedOption();
		String selectedvalue = wsx.getText();
		System.out.println(selectedvalue); // print the selected value

	}

	@Test(priority = 5)
	void using_getattribute() { // using the getOptions method to get the dropdwon values

		Select all = new Select(driver.findElement(By.id("drop1")));
		List<WebElement> qa = all.getOptions();
		System.out.println(qa.size());

		for (int k = 0; k < qa.size(); k++) {
			WebElement ele = qa.get(k);
			System.out.println(ele.getAttribute("value"));
		}

	}

	@Test
	void images() throws IOException {
		List<WebElement> imgs = driver.findElements(By.tagName("img"));
		System.out.println(imgs.size());
		for (int io = 0; io < imgs.size(); io++) {
			System.out.println("each img " + imgs.get(io).getAttribute("src"));

		}

		WebElement imgvalue = driver.findElement(By.xpath(
				"//img[@src='https://assets.about.me/background/www.softwaretestingcollege.blogspot.com_1330713399_12.jpg']"));

		String qwe = imgvalue.getAttribute("src");
		URL edc = new URL(qwe);
		BufferedImage asd = ImageIO.read(edc);
		ImageIO.write(asd, "png", new File("logo-image.png"));

	}

	@Test
	void text() throws InterruptedException {
		List<WebElement> qwe = driver.findElements(By.tagName("p"));
		System.out.println("No of total normal TEXT  " + qwe.size());
//		Thread.sleep(2000);
//		List<WebElement>asd = driver.findElements(By.tagName("b"));
//		System.out.println("No of Bold Text"+ asd.size());

	}

	@AfterMethod
	void close_web_application() {

		driver.quit();
	}

}
