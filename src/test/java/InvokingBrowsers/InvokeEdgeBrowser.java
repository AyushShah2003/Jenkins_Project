package InvokingBrowsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class InvokeEdgeBrowser {

    public static void main(String[] args) {

        // Point directly to your downloaded driver
        System.setProperty("webdriver.edge.driver", "C:\\msedgedriver.exe");

        EdgeOptions edgeOption = new EdgeOptions();
        WebDriver driver = new EdgeDriver(edgeOption);

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
}