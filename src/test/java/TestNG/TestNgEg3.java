package TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNgEg3 {

    WebDriver driver;

    @Test(priority = 1)
    public void login() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // enter username
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");

        // enter password
        WebElement password = driver.findElement(By.xpath("//input[@name = 'password']"));
        password.sendKeys("admin123");

        // click on login button
        WebElement loginbutton = driver.findElement(By.xpath("//button[@type = 'submit']"));
        loginbutton.click();

        Thread.sleep(2000);  // just to observe (not recommended for real tests)
    }

    @Test(priority = 2, dependsOnMethods = {"login"})
    public void testcheckbox() throws InterruptedException {
        // Reuse the same driver OR open new browser (here reusing login session for demo)
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement checkbox = driver.findElement(By.id("checkBoxOption1"));
        checkbox.click();

        Thread.sleep(2000); // just to observe
        driver.quit();      // close the browser at the end
    }
}