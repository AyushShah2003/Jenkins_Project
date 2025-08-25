package Date_20_08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class DataProviders {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @DataProvider(name = "logindata", parallel = true)
    public Object[][] getData() {
        return new Object[][]{
                {"admin", "admin123"},
                {"adm", "admin123"},
                {"admn", "admin123"}
        };
    }

    @Test(dataProvider = "logindata")
    public void loginTest(String username, String password) {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Wait for username field
        WebElement usernameField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("username"))
        );
        usernameField.sendKeys(username);

        // Enter password
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys(password);

        // Click login
        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        loginBtn.click();

        // Optional: Verify login result
        System.out.println("Tried login with: " + username + " / " + password);
    }
}
