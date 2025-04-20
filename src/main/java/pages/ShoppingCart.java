package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private WebDriver webDriver;
    private By shoppingCartLabel=By.xpath("//h3[contains(text(), 'SHOPPING CART')]");
    private By productsNameInCart=By.xpath("//tr/td/label[@class='roboto-regular productName ng-binding']");
    private By productQuantityInCart=By.xpath("//td[@class='smollCell quantityMobile']");
    private By removeBtns=By.xpath("//a[@class='remove red ng-scope']");
    private By editBtns=By.xpath("//a[@translate='EDIT']");
    private By productPrice=By.xpath("//td/p[@class='price roboto-regular ng-binding']");
//    private By speakersSection=By.id("speakersImg");
    private By speakersSection=By.xpath("//span[@aria-label='SpeakersCategoryTxt']");
    private By speakersProducts=By.xpath("//a[@class='productName ng-binding']");
    private By addToCartBtn=By.name("save_to_cart");
    private By cartIcon=By.id("menuCart");
    private By cartEmptyIndication=By.xpath("//a[@translate='CONTINUE_SHOPPING']");
    private By numberOnCart=By.cssSelector("span.cart.ng-binding");
    private By increaseQuantity=By.cssSelector(".plus");
    private By decreaseQuantity=By.cssSelector(".minus");

    public ShoppingCart(WebDriver driver){
        webDriver=driver;
    }
    public WebElement getShoppingCartLabel(){
        return webDriver.findElement(shoppingCartLabel);
    }
    public By getAddToCartBtn(){
        return (addToCartBtn);
    }
    public By getCartIcon(){
        return (cartIcon);
    }
    public int getNumberOnCart(){
        List<WebElement> numberOnCartW=webDriver.findElements(numberOnCart);
         return Integer.parseInt(numberOnCartW.get(1).getText());
    }
    public By getCartEmptyIndication(){
        return (cartEmptyIndication);
    }
    public By getSpeakersSection(){
       return (speakersSection);
    }
    public List<String> getProductsNamesInCart() {
        WebDriverWait wait=new WebDriverWait(webDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productsNameInCart));
        List<WebElement> names = webDriver.findElements(productsNameInCart);
        List<String> productsNames = new ArrayList<>();

        for (WebElement element : names) {
            productsNames.add(element.getText());
        }
        return productsNames;
    }
    public List<Integer> getProductsQuantitiesInCart() {
        List<WebElement> elements = webDriver.findElements(productQuantityInCart);
        List<Integer> productsQuantities = new ArrayList<>();

        for (WebElement element : elements) {
            productsQuantities.add(Integer.parseInt(element.getText().trim()));
        }
        return productsQuantities;
    }
    public List<WebElement> getRemoveBtn(){
        return webDriver.findElements(removeBtns);
    }
    public List<WebElement> getEditBtn(){
        return webDriver.findElements(editBtns);
    }
    public By getSpeakersProducts(){
        return (speakersProducts);
    }
    public List<WebElement> getAllSpeakerProduct(){
        return webDriver.findElements(speakersProducts);
    }
    public void increaseQuantity(){
        webDriver.findElement(increaseQuantity).click();
    }
    public void decreaseQuantity(){
        webDriver.findElement(decreaseQuantity).click();
    }


}
