package Date_13_08;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class DatePicker {
public static void main(String[] args) throws InterruptedException {
        
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://ui.shadcn.com/docs/components/date-picker");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        WebElement datePickerBtn = driver.findElement(By.xpath("//*[@id=\"date\"]"));
        datePickerBtn.click();
        Thread.sleep(2000);

        WebElement daypicker1 = driver.findElement(By.xpath("//*[@id=\"radix-«ra»\"]/div/div/div/table/tbody/tr[3]/td[4]/button"));
        daypicker1.click();
        Thread.sleep(2000);

        datePickerBtn.click();
        Thread.sleep(2000);

        WebElement daypicker2 = driver.findElement(By.xpath("//*[@id=\"radix-«ra»\"]/div/div/div/table/tbody/tr[3]/td[6]/button"));
        daypicker2.click();
        Thread.sleep(2000);

    }
}