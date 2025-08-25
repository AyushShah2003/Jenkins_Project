package Date_13_08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DeselectDropdown {

    public static void main(String[] args) throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://grotechminds.com/multiple-select/");
        driver.manage().window().maximize();

        WebElement drdwn = driver.findElement(By.name("cars"));
        Select sel = new Select(drdwn);
        sel.selectByVisibleText("Motorcycle");
        sel.selectByValue("volvo");
        Thread.sleep(2000);
        sel.selectByIndex(2); 
        sel.deselectByVisibleText("Audi");
        sel.deselectByValue("volvo");
        Thread.sleep(2000);
        sel.deselectByIndex(2);

        driver.quit();
    }
}
