package Date_13_08;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class MultiCheckbox {
	public static void main(String[] args) throws InterruptedException {
        // WebDriverManager.chromedriver().setup();
        ChromeOptions chromeopt = new ChromeOptions();
        WebDriver driver = new ChromeDriver(chromeopt);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        Thread.sleep(2500);

        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        for(WebElement w:checkboxes){
            w.click();
        }
        System.out.println( "Hello World!" );
    }
}
