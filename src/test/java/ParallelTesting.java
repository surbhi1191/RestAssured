import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ParallelTesting {
    WebDriver driver;
    @Test
    void logoTest()
    {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com");
        WebElement logo = driver.findElement(By.xpath("//*[@id=\"divLogo\"]/img"));
 Assert.assertTrue(logo.isDisplayed());

    }
    @Test
    void homePageTitle()

    {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com");

        Assert.assertEquals("OrangeHRM",driver.getTitle());

    }
    @AfterClass
    void teardown()
    {
       driver.quit();
    }

}
