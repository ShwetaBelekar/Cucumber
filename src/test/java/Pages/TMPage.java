package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class TMPage
{
    public void CreateTimeRecord(WebDriver driver) throws InterruptedException
    {
        try
        {
            WebElement createNewButton = driver.findElement(By.xpath("//*[@id=\"container\"]/p/a"));
            createNewButton.click();

        }
        catch (Exception ex)
        {
            Assert.fail("Create new button hasn't been found");
        }


        WebElement typeCodeDropdown = driver.findElement(By.xpath("//*[@id=\"TimeMaterialEditForm\"]/div/div[1]/div/span[1]/span/span[2]/span"));
        typeCodeDropdown.click();
        Thread.sleep(1000);

        WebElement timeOption = driver.findElement(By.xpath("//*[@id=\"TypeCode_listbox\"]/li[2]"));
        timeOption.click();

        WebElement codeTextbox = driver.findElement(By.id("Code"));
        codeTextbox.sendKeys("ABC");

        WebElement descriptionTextbox = driver.findElement(By.id("Description"));
        descriptionTextbox.sendKeys("ABCDescription");
        Thread.sleep(1000);

        WebElement priceTagOverlap = driver.findElement(By.xpath("//*[@id=\"TimeMaterialEditForm\"]/div/div[4]/div/span[1]/span/input[1]"));
        priceTagOverlap.click();

        WebElement priceTextbox = driver.findElement(By.id("Price"));
        priceTextbox.sendKeys("$20.00");
        Thread.sleep(5000);

        WebElement saveButton = driver.findElement(By.id("SaveButton"));
        saveButton.click();
        Thread.sleep(1000);

        WebElement goToLastPageButton = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[4]/a[4]/span"));
        goToLastPageButton.click();
        Thread.sleep(5000);


    }
    public String GetCode(WebDriver driver)
    {
        WebElement newCode = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));
        return newCode.getText();
    }
    public String GetDescription(WebDriver driver)
    {
        WebElement newDescription = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[3]"));
        return newDescription.getText();
    }

    public void EditTimeRecord(WebDriver driver, String code, String description) throws InterruptedException
    {

        Thread.sleep(4000);
        // Create an Edit Record
        WebElement lastPageButton = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[4]/a[4]/span"));
        lastPageButton.click();
        Thread.sleep(2000);

        WebElement editButton = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[5]/a[1]"));
        editButton.click();

        WebElement codeTextbox = driver.findElement(By.id("Code"));
        codeTextbox.clear();
        Thread.sleep(2000);
        codeTextbox.sendKeys(code);

        WebElement descriptionTextbox = driver.findElement(By.id("Description"));
        descriptionTextbox.clear();
        descriptionTextbox.sendKeys(description);

        WebElement saveButton = driver.findElement(By.id("SaveButton"));
        saveButton.click();
        Thread.sleep(1000);

        WebElement llastPageButton = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[4]/a[4]/span"));
        llastPageButton.click();
        Thread.sleep(1500);

    }
    public String GetEditedCode(WebDriver driver)
    {
        WebElement editedCode = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));
        return editedCode.getText();
    }
    public String GetEditedDescription(WebDriver driver)
    {
        WebElement editedDescription = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[3]"));
        return editedDescription.getText();
    }

}
