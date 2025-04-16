package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage{
    private WebDriver driver;
    WebDriverWait wait;
    public RegisterPage(WebDriver driver){
        wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        this.driver=driver;
    }
    private By usernameField=By.xpath("//input[@name='usernameRegisterPage']");
    private By emailField=By.xpath("//input[@name='emailRegisterPage']");
    private By passField=By.xpath("//input[@name='passwordRegisterPage']");
    private By confirmPassField=By.xpath("//input[@name='confirm_passwordRegisterPage']");
    private By firstNameField=By.xpath("//input[@name='first_nameRegisterPage']");
    private By lastNameField=By.xpath("//input[@name='last_nameRegisterPage']");
    private By phoneNumField=By.xpath("//input[@name='phone_numberRegisterPage']");
    private By cityField=By.xpath("//input[@name='cityRegisterPage']");
    private By stateField=By.xpath("//input[@name='state_/_province_/_regionRegisterPage']");
    private By postalCodeField=By.xpath("//input[@name='postal_codeRegisterPage']");
    private By addressField=By.name("addressRegisterPage");
    private By registerBtn=By.id("register_btn");
    private By RegisterLabel=By.xpath("//h3[@translate='CREATE_ACCOUNT']");
    private By alreadyExistingAcc=By.xpath("//label[@data-ng-show=\"!registerSuccess\"]");
    private By emailFieldMsgReq=By.xpath("//label[@data-ng-click=\"labelClicked()\" and contains(text(),'Email field is required')]");
    private By passFieldMsgReq=By.xpath("//label[@data-ng-click=\"labelClicked()\" and contains(text(),'Password field is required')]");
    private By confirmPassFieldMsgReq=By.xpath("//label[@data-ng-click=\"labelClicked()\" and contains(text(),'Confirm password field is required')]");


    public void setUsernameField(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        wait.until(ExpectedConditions.elementToBeClickable(usernameField));
        driver.findElement(usernameField).sendKeys(username);
    }
    public WebElement getRegisterLabel(){
        return driver.findElement(RegisterLabel);
    }
    public WebElement getEmailFieldMsgReq(){
        return driver.findElement(emailFieldMsgReq);
    }
    public WebElement getPassFieldMsgReq(){
        return driver.findElement(passFieldMsgReq);
    }
    public WebElement getConfirmPassFieldMsgReq(){
        return driver.findElement(confirmPassField);
    }
    public WebElement getAlreadyExistingAcc(){
        return driver.findElement(alreadyExistingAcc);
    }
    public void setAddressField(String address) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addressField));
        wait.until(ExpectedConditions.elementToBeClickable(addressField));
        driver.findElement(addressField).sendKeys(address);
    }

    public void setEmailField(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        wait.until(ExpectedConditions.elementToBeClickable(emailField));
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPassField(String pass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passField));
        wait.until(ExpectedConditions.elementToBeClickable(passField));
        driver.findElement(passField).sendKeys(pass);
    }

    public void setConfirmPassField(String confirmPass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPassField));
        wait.until(ExpectedConditions.elementToBeClickable(confirmPassField));
        driver.findElement(confirmPassField).sendKeys(confirmPass);
    }
    public void clickRegisterBtn(){
        driver.findElement(registerBtn).click();
    }
    public WebElement getRegisterBtn(){
       return driver.findElement(registerBtn);
    }

    public void setFirstNameField(String firstName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
        wait.until(ExpectedConditions.elementToBeClickable(firstNameField));
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void setLastNameField(String lastName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField));
        wait.until(ExpectedConditions.elementToBeClickable(lastNameField));
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void setPhoneNumField(String phoneNum) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumField));
        wait.until(ExpectedConditions.elementToBeClickable(phoneNumField));
        driver.findElement(phoneNumField).sendKeys(phoneNum);
    }

    public void setCountry(String country) {
        Select countryDrop_down= new Select(driver.findElement(By.name("countryListboxRegisterPage")));
        countryDrop_down.selectByVisibleText(country);
    }
    public void setCityField(String city) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cityField));
        wait.until(ExpectedConditions.elementToBeClickable(cityField));
        driver.findElement(cityField).sendKeys(city);
    }

    public void setStateField(String state) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(stateField));
        wait.until(ExpectedConditions.elementToBeClickable(stateField));
        driver.findElement(stateField).sendKeys(state);
    }

    public void setPostalCodeField(String postalCode) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(postalCodeField));
        wait.until(ExpectedConditions.elementToBeClickable(postalCodeField));
        driver.findElement(postalCodeField).sendKeys(postalCode);
    }
    public void AgreeCheckbox(){
        driver.findElement(By.xpath("//input[@name='i_agree']")).click();
    }
}
