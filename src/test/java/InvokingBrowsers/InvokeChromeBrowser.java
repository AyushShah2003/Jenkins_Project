package InvokingBrowsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class InvokeChromeBrowser {

    public static void main(String[] args) {

        // Create ChromeOptions (optional custom settings)
        ChromeOptions chromeOptions = new ChromeOptions();

        // Setup WebDriver for Chrome using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Launch Chrome browser
        WebDriver driver = new ChromeDriver(chromeOptions);

        // Open URL
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
}