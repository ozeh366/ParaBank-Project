package findtransaction;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FindTransactionTest extends BaseTests {

    @Test
    public void testFindTransactionsByDate() {
        //Login to account overview page
        CustomerLoginPage customerLoginPage = homePage.getCustomerLoginPage();
        customerLoginPage.enterUserName("tony");
        customerLoginPage.enterPassword("stark");

        //click find transactions link
        FindTransactionsPage findTransactionsPage = customerLoginPage.getFindTransactionPage();
        homePage.clickFindTransactionsLink();

        // enter account details selection
        String option = "30327";
        findTransactionsPage.selectFromAccountIdField(option);
        var selectedOptions = findTransactionsPage.getSelectedOptions();
        assertEquals(selectedOptions.size(), 1, "Incorrect number of selections");
        assertTrue(selectedOptions.contains(option), "Option not selected");

        //enter transc. date
        findTransactionsPage.enterTransactionDate("12-15-2021");
        findTransactionsPage.clickFindTransactionsByDateBtn();

        //Transaction Result Page assertion
        TransactionResultsPage transactionResultsPage = findTransactionsPage.clickFindTransactionsByDateBtn();
        assertTrue(transactionResultsPage.getDateConfirmationText()
                .contains("12-15-2021"), "invalid assertion");
        homePage.clickLogOutBtn();

    }

    @Test
    public void testFindTranscWithInvDate() {
        //Login to account overview page
        CustomerLoginPage customerLoginPage = homePage.getCustomerLoginPage();
        customerLoginPage.enterUserName("tony");
        customerLoginPage.enterPassword("stark");

        //click find transactions link
        FindTransactionsPage findTransactionsPage = customerLoginPage.getFindTransactionPage();
        homePage.clickFindTransactionsLink();

        // enter account details selection
        String option = "30327";
        findTransactionsPage.selectFromAccountIdField(option);
        var selectedOptions = findTransactionsPage.getSelectedOptions();
        assertEquals(selectedOptions.size(), 1, "Incorrect number of selections");
        assertTrue(selectedOptions.contains(option), "Option not selected");

        //enter transc. date
        findTransactionsPage.enterTransactionDate("13-06-2021");
        findTransactionsPage.clickFindTransactionsByDateBtn();
        homePage.clickLogOutBtn();
    }

    @Test
    public void testFindTranscByAmount() {
        //Login to account overview page
        CustomerLoginPage customerLoginPage = homePage.getCustomerLoginPage();
        customerLoginPage.enterUserName("tony");
        customerLoginPage.enterPassword("tony");

        //click find transactions link
        FindTransactionsPage findTransactionsPage = customerLoginPage.getFindTransactionPage();
        homePage.clickFindTransactionsLink();

        // enter account details selection
        String option = "30327";
        findTransactionsPage.selectFromAccountIdField(option);
        var selectedOptions = findTransactionsPage.getSelectedOptions();
        assertEquals(selectedOptions.size(), 1, "Incorrect number of selections");
        assertTrue(selectedOptions.contains(option), "Option not selected");

        //enter transc. amount
        findTransactionsPage.enterTransactionAmount("100.00");
        findTransactionsPage.clickFindTransactionsByAmountBtn();

        //Transaction Result Page assertion
        TransactionResultsPage transactionResultsPage = findTransactionsPage.clickFindTransactionsByAmountBtn();
        assertTrue(transactionResultsPage.getAmountConfirmationText()
                .contains("100.00"), "invalid assertion");
        homePage.clickLogOutBtn();
    }

    @Test
    public void testFindTranscByInvAmount() {
        //Login to account overview page
        CustomerLoginPage customerLoginPage = homePage.getCustomerLoginPage();
        customerLoginPage.enterUserName("admin");
        customerLoginPage.enterPassword("admin");

        //click find transactions link
        FindTransactionsPage findTransactionsPage = customerLoginPage.getFindTransactionPage();
        homePage.clickFindTransactionsLink();

        // enter account details selection
        String option = "30327";
        findTransactionsPage.selectFromAccountIdField(option);
        var selectedOptions = findTransactionsPage.getSelectedOptions();
        assertEquals(selectedOptions.size(), 1, "Incorrect number of selections");
        assertTrue(selectedOptions.contains(option), "Option not selected");

        //enter transc. amount
        findTransactionsPage.enterTransactionAmount("1,000");
        findTransactionsPage.clickFindTransactionsByAmountBtn();

        //Transaction Result Page assertion
        ErrorPage errorPage = findTransactionsPage.clickFindInvTransactionAmountBtn();
        assertTrue(errorPage.getErrorText()
                .contains("An internal error has occurred and has been logged."), "invalid assertion");
        homePage.clickLogOutBtn();
    }

    @Test
    public void testFindTransactionsByDateRange() {
        //Login to account overview page
        var customerLoginPage = homePage.getCustomerLoginPage();
        customerLoginPage.enterUserName("tony");
        customerLoginPage.enterPassword("stark");

        //click find transactions link
        FindTransactionsPage findTransactionsPage = customerLoginPage.getFindTransactionPage();
        homePage.clickFindTransactionsLink();

        // enter account details selection
        String option = "30327";
        findTransactionsPage.selectFromAccountIdField(option);
        var selectedOptions = findTransactionsPage.getSelectedOptions();
        assertEquals(selectedOptions.size(), 1, "Incorrect number of selections");
        assertTrue(selectedOptions.contains(option), "Option not selected");

        //enter transc. date
        findTransactionsPage.enterTransactDateRangeFrom("11-08-2021");
        findTransactionsPage.enterTransactDateRangeTo("12-15-2021");
        findTransactionsPage.clickFindTransactionsByDateBtn();

        //Transaction Result Page assertion
        TransactionResultsPage transactionResultsPage = findTransactionsPage.clickFindTransactionsByRangeBtn();
        assertTrue(transactionResultsPage.getDateConfirmationText()
                .contains("12-15-2021"), "invalid assertion");
        homePage.clickLogOutBtn();
    }

    @Test
    public void testFindTransactionsByInvDateRange() {
        //Login to account overview page
        var customerLoginPage = homePage.getCustomerLoginPage();
        customerLoginPage.enterUserName("tony");
        customerLoginPage.enterPassword("a");

        //click find transactions link
        var findTransactionsPage = homePage.clickFindTransactionsLink();

        // enter account details selection
        String option = "18672";
        findTransactionsPage.selectFromAccountIdField(option);
        var selectedOptions = findTransactionsPage.getSelectedOptions();
        assertEquals(selectedOptions.size(), 1, "Incorrect number of selections");
        assertTrue(selectedOptions.contains(option), "Option not selected");

        //enter transc. date
        findTransactionsPage.enterTransactDateRangeFrom("19-08-3024");
        findTransactionsPage.enterTransactDateRangeTo("12-09-2000");
        findTransactionsPage.clickFindTransactionsByRangeBtn();
        homePage.clickLogOutBtn();
    }
}