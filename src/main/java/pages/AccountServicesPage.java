package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/*
We are only making an assertion on this page.
*/

public class AccountServicesPage {

    private WebDriver driver;
    private By alertText = By.xpath("/html/body/div[1]/div[3]/div[2]/p");

    public AccountServicesPage (WebDriver driver){
        this.driver = driver;
    }
    public String getLoadedTxt(){
        return driver.findElement(alertText).getText();
    }

}
