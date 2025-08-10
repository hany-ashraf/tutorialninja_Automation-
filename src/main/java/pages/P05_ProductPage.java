package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v136.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class P05_ProductPage {

    WebDriver driver;
    public P05_ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div/button/i/following::span[text()=\"Add to Cart\"]")
    WebElement addToCart1;
    @FindBy(xpath = "(//div/button/i/following-sibling::span[text()=\"Add to Cart\"])[2]")
    WebElement addToCart2;
    @FindBy(xpath = "(//div/button/following-sibling::button[@data-toggle=\"tooltip\"])[4]")
    WebElement wishListButton;
    @FindBy(xpath = "(//div/button/following-sibling::button[@data-toggle=\"tooltip\"])[5]")
    WebElement compareList;
    @FindBy(xpath = "//div/label/input[@type=\"checkbox\"][@value=\"10\"]")
    WebElement checkBox;
    @FindBy(xpath = "//div/input[@id=\"input-option208\"]")
    WebElement textField;
    @FindBy(xpath = "//div/select[@id=\"input-option217\"]")
    WebElement selectList;
    @FindBy(xpath = "//div/textarea[@id=\"input-option209\"]")
    WebElement textArea;
    @FindBy(xpath = "//div/button[@id=\"button-upload222\"]")
    WebElement uploadFile;
    @FindBy(xpath = "//div/button[@id=\"button-cart\"][text()='Add to Cart']")
    WebElement finalAddToCart;
    @FindBy(xpath = "//div/button/span[@id=\"cart-total\"]")
    WebElement myCart;
    @FindBy(xpath = "(//tr/td)[5]/button[@title=\"Remove\"]")
    WebElement removeItem;
    @FindBy(xpath = "//a/strong[text()=\"Checkout\"]")
    WebElement checkOut;
    @FindBy(xpath = "//div/i/following-sibling::a")
    WebElement itemCompareListMessage;
    @FindBy(xpath = "//div/i/following-sibling::a/following-sibling::a")
    WebElement itemComparison;
    @FindBy(xpath = "(//div/button/i/following-sibling::span)[2]")
    WebElement itemFullOrder;


    //Action methods
    public void clickAddToCart(){
        addToCart2.click();
    }
    public void clickToWishList(){
        wishListButton.click();
    }
    public void clickCompareList(){
        compareList.click();
    }
    public void clickCheckBox(){
        checkBox.click();
    }
    public void enterTextField(){
        textField.clear();
        textField.sendKeys("Hany");
    }
    public void clickSelectionList(int index){
        Select select = new Select(selectList);
        select.selectByIndex(index);  // index starts from 0
    }
    public void enterTextArea(){
        textArea.clear();
        textArea.sendKeys("Selenium WebDriver (Java)");
    }
    public void clickUploadFile() throws InterruptedException {

//        uploadFile.sendKeys("C:\\CoverLeter.pdf");
        uploadFile.click();
        uploadFile.sendKeys("C:\\CoverLeter.pdf");
        Thread.sleep(5000);
    }
    public void clickAddtoMyCart() throws InterruptedException {
        itemFullOrder.click();
        Thread.sleep(2000);
        finalAddToCart.click();
    }
    public String returnActionSuccessMessage(){
        return " Success: You have added "+itemCompareListMessage.getText()+"  to your "+itemComparison.getText();
    }
    public void clickMyCart() throws InterruptedException {
        myCart.click();
        Thread.sleep(1000);

    }
    public void clickMyCartCheckOut() throws InterruptedException {
        checkOut.click();
    }
    public void clickRemoveItem(){
        removeItem.click();
    }



}
