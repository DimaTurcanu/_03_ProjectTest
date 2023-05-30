package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Waiter;

public class _08_TGWaitsTest extends Base{
    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/");
        driver.findElement(By.id("card-4")).click();
    }
    @Test
    public void validateRedBox(){
        WebElement button1 = driver.findElement(By.id("red"));
        button1.click();
        WebElement redBox = driver.findElement(By.cssSelector("button[class*='Box']"));
        Assert.assertTrue(redBox.isDisplayed());
    }
    @Test
    public void validateBlueBox(){
        WebElement button2 = driver.findElement(By.id("blue"));
        button2.click();

        WebElement blueBox = driver.findElement(By.cssSelector("button[class*='blue_box']"));
        Waiter.waitForVisibilityOfElement(blueBox, 35);
        Assert.assertTrue(blueBox.isDisplayed());
    }
}
