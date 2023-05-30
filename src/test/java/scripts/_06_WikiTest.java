package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Waiter;

/*
Go to "https://www.wikipedia.org/"
Search for "Tesla"
Validate the main header of the page is displayed and is "Tesla"
*/
public class _06_WikiTest extends Base{
    @BeforeMethod
    public void SetUp(){
            driver.get("https://www.wikipedia.org/");
    }

    @Test
    public void validateWikiSearch(){

        WebElement searchBox = driver.findElement(By.id("searchInput"));

        searchBox.sendKeys("Tesla");
        Waiter.pause(2);
        searchBox.submit();
        WebElement ActualTeslaHeader = driver.findElement(By.cssSelector("#firstHeading>span"));
        String ExpectedTeslaHeader = "Tesla";

        Assert.assertEquals(ActualTeslaHeader.getText(), ExpectedTeslaHeader);
        Waiter.pause(2);
    }
}
