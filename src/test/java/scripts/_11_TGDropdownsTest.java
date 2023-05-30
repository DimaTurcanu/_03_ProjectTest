package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.DropdownHandler;

import java.util.List;

public class _11_TGDropdownsTest extends Base {

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-5")).click();
    }

    @Test
    public void productDropdownTest(){

        WebElement dropdown = driver.findElement(By.id("product_dropdown"));
        DropdownHandler.selectByVisibleText(dropdown, "iPhone 14 Pro Max");
    }

    @Test
    public void productColorTest(){
        WebElement dropdown = driver.findElement(By.id("color_dropdown"));
        DropdownHandler.selectByIndex(dropdown, 2);
    }

    @Test
    public void productDeliveryTest(){
        WebElement dropdown = driver.findElement(By.id("shipment_dropdown"));
        List<WebElement> dropdownOption = driver.findElements(By.cssSelector("#shipment_dropdown span"));

        DropdownHandler.clickDropdownOption(dropdown, dropdownOption, "Delivery");
    }

    /**
     * Test Case: Validate Dropdowns Functionality on TechGlobal Training Page
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Dropdowns" card
     * Select the "MacBook Pro 13" option from the "Product" dropdown.
     * Select the "Green" option from the "Color" dropdown.
     * Open the "Shipping" dropdown and click on the "Delivery" option.
     * Click on the "Submit" button.
     * Validate result message displays "Your Green MacBook Pro 13 will be delivered to you."
     */

    @Test
    public void dropdownTestCase(){
        WebElement productDropdown = driver.findElement(By.id("product_dropdown"));
        DropdownHandler.selectByVisibleText(productDropdown, "MacBook Pro 13");

        WebElement colorDropdown = driver.findElement(By.id("color_dropdown"));
        DropdownHandler.selectByVisibleText(colorDropdown, "Green");

        WebElement deliveryDropdown = driver.findElement(By.id("shipment_dropdown"));
        deliveryDropdown.click();

        List<WebElement> deliveryDropdownOptions = driver.findElements(By.cssSelector("#shipment_dropdown span"));
        deliveryDropdownOptions.get(0).click();

        driver.findElement(By.id("submit")).click();
        String actualText = driver.findElement(By.id("result")).getText();

        Assert.assertEquals(actualText, "Your Green MacBook Pro 13 will be delivered to you.");

    }
}