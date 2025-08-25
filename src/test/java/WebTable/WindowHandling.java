package WebTable;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
public class WindowHandling {
	public static void main(String[] args) throws InterruptedException {
		
				ChromeOptions chromeoptions=new ChromeOptions();
			   WebDriverManager.chromedriver().setup();
			  WebDriver driver=new ChromeDriver(chromeoptions);
				driver.get("https://the-internet.herokuapp.com/windows\r\n"
						+ " ");
				driver.manage().window().maximize();
				WebElement clickhere=driver.findElement(By.xpath("//a[normalize-space()='Click Here']"));
				clickhere.click();
				Thread.sleep(2000);
				//fetch all the window handles-there will be t0[0]-by default,[1]
				//click on link to open a new window
				Object[] windowHandles=driver.getWindowHandles().toArray();
				System.out.println("WindowHandles");
				driver.switchTo().window((String) windowHandles[1]);
				//assert on title of new window
				String title=driver.getTitle();
				System.out.println(title);
				Thread.sleep(2000);
				driver.close();
				driver.switchTo().window((String) windowHandles[0]);
				driver.quit();
				
				
	}

}


