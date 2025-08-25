package TestNG;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNgDependency {

    @Test(priority = 0)
    public void login() {
        System.out.println("Login performed (placeholder)");
        // Add real login steps if needed
    }

    @Test(priority = 1)
    public void testDragDrop() throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Actions act = new Actions(driver);
        WebElement from = driver.findElement(By.id("column-a"));
        WebElement to = driver.findElement(By.id("column-b"));

        act.dragAndDrop(from, to).perform();
        Thread.sleep(2000);
        driver.quit();
    }

    @Test(dependsOnMethods = {"login"}, groups = {"Sanity","Regression"})
    public void testCheckbox() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.id("checkBoxOption1")).click();
        System.out.println("Checkbox clicked");

        Thread.sleep(2000);
        driver.quit();
    }

    @Test(priority = 2)
    public void testAlerts() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();

        // Simple Alert
        driver.findElement(By.cssSelector("button[onclick='jsAlert()']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        // Confirmation Alert
        driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();

        // Prompt Alert
        driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();
        Thread.sleep(2000);

        Alert alt2 = driver.switchTo().alert();
        System.out.println("Prompt text: " + alt2.getText());
        alt2.sendKeys("Harsha");
        Thread.sleep(2000);
        alt2.accept();

        Thread.sleep(2000);
        driver.quit();
    }

    @Test(priority = 3)
    public void radioButtons() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.xpath("//input[@value = 'radio3']")).click();

        Thread.sleep(2000);
        driver.quit();
    }
}