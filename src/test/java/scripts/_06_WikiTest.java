package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _06_WikiTest extends Base {
    /*
    Go to "https://www.wikipedia.org/"
    Search for "Tesla"
    Validate the main header of the page is displayed and is "Tesla"

    validateWikiSearch
     */

    @BeforeMethod
    public void setPage(){
        driver.get("https://www.wikipedia.org/");
    }

    @Test
    public void validateWikiSearch1(){
        WebElement searchBox = driver.findElement(By.id("searchInput"));
        WebElement searchButton = driver.findElement(By.cssSelector(".pure-button-primary-progressive"));

        searchBox.sendKeys("Tesla");
        searchButton.submit();

        WebElement mainHeader = driver.findElement(By.cssSelector("#firstHeading>span"));

        Assert.assertEquals(mainHeader.getText(), "Tesla");
    }

    @Test
    public void validateWikiSearch2(){
        WebElement searchBox = driver.findElement(By.id("searchInput"));

        searchBox.sendKeys("Tesla" + Keys.ENTER);

        WebElement mainHeader = driver.findElement(By.cssSelector("#firstHeading>span"));

        Assert.assertEquals(mainHeader.getText(), "Tesla");
    }
}