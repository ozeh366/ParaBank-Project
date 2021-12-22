package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountOverviewPage {

    /*
    We are only making assertions on this page.
    */

    private WebDriver driver;
    private By loadedTextLink = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/table/tfoot/tr/td");
    private By welcomeText = By.xpath("//*[@id=\"leftPanel\"]/p");


    public AccountOverviewPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getLoadedText(){
        return driver.findElement(loadedTextLink).getText();
    }
    public String getWelcomeText(){
        return driver.findElement(welcomeText).getText();
    }
}
