package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/*
We are only making an assertion on this page.
*/

public class AcctConfirmationPage {

    private WebDriver driver;

    public AcctConfirmationPage (WebDriver driver){
        this.driver = driver;
    }
    public String getConfirmationTxt(){
        return driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/p[1]")).getText();
    }
}
