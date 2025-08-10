package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

import static drivers.DriverFactory.getNewInstance;
import static drivers.DriverHolder.getDriver;
import static drivers.DriverHolder.setDriver;

public class TestBase {


    //@Parameters("browser")
    @BeforeTest
    public void setupDriver(){

        setDriver(getNewInstance(""));

        getDriver().get("https://tutorialsninja.com/demo/");
    }

    //TODO: Back again to the home page
    public void clickBack(){
        getDriver().navigate().back();
    }

    //TODO: Refresh the page
    public void clickRefreshTwice(){
        getDriver().navigate().refresh();
        getDriver().navigate().refresh();
    }

    //TODO: Implicit Waiting
    public void waitToLoadElement(WebElement locator){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement deleteButton = wait.until(
                ExpectedConditions.visibilityOf(locator)
        );
    }

    @AfterTest
    public void tearDown(){
        //getDriver().quit();
    }

}
