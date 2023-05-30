
package scripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Waiter;

public class _12_TGAlertsTest extends Base {

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-8")).click();
    }

    /**
     * WARNING ALERT
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Alerts" card
     * Click on the "Warning alert" button
     * Validate the alert text equals "You are on TechGlobal Training application."
     * Click on the "OK" button on the alert
     * Validate the result message equals "You accepted warning by clicking OK."
     */
    @Test
    public void warningAlert(){
        WebElement warningAlert = driver.findElement(By.id("warning_alert"));
        warningAlert.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "You are on TechGlobal Training application.");
        alert.accept();

        WebElement resultText = driver.findElement(By.id("action"));
        Assert.assertEquals(resultText.getText(), "You accepted warning by clicking OK.");
        Waiter.pause(2);

    }
}