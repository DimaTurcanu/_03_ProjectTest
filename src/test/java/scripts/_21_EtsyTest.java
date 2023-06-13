package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.EtsyHomePage;

public class _21_EtsyTest extends Base {

    @BeforeMethod
    public void setPage(){
        driver.get("https://www.etsy.com/");
        etsyHomePage = new EtsyHomePage();
    }

    @Test(priority = 1, description = "TC123: Validate Etsy Header items")
    public void validateEtsyHeaderItems(){
        String[] expectedHeaderItemsText = {
                "Father's Day Gifts",
                "Jewelry & Accessories",
                "Clothing & Shoes",
                "Home & Living",
                "Wedding & Party",
                "Toys & Entertainment",
                "Art & Collectibles",
                "Craft Supplies",
                "Gifts & Gift Cards"};

        for (int i = 0; i < 9; i++) {
            Assert.assertTrue(etsyHomePage.headerItems.get(i).isDisplayed());
            Assert.assertEquals(etsyHomePage.headerItems.get(i).getText(), expectedHeaderItemsText[i]);
        }
    }
}