package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage
{
    public void LoginActions(WebDriver driver) throws InterruptedException
    {
        //Launch Trunup portal
        driver.navigate().to("http://horse.industryconnect.io/");
        driver.manage().window().maximize();
        Thread.sleep(1000);

        try
        {
            WebElement usernameTextbox = driver.findElement(By.id("UserName"));
            usernameTextbox.sendKeys("hari");
        }
        catch (Exception ex)
        {
            Assert.fail("Username textbox not located.");
        }

        // Identify password textbox and enter valid password
        WebElement passwordTextbox = driver.findElement(By.id("Password"));
        passwordTextbox.sendKeys("123123");
        // Identify login button and click on it
        WebElement loginButton = driver.findElement(By.xpath(" //*[@id=\"loginForm\"]/form/div[3]/input[1]"));
        loginButton.click();
        Thread.sleep(2000);//thread means stop
    }
    // check if user has logged in successfully
    public void VerifyUserInHomePage(WebDriver driver)
    {
        WebElement hellohari = driver.findElement(By.xpath(" //*[@id=\"logoutForm\"]/ul/li/a"));

        if (hellohari.getText().equals("Hello hari!"))
        {
            System.out.println("User has logged in successfully. Test passed!");
        }
        else
        {
            System.out.println("User has not logged in. Test failed!");
        }

    }
}
