package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGTestCase {
	@Test
	public void launchbrowser() {
		  ChromeOptions chromeOptions = new ChromeOptions();
	        WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver(chromeOptions);
	        driver.get("https://the-internet.herokuapp.com/windows");
	        driver.manage().window().maximize();
	}  	
}
