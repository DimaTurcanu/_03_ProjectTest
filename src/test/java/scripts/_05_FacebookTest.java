package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Waiter;

public class _05_FacebookTest extends Base {
        /*
        Go to https://www.facebook.com/
        Validate the title of the page is "Facebook - log in or sign up"
        Validate the URL of the page is "https://www.facebook.com/"
        Validate "facebook" logo is displayed
        Validate heading2 "Connect with friends and the world around you on Facebook." is displayed
        Validate "Email or phone number" input box is displayed
        Validate "Password" input box is displayed
        Validate "Log In" button is displayed and enabled
        Validate "Forgot password?" link is displayed
        Validate "Create new account" link is displayed
         */
        WebElement usernameInputBox;
        WebElement passwordInputBox;
        WebElement loginButton;


    @BeforeMethod
    public void setPage(){
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void validateFacebookLoginForm(){
        Assert.assertEquals(driver.getTitle(), "Facebook - log in or sign up");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/");

        WebElement logo = driver.findElement(By.cssSelector(".fb_logo"));
        WebElement heading = driver.findElement(By.cssSelector("._8eso"));
        usernameInputBox = driver.findElement(By.id("email"));
        passwordInputBox = driver.findElement(By.id("pass"));
        loginButton = driver.findElement(By.cssSelector("button[id^='u_0_5']"));
        WebElement forgotPasswordLink = driver.findElement(By.cssSelector("._6ltj>a"));
        WebElement createNewAccountLink = driver.findElement(By.cssSelector("a[id^='u_0_0']"));


        //Validate different elements
        Assert.assertTrue(logo.isDisplayed());

        Assert.assertTrue(heading.isDisplayed());
        Assert.assertEquals(heading.getText(), "Connect with friends and the world around you on Facebook.");

        Assert.assertTrue(usernameInputBox.isDisplayed());
        Assert.assertTrue(usernameInputBox.isEnabled());
        Assert.assertEquals(usernameInputBox.getAttribute("placeholder"), "Email or phone number");

        Assert.assertTrue(passwordInputBox.isDisplayed());
        Assert.assertTrue(passwordInputBox.isEnabled());
        Assert.assertEquals(passwordInputBox.getAttribute("placeholder"), "Password");

        Assert.assertTrue(loginButton.isDisplayed());
        Assert.assertTrue(loginButton.isEnabled());
        Assert.assertEquals(loginButton.getText(), "Log In");

        Assert.assertTrue(forgotPasswordLink.isDisplayed());
        Assert.assertTrue(forgotPasswordLink.isEnabled());
        Assert.assertEquals(forgotPasswordLink.getText(), "Forgot password?");
        Assert.assertFalse(forgotPasswordLink.getAttribute("href").isEmpty());

        Assert.assertTrue(createNewAccountLink.isDisplayed());
        Assert.assertTrue(createNewAccountLink.isEnabled());
        Assert.assertEquals(createNewAccountLink.getText(), "Create new account");
        Assert.assertFalse(createNewAccountLink.getAttribute("href").isEmpty());
    }
     /*
    Go to https://www.facebook.com/
    Enter username as "johnnnnn@gmail.com"
    Enter password as "1234"
    Click on "Log In" button
    Validate the error message "The email you entered isn't connected to an account. Find your account and log in."
  */
     @Test
     public void validateFacebookInvalidLoginAttempt() throws InterruptedException {
         driver.get("https://www.facebook.com/");

         WebElement usernameInputBox = driver.findElement(By.id("email")); // Replace with the actual ID of the username input box
         WebElement passwordInputBox = driver.findElement(By.id("pass")); // Replace with the actual ID of the password input box
         WebElement loginButton = driver.findElement(By.name("login")); // Replace with the actual name or ID of the login button

         usernameInputBox.sendKeys("johnnnnbbbn@gmail.com");
         passwordInputBox.sendKeys("1234");
         Thread.sleep(1500);
         loginButton.click();

         WebElement actualErrorMessage = driver.findElement(By.cssSelector("._9ay7")); // Replace with the actual CSS selector of the error message element
         String expectedErrorMessage = "The email you entered isn’t connected to an account. Find your account and log in.";

         Assert.assertTrue(actualErrorMessage.isDisplayed());
         Assert.assertEquals(expectedErrorMessage, actualErrorMessage.getText());
         Waiter.pause(3);
     }

    }