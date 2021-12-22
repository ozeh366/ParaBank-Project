package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/*
From this page we can log into Account Services
 */

public class CustomerLoginPage {

    private WebDriver driver;

    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.cssSelector("#loginPanel > form > div:nth-child(5) > input");

    public CustomerLoginPage(WebDriver driver){
        this.driver = driver;
    }
    public void enterUserName(String username){
        driver.findElement(usernameField).sendKeys(username);
    }
    public void enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public AccountOverviewPage getAcctOverviewPage(){
        driver.findElement(loginButton).click();
        return new AccountOverviewPage(driver);
    }
    public FindTransactionsPage getFindTransactionPage(){
        driver.findElement(loginButton).click();
        return new FindTransactionsPage(driver);
    }
    public OpenNewAccountPage getNewAcctPage(){
        driver.findElement(loginButton).click();
        return new OpenNewAccountPage(driver);
    }
}
