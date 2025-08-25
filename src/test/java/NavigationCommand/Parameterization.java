package NavigationCommand;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Parameterization {

    WebDriver driver;

    @Parameters({ "browser", "platform" })
    @Test
    public void testParameters(String browser, String platform) throws InterruptedException {
        if (browser.equalsIgnoreCase("chrome")) {
            if (platform.equalsIgnoreCase("windows")) {
                ChromeOptions chromeOptions = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(chromeOptions);
            }
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver",
            		"C://msedgedriver.exe");
            driver = new EdgeDriver();
        }

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(2000);

        driver.quit();
    }
}