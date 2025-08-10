package testcases;

import org.testng.annotations.Test;
import pages.P01_HomePage;

import static drivers.DriverHolder.getDriver;

public class TC01_HomePage extends TestBase{
    P01_HomePage homePage;
    @Test(priority = 0, description = "Click on register button")
    public void validateRegisterButton_P(){
        homePage = new P01_HomePage(getDriver());
        homePage.clickMyAccount();
        homePage.clickRegister();

    }
}
