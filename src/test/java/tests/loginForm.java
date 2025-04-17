package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.Setup;

public class loginForm extends Setup {
    String validUsername="testyy";
    String InvalidUsername="invalid";
    String validPassword="P@ssword1";
    @Test
    public void TC1_successfulLogin() {
        homePage.clickMyAccIcon();
        homePage.getUsernameLogin().sendKeys(validUsername);
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getPasswordLogin()));
        homePage.getPasswordLogin().sendKeys(validPassword);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getSignInBtn()));
        homePage.getSignInBtn().click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='menuUserLink']/span[text()='"+validUsername+"']")));
        Assert.assertEquals(homePage.getUsernameSignIn(validUsername),validUsername);
    }
    @Test
    public void TC2_BlankLoginUsername(){
        homePage.clickMyAccIcon();
        wait.until(ExpectedConditions.visibilityOf(homePage.getUsernameLogin()));
        homePage.getPasswordLogin().sendKeys(validPassword);
        homePage.getSignInBtn().click();
        softAssert.assertTrue(homePage.getErrMsgEmptyUsername());
        softAssert.assertAll();
    }
    @Test
    public void TC3_BlankLoginPassword(){
        homePage.clickMyAccIcon();
        wait.until(ExpectedConditions.visibilityOf(homePage.getUsernameLogin()));
        homePage.getUsernameLogin().sendKeys(validUsername);
        softAssert.assertFalse(homePage.getSignInBtn().isEnabled());
        softAssert.assertAll();
    }
    @Test
    public void TC4_signInWithInvalidCredentials(){
        homePage.clickMyAccIcon();
        homePage.getUsernameLogin().sendKeys(InvalidUsername);
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getPasswordLogin()));
        homePage.getPasswordLogin().sendKeys(validPassword);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getSignInBtn()));
        homePage.getSignInBtn().click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));
        wait.until(ExpectedConditions.textToBePresentInElement(homePage.getErrMsgInvalidCredentials(), "Incorrect user name or password."));
    }
    @Test
    public void TC5_BlockingAccount(){
        homePage.clickMyAccIcon();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));
        homePage.getUsernameLogin().sendKeys("testy");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getPasswordLogin()));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));
        homePage.getPasswordLogin().sendKeys(validPassword+"50");
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getSignInBtn()));
        for(int i=0;i<7;i++){
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));
            wait.until(ExpectedConditions.elementToBeClickable(homePage.getSignInBtn()));
            homePage.getSignInBtn().click();
        }
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));
        Assert.assertEquals(homePage.getErrMsgInvalidCredentials().getText(), "User is temporary blocked from login");

    }
}
