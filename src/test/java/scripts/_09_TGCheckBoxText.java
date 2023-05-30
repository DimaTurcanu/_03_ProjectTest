package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class _09_TGCheckBoxText extends Base{
    /*
    Go to https://techglobal-training.com/frontend/
    Click on the "Checkboxes" card
    Validate "Apple" and "Microsoft" checkboxes are displayed, enabled, and not selected
    Select both and validate they are both selected
    Deselect both and validate they are deselected
     */

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-7")).click();
    }
    @Test
    public void checkBoxTest1(){
        List<WebElement> checkBoxLabel = driver.findElements(By.cssSelector("#checkbox-button-group_1 label"));
        List<WebElement> checkBoxInput = driver.findElements(By.cssSelector("#checkbox-button-group_1 input"));

        checkBoxInput.forEach(cb -> {
            Assert.assertTrue(cb.isDisplayed());
            Assert.assertFalse(cb.isSelected());
            Assert.assertTrue(cb.isEnabled());
        });

        for (int i = 0; i < checkBoxLabel.size(); i++) {
            checkBoxLabel.get(i).click();
            Assert.assertTrue(checkBoxInput.get(i).isSelected());
        }
        for (int i = 0; i < checkBoxLabel.size(); i++) {
            checkBoxLabel.get(i).click();
            Assert.assertFalse(checkBoxInput.get(i).isSelected());
        }
    }
    @Test
    public void checkBoxTest2(){
        List<WebElement> checkBoxLabel = driver.findElements(By.cssSelector("#checkbox-button-group_2 label"));
        List<WebElement> checkBoxInput = driver.findElements(By.cssSelector("#checkbox-button-group_2 input"));

        checkBoxInput.forEach(cb -> {
            Assert.assertTrue(cb.isDisplayed());
            Assert.assertFalse(cb.isSelected());
            Assert.assertTrue(cb.isEnabled());
        });

        for (int i = 0; i < checkBoxLabel.size(); i++) {
            checkBoxLabel.get(i).click();
            Assert.assertTrue(checkBoxInput.get(i).isSelected());
        }
        for (int i = 0; i < checkBoxLabel.size(); i++) {
            checkBoxLabel.get(i).click();
            Assert.assertFalse(checkBoxInput.get(i).isSelected());
        }
    }
    }

