package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Project2Page;

public class _22_Login_With_DataProvider extends Base{

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/project-2");
        project2Page = new Project2Page();
    }

    @Test(priority = 1, dataProvider = "loginData", description = "Validate the invalid login attempt")
    public void testInvalidLoginAttempts(String username, String password, String message){
        project2Page.login(username, password);

        Assert.assertTrue(project2Page.errorMessage.isDisplayed());
        Assert.assertEquals(project2Page.errorMessage.getText(), message);
    }

    @DataProvider
    public Object[][] loginData(){
        return new Object[][]{
                {"", "", "Invalid Username entered!"},
                {"John", "Test1234", "Invalid Username entered!"},
                {"TechGlobal", "1234", "Invalid Password entered!"},
                {"John", "1234", "Invalid Username entered!"}
        };
    }
}