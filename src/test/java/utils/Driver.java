package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;

    private Driver(){}

    public static WebDriver getDriver(){
        if(driver == null){
            WebDriverManager.chromedriver().setup(); // Set up Chrome driver

            driver = new ChromeDriver(); // Launch a Chrome driver
            driver.manage().window().maximize(); // Maximizes the Chrome window
            driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS); // implicit wait
        }
        return driver;
    }


    public static void quitDriver(){
        if(driver != null){
            driver.manage().deleteAllCookies();
            driver.quit();
            driver = null;
        }
    }

}