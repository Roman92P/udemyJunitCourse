package pl.devfoundry.selenium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ModalClass {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebDriverWait webDriverWait = new WebDriverWait(driver, 1000);
		
		try {
			
			driver.get("http://127.0.0.1:5500/index.html");
			Thread.sleep(5000);
			
			WebElement element1 = driver.findElement(By.id("a"));
			WebElement element2 = driver.findElement(By.id("b"));
			WebElement element3 = driver.findElement(By.id("c"));
			
			element1.click();
			
			Alert alert = webDriverWait.until(ExpectedConditions.alertIsPresent());
			alert.accept();
			
			element2.click();
			
			Alert prompt = webDriverWait.until(ExpectedConditions.alertIsPresent());
			
			prompt.sendKeys("Example text message!");
			prompt.accept();
			
			Alert alert2= webDriverWait.until(ExpectedConditions.alertIsPresent());
			Thread.sleep(5000);
			alert2.dismiss();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}

}
