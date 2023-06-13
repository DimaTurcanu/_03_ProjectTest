package scripts;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Project2Page;

public class _02_ProjectTest extends Base {

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/project-2");
        project2Page = new Project2Page();
    }

    @Test(priority = 1, description = "Test Case 01 - Validate the login form")
    public void validateTheLoginForm(){
        Assert.assertTrue(project2Page.usernameInputBox.isDisplayed());
        Assert.assertTrue(project2Page.usernameInputBox.isEnabled());
        Assert.assertNotEquals(project2Page.usernameInputBox.getAttribute("required"), "true");
        Assert.assertTrue(project2Page.usernameInputBoxLabel.isDisplayed());
        Assert.assertEquals(project2Page.usernameInputBoxLabel.getText(), "Please enter your username");

        Assert.assertTrue(project2Page.passwordInputBox.isDisplayed());
        Assert.assertTrue(project2Page.passwordInputBox.isEnabled());
        Assert.assertNotEquals(project2Page.passwordInputBox.getAttribute("required"), "true");
        Assert.assertTrue(project2Page.passwordInputBoxLabel.isDisplayed());
        Assert.assertEquals(project2Page.passwordInputBoxLabel.getText(), "Please enter your password");

        Assert.assertTrue(project2Page.loginButton.isDisplayed());
        Assert.assertTrue(project2Page.loginButton.isEnabled());
        Assert.assertEquals(project2Page.loginButton.getText(), "LOGIN");

        Assert.assertTrue(project2Page.forgotPasswordLink.isDisplayed());
        Assert.assertTrue(project2Page.forgotPasswordLink.isEnabled());
        Assert.assertEquals(project2Page.forgotPasswordLink.getText(), "Forgot Password?");
    }

    @Test(priority = 2, description = "Test Case 02 - Validate the valid login")
    public void validateTheValidLogin(){
        project2Page.login("TechGlobal", "Test1234");

        Assert.assertTrue(project2Page.successfulLoginMessage.isDisplayed());
        Assert.assertEquals(project2Page.successfulLoginMessage.getText(), "You are logged in");

        Assert.assertTrue(project2Page.logoutButton.isDisplayed());
        Assert.assertTrue(project2Page.logoutButton.isEnabled());
        Assert.assertEquals(project2Page.logoutButton.getText(), "LOGOUT");
    }

    @Test(priority = 3, description = "Test Case 03 - Validate the logout")
    public void validateTheLogOut(){
        project2Page.login("TechGlobal", "Test1234");
        project2Page.logoutButton.click();
        Assert.assertTrue(project2Page.loginForm.isDisplayed());
    }

    @Test(priority = 4, description = "Test Case 04 - Validate the Forgot Password? Link and Reset Password modal")
    public void validateTheForgotPasswordLinkAndResetPasswordModal(){
        project2Page.forgotPasswordLink.click();

        Assert.assertTrue(project2Page.resetPasswordModalTitle.isDisplayed());
        Assert.assertEquals(project2Page.resetPasswordModalTitle.getText(), "Reset Password");

        Assert.assertTrue(project2Page.resetPasswordModalCloseButton.isDisplayed());
        Assert.assertTrue(project2Page.resetPasswordModalCloseButton.isEnabled());

        Assert.assertTrue(project2Page.resetPasswordModalHeading.isDisplayed());
        Assert.assertEquals(project2Page.resetPasswordModalHeading.getText(), "Reset Password");

        Assert.assertTrue(project2Page.resetPasswordModalEmailInputBoxLabel.isDisplayed());
        Assert.assertEquals(project2Page.resetPasswordModalEmailInputBoxLabel.getText(), "Enter your email address and we'll send you a link to reset your password.");

        Assert.assertTrue(project2Page.resetPasswordModalEmailInputBox.isDisplayed());
        Assert.assertTrue(project2Page.resetPasswordModalEmailInputBox.isEnabled());

        Assert.assertTrue(project2Page.resetPasswordModalSubmitButton.isDisplayed());
        Assert.assertTrue(project2Page.resetPasswordModalSubmitButton.isEnabled());
        Assert.assertEquals(project2Page.resetPasswordModalSubmitButton.getText(), "SUBMIT");
    }

    @Test(priority = 5, description = "Test Case 05 - Validate the Reset Password modal close button")
    public void validateTheResetPasswordModalCloseButton(){
        project2Page.forgotPasswordLink.click();

        Assert.assertTrue(project2Page.resetPasswordModal.isDisplayed());

        project2Page.resetPasswordModalCloseButton.click();

        //One way to validate the modal is not displayed
        try{
            Assert.assertFalse(project2Page.resetPasswordModal.isDisplayed());
        } catch (NoSuchElementException e){
            Assert.assertTrue(true);
        }
    }

    @Test(priority = 6, description = "Test Case 06 - Validate the Reset Password form submission")
    public void validateTheResetPasswordFormSubmission(){
        project2Page.forgotPasswordLink.click();
        project2Page.resetPasswordModalEmailInputBox.sendKeys("johndoe@gmail.com");
        project2Page.resetPasswordModalSubmitButton.click();

        Assert.assertTrue(project2Page.resetPasswordModalMessage.isDisplayed());
        Assert.assertEquals(project2Page.resetPasswordModalMessage.getText(), "A link to reset your password has been sent to your email address.");
    }

    @Test(priority = 7, description = "Test Case 07 - Validate the invalid login with the empty credentials")
    public void validateTheInvalidLoginWithEmptyCredentials(){
        project2Page.loginButton.click();

        Assert.assertTrue(project2Page.errorMessage.isDisplayed());
        Assert.assertEquals(project2Page.errorMessage.getText(), "Invalid Username entered!");
    }

    @Test(priority = 8, description = "Test Case 08 - Validate the invalid login with the wrong username")
    public void validateTheInvalidLoginWithTheWrongUsername(){
        project2Page.login("John", "Test1234");

        Assert.assertTrue(project2Page.errorMessage.isDisplayed());
        Assert.assertEquals(project2Page.errorMessage.getText(), "Invalid Username entered!");
    }

    @Test(priority = 9, description = "Test Case 09 - Validate the invalid login with the wrong password")
    public void validateTheInvalidLoginWithTheWrongPassword(){
        project2Page.login("TechGlobal", "1234");

        Assert.assertTrue(project2Page.errorMessage.isDisplayed());
        Assert.assertEquals(project2Page.errorMessage.getText(), "Invalid Password entered!");
    }

    @Test(priority = 10, description = "Test Case 10 - Validate the invalid login with the wrong username and password")
    public void validateTheInvalidLoginWithTheWrongUsernameAndPassword(){
        project2Page.login("John", "1234");

        Assert.assertTrue(project2Page.errorMessage.isDisplayed());
        Assert.assertEquals(project2Page.errorMessage.getText(), "Invalid Username entered!");
    }
}