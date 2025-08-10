package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v136.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P03_LoginPage {
    //Create Constructor
    WebDriver driver;
    public P03_LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    //Locate elements
    @FindBy(xpath = "//div/input[@id=\"input-email\"]")
    WebElement emailAddress;
    @FindBy(xpath = "//div/input[@id=\"input-password\"]")
    WebElement password;
    @FindBy(xpath = "//form/input[@value=\"Login\"]")
    WebElement loginButton;
    @FindBy(xpath = "(//div/a[text()=\"Forgotten Password\"])[1]\n")
    WebElement forgetPassword;
    @FindBy(xpath = "//div/input[@id=\"input-email\"]")
    WebElement emailAddReset;
    @FindBy(xpath = "//div/input[@value=\"Continue\"]")
    WebElement continueButton;
    @FindBy(xpath = "//div[text()=\"An email with a confirmation link has been sent your email address.\"]")
    WebElement resetMessage;
    @FindBy(xpath = "(//div[@id=\"content\"]/h2)[1]")
    WebElement successMessage;

    //Action Methods
    public void loginData(String email, String password){
        this.emailAddress.sendKeys(email);
        this.password.sendKeys(password);
    }
    public void clickLoginButton(){
        loginButton.click();
    }
    public void clickForgetPassword(){
        forgetPassword.click();
    }
    public void enterEmailToReset(String email){
        emailAddReset.sendKeys(email);
    }
    public void clickContinueButton(){
        continueButton.click();
    }
    public String resetMessageSuc(){
        return resetMessage.getText();
    }
    public String returnResetURL() {
        return this.driver.getCurrentUrl();
    }
    public String returnSuccessMessage(){
        return successMessage.getText();
    }
    public String returnURL() {
        return this.driver.getCurrentUrl();
    }

}
