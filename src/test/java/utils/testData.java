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
    @DataProvider(name="MismatchPassword")
    public Object[][] getMismatchPasswordData(){
        return new Object[][]{
                {"validUsername3","validmail3@x.com","P@ssword1","P@ssword2","firstTest","lastTest","0123456789",
                "Egypt","cityTest","Address","stateTest","123456"},
        };
    }
    @DataProvider(name="RegisterInvalidMailFormat")
    public Object[][] getInvalidMailFormat(){
        return new Object[][]{
                {"validUsername4","user@!domain.com","P@ssword1","P@ssword1","firstTest","lastTest","0123456789",
                        "Egypt","cityTest","Address","stateTest","123456"},{"validUsername4","user@#domain.com","P@ssword1","P@ssword1","firstTest","lastTest","0123456789",
                        "Egypt","cityTest","Address","stateTest","123456"},{"validUsername4","user@%domain.com","P@ssword1","P@ssword1","firstTest","lastTest","0123456789",
                        "Egypt","cityTest","Address","stateTest","123456"},{"validUsername4","user@domain$.com","P@ssword1","P@ssword1","firstTest","lastTest","0123456789",
                        "Egypt","cityTest","Address","stateTest","123456"},{"validUsername4","user@domain^com","P@ssword1","P@ssword1","firstTest","lastTest","0123456789",
                        "Egypt","cityTest","Address","stateTest","123456"},{"validUsername4","user@domain&com","P@ssword1","P@ssword1","firstTest","lastTest","0123456789",
                        "Egypt","cityTest","Address","stateTest","123456"},{"valid","user@domain&com","P@ssword1","P@ssword1","firstTest","lastTest","0123456789",
                        "Egypt","cityTest","Address","stateTest","123456"},
        };

    }
    @DataProvider(name="RegisterInvalidPassFormat")
    public Object[][] getInvalidPassFormat(){
        return new Object[][]{
                {"validUsername4","user@domain.com","123","123","firstTest","lastTest","0123456789",
                        "Egypt","cityTest","Address","stateTest","123456"},{"validUsername4","user@domain.com","abcdefghijklm","abcdefghijklm","firstTest","lastTest","0123456789",
                        "Egypt","cityTest","Address","stateTest","123456"},{"validUsername4","user@domain.com","12345678","12345678","firstTest","lastTest","0123456789",
                        "Egypt","cityTest","Address","stateTest","123456"},{"validUsername4","user@domain.com","ABCDEFGH","ABCDEFGH","firstTest","lastTest","0123456789",
                        "Egypt","cityTest","Address","stateTest","123456"},{"validUsername4","user@domain.com","abcdefgh","abcdefgh","firstTest","lastTest","0123456789",
                        "Egypt","cityTest","Address","stateTest","123456"},{"validUsername4","user@domain.com","ABCD1234","ABCD1234","firstTest","lastTest","0123456789",
                        "Egypt","cityTest","Address","stateTest","123456"},{"valid","user@domain.com","P@ssword1","abc123","abc123","lastTest","0123456789",
                        "Egypt","cityTest","Address","stateTest","123456"},
        };}
    @DataProvider(name="RegisterInvalidUsername")
    public Object[][] getInvalidUsername(){
        return new Object[][]{
                {"1","user@domain.com","123","123","firstTest","lastTest","0123456789",
                        "Egypt","cityTest","Address","stateTest","123456"},{"usr4","user@domain.com","abcdefghijklm","abcdefghijklm","firstTest","lastTest","0123456789",
                        "Egypt","cityTest","Address","stateTest","123456"},{"thisisaverylongusername","user@domain.com","12345678","12345678","firstTest","lastTest","0123456789",
                        "Egypt","cityTest","Address","stateTest","123456"},{"123","user@domain.com","ABCDEFGH","ABCDEFGH","firstTest","lastTest","0123456789",
                        "Egypt","cityTest","Address","stateTest","123456"},{"u","user@domain.com","abcdefgh","abcdefgh","firstTest","lastTest","0123456789",
                        "Egypt","cityTest","Address","stateTest","123456"},{"/*-+0988","user@domain.com","ABCD1234","ABCD1234","firstTest","lastTest","0123456789",
                        "Egypt","cityTest","Address","stateTest","123456"}};
    }
    @DataProvider(name="RegisterInvalidFirstAndLastName")
    public Object[][] getInvalidFirstAndLastName(){
        return new Object[][]{
                {"validUsername4", "validmail2@x.com", "P@ssword1", "P@ssword1", "a", "a", "0123456789",
                        "Egypt", "cityTest", "Address", "stateTest", "123456"},{"validUsername4", "validmail2@x.com", "P@ssword1", "P@ssword1", "this_is_way_too_long_for_a_username_123456",
                "this_is_way_too_long_for_a_username_123456", "0123456789",
                        "Egypt", "cityTest", "Address", "stateTest", "123456"},
        };    }
    @DataProvider(name="RegisterInvalidPhoneNumber")
    public Object[][] getInvalidPhoneNumber(){
        return new Object[][]{
                {"validUsername4", "validmail2@x.com", "P@ssword1", "P@ssword1", "aaaaaa", "aaaaaa", "010207989170102079891701020798917",
                        "Egypt", "cityTest", "Address", "stateTest", "123456"}
        };    }
    @DataProvider(name="RegisterInvalidCity")
    public Object[][] getInvalidCity(){
        return new Object[][]{
                {"validUsername4", "validmail2@x.com", "P@ssword1", "P@ssword1", "aaaaa", "aaaaaa", "0123456789",
                        "Egypt", "cityTestcityTestcityTestcityTest", "Address", "stateTest", "123456"}
        };    }
    @DataProvider(name="RegisterInvalidState")
    public Object[][] getInvalidState(){
        return new Object[][]{
                {"validUsername4", "validmail2@x.com", "P@ssword1", "P@ssword1", "aaaaa", "aaaaaa", "0123456789",
                        "Egypt", "cityTest", "Address", "stateTeststateTest", "123456"}
        };    }
}
