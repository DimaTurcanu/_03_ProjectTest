package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.GoogleSearchPage;
import pages.GoogleSearchResultsPage;

public class _20_GoogleSearchTest extends Base {

    @BeforeMethod
    public void setPage(){
        driver.get("https://www.google.com/");
        googleSearchPage = new GoogleSearchPage();
        googleSearchResultsPage = new GoogleSearchResultsPage();
    }

    @Test(priority = 1, description = "Validate the Google Search")
    public void validateTheGoogleSearchResult(){
        googleSearchPage.search("canvas painting");

        Assert.assertTrue(googleSearchResultsPage.resultTag.isDisplayed());
        String resultTag = googleSearchResultsPage.resultTag.getText(); // About 1,010,000,000 results (0.60 seconds)

        Assert.assertTrue(Integer.parseInt(resultTag.replaceAll("[^0-9]", "").substring(0, 1)) > 0);
    }

    @Test(priority = 2, description = "Validate the Google Search", dataProvider = "searchKeys")
    public void validateTheSearch(String key){
        googleSearchPage.search(key);

        Assert.assertTrue(googleSearchResultsPage.resultTag.isDisplayed());
        String resultTag = googleSearchResultsPage.resultTag.getText();

        Assert.assertTrue(Integer.parseInt(resultTag.replaceAll("[^0-9]", "").substring(0, 1)) > 0);
    }

    @DataProvider
    public Object[] searchKeys(){
        return new Object[]{"Tesla", "Microsoft", "Apple", "Oracle"};
    }
}