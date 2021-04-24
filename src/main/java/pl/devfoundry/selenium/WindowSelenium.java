package pl.devfoundry.selenium;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowSelenium {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {

			driver.get("http://127.0.0.1:5500/index.html");
			Thread.sleep(5000);
			
			String window1 = driver.getWindowHandle();
			
			js.executeScript("window.open()");
			
			Set<String> windowHandles = driver.getWindowHandles();
			
			String window2=null;
			
			for (String string : windowHandles) {
				if(!string.equals(window1)) {
					window2 = string;
					break;
				}
			}
			
			driver.switchTo().window(window2);
			Thread.sleep(10000);
			driver.get("http://127.0.0.1:5500/index.html");
			driver.close();
			driver.switchTo().window(window1);


			
			

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}

}
