package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class Project3Page {

    //Modify default constructor to introduce web elements to driver!
    public Project3Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(css = "input[value='One way']")
    public WebElement oneWayButton;

    @FindBy(css = "input[value='Round trip']")
    public WebElement roundTripButton;

    @FindBy(css = "div:nth-of-type(2) > label")
    public WebElement cabinClassLabel;

    @FindBy(css = ":nth-child(2) > div > select")
    public WebElement dropdownCabinClass;

    @FindBy(css = "div:nth-of-type(3) > label")
    public WebElement fromLabel;

    @FindBy(css = ":nth-child(3) > div > select")
    public WebElement fromDropdown;

    @FindBy(css = "div:nth-of-type(4) > label")
    public WebElement toLabel;

    @FindBy(css = ":nth-child(4) > div > select")
    public WebElement toDropdown;

    @FindBy(css = "div:nth-of-type(5) > label")
    public WebElement departLabel;

    @FindBy(css = "div:nth-child(5) > div > div > div > div")
    public WebElement departDatePicker;

    @FindBy(css = "div:nth-child(5) > div > div > div > div :nth-child(1)")
    public WebElement departDatePickerInput;

    @FindBy(css = "div:nth-child(5) > div > div > div > div :nth-child(4)")
    public WebElement departDayPickerInput;

    @FindBy(css = "div:nth-child(6) > div > div > div > div :nth-child(2)")
    public WebElement returnMonthPickerInput;

    @FindBy(css = "div:nth-of-type(6) > label")
    public WebElement returnLabel;

    @FindBy(css = "div:nth-child(6) > div > div > div > div")
    public WebElement returnDatePicker;

    @FindBy(css = "div:nth-child(6) > div > div > div > div :nth-child(1)")
    public WebElement returnDatePickerInput;

    @FindBy(css = "div:nth-of-type(7) > label")
    public WebElement numberOfPassengersLabel;

    @FindBy(css = "div:nth-child(7) > div > select")
    public WebElement numberOfPassengersDropdown;

    @FindBy(css = "div:nth-of-type(8) > label")
    public WebElement passenger1Label;

    @FindBy(css = "div:nth-child(8) > div > select")
    public WebElement passenger1Dropdown;

    @FindBy(css = "div:nth-child(9) > div > select")
    public WebElement passenger2Dropdown;

    @FindBy(css = "button[type='submit']")
    public WebElement bookButton;

    @FindBy(css = ".ml-3")
    public WebElement confirmationMessage;
















}