package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.P01_HomePage;
import pages.P02_RegisterPage;
import util.Utility;

import static drivers.DriverHolder.getDriver;
import static util.Utility.*;

public class TC02_RegisterPage extends TestBase{
    P01_HomePage homePage;
    P02_RegisterPage registerPage;
    SoftAssert softAssert;

    String firstName = generateRandomName();
    String lastName = generateRandomName();
    String email = generateRandomGmail();
    String password = generateRandomPassword();
    String phone = "0124578962";
    String expectedMessageForRegisterSuc = "Congratulations! Your new account has been successfully created!";
    String registerSuccessfullyURL = "https://tutorialsninja.com/demo/index.php?route=account/success";

    @Test(priority = 1, description = "Register with valid data of new account")
    public void registerNewAccountWithValidData_P() throws InterruptedException {
        homePage = new P01_HomePage(getDriver());
        registerPage = new P02_RegisterPage(getDriver());
        homePage.clickMyAccount();
        homePage.clickRegister();
        registerPage.registerNewAccount(firstName,lastName,email,phone,password);
        registerPage.selectUnsubscribe();
        registerPage.agreeToPolicy();
        registerPage.clickContinue();
        Thread.sleep(3000);
        System.out.println(email + " " + password);
        softAssert = new SoftAssert();
        softAssert.assertEquals(registerPage.returnSuccessMessage(), expectedMessageForRegisterSuc);
        Assert.assertEquals(registerPage.returnURL(), registerSuccessfullyURL, "Regsiteration Fail");

        softAssert.assertAll();  // Reports both Country and Phone mismatches

    }

}
