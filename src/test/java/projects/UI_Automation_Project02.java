package projects;

import javafx.scene.layout.Priority;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import scripts.Base;
import utils.Waiter;

public class UI_Automation_Project02 extends Base {
    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/project-2");
    }
    /*
    Navigate to https://techglobal-training.com/frontend/project-2
    Validate that the username input box is displayed
    Validate that the username input box is not required
    Validate that the label of the username input box is “Please enter your username”
    Validate that the password input box is displayed
    Validate that the password input box is not required
    Validate that the label of the password input box is “Please enter your password”
    Validate the “LOGIN” button is displayed
    Validate the “LOGIN” button is clickable
    Validate that the button text is “LOGIN”
    Validate the “Forgot Password?” link is displayed
    Validate that the “Forgot Password?” link is clickable
    Validate that the link text is “Forgot Password?”
     */

    @Test(priority = 1)
    public void validateLogin() {
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement usernameLabel = driver.findElement(By.cssSelector("label[for='username']"));
        WebElement passwordLabel = driver.findElement(By.cssSelector("label[for='password']"));
        WebElement loginButton = driver.findElement(By.id("login_btn"));
        WebElement forgotPassword = driver.findElement(By.cssSelector("div:nth-child(3)>a"));

        Assert.assertTrue(usernameInput.isDisplayed());
        Assert.assertNotEquals(usernameInput.getAttribute("required"), "true");
        Assert.assertEquals(usernameLabel.getText(), "Please enter your username");
        Assert.assertTrue(passwordInput.isDisplayed());
        Assert.assertNotEquals(passwordInput.getAttribute("required"), "true");
        Assert.assertEquals(passwordLabel.getText(), "Please enter your password");
        Assert.assertTrue(loginButton.isDisplayed());
        Assert.assertTrue(loginButton.isEnabled());
        Assert.assertEquals(loginButton.getText(), "LOGIN");
        Assert.assertTrue(forgotPassword.isDisplayed());
        Assert.assertTrue(forgotPassword.isEnabled());
        Assert.assertEquals(forgotPassword.getText(), "Forgot Password?");
    }
    /*
    Navigate to https://techglobal-training.com/frontend/project-2
    Enter the username as “TechGlobal”
    Enter the password as “Test1234”
    Click on the “LOGIN” button
    Validate the success message is displayed as “You are logged in”
    Validate the logout button displayed with the text “LOGOUT”
     */
    @Test(priority = 2)
    public void validateLoginOutput(){
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login_btn"));

        usernameInput.sendKeys("TechGlobal");
        passwordInput.sendKeys("Test1234");
        loginButton.click();

        WebElement logoutButton = driver.findElement(By.id("logout"));
        WebElement headDisplay = driver.findElement(By.id("success_lgn"));

        Assert.assertEquals(headDisplay.getText(), "You are logged in");
        Assert.assertEquals(logoutButton.getText(), "LOGOUT");
    }
    /*
    Navigate to https://techglobal-training.com/frontend/project-2
    Enter the username as “TechGlobal”
    Enter the password as “Test1234”
    Click on the “LOGIN” button
    Click on the “LOGOUT” button
    Validate that the login form is displayed
     */
    @Test(priority = 3)
    public void validateLogout(){
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login_btn"));

        usernameInput.sendKeys("TechGlobal");
        passwordInput.sendKeys("Test1234");
        loginButton.click();

        WebElement logoutButton = driver.findElement(By.id("logout"));
        logoutButton.click();
        WebElement loginForm = driver.findElement(By.cssSelector("div.LoginForm_form__b4o6J"));
        Assert.assertTrue(loginForm.isDisplayed());
    }
    /*
    Navigate to https://techglobal-training.com/frontend/project-2
    Click on the “Forgot Password?” link
    Validate that the modal heading “Reset Password” is displayed
    Validate that the close button is displayed
    Validate that the email input box is displayed
    Validate that the label of the email input box is “Enter your email address and we'll send you a link to reset your password.”
    Validate the “SUBMIT” button is displayed
    Validate the “SUBMIT” button is clickable
    Validate that the button text is “SUBMIT”
     */

    @Test(priority = 4)
    public void forgotPassword(){
        WebElement forgotPassword = driver.findElement(By.cssSelector("div:nth-child(3)>a"));
        forgotPassword.click();

        WebElement modalHeading = driver.findElement(By.id("sub_heading"));
        WebElement modalCloseButton = driver.findElement(By.cssSelector("button[class='delete']"));
        WebElement inputEmail = driver.findElement(By.id("email"));
        WebElement labelEmail = driver.findElement(By.cssSelector("label[for='email']"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        Assert.assertTrue(modalHeading.isDisplayed());
        Assert.assertTrue(modalCloseButton.isDisplayed());
        Assert.assertTrue(inputEmail.isDisplayed());
        Assert.assertEquals(labelEmail.getText(), "Enter your email address and we'll send you a link to reset your password.");
        Assert.assertTrue(submitButton.isDisplayed());
        Assert.assertEquals(submitButton.getText(), "SUBMIT");

    }
    /*
    Navigate to https://techglobal-training.com/frontend/project-2
    Click on the “Forgot Password?” link
    Validate that the “Reset Password” modal is displayed
    Click on the close button
    Validate that the “Reset Password” modal is closed
     */

    @Test(priority = 5)
    public void validateModalCloses(){
        WebElement forgotPassword = driver.findElement(By.cssSelector("div:nth-child(3)>a"));
        forgotPassword.click();

        WebElement modalIsActive = driver.findElement(By.cssSelector("div[class='modal is-active']"));
        WebElement modalCloseButton = driver.findElement(By.cssSelector("button[class='delete']"));

        Assert.assertTrue(modalIsActive.isDisplayed());
        modalCloseButton.click();
        Waiter.pause(2);

        WebElement modalIsClosed = driver.findElement(By.cssSelector("div[class='modal is-active']"));
        Assert.assertFalse(modalIsClosed.isDisplayed());
    }

    /*
    Navigate to https://techglobal-training.com/frontend/project-2
    Click on the “Forgot Password?” link
    Enter an email
    Click on the “SUBMIT” button
    Validate the form message “A link to reset your password has been sent to your email address.” is displayed under the “SUBMIT” button
    */

    @Test(priority = 6)
    public void validateResetSubmission(){
        WebElement forgotPassword = driver.findElement(By.cssSelector("div:nth-child(3)>a"));
        forgotPassword.click();

        WebElement inputEmail = driver.findElement(By.id("email"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        inputEmail.sendKeys("techGlobalSchool@gmail.com");
        submitButton.click();

        WebElement resetConfirmation = driver.findElement(By.id("confirmation_message"));
        Assert.assertTrue(resetConfirmation.getLocation().getY() > submitButton.getLocation().getY(), "A link to reset your password has been sent to your email address.");
    }

    /*
    Navigate to https://techglobal-training.com/frontend/project-2
    Leave username empty
    Leave password empty
    Click on the “LOGIN” button
    Validate the failure message is displayed as “Invalid Username entered!” above the form
     */
    @Test(priority = 7)
    public void resetPassword(){
        WebElement loginButton = driver.findElement(By.id("login_btn"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.id("error_message"));
        WebElement loginForm = driver.findElement(By.cssSelector("div[class='mb-5'] h1"));

        Assert.assertTrue(errorMessage.getLocation().getY() > loginForm.getLocation().getY(), "Invalid Username entered!");
    }
    /*
    Navigate to https://techglobal-training.com/frontend/project-2
    Enter the username as “John”
    Enter the password as “Test1234”
    Click on the “LOGIN” button
    Validate the failure message is displayed as “Invalid Username entered!” above the form
     */
    @Test(priority = 8)
    public void loginWrongUsername(){
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login_btn"));

        usernameInput.sendKeys("John");
        passwordInput.sendKeys("Test1234");
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.id("error_message"));
        WebElement loginForm = driver.findElement(By.cssSelector("div[class='mb-5'] h1"));

        Assert.assertTrue(errorMessage.getLocation().getY() > loginForm.getLocation().getY(), "Invalid Username entered!");
    }
    /*
    Navigate to https://techglobal-training.com/frontend/project-2
    Enter the username as “TechGlobal”
    Enter the password as “1234”
    Click on the “LOGIN” button
    Validate the failure message is displayed as “Invalid Password entered!” above the form
     */
    @Test(priority = 9)
    public void loginWrongPassword(){
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login_btn"));

        usernameInput.sendKeys("TechGlobal");
        passwordInput.sendKeys("1234");
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.id("error_message"));
        WebElement loginForm = driver.findElement(By.cssSelector("div[class='mb-5'] h1"));

        Assert.assertTrue(errorMessage.getLocation().getY() > loginForm.getLocation().getY(), "Invalid Password entered!");
    }

    /*
    Navigate to https://techglobal-training.com/frontend/project-2
    Enter the username as “John”
    Enter the password as “1234”
    Click on the “LOGIN” button
    Validate the failure message is displayed as “Invalid Username entered!” above the form
     */
    @Test(priority = 10)
    public void loginWrongUsernameAndPassword() {
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login_btn"));

        usernameInput.sendKeys("John");
        passwordInput.sendKeys("1234");
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.id("error_message"));
        WebElement loginForm = driver.findElement(By.cssSelector("div[class='mb-5'] h1"));

        Assert.assertTrue(errorMessage.getLocation().getY() > loginForm.getLocation().getY(), "Invalid Username entered!");
    }
}
