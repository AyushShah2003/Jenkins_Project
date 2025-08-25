package Date_20_08;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.logging.log4j.Logger;
public class TestNgLogger {
	private static final Logger log = LoggerHelper.getLogger(TestNgLogger.class);

    @Test
    public void launchBrowser() {
        log.info("===== Test Started: launchBrowser =====");

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        log.info("Chrome browser launched successfully.");
        driver.manage().window().maximize();
        log.info("Browser window maximized.");

        driver.get("https://the-internet.herokuapp.com/windows");
        log.info("Navigated to: https://the-internet.herokuapp.com/windows");

        driver.quit();
        log.info("Browser closed successfully.");
        log.info("===== Test Finished: launchBrowser =====");
    }
}
    