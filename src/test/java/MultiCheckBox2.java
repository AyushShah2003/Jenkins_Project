import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiCheckBox2 {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        List<WebElement>chkboxes=driver.findElements(By.xpath("//input[@type='checkbox']"));
        int size=chkboxes.size();
        for(int i=0;i<size;i++) {
        	Thread.sleep(1000);
        	chkboxes.get(i).click();
        	Thread.sleep(2000);
        }
	}
}
