package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Waiter;

public class _13_IFrameTest extends Base {

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/iframes");
    }

    /*
    TEST CASE
    Go to https://techglobal-training.com/frontend/iframes
    Validate the "Please fill out your information below" paragraph
     */

    @Test(priority = 1, description = "TC123: Validate the IFrame Page content paragraph")
    public void validateTheParagraph(){
        WebElement iframe = driver.findElement(By.id("form_frame"));
        driver.switchTo().frame(iframe);
        WebElement paragraph = driver.findElement(By.cssSelector("#name_form>p"));

        Assert.assertEquals(paragraph.getText(), "Please fill out your information below");
    }
    @Test(priority = 2, description = "Validate the form submission")
    public void ValidateTheFormSubmission(){
        WebElement iframe = driver.findElement(By.id("form_frame"));
        driver.switchTo().frame(iframe);

        WebElement FirstNameInput = driver.findElement(By.id("first_name"));
        WebElement LastNameInput = driver.findElement(By.id("last_name"));
        WebElement submit = driver.findElement(By.id("submit"));

        FirstNameInput.sendKeys("John");
        LastNameInput.sendKeys("Doe");
        submit.submit();
        Waiter.pause(2);

        driver.switchTo().parentFrame();
        WebElement result = driver.findElement(By.id("result"));

        Assert.assertTrue(result.isDisplayed());
        Assert.assertEquals(result.getText(),"You entered: John Doe");

    }

}