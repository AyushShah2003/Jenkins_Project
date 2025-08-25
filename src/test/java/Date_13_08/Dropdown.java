package Date_13_08;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://grotechminds.com/multiple-select/");
        driver.manage().window().maximize();
        WebElement drdwn=driver.findElement(By.xpath("//select[@id='automobiles']"));
        Select sel=new Select(drdwn);
        sel.selectByVisibleText("Motorcycle");
        sel.selectByVisibleText("Sedan");
        sel.selectByVisibleText("Hatchback");
        sel.selectByVisibleText("SUV");
        Thread.sleep(2000);
        sel.deselectByVisibleText("Motorcycle");
        sel.deselectByVisibleText("Sedan");
        sel.deselectByVisibleText("Hatchback");
        sel.deselectByVisibleText("SUV");
        Thread.sleep(2000);
        sel.deselectByIndex(4);
	}

}