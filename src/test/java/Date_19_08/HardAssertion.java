package Date_19_08;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;



import org.openqa.selenium.support.ui.Wait;


import io.github.bonigarcia.wdm.WebDriverManager;

public class HardAssertion {

    @Test
    public void testlogin() throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // wait for page load
        Thread.sleep(2000);

        String actualtitle = driver.getTitle();
        System.out.println("Page title: " + actualtitle);

        String expectedtitle = "Orange"; // purposely wrong for demo

        // Hard assertion (test fails if this doesn't match)
        Assert.assertEquals(actualtitle, expectedtitle, "Title does not match!");

        // username field
        WebElement username = driver.findElement(By.name("username"));

        // explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> username.isDisplayed());

        username.sendKeys("Admin");

        Thread.sleep(2000);

        // password field
        WebElement password = driver.findElement(By.xpath("//input[@name = 'password']"));

        // fluent wait
        Wait<WebDriver> wait1 = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(2))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class);

        wait1.until((ExpectedCondition<Boolean>) d -> {
            password.isDisplayed();
            return true;
        });

        password.sendKeys("admin123");

        // login button
        Thread.sleep(2000);

        WebElement loginbutton = driver.findElement(By.xpath("//button[@type = 'submit']"));
        loginbutton.click();

        Thread.sleep(3000);

        driver.quit();
    }
}
