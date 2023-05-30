package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _16_TGFileDownload extends Base{
    @BeforeMethod
    public void setPage() {
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-14")).click();
    }

    /*
    TEST CASE
    Go to https://techglobal-training.com/frontend/
    Click on the "File Download" card
    Click on the "TechGlobal School.pptx" file
    MANUALLY TEST that the file is downloaded in your Downloads file
     */
    @Test
    public void validateUploadButton(){
        WebElement fileDownload = driver.findElement(By.id("file_download"));
        fileDownload.click();
    }
}
