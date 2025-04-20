package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ShoppingCart;
import setup.Setup;

import java.util.List;

public class ShoppingCartTest extends Setup {
    @BeforeMethod
    public void setup(){
        shoppingCart=new ShoppingCart(webdriver);
    }
    @Test
    public void TC1_AddToCartSuccessfully(){
        wait.until(ExpectedConditions.presenceOfElementLocated(shoppingCart.getSpeakersSection()));
        webdriver.findElement(shoppingCart.getSpeakersSection()).click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(shoppingCart.getSpeakersProducts()));
        String chosenProduct=shoppingCart.getAllSpeakerProduct().get(0).getText();
        shoppingCart.getAllSpeakerProduct().get(0).click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(shoppingCart.getAddToCartBtn()));
        webdriver.findElement(shoppingCart.getAddToCartBtn()).click();
        webdriver.findElement(shoppingCart.getCartIcon()).click();
        List<String> products=shoppingCart.getProductsNamesInCart();
        Assert.assertEquals(chosenProduct.toLowerCase(),products.get(0).toLowerCase());
    }
//    @Test
//    public void TC2_CheckEmptyCart(){
//        wait.until(ExpectedConditions.presenceOfElementLocated(shoppingCart.getCartIcon()));
//        webdriver.findElement(shoppingCart.getCartIcon()).click();
//        wait.until(ExpectedConditions.presenceOfElementLocated(shoppingCart.getCartEmptyIndication()));
//        Assert.assertTrue(webdriver.findElement(shoppingCart.getCartEmptyIndication()).isDisplayed());
//    }
//
//    @Test(dependsOnMethods = "TC1_AddToCartSuccessfully")
//    public void TC3_CheckNumberOnCart(){
//        Assert.assertEquals(shoppingCart.getNumberOnCart(),1);
//    }
//    @Test(dependsOnMethods = "TC1_AddToCartSuccessfully")
//    public void TC4_removeFromCart(){
//        shoppingCart.getRemoveBtn().get(0).click();
//        wait.until(ExpectedConditions.presenceOfElementLocated(shoppingCart.getCartEmptyIndication()));
//        Assert.assertTrue(webdriver.findElement(shoppingCart.getCartEmptyIndication()).isDisplayed());
//    }
//    @Test(dependsOnMethods = "TC1_AddToCartSuccessfully")
//    public void TC5_CheckEditFromCart(){
//        shoppingCart.getEditBtn().get(0).click();
//        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(shoppingCart.getAddToCartBtn()));
//        shoppingCart.increaseQuantity();
//        shoppingCart.increaseQuantity();
//        shoppingCart.increaseQuantity();
//        webdriver.findElement(shoppingCart.getAddToCartBtn()).click();
//        webdriver.findElement(shoppingCart.getCartIcon()).click();
//        Assert.assertEquals(shoppingCart.getProductsQuantitiesInCart().get(0),4);
//    }
//    @Test
//    public void TC6_checkMaxQuantity(){
//        wait.until(ExpectedConditions.presenceOfElementLocated(shoppingCart.getSpeakersSection()));
//        webdriver.findElement(shoppingCart.getSpeakersSection()).click();
//        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(shoppingCart.getSpeakersProducts()));
//        shoppingCart.getAllSpeakerProduct().get(0).click();
//        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(shoppingCart.getAddToCartBtn()));
//        for(int i=0;i<10;i++)
//        shoppingCart.increaseQuantity();
//        webdriver.findElement(shoppingCart.getAddToCartBtn()).click();
//        webdriver.findElement(shoppingCart.getCartIcon()).click();
//        Assert.assertEquals(shoppingCart.getNumberOnCart(),10);
//    }
}
