package scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class _01_GoogleTest {

    public static WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup(); // Set up Chrome driver

        driver = new ChromeDriver(); // Launch a Chrome driver
        driver.manage().window().maximize(); // Maximizes the Chrome window
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // implicit wait

        driver.get("https://www.google.com/");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    /*
    Go to https://www.google.com/
    Validate that the user see a search input box
     */

    @Test(priority = 2)
    public void validateSearchBar(){
        WebElement searchInputBox = driver.findElement(By.name("q"));
        Assert.assertTrue(searchInputBox.isDisplayed());
    }

     /*
    Go to https://www.google.com/
    Validate that the title is "Google"
    Validate that the URL is "https://www.google.com/"
     */

    @Test(priority = 1)
    public void validateTitleAndURL() {
        //Validation of title and URL
        System.out.println("The title is = " + driver.getTitle()); // Google
        System.out.println("The current URL is =  "+ driver.getCurrentUrl()); // https://www.google.com/

        Assert.assertEquals(driver.getTitle(), "Google");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.google.com/");
    }

    /*
    Go to https://www.google.com/
    Refresh the page
    Navigate to https://www.amazon.com/
    Navigate back
    Navigate forward
    Validate that the title is "Amazon.com. Spend less. Smile more."
     */

    @Test
    public void validateNavigation() throws InterruptedException {
        Thread.sleep(2000);
        driver.navigate().refresh();

        Thread.sleep(2000);
        driver.navigate().to("https://www.amazon.com/");

        Thread.sleep(2000);
        driver.navigate().back();

        Thread.sleep(2000);
        driver.navigate().forward();

        System.out.println("The title is = " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Amazon.com. Spend less. Smile more.");
    }

     /*
    Go to https://www.google.com/
    Validate that the user "Google Search" button
    Validate its text is "Google Search"
    Validate that it is clickable

    validateGoogleSearchButton
     */

    @Test
    public void validateSearchButton(){
        WebElement searchButton = driver.findElement(By.xpath("(//input[@name='btnK'])[2]"));

        Assert.assertTrue(searchButton.isDisplayed());
        System.out.println(searchButton.getAttribute("value")); // Google Search

        Assert.assertEquals(searchButton.getAttribute("value"), "Google Search");

        Assert.assertTrue(searchButton.isEnabled());
    }
}