package projects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import scripts.Base;
import utils.Waiter;

import java.util.List;


public class UI_Automation_Project extends Base{


    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/project-1");
    }
    /*
    Navigate to https://techglobal-training.com/frontend/project-1
    Validate the heading is “Contact Us”
    Validate the address is “2860 S River Rd Suite 350, Des Plaines IL 60018”
    Validate the email is “info@techglobalschool.com"
    Validate the phone number is “(773) 257-3010”
     */
    @Test (priority = 1)
    public void validateHeadingInformation(){
        WebElement heading = driver.findElement(By.cssSelector(".is-size-2"));
        WebElement address = driver.findElement(By.id("address"));
        WebElement email = driver.findElement(By.id("email"));
        WebElement phoneNr = driver.findElement(By.id("phone-number"));
        Assert.assertEquals(heading.getText(), "Contact Us");
        Assert.assertEquals(address.getText(), "2860 S River Rd Suite 350, Des Plaines IL 60018");
        Assert.assertEquals(email.getText(), "info@techglobalschool.com");
        Assert.assertEquals(phoneNr.getText(), "(773) 257-3010");
    }

    /*
    Navigate to https://techglobal-training.com/frontend/project-1
    Validate that the Full name input box is displayed
    Validate that the Full name input box is required
    Validate that the label of the Full name input box is “Full name”
    Validate that the placeholder of the Full name input box is “Enter your name”
    */
    @Test (priority = 2)
    public void fullNameBox(){
        WebElement fullNameInBox = driver.findElement(By.xpath("(//input[@type='text'])[1]"));
        WebElement label = driver.findElement(By.cssSelector(".label[for=\"name\"]"));

        Assert.assertTrue(fullNameInBox.isDisplayed());
        Assert.assertEquals(fullNameInBox.getAttribute("required"), "true");
        Assert.assertEquals(label.getText(), "Full name *");
        Assert.assertEquals(fullNameInBox.getAttribute("placeholder"), "Enter your full name");
    }

    /*
    Navigate to https://techglobal-training.com/frontend/project-1
    Validate the label is “Gender”
    Validate that the Gender is required
    Validate the options are “Female”, “Male” and “Prefer not to disclose”
    Validate the options are clickable and not selected
    Click on the “Male” option and validate it is selected while the others are not selected
    Click on the “Female” option and validate it is selected while the others are not selected
*/
    @Test (priority = 3)
    public void validateGenderBox(){
    WebElement genderBox = driver.findElement(By.xpath("(//label[@class='label'])[2]"));

    List<WebElement> genderOptionsExist = driver.findElements(By.cssSelector(".radio"));
    List<WebElement> genderOptionsSelected = driver.findElements(By.cssSelector(".radio input"));

    String [] expectedTexts = {"Male", "Female", "Prefer not to disclose"};

    Assert.assertEquals(genderBox.getText(), "Gender *");
        Assert.assertEquals(genderOptionsSelected.get(0).getAttribute("required"), "true");

        for (int i = 0; i < genderOptionsExist.size(); i++) {

            Assert.assertEquals(genderOptionsExist.get(i).getText(), expectedTexts[i]);
            Assert.assertTrue(genderOptionsExist.get(i).isEnabled());
            Assert.assertFalse(genderOptionsSelected.get(i).isSelected());
        }
        genderOptionsExist.get(0).click();
        Assert.assertTrue(genderOptionsSelected.get(0).isSelected());
        Waiter.pause(2);

        for (int i = 1; i < genderOptionsSelected.size(); i++) {
            Assert.assertFalse(genderOptionsSelected.get(i).isSelected());
        }
        genderOptionsExist.get(1).click();
        Assert.assertTrue(genderOptionsSelected.get(1).isSelected());
        Waiter.pause(2);

        for (int i = 0; i < genderOptionsSelected.size(); i+=2) {
            Assert.assertFalse(genderOptionsSelected.get(i).isSelected());
        }
    }
    /*
    Navigate to https://techglobal-training.com/frontend/project-1
    Validate that the Address input box is displayed
    Validate that the Address input box is not required
    Validate that the label of the Address input box is “Address”
    Validate that the placeholder of the Address input box is “Enter your address*”
     */
    @Test (priority = 4)
    public void AddressBox(){
        WebElement addressLocator = driver.findElement(By.xpath("(//input[@class='input'])[2]"));
        WebElement addressLabelLocator = driver.findElement(By.xpath("(//label[@class='label'])[3]"));

        Assert.assertTrue(addressLocator.isDisplayed());
        Assert.assertNull(addressLocator.getAttribute("required"));
        Assert.assertEquals(addressLabelLocator.getText(), "Address");
        Assert.assertEquals(addressLocator.getAttribute("placeholder"), "Enter your address");
    }

    /*
    Navigate to https://techglobal-training.com/frontend/project-1
    Validate that the Email input box is displayed
    Validate that the Email input box is required
    Validate that the label of the Email input box is “Email”
    Validate that the placeholder of the Email input box is “Enter your email”
     */

    @Test (priority = 5)
    public void emailBox(){
        WebElement emailLocator = driver.findElement(By.xpath("(//input[@class='input'])[3]"));
        WebElement emailLabelLocator = driver.findElement(By.xpath("(//label[@class='label'])[4]"));

        Assert.assertTrue(emailLocator.isDisplayed());
        Assert.assertEquals(emailLocator.getAttribute("required"), "true");
        Assert.assertEquals(emailLabelLocator.getText(), "Email *");
        Assert.assertEquals(emailLocator.getAttribute("placeholder"), "Enter your email");
    }

    /*
    Navigate to https://techglobal-training.com/frontend/project-1
    Validate that the Phone input box is displayed
    Validate that the Phone input box is not required
    Validate that the label of the Phone input box is “Phone”
    Validate that the placeholder of the Address input box is “Enter your phone number”
     */

    @Test  (priority = 6)
    public void phoneBox(){
        WebElement phoneLocator = driver.findElement(By.xpath("(//input[@class='input'])[4]"));
        WebElement phoneLabelLocator = driver.findElement(By.xpath("(//label[@class='label'])[5]"));

        Assert.assertTrue(phoneLocator.isDisplayed());
        Assert.assertNull(phoneLocator.getAttribute("required"));
        Assert.assertEquals(phoneLabelLocator.getText(), "Phone");
        Assert.assertEquals(phoneLocator.getAttribute("placeholder"), "Enter your phone number");
    }
    /*
    Navigate to https://techglobal-training.com/frontend/project-1
    Validate that the Message text area is displayed
    Validate that the Message text area is not required
    Validate that the label of the Message text area is “Message”
    Validate that the placeholder of the Message text area is “Type your message here…”
     */
    @Test (priority = 7)
    public void MessageBox(){
        WebElement messageBoxLocator = driver.findElement(By.xpath("(//textarea[@class='textarea'])"));
        WebElement messageBoxLabelLocator = driver.findElement(By.xpath("(//label[@class='label'])[6]"));

        Assert.assertTrue(messageBoxLocator.isDisplayed());
        Assert.assertNull(messageBoxLocator.getAttribute("required"));
        Assert.assertEquals(messageBoxLabelLocator.getText(), "Message");
        Assert.assertEquals(messageBoxLocator.getAttribute("placeholder"), "Type your message here...");
    }
    /*
    Navigate to https://techglobal-training.com/frontend/project-1
    Validate the label is “I give my consent to be contacted.”
    Validate that the Consent checkbox is required
    Validate that the Consent checkbox is clickable
    Click on the “I give my consent to be contacted.” checkbox and validate it is selected
    Click on the “I give my consent to be contacted.” checkbox again and validate it is not selected
     */
    @Test (priority = 8)
    public void checkbox(){
        WebElement checkbox = driver.findElement(By.xpath("(//input[@type='checkbox'])"));
        WebElement checkboxLabel = driver.findElement(By.xpath("(//label[@class='checkbox'])"));

        Assert.assertEquals(checkboxLabel.getText(), "I give my consent to be contacted.");
        Assert.assertEquals(checkbox.getAttribute("required"), "true");
        Assert.assertTrue(checkboxLabel.isEnabled());
        checkboxLabel.click();
        Waiter.pause(4);
        Assert.assertTrue(checkbox.isSelected());
        checkboxLabel.click();
        Waiter.pause(2);
        Assert.assertFalse(checkbox.isSelected());
    }

    /*
    Navigate to https://techglobal-training.com/frontend/project-1
    Validate the “SUBMIT” button is displayed
    Validate the “SUBMIT” button is clickable
    Validate that the button text is “SUBMIT”
     */

    @Test (priority = 9)
    public void submitButton(){
        WebElement submit = driver.findElement(By.xpath("(//button[@class='button is-link'])"));
        Assert.assertTrue(submit.isDisplayed());
        Assert.assertTrue(submit.isEnabled());
        Assert.assertEquals(submit.getText(), "SUBMIT");
    }
    /*
    Navigate to https://techglobal-training.com/frontend/project-1
    Enter a first name
    Select a gender
    Enter an address
    Enter an email
    Enter a phone number
    Enter a message
    Select the “I give my consent to be contacted.” checkbox
    Click on the “SUBMIT” button
    Validate the form message “Thanks for submitting!” is displayed under the “SUBMIT” button
     */

    @Test (priority = 10)
    public void fullWebpageTest(){
        driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("John Doe");
        driver.findElements(By.cssSelector(".radio")).get(1).click();
        Waiter.pause(2);
        driver.findElement(By.xpath("(//input[@class='input'])[2]")).sendKeys("123 chicago");
        driver.findElement(By.xpath("(//input[@class='input'])[3]")).sendKeys("abc@gmail.com");
        Waiter.pause(2);
        driver.findElement(By.xpath("(//input[@class='input'])[4]")).sendKeys("773-355-7553");
        driver.findElement(By.xpath("(//textarea[@class='textarea'])")).sendKeys("here we go");
        Waiter.pause(2);
        driver.findElement(By.xpath("(//label[@class='checkbox'])")).click();
        driver.findElement(By.xpath("(//button[@class='button is-link'])")).click();
        Waiter.pause(2);
        Assert.assertEquals(driver.findElement(By.xpath("(//strong[@class='mt-5'])")).getText(), "Thanks for submitting!");





    }
}
