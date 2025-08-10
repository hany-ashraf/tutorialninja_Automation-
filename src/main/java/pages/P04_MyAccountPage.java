package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P04_MyAccountPage {
    public P04_MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//ul/li/a/i[@class=\"fa fa-home\"]")
    WebElement returnHomePageButton;
    //Action Method
    public void clickReturnHomePage(){
        returnHomePageButton.click();
    }
    public WebElement returnLocator(){
        return returnHomePageButton;
    }

}
