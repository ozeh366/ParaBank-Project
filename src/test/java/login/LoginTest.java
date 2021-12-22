package login;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTests {

    @Test
    public void testValidLogin () {
        var customerLoginPage = homePage.getCustomerLoginPage();
        customerLoginPage.enterUserName("tony");
        customerLoginPage.enterPassword("stark");
        var accountOverviewPage = customerLoginPage.getAcctOverviewPage();
        assertTrue(accountOverviewPage.getWelcomeText().contains("Welcome Tony Stark"),
                "Alert text is incorrect");

    }
    @Test
    public void testInvalidLogin (){
        var customerLoginPage = homePage.getCustomerLoginPage();
        customerLoginPage.enterUserName("xx");
        customerLoginPage.enterPassword("x");

        var accountOverviewPage = customerLoginPage.getAcctOverviewPage();
        assertTrue(accountOverviewPage.getLoadedText()
                        .contains("*Balance includes deposits that may be subject to holds"),

                "Alert text is incorrect");
        homePage.clickLogOutBtn();
    }
}
