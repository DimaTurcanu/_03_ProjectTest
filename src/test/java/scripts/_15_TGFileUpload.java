package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Waiter;

public class _15_TGFileUpload extends Base {
    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-13")).click();
    }
    @Test
    public void validateUploadButton(){
        WebElement inputUpload = driver.findElement(By.id("file_upload"));
        WebElement uploadButton = driver.findElement(By.id("file_submit"));

        inputUpload.sendKeys("/Users/oksanazbytkovska/Downloads/Mentoring-Week06-Dima.docx");
        uploadButton.click();
        Waiter.pause(3);
        // /Users/oksanazbytkovska/IdeaProjects/ui_automation_6/hello.txt
    }

    /*
    TEST CASE
    Go to https://techglobal-training.com/frontend/
    Click on the "File Upload" card
    Send the path of the file as keys to the "Choose File" input box
    Click on the "UPLOAD" button
    Validate the result message equals "You Uploaded 'hello.txt'"
     */

    @Test
    public void fileUpload(){
        WebElement inputUpload = driver.findElement(By.id("file_upload"));
        WebElement uploadButton = driver.findElement(By.id("file_submit"));

        String fileName = "/Users/oksanazbytkovska/IdeaProjects/ui_automation_6/hello.txt";

        inputUpload.sendKeys(fileName);
        uploadButton.click();
        WebElement result = driver.findElement(By.id("result"));
        Assert.assertEquals(result.getText(), "You Uploaded '"+ fileName.substring(fileName.lastIndexOf("/") + 1)+"'");
    }

}
