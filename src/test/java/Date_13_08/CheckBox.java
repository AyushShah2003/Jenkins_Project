package Date_13_08;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
public class CheckBox {

	public static void main(String[] args)throws InterruptedException {
		ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement checkbox=driver.findElement(By.xpath("//input[@id = 'checkBoxOption2']"));
        checkbox.click();
        Thread.sleep(2000);
	}

}
