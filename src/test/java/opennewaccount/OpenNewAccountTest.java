package opennewaccount;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.AcctConfirmationPage;
import pages.CustomerLoginPage;
import pages.OpenNewAccountPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class OpenNewAccountTest extends BaseTests {

    @Test
    public void testOpenNewSavingsAcct() {
        var customerLoginPage = homePage.getCustomerLoginPage();
        customerLoginPage.enterUserName("admin");
        customerLoginPage.enterPassword("admin");

       var openNewAccountPage = customerLoginPage.getNewAcctPage();
        homePage.clickOpenNewAccountLink();

        //Choose acct type
        String option = "SAVINGS";
        openNewAccountPage.selectAccountByType(option);
        var selectedOptionsType = openNewAccountPage.getSelectedAcctType();
        assertEquals(selectedOptionsType.size(), 1, "Incorrect number of selections");
        assertTrue(selectedOptionsType.contains(option), "Option not selected");

        //choose acct number to make deduction
        String acctId = "15342";
        openNewAccountPage.selectAccountByID(acctId);
        var selectedOptionsID = openNewAccountPage.getSelectedAcctID();
        assertEquals(selectedOptionsID.size(), 1, "Incorrect number of selections");
        assertTrue(selectedOptionsID.contains(acctId), "Option not selected");

        //Make final assertion
        AcctConfirmationPage acctConfirmationPage = openNewAccountPage.clickOpenNewAcctBtn();
        assertTrue(acctConfirmationPage.getConfirmationTxt()
                .contains("Congratulations, your account is now open."), "invalid assertion");
        homePage.clickLogOutBtn();
    }
    @Test
    public void testOpenNewCheckingAcct(){
        CustomerLoginPage customerLoginPage = homePage.getCustomerLoginPage();
        customerLoginPage.enterUserName("a");
        customerLoginPage.enterPassword("a");

        OpenNewAccountPage openNewAccountPage = customerLoginPage.getNewAcctPage();
        homePage.clickOpenNewAccountLink();

        //Choose acct type
        String option = "CHECKING";
        openNewAccountPage.selectAccountByType(option);
        var selectedOptionsType = openNewAccountPage.getSelectedAcctType();
        assertEquals(selectedOptionsType.size(), 1, "Incorrect number of selections");
        assertTrue(selectedOptionsType.contains(option), "Option not selected");

        //choose acct number to make deduction
        String acctId = "15120";
        openNewAccountPage.selectAccountByID(acctId);
        var selectedOptionsID = openNewAccountPage.getSelectedAcctID();
        assertEquals(selectedOptionsID.size(), 1, "Incorrect number of selections");
        assertTrue(selectedOptionsID.contains(acctId), "Option not selected");

        //Make final assertion
        AcctConfirmationPage acctConfirmationPage = openNewAccountPage.clickOpenNewAcctBtn();
        assertTrue(acctConfirmationPage.getConfirmationTxt()
                .contains("Congratulations, your account is now open."), "invalid assertion");
        homePage.clickLogOutBtn();
    }
    @Test
    public void testOpenNewAcctwithInvData(){
        CustomerLoginPage customerLoginPage = homePage.getCustomerLoginPage();
        customerLoginPage.enterUserName("a");
        customerLoginPage.enterPassword("a");

        OpenNewAccountPage openNewAccountPage = customerLoginPage.getNewAcctPage();
        homePage.clickOpenNewAccountLink();

        //Choose acct type
        String option = "SAVINGS";
        openNewAccountPage.selectAccountByType(option);
        var selectedOptionsType = openNewAccountPage.getSelectedAcctType();
        assertEquals(selectedOptionsType.size(), 1, "Incorrect number of selections");
        assertTrue(selectedOptionsType.contains(option), "Option not selected");

        //choose acct number to make deduction
        String acctId = "15120";
        openNewAccountPage.selectAccountByID(acctId);
        var selectedOptionsID = openNewAccountPage.getSelectedAcctID();
        assertEquals(selectedOptionsID.size(), 1, "Incorrect number of selections");
        assertTrue(selectedOptionsID.contains(acctId), "Option not selected");

        //Make final assertion
        AcctConfirmationPage acctConfirmationPage = openNewAccountPage.clickOpenNewAcctBtn();
        assertTrue(acctConfirmationPage.getConfirmationTxt()
                .contains("Congratulations, your account is now open."), "invalid assertion");
        homePage.clickLogOutBtn();
    }
}