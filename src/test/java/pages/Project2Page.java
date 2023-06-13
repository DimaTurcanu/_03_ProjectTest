package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class Project2Page {

    //Modify default constructor to introduce web elements to driver!
    public Project2Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = ".LoginForm_form__b4o6J")
    public WebElement loginForm;

    @FindBy(id = "username")
    public WebElement usernameInputBox;

    @FindBy(css = "label[for='username']")
    public WebElement usernameInputBoxLabel;

    @FindBy(id = "password")
    public WebElement passwordInputBox;

    @FindBy(css = "label[for='password']")
    public WebElement passwordInputBoxLabel;

    @FindBy(id = "login_btn")
    public WebElement loginButton;

    @FindBy(linkText = "Forgot Password?")
    public WebElement forgotPasswordLink;

    @FindBy(id = "error_message")
    public WebElement errorMessage;

    @FindBy(id = "success_lgn")
    public WebElement successfulLoginMessage;

    @FindBy(id = "logout")
    public WebElement logoutButton;

    @FindBy(css = ".modal-card")
    public WebElement resetPasswordModal;

    @FindBy(id = "modal_title")
    public WebElement resetPasswordModalTitle;

    @FindBy(css = ".delete")
    public WebElement resetPasswordModalCloseButton;

    @FindBy(id = "sub_heading")
    public WebElement resetPasswordModalHeading;

    @FindBy(id = "email")
    public WebElement resetPasswordModalEmailInputBox;

    @FindBy(css = "label[for='email']")
    public WebElement resetPasswordModalEmailInputBoxLabel;

    @FindBy(id = "submit")
    public WebElement resetPasswordModalSubmitButton;

    @FindBy(css = "p[class^='has-text-']")
    public WebElement resetPasswordModalMessage;


    //Reusable methods
    public void login(String username, String password){
        usernameInputBox.sendKeys(username);
        passwordInputBox.sendKeys(password);
        loginButton.click();
    }
}