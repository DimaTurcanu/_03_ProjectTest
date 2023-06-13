package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EtsyHomePage {

    @FindBy(css = "ul[data-ui='top-nav-category-list'] a")
    public List<WebElement> headerItems;
}
