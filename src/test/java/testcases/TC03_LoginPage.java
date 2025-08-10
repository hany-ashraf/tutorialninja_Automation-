package testcases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.P01_HomePage;
import pages.P03_LoginPage;
import static util.Utility.*;

import static drivers.DriverHolder.getDriver;

public class TC03_LoginPage extends TestBase{
    private static final Logger log = LoggerFactory.getLogger(TC03_LoginPage.class);
    P01_HomePage homePage;
    P03_LoginPage loginPage;
    SoftAssert softAssert;

    String email = getLoginMail();
    String password = getLoginPassword();
    String loginSuccessfullyURL = "https://tutorialsninja.com/demo/index.php?route=account/account";
    String expectedMessageForLoginSuc = "My Account";
    String expectedMessageForResetPass = "An email with a confirmation link has been sent your email address.";
    String resetSuccessfullyPasswordURL = "https://tutorialsninja.com/demo/index.php?route=account/login";


    @Test(priority = 1, description = "Login with valid data")
    public void loginWithValidData_P() throws InterruptedException {
        homePage = new P01_HomePage(getDriver());
        homePage.clickMyAccount();
        homePage.clickLoginButton();
        loginPage = new P03_LoginPage(getDriver());
        loginPage.loginData(email, password);
        loginPage.clickLoginButton();
        Thread.sleep(2000);
        Assert.assertEquals(loginPage.returnURL(), loginSuccessfullyURL, "Login Fail");
        softAssert = new SoftAssert();
        softAssert.assertEquals(loginPage.returnSuccessMessage(), expectedMessageForLoginSuc);
        softAssert.assertAll();  // Reports both Country and Phone mismatches
    }
    @Test(priority = 2, description = "Reset Password")
    public void validateForgetPassword_N() throws InterruptedException {
        homePage = new P01_HomePage(getDriver());
        homePage.clickMyAccount();
        homePage.clickLoginButton();
        loginPage = new P03_LoginPage(getDriver());
        loginPage.clickForgetPassword();
        loginPage.enterEmailToReset(email);
        loginPage.clickContinueButton();
        Thread.sleep(2000);

        Assert.assertEquals(loginPage.returnResetURL(), resetSuccessfullyPasswordURL, "Reset Password URL does not match expected URL");
        softAssert = new SoftAssert();
        softAssert.assertEquals(loginPage.resetMessageSuc(), expectedMessageForResetPass);
        softAssert.assertAll();  // Reports both Country and Phone mismatches
    }
}
