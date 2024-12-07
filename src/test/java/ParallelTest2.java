import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ParallelTest2 {
    WebDriver driver;

    @Test
    void loginTest() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[text()=' Login ']")).click();
        Thread.sleep(5000);
        Assert.assertEquals(driver.getTitle(), "OrangeHRM");
        Thread.sleep(5000);


    }

    @Test
    void homePageTitle() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com");

        Assert.assertEquals("OrangeHRM", driver.getTitle());
        Thread.sleep(5000);

    }

    @AfterMethod
    void teardown() {
        driver.quit();
    }


}
