package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.stream.Collectors;


public class FindTransactionsPage {

    private WebDriver driver;


    public FindTransactionsPage(WebDriver driver) {
        this.driver = driver;
    }

    //select account id field
    public void selectFromAccountIdField(String option){
        selectFromAccountIdField().selectByVisibleText(option);
    }
    public List<String> getSelectedOptions(){
        List<WebElement> selectedElements = selectFromAccountIdField().getAllSelectedOptions();
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
    }
    private Select selectFromAccountIdField(){
        return new Select(driver.findElement(By.id("accountId")));
    }

    //enter transaction date
    public void enterTransactionDate(String date){
     driver.findElement(By.id("criteria.onDate")).sendKeys(date);
    }

    //enter date range
    public void enterTransactDateRangeFrom(String date){
        driver.findElement(By.id("criteria.fromDate")).sendKeys(date);
    }
    public void enterTransactDateRangeTo(String date){
        driver.findElement(By.id("criteria.toDate")).sendKeys(date);
    }

    //enter transaction amount
    public void enterTransactionAmount(String amount){
        driver.findElement(By.id("criteria.amount")).sendKeys(amount);
    }

    //click find transactions button
    public TransactionResultsPage clickFindTransactionsByDateBtn() {
        driver.findElement(By.cssSelector("#rightPanel > div > div > form > div:nth-child(9) > button")).click();
        return new TransactionResultsPage(driver);
    }
    public TransactionResultsPage clickFindTransactionsByAmountBtn() {
        driver.findElement(By.cssSelector("#rightPanel > div > div > form > div:nth-child(17) > button")).click();
        return new TransactionResultsPage(driver);
    }
    public TransactionResultsPage clickFindTransactionsByRangeBtn() {
        driver.findElement(By.cssSelector("#rightPanel > div > div > form > div:nth-child(13) > button")).click();
        return new TransactionResultsPage(driver);
    }

    //Get error message page
    public ErrorPage clickFindInvTransactionAmountBtn() {
        driver.findElement(By.cssSelector("#rightPanel > div > div > form > div:nth-child(17) > button")).click();
        return new ErrorPage(driver);
    }
}

