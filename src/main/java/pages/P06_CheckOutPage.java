package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class P06_CheckOutPage {
    WebDriver driver;
    public P06_CheckOutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }
    @FindBy(xpath = "(//div/a)[6][text()=\"Checkout\"]")
    WebElement checkOut;
    @FindBy(xpath = "//div/input[@id=\"input-payment-firstname\"]")
    WebElement billingDetailsfirstName;
    @FindBy(xpath = "//div/input[@id=\"input-payment-lastname\"]")
    WebElement billingDetailsLastName;
    @FindBy(xpath = "//div/input[@id=\"input-payment-address-1\"]")
    WebElement billingDetailsAddress;
    @FindBy(xpath = "//div/input[@id=\"input-payment-city\"]")
    WebElement billingDetailsCity;
    @FindBy(xpath = "//div/input[@id=\"input-payment-postcode\"]")
    WebElement billingDetailsPostCode;
    @FindBy(xpath = "//div/select[@id=\"input-payment-country\"]")
    WebElement billingDetailsCountry;
    @FindBy(xpath = "//div/select[@id=\"input-payment-zone\"]")
    WebElement billingDetailsRegion;
    @FindBy(xpath = "//div/input[@id=\"button-payment-address\"]")
    WebElement billingDetailsContinue;

    @FindBy(xpath = "//div/div/input[@id=\"button-shipping-address\"]")
    WebElement deliveryDetailsContinue;
    @FindBy(xpath = "//div/div/input[@id=\"button-shipping-method\"]")
    WebElement deliveryMethodContinue;

    @FindBy(xpath = "(//div/div/a/following-sibling::input)[2]")
    WebElement paymentMethodContinue;
    @FindBy(xpath = "(//div/div/a/following-sibling::input)[1]")
    WebElement checkBoxPolicy;

    @FindBy(xpath = "//div/input[@id=\"button-confirm\"]")
    WebElement confirmOrder;

    @FindBy(xpath = "//div/div[@class=\"col-sm-12\"]/h1")
    WebElement successOrderMessage;

    //Action methods
    public void clickCheckoutButton(){
        checkOut.click();
    }

    public void dataOfCreateOrder(String firstName, String lastName, String address, String city, String postCode) throws InterruptedException {
        billingDetailsfirstName.sendKeys(firstName);
        billingDetailsLastName.sendKeys(lastName);
        billingDetailsAddress.sendKeys(address);
        billingDetailsCity.sendKeys(city);
        billingDetailsPostCode.sendKeys(postCode);
        selectCountry();
        Thread.sleep(2000);
        selectRegion();
    }
    public void clickBillingContinueButton(){
        billingDetailsContinue.click();
    }
    public void clickDeliveryDetailContinueButton(){
        deliveryDetailsContinue.click();
    }
    public void clickDeliveryMethodContinueButton(){
        deliveryMethodContinue.click();
    }
    public void clickPaymentContinueButton(){
        checkBoxPolicy.click();
        paymentMethodContinue.click();
    }
    public void clickConfirmOrder(){
        confirmOrder.click();
    }
    public void selectCountry(){
        // Create a Select object
        Select selectCountry = new Select(billingDetailsCountry);
        // Select by value attribute
        selectCountry.selectByValue("63");
    }
    public void selectRegion(){
        // Create a Select object
        Select selectRegion = new Select(billingDetailsRegion);
        // Select by value attribute
        selectRegion.selectByValue("1004");
    }
    public String returnSuccessOrderMessage(){
        return successOrderMessage.getText();
    }
    public String returnCurrentURL(){
        return this.driver.getCurrentUrl();
    }
}
