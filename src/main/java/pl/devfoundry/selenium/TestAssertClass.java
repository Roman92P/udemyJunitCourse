package pl.devfoundry.selenium;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;



public class TestAssertClass {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebDriverWait wait = new WebDriverWait(driver, 1000); 
		try {

			driver.get("http://127.0.0.1:5500/index.html");
			Thread.sleep(5000);
			
			String title = driver.getTitle();
		
			Assert.assertEquals(title, "Document");
		
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}

}
