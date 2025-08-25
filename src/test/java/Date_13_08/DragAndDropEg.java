package Date_13_08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropEg {
    public static void main(String[] args) throws InterruptedException {
    	try {
            WebDriver driver = new ChromeDriver();
            driver.get("https://the-internet.herokuapp.com/drag_and_drop");
            driver.manage().window().maximize();
            Actions act = new Actions(driver);
            WebElement from = driver.findElement(By.id("column-a"));
            WebElement to = driver.findElement(By.id("column-b"));
            act.dragAndDrop(from, to).perform();

            Thread.sleep(3000);

            driver.quit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
