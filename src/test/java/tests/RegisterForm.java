package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.RegisterPage;
import setup.Setup;
import utils.testData;

import java.lang.reflect.Method;

public class RegisterForm extends Setup {
    @BeforeMethod
    public void setup() {
        webdriver.get("https://advantageonlineshopping.com/#/register");
        webdriver.navigate().refresh();
        registerPage = new RegisterPage(webdriver);
    }

    @Test(dataProvider = "successfulRegistration", dataProviderClass = testData.class)
    public void TC1_successfulRegister(String username, String mail, String pass, String confirmPass, String firstName, String lastName,
                                       String phoneNum, String country, String city, String Address, String state, String postalCode) {
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='menuUserLink']/span[text()='" + username + "']")));
        Assert.assertEquals(homePage.getUsernameSignIn(username), username);
    }

    @Test(dataProvider = "alreadyExistingAcc", dataProviderClass = testData.class)
    public void TC2_RegisterWithExistingUser(String username, String mail, String pass, String confirmPass, String firstName, String lastName,
                                             String phoneNum, String country, String city, String Address, String state, String postalCode) {
        register(username, mail, pass, confirmPass, firstName, lastName,
                phoneNum, country, city, Address, state, postalCode);
        registerPage.clickRegisterBtn();
        wait.until(ExpectedConditions.textToBePresentInElement(registerPage.getAlreadyExistingAcc(), "User name already exists"));
    }

    @Test
    public void TC3_BlankMandatoryFields() {
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

    @Test(dataProvider = "RegisterInvalidMailFormat", dataProviderClass = testData.class)
    //Your email address isn't formatted correctly
    public void TC4_RegisterWithInvalidMailFormat(String username, String mail, String pass, String confirmPass, String firstName, String lastName,
                                                  String phoneNum, String country, String city, String Address, String state, String postalCode) {
        register(username, mail, pass, confirmPass, firstName, lastName,
                phoneNum, country, city, Address, state, postalCode);
        registerPage.clickRegisterBtn();
        softAssert.assertFalse(registerPage.getRegisterBtn().isEnabled());
        softAssert.assertAll();
    }

    @Test(dataProvider = "RegisterInvalidUsername", dataProviderClass = testData.class)
    public void TC5_RegisterWithInvalidUsername(String username, String mail, String pass, String confirmPass, String firstName, String lastName,
                                                String phoneNum, String country, String city, String Address, String state, String postalCode) {
        register(username, mail, pass, confirmPass, firstName, lastName,
                phoneNum, country, city, Address, state, postalCode);//        wait.until(ExpectedConditions.visibilityOf(registerPage.getInvalidUsername()));
        Assert.assertFalse(registerPage.getRegisterBtn().isEnabled());
        softAssert.assertAll();
    }

    @Test(dataProvider = "RegisterInvalidPassFormat", dataProviderClass = testData.class)
    public void TC6_RegisterWithInvalidPassword(String username, String mail, String pass, String confirmPass, String firstName, String lastName,
                                                String phoneNum, String country, String city, String Address, String state, String postalCode) {
        register(username, mail, pass, confirmPass, firstName, lastName,
                phoneNum, country, city, Address, state, postalCode);
        softAssert.assertTrue(registerPage.getPassMismatchMsg().isDisplayed());
        Assert.assertFalse(registerPage.getRegisterBtn().isEnabled());
        softAssert.assertAll();
    }

    @Test(dataProvider = "MismatchPassword", dataProviderClass = testData.class)
    public void TC7_RegisterWithPasswordMismatch(String username, String mail, String pass, String confirmPass, String firstName, String lastName,
                                                 String phoneNum, String country, String city, String Address, String state, String postalCode) {

        register(username, mail, pass, confirmPass, firstName, lastName,
                phoneNum, country, city, Address, state, postalCode);
        softAssert.assertTrue(registerPage.getPassMismatchMsg().isDisplayed());
        Assert.assertFalse(registerPage.getRegisterBtn().isEnabled());
        softAssert.assertAll();
    }

    @Test(dataProvider = "RegisterInvalidFirstAndLastName", dataProviderClass = testData.class)
    public void TC8_RegisterWithInvalidFirstNameAndLastName(String username, String mail, String pass, String confirmPass, String firstName, String lastName,
                                                            String phoneNum, String country, String city, String Address, String state, String postalCode) {
        register(username, mail, pass, confirmPass, firstName, lastName,
                phoneNum, country, city, Address, state, postalCode);
        softAssert.assertTrue(registerPage.getInvalidLast_FirstName().isDisplayed());
        softAssert.assertAll();
    }

    @Test(dataProvider = "RegisterInvalidPhoneNumber", dataProviderClass = testData.class)
    public void TC9_RegisterInvalidPhoneNumber(String username, String mail, String pass, String confirmPass, String firstName, String lastName,
                                                            String phoneNum, String country, String city, String Address, String state, String postalCode) {
        register(username, mail, pass, confirmPass, firstName, lastName,
                phoneNum, country, city, Address, state, postalCode);
        Assert.assertTrue(registerPage.getInvalidPhoneNumber().isDisplayed());
    }
    @Test(dataProvider = "RegisterInvalidCity", dataProviderClass = testData.class)
    public void TC10_RegisterInvalidCity(String username, String mail, String pass, String confirmPass, String firstName, String lastName,
                                                            String phoneNum, String country, String city, String Address, String state, String postalCode) {
        register(username, mail, pass, confirmPass, firstName, lastName,
                phoneNum, country, city, Address, state, postalCode);
        Assert.assertTrue(registerPage.getInvalidCity().isDisplayed());
    }
    @Test(dataProvider = "RegisterInvalidState", dataProviderClass = testData.class)
    public void TC11_RegisterInvalidState(String username, String mail, String pass, String confirmPass, String firstName, String lastName,
                                                            String phoneNum, String country, String city, String Address, String state, String postalCode) {
        register(username, mail, pass, confirmPass, firstName, lastName,
                phoneNum, country, city, Address, state, postalCode);
        Assert.assertTrue(registerPage.getInvalidState().isDisplayed());
    }

    public void register(String username, String mail, String pass, String confirmPass, String firstName, String lastName,
                         String phoneNum, String country, String city, String Address, String state, String postalCode) {
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


    }
}
