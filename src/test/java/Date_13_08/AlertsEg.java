package Date_13_08;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsEg {

	public static void main(String[] args)throws InterruptedException {
		ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        // Simple Alert
        WebElement simplealert = driver.findElement(By.cssSelector("button[onclick='jsAlert()']"));
        simplealert.click();
        Alert alt = driver.switchTo().alert();
        alt.accept();
        Thread.sleep(2000); // give page time after alert close
        
        // Confirm Alert
        WebElement confirmalert = driver.findElement(By.cssSelector("button[onclick='jsConfirm()']"));
        confirmalert.click();
        Alert alt1 = driver.switchTo().alert();
        alt1.dismiss();
        Thread.sleep(2000);

        // Prompt Alert
        WebElement promptalert = driver.findElement(By.cssSelector("button[onclick='jsPrompt()']"));
        promptalert.click();
        Alert alt2 = driver.switchTo().alert();
        String alerttext = alt2.getText();
        System.out.println(alerttext);
        alt2.sendKeys("Satya");
        alt2.accept();
        Thread.sleep(2000);

        driver.quit();
	}

}
