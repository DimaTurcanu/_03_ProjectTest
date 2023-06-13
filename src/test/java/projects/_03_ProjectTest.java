package projects;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Project3Page;
import scripts.Base;
import utils.DropdownHandler;
import utils.Waiter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class _03_ProjectTest extends Base {

    public LocalDate currentDate = LocalDate.now();
    public LocalDate nextDay = currentDate.plusDays(1);
    public LocalDate nextWeek = currentDate.plusDays(7);
    public LocalDate nextMonth = currentDate.plusMonths(1).plusDays(7);

    @BeforeMethod
    public void setPage() {
        driver.get("https://techglobal-training.com/frontend/project-3");
        project3Page = new Project3Page();
    }

    @Test(priority = 1, description = "Test Case 01 - Validate the default Book your trip form")
    public void validateDefaultForm() {

        Assert.assertTrue(project3Page.oneWayButton.isDisplayed());
        Assert.assertTrue(project3Page.oneWayButton.isEnabled());
        Assert.assertTrue(project3Page.oneWayButton.isSelected());

        Assert.assertTrue(project3Page.roundTripButton.isDisplayed());
        Assert.assertTrue(project3Page.roundTripButton.isEnabled());
        Assert.assertFalse(project3Page.roundTripButton.isSelected());

        List<WebElement> options = Arrays.asList(project3Page.cabinClassLabel, project3Page.dropdownCabinClass,
                project3Page.fromLabel, project3Page.fromDropdown, project3Page.toLabel, project3Page.toDropdown,
                project3Page.departLabel, project3Page.departDatePicker, project3Page.returnLabel);

        for (WebElement option : options) {
            Assert.assertTrue(option.isDisplayed());
        }

        Assert.assertFalse(project3Page.returnDatePickerInput.isEnabled());

        Assert.assertTrue(project3Page.numberOfPassengersLabel.isDisplayed());
        Assert.assertTrue(project3Page.numberOfPassengersDropdown.isDisplayed());
        Assert.assertEquals(project3Page.numberOfPassengersDropdown.getAttribute("value"), "1");

        Assert.assertTrue(project3Page.passenger1Label.isDisplayed());
        Assert.assertTrue(project3Page.passenger1Dropdown.isDisplayed());
        Assert.assertEquals(project3Page.passenger1Dropdown.getAttribute("value"), "Adult (16-64)");

        Assert.assertTrue(project3Page.bookButton.isDisplayed());
        Assert.assertTrue(project3Page.bookButton.isEnabled());

    }

    @Test(priority = 2, description = "Validate the Book your trip form when Round trip is selected")
    public void validateRoundTrip() {
        project3Page.roundTripButton.click();
        Assert.assertTrue(project3Page.roundTripButton.isSelected());
        Assert.assertFalse(project3Page.oneWayButton.isSelected());

        List<WebElement> options = Arrays.asList(project3Page.cabinClassLabel, project3Page.dropdownCabinClass,
                project3Page.fromLabel, project3Page.fromDropdown, project3Page.toLabel, project3Page.toDropdown,
                project3Page.departLabel, project3Page.departDatePicker, project3Page.returnLabel, project3Page.returnDatePicker);

        for (WebElement option : options) {
            Assert.assertTrue(option.isDisplayed());
        }

        Assert.assertTrue(project3Page.numberOfPassengersLabel.isDisplayed());
        Assert.assertTrue(project3Page.numberOfPassengersDropdown.isDisplayed());
        Assert.assertEquals(project3Page.numberOfPassengersDropdown.getAttribute("value"), "1");

        Assert.assertTrue(project3Page.passenger1Label.isDisplayed());
        Assert.assertTrue(project3Page.passenger1Dropdown.isDisplayed());
        Assert.assertEquals(project3Page.passenger1Dropdown.getAttribute("value"), "Adult (16-64)");

        Assert.assertTrue(project3Page.bookButton.isDisplayed());
        Assert.assertTrue(project3Page.bookButton.isEnabled());
    }

    @Test(priority = 3, description = "Validate the booking for 1 passenger and one way")
    public void validate1PassengerOneWayOption() {

        project3Page.oneWayButton.click();

        DropdownHandler.selectByVisibleText(project3Page.dropdownCabinClass, "Business");
        DropdownHandler.selectByVisibleText(project3Page.fromDropdown, "Illinois");
        DropdownHandler.selectByVisibleText(project3Page.toDropdown, "Florida");

        project3Page.departDayPickerInput.sendKeys(Integer.toString(currentDate.getDayOfMonth() + 7));
        Waiter.pause(3);

        DropdownHandler.selectByVisibleText(project3Page.numberOfPassengersDropdown, "1");
        DropdownHandler.selectByVisibleText(project3Page.passenger1Dropdown, "Senior (65+)");
        Waiter.pause(3);

        project3Page.bookButton.click();
        Waiter.pause(3);

        Assert.assertEquals(project3Page.confirmationMessage.getText(), "DEPART\n" +
                "IL to FL\n" +
                nextWeek.format(DateTimeFormatter.ofPattern("E MMM dd yyyy")) +
                "\nNumber of Passengers: 1\n" +
                "Passenger 1: Senior (65+)\n" +
                "Cabin class: Business");
    }

    @Test(priority = 4, description = "Validate the booking for 1 passenger and round trip")
    public void validate1PassengerRoundTripOption() {

        project3Page.roundTripButton.click();
        DropdownHandler.selectByVisibleText(project3Page.dropdownCabinClass, "First");
        DropdownHandler.selectByVisibleText(project3Page.fromDropdown, "California");
        DropdownHandler.selectByVisibleText(project3Page.toDropdown, "Illinois");

        project3Page.departDayPickerInput.sendKeys(Integer.toString(currentDate.getDayOfMonth() + 7));
        Waiter.pause(2);

        project3Page.returnMonthPickerInput.sendKeys(Integer.toString(currentDate.getMonthValue() + 1));
        Waiter.pause(2);

        DropdownHandler.selectByVisibleText(project3Page.numberOfPassengersDropdown, "1");
        DropdownHandler.selectByVisibleText(project3Page.passenger1Dropdown, "Adult (16-64)");

        project3Page.bookButton.click();
        Assert.assertEquals(project3Page.confirmationMessage.getText(), "DEPART\n" +
                "CA to IL\n" +
                nextWeek.format(DateTimeFormatter.ofPattern("E MMM dd yyyy")) +
                "\nRETURN\n" +
                "IL to CA\n" +
                nextMonth.format(DateTimeFormatter.ofPattern("E MMM dd yyyy")) +
                "\nNumber of Passengers: 1\n" +
                "Passenger 1: Adult (16-64)\n" +
                "Cabin class: First");
    }

    @Test(priority = 5, description = "Validate the booking for 2 passengers and one way")
    public void validate2PassengerOneWayOption() {

        project3Page.oneWayButton.click();
        DropdownHandler.selectByVisibleText(project3Page.dropdownCabinClass, "Premium Economy");
        DropdownHandler.selectByVisibleText(project3Page.fromDropdown, "New York");
        DropdownHandler.selectByVisibleText(project3Page.toDropdown, "Texas");

        project3Page.departDayPickerInput.sendKeys(Integer.toString(currentDate.getDayOfMonth() + 1));
        Waiter.pause(5);

        DropdownHandler.selectByVisibleText(project3Page.numberOfPassengersDropdown, "2");
        DropdownHandler.selectByVisibleText(project3Page.passenger1Dropdown, "Adult (16-64)");
        DropdownHandler.selectByVisibleText(project3Page.passenger2Dropdown, "Child (2-11)");
        project3Page.bookButton.click();

        Assert.assertEquals(project3Page.confirmationMessage.getText(), "DEPART\n" +
                "NY to TX\n" +
                nextDay.format(DateTimeFormatter.ofPattern("E MMM dd yyyy")) +
                "\nNumber of Passengers: 2\n" +
                "Passenger 1: Adult (16-64)\n" +
                "Passenger 2: Child (2-11)\n" +
                "Cabin class: Premium Economy");
    }
}
