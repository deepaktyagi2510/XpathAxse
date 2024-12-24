package test.testdemo;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class xpathaxes {

	public static void main(String[] args) {
		WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DeepakTyagi\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("file:///C:/Users/DeepakTyagi/Downloads/xpathaxes.html");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
WebElement Followingsibling = driver.findElement(By.xpath("//label[@for='username']/following-sibling::*"));
Followingsibling.click();
Followingsibling.sendKeys("deepak");

WebElement decendent = driver.findElement(By.xpath("//form[@action='/submit' and @method='POST']/descendant::input[@type='password']"));
decendent.click();
decendent.sendKeys("deepak@134");



WebElement decendantosfgrandprent = driver.findElement(By.xpath("//div[@class='container']/descendant::h1"));
System.out.println(decendantosfgrandprent.getText());

WebElement self  = driver.findElement(By.xpath("//a[@href=\"#\"]/self::*"));
self.click();



WebElement inputElement = driver.findElement(By.xpath("//input[@type='text' and @id='username']"));


WebElement ancestorForm = inputElement.findElement(By.xpath("ancestor::form"));


String formAction = ancestorForm.getAttribute("action");
System.out.println( formAction);

//WebElement child  = driver.findElement(By.xpath("//form[@action='/submit']/child::button[@type='submit']"));
//child.click();

/*
 * WebElement precedingsibling = driver.findElement(By.
 * xpath("//form[@action='/submit' and @method='POST']/preceding-sibling::h1"));
 * System.out.println(precedingsibling.getText());
 * 
 * WebElement following_sibling_childs = driver.findElement(By.xpath(
 * "//div[@class='container']/following-sibling::child:://p[2]"));
 * 
 * 
 * String text = following_sibling_childs.getText(); System.out.println(text);
 */



WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

try {
    
    WebElement secondParagraph = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='hey this is p1']/following-sibling::p[1]")));
    System.out.println(secondParagraph.getText());

  
    WebElement firstParagraph = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='hey this is p2']/preceding-sibling::p[1]")));
    System.out.println(firstParagraph.getText());
    
   
   
} catch (Exception e) {
    System.out.println("Error: " + e.getMessage());
} finally {
    driver.quit();
}
driver.quit();

	}

}
