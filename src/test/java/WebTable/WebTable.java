package WebTable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {
	public static void main(String[] args) {
		ChromeOptions chromeoptions=new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(chromeoptions);
		driver.get("https://the-internet.herokuapp.com/tables");
		driver.manage().window().maximize();
		//find the rows present
		List<WebElement> rows=driver.findElements(By.xpath("//table[@id='table1']/thead/tr[1]/th"));
		int rowscount=rows.size();
		System.out.println(rowscount);
		//find the cols present
		List<WebElement> cols=driver.findElements(By.xpath("//table[@id='table1']/thead/tr[1]/th"));
		int colscount=cols.size();
		System.out.println(colscount);
		//text of a cell
		WebElement celltext=driver.findElement(By.xpath("//table[@id='table2']/tbody/tr[4]/td[3]"));
		String actualcelltext=celltext.getText();
		String expectedcelltext="tconway@earthlink.net";
		if(actualcelltext.equalsIgnoreCase(expectedcelltext)) {
			System.out.println("The text matches");
			}else {
				System.out.println("The text does not match");
				}
	}

}