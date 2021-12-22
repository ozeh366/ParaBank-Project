package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public RegistrationPage clickRegisterButton(){
        clickLink("Register");
        return new RegistrationPage(driver);
    }

    public CustomerLoginPage getCustomerLoginPage() {
        return new CustomerLoginPage(driver);
    }

    public AccountOverviewPage clickAccountOverviewLink(){
       clickLink("Accounts Overview");
        return new AccountOverviewPage (driver);
    }

    public FindTransactionsPage clickFindTransactionsLink(){
        clickLink("Find Transactions");
        return new FindTransactionsPage (driver);
    }

    public void clickOpenNewAccountLink(){
        clickLink("Open New Account");
    }

    public void clickLogOutBtn(){
        clickLink("Log Out");
    }

    public void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }
}
