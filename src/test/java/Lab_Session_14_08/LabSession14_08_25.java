package Lab_Session_14_08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LabSession14_08_25 {

    public static void main(String[] args) {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        driver.manage().window().maximize();
        WebElement name = driver.findElement(By.xpath("//input[@id='name']"));
        name.sendKeys("Satyajit");
        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("pradhansatyajit@gmail.com");
        WebElement gender = driver.findElement(By.xpath("//input[@id='gender']"));
        gender.click();
        WebElement mobile = driver.findElement(By.xpath("//input[@id='mobile']"));
        mobile.sendKeys("9876543210");
        WebElement dob = driver.findElement(By.xpath("//input[@id='dob']"));
        dob.sendKeys("14-08-2025"); 
        WebElement subjects = driver.findElement(By.xpath("//input[@id='subjects']"));
        subjects.sendKeys("Maths"); 
        WebElement hobby = driver.findElement(By.xpath("//input[@id='hobbies']"));
        hobby.click();

        WebElement picture = driver.findElement(By.xpath("//input[@id='picture']"));
        picture.sendKeys("C:\\Users\\HP\\Downloads\\test-file.txt"); 

        WebElement address = driver.findElement(By.xpath("//textarea[@id='picture']"));
        address.sendKeys("xyz");
        
        WebElement state=driver.findElement(By.xpath("//select[@id='state']"));
        Select sel=new Select(state);
        sel.selectByVisibleText("Uttar Pradesh");
        
        WebElement city=driver.findElement(By.xpath("//select[@id='city']"));
        Select sel1=new Select(city);
        sel1.selectByVisibleText("Lucknow");

        WebElement submit = driver.findElement(By.xpath("//input[@value='Login']"));
        submit.click();  
        
    }
}