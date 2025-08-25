package Date_13_08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class MoveToElements {

	public static void main(String[] args) throws InterruptedException {
		 WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
     
        Actions act = new Actions (driver);
		WebElement prime = driver.findElement
				(By.xpath("//span[normalize-space()='Prime']"));
		act.moveToElement(prime).perform();
		Thread.sleep(2000);
		WebElement joinnow = driver.findElement
				(By.xpath("//a[@href ='/prime']"));
		act.click(joinnow).perform();
		Thread.sleep(2000);			
	      driver.quit();
	}

}


	