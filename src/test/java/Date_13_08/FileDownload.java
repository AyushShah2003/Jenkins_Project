package Date_13_08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;

public class FileDownload {

    public static void main(String[] args) throws InterruptedException {
        // Setup ChromeDriver
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);

        // Open the download page
        driver.get("https://the-internet.herokuapp.com/download");
        driver.manage().window().maximize();

        // Locate the file link and click it
        WebElement fileDownload = driver.findElement(By.xpath("//a[normalize-space()='test-file.txt']"));
        fileDownload.click();

        // Wait to ensure file gets downloaded
        Thread.sleep(3000);

        // Check if file exists in Downloads folder
        File f = new File("C:\\Users\\HP\\Downloads\\test-file.txt");
        if (f.exists()) {
            System.out.println("File is present.");
        } else {
            System.out.println("File is not present.");
        }

        driver.quit();
    }
}