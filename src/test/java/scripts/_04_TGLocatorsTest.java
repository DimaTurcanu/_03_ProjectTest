package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class _04_TGLocatorsTest extends Base{
    /*
    Go to "https://techglobal-training.com/frontend/xpath-css-locators"
    Validate the header is "Xpath-CSS Locators"
     */

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/xpath-css-locators");
    }


        @Test
        public void validateListHeaders(){
            List<WebElement> listHeaders = driver.findElements(By.tagName("h3"));

            String[] expectedTexts = {"Programming Languages", "Automation Tools"};

            for (int i = 0; i < listHeaders.size(); i++) {
                Assert.assertTrue(listHeaders.get(i).isDisplayed());
                Assert.assertEquals(listHeaders.get(i).getText(), expectedTexts[i]);
            }
        }
    }
