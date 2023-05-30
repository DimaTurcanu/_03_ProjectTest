package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class _03_TGLocatorsTest extends Base{
    /*
    Test case 1:
    Go to "https://techglobal-training.com/frontend/locators"
    Validate the "Kiwi" paragraph
     */

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/locators");
    }

    @Test(priority = 1)
    public void validateKiwiParagraph(){
        WebElement kiwi_paragraph = driver.findElement(By.id("item_kiwi"));

        Assert.assertTrue(kiwi_paragraph.isDisplayed());
        Assert.assertEquals(kiwi_paragraph.getText(), "Kiwi");
    }


     /*
    Test case 2:
    Go to "https://techglobal-training.com/frontend/locators"
    Validate the "Orange" paragraph
     */

    @Test(priority = 2)
    public void validateOrangeParagraph(){
        WebElement orange_paragraph = driver.findElement(By.name("item_orange"));

        Assert.assertTrue(orange_paragraph.isDisplayed());
        Assert.assertEquals(orange_paragraph.getText(), "Orange");

        System.out.println(orange_paragraph.getText()); // Orange

        System.out.println(orange_paragraph.getAttribute("id")); // empty
        System.out.println(orange_paragraph.getAttribute("name")); // item_orange
        System.out.println(orange_paragraph.getTagName()); // p

        System.out.println(orange_paragraph.getCssValue("font-size")); // 14.4px
        System.out.println(orange_paragraph.getCssValue("color")); // rgba(105, 105, 105, 1)
        System.out.println(orange_paragraph.getCssValue("line-height")); // 21.6px
        System.out.println(orange_paragraph.getCssValue("font-family")); // Poppins, Helvetica, Arial, sans-serif
        System.out.println(orange_paragraph.getCssValue("box-sizing")); // border-box
    }


     /*
    Test case 3:
    Go to "https://techglobal-training.com/frontend/locators"
    Validate the "Grapes" paragraph
     */

    @Test(priority = 3)
    public void validateGrapesParagraph(){
        WebElement grapes_paragraph = driver.findElement(By.className("item_grapes"));

        Assert.assertTrue(grapes_paragraph.isDisplayed());
        Assert.assertEquals(grapes_paragraph.getText(), "Grapes");
    }

    /*
    Test case 4:
    Go to "https://techglobal-training.com/frontend/locators"
    Validate the "Kiwi", "Orange", "Grapes" paragraphs
     */
    @Test(priority = 4)
    public void validateAllParagraphs(){
        List<WebElement> allParagraphs = driver.findElements(By.tagName("p")); // Kiwi, Orange, Grapes

        String[] expectedTexts = {"Kiwi", "Orange", "Grapes"};

        for (int i = 0; i <= 2; i++) {
            Assert.assertTrue(allParagraphs.get(i).isDisplayed());
            Assert.assertEquals(allParagraphs.get(i).getText(), expectedTexts[i]);
        }
    }

    /*
   Test case 5:
   Go to "https://techglobal-training.com/frontend/locators"
   Validate the "Red Apple" link (displayed and enabled)
   Validate it navigates user to the "https://en.wikipedia.org/wiki/Red_apple"
    */
    @Test(priority = 5)
    public void validateRedAppleLink(){
        WebElement redApple = driver.findElement(By.linkText("Red Apple"));

        Assert.assertTrue(redApple.isDisplayed());
        Assert.assertTrue(redApple.isEnabled());

        Assert.assertEquals(redApple.getAttribute("href"), "https://en.wikipedia.org/wiki/Red_apple");

        /*
        Another way is to click and validate the URL
        redApple.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://en.wikipedia.org/wiki/Red_apple");
         */
    }


    /*
   Test case 6:
   Go to "https://techglobal-training.com/frontend/locators"
   Validate the "Red Apple", "Green Apple" and "Pineapple" links (displayed and enabled and their text)
   Validate they navigate user to the "https://en.wikipedia.org/wiki/Red_apple", "https://en.wikipedia.org/wiki/Green_apple" and "https://en.wikipedia.org/wiki/Pineapple"
    */
    @Test(priority = 6)
    public void validateAllLinks(){
        List<WebElement> allLinks = driver.findElements(By.partialLinkText("pple")); // 3 links
        String[] expectedVisibleTexts = {"Red Apple", "Green Apple", "Pineapple"};
        String[] expectedLinks = {"https://en.wikipedia.org/wiki/Red_apple", "https://en.wikipedia.org/wiki/Green_apple", "https://en.wikipedia.org/wiki/Pineapple"};

        for (int i = 0; i <= 2; i++) {
            Assert.assertTrue(allLinks.get(i).isDisplayed());
            Assert.assertTrue(allLinks.get(i).isEnabled());
            Assert.assertEquals(allLinks.get(i).getText(), expectedVisibleTexts[i]);
            Assert.assertEquals(allLinks.get(i).getAttribute("href"), expectedLinks[i]);
        }
    }
}