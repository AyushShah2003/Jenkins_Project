package Date_13_08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUpload {

    public static void main(String[] args) throws InterruptedException {
        
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize();
        Thread.sleep(500);
        WebElement fileupload = driver.findElement(By.xpath("//input[@id='file-upload']"));
        Thread.sleep(2000);
        fileupload.sendKeys("C:\\Users\\HP\\Downloads\\test-file.txt"); // Change to your file path

        Thread.sleep(2000);
        WebElement submit = driver.findElement(By.xpath("//input[@id='file-submit']"));
        submit.click();
        Thread.sleep(1000);
        WebElement validationmsg = driver.findElement(By.xpath("//h3[normalize-space()='File Uploaded!']"));

        if (validationmsg.isDisplayed()) {
            System.out.println("The message is displayed properly");
        } else {
            System.out.println("The message is not displayed");
        }
        Thread.sleep(1000);
        driver.quit();
    }
}