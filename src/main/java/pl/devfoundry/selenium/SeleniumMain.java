package pl.devfoundry.selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeleniumMain {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//		driver.get("https://google.com");
//		

//		
//		WebElement inputElement = driver.findElement(By.xpath("//input[@aria-label='Szukaj']"));
//		
//		WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(10))
//				.until(ExpectedConditions.presenceOfElementLocated(By.id("123"))));

//		inputElement.click();

//		driver.get("https://www.avito.ru/rossiya/avtomobili");

//		WebElement element = driver.findElement(By.xpath("(//a[text()='Автомобили'])[1]"));
//		WebElement element = driver.findElement(By.cssSelector(".popular-rubricator-count-1xZYg"));

//		String attribute = element.getText();
//		String attribute = element.getCssValue("color");
//		
//		System.out.println(attribute);

//      move element		
//		try {
//			driver.get("https://crossbrowsertesting.github.io/drag-and-drop");
//			Thread.sleep(2000);
//			WebElement element1 = driver.findElement(By.id("draggable"));
//			WebElement element2 = driver.findElement(By.id("droppable"));
//			
//			Actions actions = new Actions(driver);
//			
//			actions.moveToElement(element1)
//			.clickAndHold()
//			.moveToElement(element2)
//			.release()
//			.build()
//			.perform();

//		or	actions.dragAndDrop(element1, element2)

//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}finally {
//			Thread.sleep(20000);
//			driver.quit();
//		}

// 		oczekiwanie że objekt przepadnie z DOM'u

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			driver.get("https://pagination.js.org/");
			Thread.sleep(2000);

			List<WebElement> elements = driver.findElements(By.xpath("//div[@class='data-container']/ul/li"));
			List<WebElement> pages = driver.findElements(By.xpath("//div[@class='paginationjs-pages']/ul/li"));

			pages.get(2).click();

			wait.until(ExpectedConditions.stalenessOf(elements.get(5)));

			elements = driver.findElements(By.xpath("//div[@class='data-container']/ul/li"));
			for (WebElement we : elements) {
				System.out.println(we.getText());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.quit();
			
		}

// funkcje objektu actions		
//		actions.moveToElement()
//		.keyDown()
//		.keyUp()
//		.clickAndHold()
//		.release()
//		.build()
//		.perform();
	}

}
