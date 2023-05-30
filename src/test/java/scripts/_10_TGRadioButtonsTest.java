package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class _10_TGRadioButtonsTest extends Base {

    /**
     * TEST CASE 1
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Radio Buttons" card
     * Validate that "Java", "JavaScript" and "C#" radio buttons are displayed, enabled, and not selected
     * Select "Java" and validate it is selected but the other 2 are deselected
     * Select "JavaScript" to validate it is selected but the other 2 are deselected
     */

    @BeforeMethod
    public void setPage() {
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-6")).click();
    }

    @Test
    public void radioButtonsTest() {
        List<WebElement> buttonLabels = driver.findElements(By.cssSelector("#radio-button-group_1 label"));
        List<WebElement> buttonInput = driver.findElements(By.cssSelector("#radio-button-group_1 input"));

        buttonInput.forEach(rb -> {
            Assert.assertTrue(rb.isDisplayed());
            Assert.assertFalse(rb.isSelected());
            Assert.assertTrue(rb.isEnabled());
        });

        buttonLabels.get(0).click();
        Assert.assertTrue(buttonInput.get(0).isSelected());

        for (int i = 1; i < buttonLabels.size(); i++) {
            Assert.assertFalse(buttonInput.get(i).isSelected());
        }

        buttonLabels.get(1).click();
        Assert.assertTrue(buttonInput.get(1).isSelected());

        for (int i = 0; i < buttonLabels.size(); i++) {
            Assert.assertFalse(buttonInput.get(i).isSelected());
            i += 1;
        }
    }

    /**
     * TEST CASE 2
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Radio Buttons" card
     * Validate that "Selenium", "Cypress" and "Playwright" radio buttons are displayed, enabled, and not selected
     * Select "Cypress" and validate it is selected but the other 2 are deselected
     * Select "Playwright" to validate it is selected but the other 2 are deselected
     */

    @Test
    public void validatePracticeMore() {

        String[] expectedText = {"Selenium", "Cypress", "Playwright"};
        List<WebElement> radioButtonsExist = driver.findElements(By.cssSelector("#radio-button-group_2 label"));
        List<WebElement> radioButtonsSelected = driver.findElements(By.cssSelector("#radio-button-group_2 input"));

        //checking if the radio buttons displayed, text, enabled --- LABEL   and if its not selected --->INPUT
        for (int i = 0; i < expectedText.length; i++) {
            Assert.assertTrue(radioButtonsExist.get(i).isDisplayed());
            Assert.assertEquals(radioButtonsExist.get(i).getText(), expectedText[i]);
            Assert.assertTrue(radioButtonsExist.get(i).isEnabled());
            Assert.assertFalse(radioButtonsSelected.get(i).isSelected());
        }

        //click Java  and check if its selected using INPUT
        radioButtonsSelected.get(1).click();
        Assert.assertTrue(radioButtonsSelected.get(1).isSelected());

        //check if other buttons is not selected
        for (int i = 0; i < expectedText.length; i++) {
            if (i == 1) continue;
            Assert.assertFalse(radioButtonsSelected.get(i).isSelected());
        }

        //click
        radioButtonsSelected.get(2).click();
        Assert.assertTrue(radioButtonsSelected.get(2).isSelected());


        for (int i = 0; i < expectedText.length; i++) {
            if (i == 2) continue;
            Assert.assertFalse(radioButtonsSelected.get(i).isSelected());
        }
    }
}