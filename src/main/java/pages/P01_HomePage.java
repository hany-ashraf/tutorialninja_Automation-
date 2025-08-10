package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class P01_HomePage {
    WebDriver driver;
    String subCatDisplay;

    //Make Constructor
    public P01_HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Locate elements
    @FindBy(xpath = "//li/a[@title=\"My Account\"]")
    WebElement myAccount;
    @FindBy(xpath = "//ul/li/a[text()=\"Register\"]")
    WebElement registerButton;
    @FindBy(xpath = "//ul/li/a[text()=\"Login\"]")
    WebElement loginButton;
    //E2E locators of Test Cases
    @FindBy(xpath = "//div/input[@name=\"search\"]")
    WebElement searchField;
    @FindBy(xpath = "//button/i[@class=\"fa fa-search\"]")
    WebElement searchButton;
    @FindBy(xpath = "//div/button/strong/following-sibling::span[text()=\"Currency\"]")
    WebElement currencyDropDown;
    @FindBy(xpath = "(//ul/li)[1]")
    WebElement euroCurrency;
    @FindBy(xpath = "//div/select[@name=\"category_id\"]")
    WebElement itemCat;
    @FindBy(xpath = "(//div/h1)[2]")
    WebElement itemMessage;
    @FindBy(xpath = "//div/button/strong")
    WebElement currencySign;
    @FindBy(xpath = "//div/h2")
    WebElement selectedSubCat;

    //Action Methods
    public void clickMyAccount(){
        myAccount.click();
    }
    public void clickRegister(){
        registerButton.click();
    }
    public boolean isRegisterButtonVisible(){
            return registerButton.isDisplayed();
    }
    public void clickLoginButton(){
        loginButton.click();
    }
    public void writeItem(String item){
        searchField.sendKeys(item);
    }
    public void clickSearchButton(){
        searchButton.click();
    }
    public void selectEuroCurrency(){
        currencyDropDown.click();
        euroCurrency.click();

    }
    public void selectCatForItem(int index){
        Select select = new Select(itemCat);
        select.selectByIndex(index);  // index starts from 0
    }
    //Hovering over Main category
    public void hoverMainCat(String cat) {
        // Build the dynamic XPath
        String xpath = "//ul/li/a[text()=\"" + cat + "\"]";

        // Find the element
        WebElement componentsCat = this.driver.findElement(By.xpath(xpath));

        // Instantiate Actions class
        Actions actions = new Actions(this.driver);

        // Hover over the element
        actions.moveToElement(componentsCat).perform();
    }
    public void clickSubCat(String subCat){
        // Build the dynamic XPath
        String xpath = "//ul/li/a[text()=\""+subCat+"\"]";
        // Find the element
        WebElement componentsSubCat = driver.findElement(By.xpath(xpath));
        subCatDisplay = componentsSubCat.getText();
        componentsSubCat.click();

    }

    public String getsubCatDisplay() {
        return subCatDisplay;
    }

    public String returnItem(){
        return itemMessage.getText();
    }
    public String retrunItemURL(){
        return this.driver.getCurrentUrl();
    }
    public String returnSelectedCurrency(){
        return currencySign.getText();
    }
    public String returnSelectedSubCat(){
        return selectedSubCat.getText();
    }
    public String returnSubCatURL() {
        return this.driver.getCurrentUrl();
    }


}
