package utils;

import org.testng.annotations.DataProvider;

public class testData {
    @DataProvider(name="successfulRegistration")
    public Object[][] getValidRegistrationData(){
        return new Object[][]{
                {"validUsername4","validmail2@x.com","P@ssword1","P@ssword1","firstTest","lastTest","0123456789",
                "Egypt","cityTest","Address","stateTest","123456"},
        };
    }
    @DataProvider(name="alreadyExistingAcc")
    public Object[][] getExistingCredentialsRegistrationData(){
        return new Object[][]{
                {"validUsername3","validmail3@x.com","P@ssword1","P@ssword1","firstTest","lastTest","0123456789",
                "Egypt","cityTest","Address","stateTest","123456"},
        };
    }
}
