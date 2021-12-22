package register;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import static org.testng.Assert.assertTrue;

public class RegistrationTest extends BaseTests {

    @Test
    public void testSuccessfulLogin(){
        var registrationPage = homePage.clickRegisterButton();
        registrationPage.enterFName("Tony");
        registrationPage.enterLName("Stark");
        registrationPage.enterAddress("6000 Rock ST");
        registrationPage.enterCity("San Jose");
        registrationPage.enterState("California");
        registrationPage.enterZipcode("12345");
        registrationPage.enterPhone("757779770");
        registrationPage.enterSSN("123456789");
        registrationPage.enterUsername("tony");
        registrationPage.enterPassword("stark");
        registrationPage.enterConfirmPassword("stark");
        //click Register btn
        var accountServicesPage = registrationPage.clickRegisterBtn();

        //make assertion
        assertTrue(accountServicesPage.getLoadedTxt()
                        .contains("Your account was created successfully. You are now logged in."),
                "Alert text is incorrect");

        var accountOverviewPage = homePage.clickAccountOverviewLink();
        assertTrue(accountOverviewPage.getWelcomeText().contains("Welcome Tony Stark"),
                "Welcome text is incorrect");
        homePage.clickLogOutBtn();
    }

    @Test
    public void testUnsuccessfulLogin(){
        var registrationPage = homePage.clickRegisterButton();
        registrationPage.enterFName("Tony");
        registrationPage.enterLName("Stark");
        registrationPage.enterAddress("6000 Rock ST");
        registrationPage.enterCity("San Jose");
        registrationPage.enterState("California");
        registrationPage.enterZipcode("12345");
        registrationPage.enterPhone("757779770");
        registrationPage.enterSSN("123456789");
        registrationPage.enterUsername("tony");
        registrationPage.enterPassword("stark");
        registrationPage.enterConfirmPassword("stark");
        //click Register btn
        registrationPage.clickRegisterBtn();
        //make assertion
        assertTrue(registrationPage.getUsernameErrorMsg().contains("This username already exists."),
                "Alert text is incorrect");
        goHome();
    }

    @Test
    public void testPasswordIntegrity (){
        var registrationPage = homePage.clickRegisterButton();
        registrationPage.enterFName("Tony");
        registrationPage.enterLName("Stark");
        registrationPage.enterAddress("6000 Rock ST");
        registrationPage.enterCity("San Jose");
        registrationPage.enterState("California");
        registrationPage.enterZipcode("12345");
        registrationPage.enterPhone("757779770");
        registrationPage.enterSSN("123456789");
        registrationPage.enterUsername("tonyx");
        registrationPage.enterPassword("Wahala");
        registrationPage.enterConfirmPassword("Wahalaa");
        //click Register btn
        registrationPage.clickRegisterBtn();
        //make assertion
        assertTrue(registrationPage.getPasswordErrorMsg().contains("Passwords did not match."),
                "Alert text is incorrect");
        goHome();
    }

    @Test
    public void testInvalidRegistrationData () {
        RegistrationPage registrationPage = homePage.clickRegisterButton();
        registrationPage.enterFName("x");
        registrationPage.enterLName("x");
        registrationPage.enterAddress("x");
        registrationPage.enterCity("x");
        registrationPage.enterState("x");
        registrationPage.enterZipcode("x");
        registrationPage.enterPhone("x");
        registrationPage.enterSSN("x");
        registrationPage.enterUsername("xx");
        registrationPage.enterPassword("x");
        registrationPage.enterConfirmPassword("x");
        //click Register btn
        var accountServicesPage = registrationPage.clickRegisterBtn();
        //make assertion
        assertTrue(accountServicesPage.getLoadedTxt().contains("Your account was created successfully. You are now logged in."),
                "Alert text is incorrect");
        homePage.clickLogOutBtn();

    }
}