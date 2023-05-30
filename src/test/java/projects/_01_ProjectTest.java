package projects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import scripts.Base;
import utils.Waiter;

import java.util.List;

public class _01_ProjectTest extends Base {

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/project-1");
    }

    @Test(priority = 1, description = "Test Case 01 - Validate the Contact Us information")
    public void validateTheContactUsInformation(){
        WebElement contactUsHeading = driver.findElement(By.cssSelector(".mb-5>h1"));
        WebElement contactUsAddress = driver.findElement(By.id("address"));
        WebElement contactUsEmail = driver.findElement(By.id("email"));
        WebElement contactUsPhoneNumber = driver.findElement(By.id("phone-number"));

        Assert.assertTrue(contactUsHeading.isDisplayed());
        Assert.assertEquals(contactUsHeading.getText(), "Contact Us");

        Assert.assertTrue(contactUsAddress.isDisplayed());
        Assert.assertEquals(contactUsAddress.getText(), "2860 S River Rd Suite 350, Des Plaines IL 60018");

        Assert.assertTrue(contactUsEmail.isDisplayed());
        Assert.assertEquals(contactUsEmail.getText(), "info@techglobalschool.com");

        Assert.assertTrue(contactUsPhoneNumber.isDisplayed());
        Assert.assertEquals(contactUsPhoneNumber.getText(), "(773) 257-3010");
    }

    @Test(priority = 2, description = "Test Case 02 - Validate the Full name input box")
    public void validateTheFullNameInputBox(){
        WebElement nameInputBox = driver.findElement(By.xpath("//label[@for='name']/..//input"));
        WebElement nameInputBoxLabel = driver.findElement(By.xpath("//label[@for='name']"));

        Assert.assertTrue(nameInputBox.isDisplayed());
        Assert.assertTrue(nameInputBox.isEnabled());
        Assert.assertEquals(nameInputBox.getAttribute("required"), "true");
        Assert.assertEquals(nameInputBox.getAttribute("placeholder"), "Enter your name");

        Assert.assertTrue(nameInputBoxLabel.isDisplayed());
        Assert.assertEquals(nameInputBoxLabel.getText(), "Full name *");
    }

    @Test(priority = 3, description = "Test Case 03 - Validate the Gender radio button")
    public void validateTheGenderRadioButton(){
        WebElement genderLabel = driver.findElement(By.xpath("//label[text()='Gender *']"));
        List<WebElement> genderRadioButtonLabels = driver.findElements(By.cssSelector(".radio"));
        List<WebElement> genderRadioButtonInputs = driver.findElements(By.cssSelector(".radio>input"));

        String[] expectedGenderLabelText = {"Male", "Female", "Prefer not to disclose"};

        Assert.assertEquals(genderLabel.getText(), "Gender *");

        Assert.assertEquals(genderRadioButtonInputs.get(0).getAttribute("required"), "true");

        for (int i = 0; i < 3; i++) {
            Assert.assertEquals(genderRadioButtonLabels.get(i).getText(), expectedGenderLabelText[i]);
            Assert.assertTrue(genderRadioButtonInputs.get(i).isEnabled());
            Assert.assertFalse(genderRadioButtonInputs.get(i).isSelected());
        }

        genderRadioButtonInputs.get(0).click();
        Waiter.pause(2);
        Assert.assertTrue(genderRadioButtonInputs.get(0).isSelected());
        Assert.assertFalse(genderRadioButtonInputs.get(1).isSelected());
        Assert.assertFalse(genderRadioButtonInputs.get(2).isSelected());

        genderRadioButtonInputs.get(1).click();
        Waiter.pause(2);
        Assert.assertFalse(genderRadioButtonInputs.get(0).isSelected());
        Assert.assertTrue(genderRadioButtonInputs.get(1).isSelected());
        Assert.assertFalse(genderRadioButtonInputs.get(2).isSelected());

        Waiter.pause(5);
    }

    @Test(priority = 4, description = "Test Case 04 - Validate the Address input box")
    public void validateTheAddressInputBox(){
        WebElement addressInputBox = driver.findElement(By.xpath("//label[text()='Address']/..//input"));
        WebElement addressInputBoxLabel = driver.findElement(By.xpath("//label[text()='Address']"));

        Assert.assertTrue(addressInputBox.isDisplayed());
        Assert.assertTrue(addressInputBox.isEnabled());
        Assert.assertNotEquals(addressInputBox.getAttribute("required"), "true");
        Assert.assertEquals(addressInputBox.getAttribute("placeholder"), "Enter your address");

        Assert.assertTrue(addressInputBoxLabel.isDisplayed());
        Assert.assertEquals(addressInputBoxLabel.getText(), "Address");
    }

    @Test(priority = 5, description = "Test Case 05 - Validate the Email input box")
    public void validateTheEmailInputBox(){
        WebElement emailInputBox = driver.findElement(By.cssSelector("input[type='email']"));
        WebElement emailInputBoxLabel = driver.findElement(By.xpath("//label[text()='Email *']"));

        Assert.assertTrue(emailInputBox.isDisplayed());
        Assert.assertTrue(emailInputBox.isEnabled());
        Assert.assertEquals(emailInputBox.getAttribute("required"), "true");
        Assert.assertEquals(emailInputBox.getAttribute("placeholder"), "Enter your email");

        Assert.assertTrue(emailInputBoxLabel.isDisplayed());
        Assert.assertEquals(emailInputBoxLabel.getText(), "Email *");
    }

    @Test(priority = 6, description = "Test Case 06 - Validate the Phone input box")
    public void validateThePhoneInputBox(){
        WebElement phoneInputBox = driver.findElement(By.cssSelector("input[type='phone']"));
        WebElement phoneInputBoxLabel = driver.findElement(By.xpath("//label[text()='Phone']"));

        Assert.assertTrue(phoneInputBox.isDisplayed());
        Assert.assertTrue(phoneInputBox.isEnabled());
        Assert.assertNotEquals(phoneInputBox.getAttribute("required"), "true");
        Assert.assertEquals(phoneInputBox.getAttribute("placeholder"), "Enter your phone number");

        Assert.assertTrue(phoneInputBoxLabel.isDisplayed());
        Assert.assertEquals(phoneInputBoxLabel.getText(), "Phone");
    }

    @Test(priority = 7, description = "Test Case 07 - Validate the Message text area")
    public void validateTheMessageTextArea(){
        WebElement messageTextArea = driver.findElement(By.tagName("textarea"));
        WebElement messageTextAreaLabel = driver.findElement(By.xpath("//label[text()='Message']"));

        Assert.assertTrue(messageTextArea.isDisplayed());
        Assert.assertTrue(messageTextArea.isEnabled());
        Assert.assertNotEquals(messageTextArea.getAttribute("required"), "true");
        Assert.assertEquals(messageTextArea.getAttribute("placeholder"), "Type your message here...");

        Assert.assertTrue(messageTextAreaLabel.isDisplayed());
        Assert.assertEquals(messageTextAreaLabel.getText(), "Message");
    }

    @Test(priority = 8, description = "Test Case 08 - Validate the Consent checkbox")
    public void validateTheConsentCheckbox(){
        WebElement consentCheckBoxLabel = driver.findElement(By.cssSelector(".checkbox"));
        WebElement consentCheckBox = driver.findElement(By.cssSelector("input[type='checkbox']"));

        Assert.assertTrue(consentCheckBoxLabel.isDisplayed());
        Assert.assertEquals(consentCheckBoxLabel.getText(), "I give my consent to be contacted.");

        Assert.assertEquals(consentCheckBox.getAttribute("required"), "true");
        Assert.assertTrue(consentCheckBox.isEnabled());
        Assert.assertFalse(consentCheckBox.isSelected());

        consentCheckBox.click();
        Waiter.pause(2);
        Assert.assertTrue(consentCheckBox.isSelected());

        consentCheckBox.click();
        Waiter.pause(2);
        Assert.assertFalse(consentCheckBox.isSelected());
    }

    @Test(priority = 9, description = "Test Case 09 - Validate the SUBMIT button")
    public void validateTheSubmitButton(){
        WebElement submitButton = driver.findElement(By.cssSelector(".is-link"));

        Assert.assertTrue(submitButton.isDisplayed());
        Assert.assertTrue(submitButton.isEnabled());
        Assert.assertEquals(submitButton.getText(), "SUBMIT");
    }

    @Test(priority = 10, description = "Test Case 10 - Validate the form submission")
    public <Faker> void validateTheFormSubmission(){


        WebElement nameInputBox = driver.findElement(By.xpath("//label[@for='name']/..//input"));
        List<WebElement> genders = driver.findElements(By.cssSelector(".mr-1"));
        WebElement addressInputBox = driver.findElement(By.xpath("//label[text()='Address']/..//input"));
        WebElement emailInputBox = driver.findElement(By.cssSelector("input[type='email']"));
        WebElement phoneInputBox = driver.findElement(By.cssSelector("input[type='phone']"));
        WebElement messageTextArea = driver.findElement(By.tagName("textarea"));
        WebElement consentCheckBox = driver.findElement(By.cssSelector("input[type='checkbox']"));
        WebElement submitButton = driver.findElement(By.cssSelector(".is-link"));



        WebElement confirmationMessage = driver.findElement(By.cssSelector(".mt-5"));

        Assert.assertTrue(confirmationMessage.isDisplayed());
        Assert.assertEquals(confirmationMessage.getText(), "Thanks for submitting!");
    }
}