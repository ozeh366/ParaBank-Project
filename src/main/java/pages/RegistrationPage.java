package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
On this page, we will fill the new user registration form
*/
public class RegistrationPage {

    private WebDriver driver;

    private By firstnameField = By.id("customer.firstName");
    private By lastnameField = By.id("customer.lastName");
    private By addressField = By.id("customer.address.street");
    private By cityField = By.id("customer.address.city");
    private By stateField = By.id("customer.address.state");
    private By zipcodeField = By.id("customer.address.zipCode");
    private By phoneField = By.id("customer.phoneNumber");
    private By ssnField = By.id("customer.ssn");
    private By usernameField = By.id("customer.username");
    private By passwordField = By.id("customer.password");
    private By confirmPasswordField = By.id("repeatedPassword");
    private By usernameError = By.xpath("/html/body/div[1]/div[3]/div[2]/form/table/tbody/tr[10]/td[3]/span");
    private By passwordError = By.xpath("/html/body/div[1]/div[3]/div[2]/form/table/tbody/tr[12]/td[3]/span");
    private By registerBtn = By.cssSelector("#customerForm > table > tbody > tr:nth-child(13) > td:nth-child(2) > input");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }
    public void enterFName (String firstname){
        driver.findElement(firstnameField).sendKeys(firstname);
    }
    public void enterLName (String lastname){
        driver.findElement(lastnameField).sendKeys(lastname);
    }
    public void enterAddress (String address){
        driver.findElement(addressField).sendKeys(address);
    }
    public void enterCity (String city){
        driver.findElement(cityField).sendKeys(city);
    }
    public void enterState (String state){
        driver.findElement(stateField).sendKeys(state);
    }
    public void enterZipcode (String zipcode){
        driver.findElement(zipcodeField).sendKeys(zipcode);
    }
    public void enterPhone (String phone){
        driver.findElement(phoneField).sendKeys(phone);
    }
    public void enterSSN (String ssn){
        driver.findElement(ssnField).sendKeys(ssn);
    }
    public void enterUsername (String username){
        driver.findElement(usernameField).sendKeys(username);
    }
    public void enterPassword (String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    public void enterConfirmPassword (String password){
        driver.findElement(confirmPasswordField).sendKeys(password);
    }

    //Get Account Services Page
    public AccountServicesPage clickRegisterBtn(){
        driver.findElement(registerBtn).click();
        return new AccountServicesPage (driver);
    }
    //Get error messages
    public String getUsernameErrorMsg() {
        return driver.findElement(usernameError).getText();
    }
    public String getPasswordErrorMsg() {
        return driver.findElement(passwordError).getText();
    }
}
