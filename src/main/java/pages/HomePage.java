package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver=driver;
    }
    private By myAccIcon=By.id("menuUserLink");
    private By LoginUsername=By.xpath("//input[@name='username']");
    private By LoginPassword=By.xpath("//input[@name='password']");
    private By signInBtn=By.id("sign_in_btn");
    private By errMsgEmptyUsername=By.xpath("//label[text()='Username field is required']");
    private By errMsgInvalidCredentials=By.id("signInResultMessage");
    private By createAccBtn=By.xpath("//a[@translate='CREATE_NEW_ACCOUNT']");
//    private By logoutBtn=By.xpath("");

    public void clickMyAccIcon(){
        driver.findElement(myAccIcon).click();
    }
    public WebElement getUsernameLogin(){
        return driver.findElement(LoginUsername);
    }
    public WebElement getCreateAccBtn(){
        return driver.findElement(createAccBtn);
    }
    public Boolean getErrMsgEmptyUsername(){
       return driver.findElement(errMsgEmptyUsername).isDisplayed();
    }
    public WebElement getPasswordLogin(){
       return driver.findElement(LoginPassword);
    }
    public WebElement getSignInBtn(){
       return driver.findElement(signInBtn);
    }
    public String getUsernameSignIn(String username){
       return driver.findElement(By.xpath("//a[@id='menuUserLink']/span[text()='"+username+"']")).getText();
    }
    public WebElement getErrMsgInvalidCredentials(){
       return driver.findElement(errMsgInvalidCredentials);
    }
    public RegisterPage clickCreateAccBtn() {
        driver.findElement(createAccBtn).click(); // Assuming createAccBtn is defined
        return new RegisterPage(driver);
    }


}

