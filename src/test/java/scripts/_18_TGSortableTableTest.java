package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.TableHandler;
import utils.Waiter;

import java.util.ArrayList;
import java.util.List;

public class _18_TGSortableTableTest extends Base {

    @BeforeMethod
    public void setPage() {
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-18")).click();
    }

    /**
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Sortable Tables" card
     * Click on the Quantity sort button to toggle Ascending Order
     * Verify that the Quantity column of the table is sorted in ascending order
     */
    @Test
    public void validateSortAscByQuantity(){
        WebElement ascByQuantity = driver.findElement(By.id("quantity_asc"));
        ascByQuantity.click();

        List<WebElement> quantityColumnElements = TableHandler.getTableColumn(1);
        List<Integer> quantityColumn = new ArrayList<>();

        for(WebElement element : quantityColumnElements){
            quantityColumn.add(Integer.parseInt(element.getText()));
        }

        Waiter.pause(2);

        for (int i = 1; i < quantityColumn.size(); i++) {
            Assert.assertTrue(quantityColumn.get(i) >= quantityColumn.get(i-1));
        }
    }
}