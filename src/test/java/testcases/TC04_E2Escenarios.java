package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;

import static drivers.DriverHolder.getDriver;
import static util.Utility.*;


public class TC04_E2Escenarios extends TestBase{
    P01_HomePage homePage;
    P03_LoginPage loginPage;
    P04_MyAccountPage myAccount;
    P05_ProductPage productPage;
    P06_CheckOutPage checkOutPage;
    SoftAssert softAssert;

    String email = "mbz2m7fwqqdr65a@gmail.com";
    String password = "gU}Pb<F#v!9+0XhKM&$3L2+,UQ]:";
    String itemSearch = "Canon EOS 5D";
    String itemSearchFullOrder = "HP LP3065";
    String cat = getRandomCategory();
    String subCat = getRandomSupCategory(cat);
    String addItemComponents = "Components";
    String addSubComponents = "Monitors (2)";
    String firstName = generateRandomName();
    String lastName = generateRandomName();
    String userAddress = "N/A";
    String userCity = "Cairo";
    String postCode = "1245";


    //Assertion Data
    String expectedItemSearchMessage = "Search - Canon EOS 5D";
    String itemURL = "https://tutorialsninja.com/demo/index.php?route=product/search&search=Canon%20EOS%205D";
    String expectedCurrencySign = "€";
    String expectedProductAddMessage = " Success: You have added Samsung SyncMaster 941BW  to your shopping cart";
    String expectedProductWishMessage = " Success: You have added Samsung SyncMaster 941BW  to your wish list";
    String expectedProductComMessage = " Success: You have added Samsung SyncMaster 941BW  to your product comparison";
    String expectedSuccessfulOrder = "Your order has been placed!";
    String successfulOrderURL = "https://tutorialsninja.com/demo/index.php?route=checkout/success";




    @Test(priority = 1, description = "Logged User could search for any product")
    public void validateSearchItem_P() throws InterruptedException {
        homePage = new P01_HomePage(getDriver());
        loginPage = new P03_LoginPage(getDriver());
        myAccount = new P04_MyAccountPage(getDriver());
        homePage.clickMyAccount();
        homePage.clickLoginButton();
        loginPage.loginData(email, password);
        loginPage.clickLoginButton();
        waitToLoadElement(myAccount.returnLocator());
        myAccount.clickReturnHomePage();
        homePage.writeItem(itemSearch);
        homePage.clickSearchButton();
        Thread.sleep(2000);
        Assert.assertEquals(homePage.retrunItemURL(), itemURL, "search Fail");
        softAssert = new SoftAssert();
        softAssert.assertEquals(homePage.returnItem(), expectedItemSearchMessage);
        softAssert.assertAll();  // Reports both Country and Phone mismatches
    }
    @Test(priority = 2, description = "Logged User could switch between currencies US-Euro")
    public void ValidationChangeCurrency_P() throws InterruptedException {
        homePage = new P01_HomePage(getDriver());
        myAccount = new P04_MyAccountPage(getDriver());
        loginPage = new P03_LoginPage(getDriver());
        homePage.clickMyAccount();
        homePage.clickLoginButton();
        loginPage.loginData(email, password);
        loginPage.clickLoginButton();
        Thread.sleep(2000);
        myAccount.clickReturnHomePage();
        homePage.selectEuroCurrency();
        Thread.sleep(2000);
        softAssert = new SoftAssert();
        softAssert.assertEquals(homePage.returnSelectedCurrency(), expectedCurrencySign);
        softAssert.assertAll();  // Reports both Country and Phone mismatches
    }

    @Test(priority = 3, description = "Logged user could select different Categories")
    public void ValidationSelectionRandomCat_P() throws InterruptedException {
        homePage = new P01_HomePage(getDriver());
        myAccount = new P04_MyAccountPage(getDriver());
        loginPage = new P03_LoginPage(getDriver());
        homePage.clickMyAccount();
        homePage.clickLoginButton();
        loginPage.loginData(email, password);
        loginPage.clickLoginButton();
        Thread.sleep(3000);
        myAccount.clickReturnHomePage();
        Thread.sleep(3000);
        homePage.hoverMainCat(cat);
        Thread.sleep(3000);
        homePage.clickSubCat(subCat);
        String subCatClean = removeParenthesesAndNumbers(homePage.getsubCatDisplay());

        softAssert = new SoftAssert();
        softAssert.assertEquals(homePage.returnSelectedSubCat(), subCatClean);
        softAssert.assertAll();  // Reports both Country and Phone mismatches

    }

    @Test(priority = 4, description = "Logged user could add different products to Shopping cart")
    public void ValidationAddItemInCart_P() throws InterruptedException {
        homePage = new P01_HomePage(getDriver());
        myAccount = new P04_MyAccountPage(getDriver());
        loginPage = new P03_LoginPage(getDriver());
        productPage = new P05_ProductPage(getDriver());
        homePage.clickMyAccount();
        homePage.clickLoginButton();
        loginPage.loginData(email, password);
        loginPage.clickLoginButton();
        Thread.sleep(2000);
        myAccount.clickReturnHomePage();
        homePage.hoverMainCat(addItemComponents);
        homePage.clickSubCat(addSubComponents);
        productPage.clickAddToCart();
        Thread.sleep(2000);
        productPage.clickMyCart();
        Thread.sleep(2000);
        productPage.clickRemoveItem();
        softAssert = new SoftAssert();
        Thread.sleep(2000);
        softAssert.assertEquals(productPage.returnActionSuccessMessage(), expectedProductAddMessage);
        softAssert.assertAll();  // Reports both Country and Phone mismatches
    }

    @Test(priority = 4, description = "Logged user could add different products to Wishlist")
    public void ValidationAddItemToWishList_P() throws InterruptedException {
        homePage = new P01_HomePage(getDriver());
        myAccount = new P04_MyAccountPage(getDriver());
        loginPage = new P03_LoginPage(getDriver());
        productPage = new P05_ProductPage(getDriver());
        homePage.clickMyAccount();
        homePage.clickLoginButton();
        loginPage.loginData(email, password);
        loginPage.clickLoginButton();
        Thread.sleep(2000);
        myAccount.clickReturnHomePage();
        homePage.hoverMainCat(addItemComponents);
        homePage.clickSubCat(addSubComponents);
        productPage.clickToWishList();
        softAssert = new SoftAssert();
        Thread.sleep(2000);
        softAssert.assertEquals(productPage.returnActionSuccessMessage(), expectedProductWishMessage);
        softAssert.assertAll();  // Reports both Country and Phone mismatches
    }

    @Test(priority = 4, description = "Logged user could add different products to compare list")
    public void ValidationCompareList_P() throws InterruptedException {
        homePage = new P01_HomePage(getDriver());
        myAccount = new P04_MyAccountPage(getDriver());
        loginPage = new P03_LoginPage(getDriver());
        productPage = new P05_ProductPage(getDriver());
        homePage.clickMyAccount();
        homePage.clickLoginButton();
        loginPage.loginData(email, password);
        loginPage.clickLoginButton();
        Thread.sleep(2000);
        myAccount.clickReturnHomePage();
        homePage.hoverMainCat(addItemComponents);
        homePage.clickSubCat(addSubComponents);
        productPage.clickCompareList();
        softAssert = new SoftAssert();
        Thread.sleep(2000);
        softAssert.assertEquals(productPage.returnActionSuccessMessage(), expectedProductComMessage);
        softAssert.assertAll();  // Reports both Country and Phone mismatches

    }
    @Test(priority = 5, description = "Logged User could Create successful Order")
    public void validateCreateSuccessfulOrder_P() throws InterruptedException {
        homePage = new P01_HomePage(getDriver());
        loginPage = new P03_LoginPage(getDriver());
        myAccount = new P04_MyAccountPage(getDriver());
        productPage = new P05_ProductPage(getDriver());
        checkOutPage = new P06_CheckOutPage(getDriver());

        homePage.clickMyAccount();
        homePage.clickLoginButton();
        loginPage.loginData(email, password);
        loginPage.clickLoginButton();
        Thread.sleep(2000);
        myAccount.clickReturnHomePage();
        homePage.writeItem(itemSearchFullOrder);
        homePage.clickSearchButton();
        Thread.sleep(2000);
        productPage.clickAddtoMyCart();
        productPage.clickMyCart();
        productPage.clickMyCartCheckOut();
        Thread.sleep(2000);
        checkOutPage.dataOfCreateOrder(firstName, lastName, userAddress, userCity, postCode);
        checkOutPage.clickBillingContinueButton();
        Thread.sleep(2000);
        checkOutPage.clickDeliveryDetailContinueButton();
        Thread.sleep(2000);
        checkOutPage.clickDeliveryMethodContinueButton();
        Thread.sleep(2000);
        checkOutPage.clickPaymentContinueButton();
        Thread.sleep(2000);
        checkOutPage.clickConfirmOrder();
        Thread.sleep(2000);
        Assert.assertEquals(checkOutPage.returnCurrentURL(), successfulOrderURL, "search Fail");
        softAssert = new SoftAssert();
        softAssert.assertEquals(checkOutPage.returnSuccessOrderMessage(), expectedSuccessfulOrder);
        softAssert.assertAll();  // Reports both Country and Phone mismatches
    }


}

