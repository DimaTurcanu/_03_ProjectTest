package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class _07_TGDynamicElementsTest extends Base{
    /*
    Go to https://techglobal-training.com/frontend/
    Click on the "Dynamic Elements" card
    Validate both boxes are displayed with the below texts
    Box 1
    Click on the "Dynamic Elements" card
    Validate box2 is displayed with the below texts
    Box 2
    */
    @BeforeMethod
    public void SetUp(){
        driver.get("https://techglobal-training.com/frontend/");
        driver.findElement(By.id("card-3")).click();

    }
    @Test
    public void validateBox1(){
        WebElement box1 = driver.findElement(By.cssSelector("p[id^='box_1_']"));
        Assert.assertTrue(box1.isDisplayed());
        Assert.assertEquals(box1.getText(), "Box 1");
    }
    @Test
    public void validateBox2(){
        WebElement box2 = driver.findElement(By.cssSelector("p[id^='box_2_']"));
        Assert.assertTrue(box2.isDisplayed());
        Assert.assertEquals(box2.getText(), "Box 2");
    }

    @Test
    public void validateListBoxes(){
        List<WebElement> boxes = driver.findElements(By.cssSelector("p[id*='box_']"));

        String [] expectedTexts = {"Box 1", "Box 2"};

        for (int i = 0; i < boxes.size(); i++) {
            Assert.assertTrue(boxes.get(i).isDisplayed());
            Assert.assertEquals(boxes.get(i).getText(), expectedTexts[i]);
        }
    }
   }
