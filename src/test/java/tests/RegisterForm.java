package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import setup.Setup;
import utils.testData;

public class RegisterForm extends Setup {
    @BeforeMethod
    public void setup() {
        homePage.clickMyAccIcon();
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getCreateAccBtn()));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));
        registerPage=homePage.clickCreateAccBtn();
    }
    @Test(dataProvider = "successfulRegistration",dataProviderClass = testData.class)
    public void TC1_successfulRegister(String username,String mail,String pass,String confirmPass,String firstName,String lastName,
    String phoneNum,String country,String city,String Address,String state,String postalCode){
        registerPage.setUsernameField(username);
        registerPage.setEmailField(mail);
        registerPage.setPassField(pass);
        registerPage.setConfirmPassField(confirmPass);
        registerPage.setFirstNameField(firstName);
        registerPage.setLastNameField(lastName);
        registerPage.setPhoneNumField(phoneNum);
        registerPage.setCountry(country);
        registerPage.setCityField(city);
        registerPage.setAddressField(Address);
        registerPage.setStateField(state);
        registerPage.setPostalCodeField(postalCode);
        registerPage.AgreeCheckbox();
        registerPage.clickRegisterBtn();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='menuUserLink']/span[text()='"+username+"']")));
        Assert.assertEquals(homePage.getUsernameSignIn(username),username);
    }
    @Test(dataProvider = "alreadyExistingAcc",dataProviderClass = testData.class)
    public void TC2_RegisterWithExistingUser(String username,String mail,String pass,String confirmPass,String firstName,String lastName,
                                             String phoneNum,String country,String city,String Address,String state,String postalCode){
        registerPage.setUsernameField(username);
        registerPage.setEmailField(mail);
        registerPage.setPassField(pass);
        registerPage.setConfirmPassField(confirmPass);
        registerPage.setFirstNameField(firstName);
        registerPage.setLastNameField(lastName);
        registerPage.setPhoneNumField(phoneNum);
        registerPage.setCountry(country);
        registerPage.setCityField(city);
        registerPage.setAddressField(Address);
        registerPage.setStateField(state);
        registerPage.setPostalCodeField(postalCode);
        registerPage.AgreeCheckbox();
        registerPage.clickRegisterBtn();
        wait.until(ExpectedConditions.textToBePresentInElement(registerPage.getAlreadyExistingAcc(),"User name already exists"));
    }
    @Test
    public void TC3_BlankMandatoryFields(){
        registerPage.setUsernameField("");
        registerPage.setEmailField("");
        registerPage.setPassField("");
        registerPage.setConfirmPassField("");
        registerPage.setFirstNameField("");
        softAssert.assertTrue(registerPage.getEmailFieldMsgReq().isDisplayed());
        softAssert.assertTrue(registerPage.getPassFieldMsgReq().isDisplayed());
        softAssert.assertTrue(registerPage.getConfirmPassFieldMsgReq().isDisplayed());
        Assert.assertFalse(registerPage.getRegisterBtn().isEnabled());
        softAssert.assertAll();
    }

}
