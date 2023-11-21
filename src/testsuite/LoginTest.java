package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    String baseUrl = " https://courses.ultimateqa.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
    //find sign in link and click on it
        driver.findElement(By.linkText("Sign In")).click();

    //verify text
    String expectedText = "Welcome Back!";
    String actualText = driver.findElement(By.xpath("//h2[@class='page__heading']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyTheErrorMessage(){
        //find sign in link and click on it
        driver.findElement(By.linkText("Sign In")).click();

        //find email id field and enter email
        driver.findElement(By.id("user[email]")).sendKeys("john123@gmail.com");

        //find password field and enter password
        driver.findElement(By.name("user[password]")).sendKeys("123");

        //find signin button and click on it
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Last step may not work because of selenium drawback it does not support captcha and OTP
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
