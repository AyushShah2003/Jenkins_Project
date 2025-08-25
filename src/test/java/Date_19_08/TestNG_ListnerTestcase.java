package Date_19_08;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

  
public class TestNG_ListnerTestcase {

    @Test
    public void testLogin() throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // wait and enter username
        Thread.sleep(2000);
        WebElement username = driver.findElement(By.name("username"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> username.isDisplayed());
        username.sendKeys("Admin");

        // wait and enter password
        Thread.sleep(2000);
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        Wait<WebDriver> wait1 = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(2))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class);

        wait1.until(d -> {
            password.isDisplayed();
            return true;
        });
        password.sendKeys("admin123");

        // click on login button
        Thread.sleep(2000);
        WebElement loginbutton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginbutton.click();

        Thread.sleep(3000);
        driver.quit();
    }
}