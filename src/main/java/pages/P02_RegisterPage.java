package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P02_RegisterPage {
    // Constructor
    WebDriver driver;
    public P02_RegisterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // Locate elements
    @FindBy(xpath = "(//div/input)[2]")
    WebElement firstName;

    @FindBy(xpath = "(//div/input)[3]")
    WebElement lastName;

    @FindBy(xpath = "(//div/input)[4]")
    WebElement email;

    @FindBy(xpath = "(//div/input)[5]")
    WebElement telephone;

    @FindBy(xpath = "(//div/input)[6]")
    WebElement password;

    @FindBy(xpath = "(//div/input)[7]")
    WebElement passwordConfirm;

    @FindBy(xpath = "(//div/label/input)[3]")
    WebElement subscribeSelect;

    @FindBy(xpath = "(//div/input)[8]")
    WebElement policyChecked;

    @FindBy(xpath = "(//div/input)[9]")
    WebElement continueButton;

    @FindBy(xpath = "(//div/h1/following-sibling::p)[1]")
    WebElement successMessage;

    @FindBy(xpath = "(//a)[7]")
    WebElement logoutButton;

    //Action Methods
    public void registerNewAccount(
            String firstName,
            String lastName,
            String email,
            String telephone,
            String password
    ){
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.email.sendKeys(email);
        this.telephone.sendKeys(telephone);
        this.password.sendKeys(password);
        this.passwordConfirm.sendKeys(password);

    }
    public void selectUnsubscribe() {
        this.subscribeSelect.click();
    }

    public void agreeToPolicy() {
        this.policyChecked.click();
    }

    public void clickContinue() {
        this.continueButton.click();
    }
    public String returnSuccessMessage(){
       return successMessage.getText();
    }
    public String returnURL() {
        return this.driver.getCurrentUrl();
    }
    public void clickLogout(){
        logoutButton.click();
    }

}
