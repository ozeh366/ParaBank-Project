package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.stream.Collectors;

public class OpenNewAccountPage {

    private WebDriver driver;

    public OpenNewAccountPage(WebDriver driver){
        this.driver = driver;
    }

    //Select Acct type
    public void selectAccountByType(String option){
        selectAccountByType().selectByVisibleText(option);
    }
    private Select selectAccountByType(){
        return new Select(driver.findElement(By.cssSelector("#type")));
    }
    public List<String> getSelectedAcctType(){
        List<WebElement> selectedElements = selectAccountByType().getAllSelectedOptions();
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    // Select Acct ID
    public void selectAccountByID(String option){
        selectAccountByID().selectByVisibleText(option);
    }
    private Select selectAccountByID(){
        return new Select(driver.findElement(By.cssSelector("#fromAccountId")));
    }
    public List<String> getSelectedAcctID(){
        List<WebElement> selectedElements = selectAccountByID().getAllSelectedOptions();
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    //Get Acct Confirmation Page
    public AcctConfirmationPage clickOpenNewAcctBtn(){
        driver.findElement(By.cssSelector("#rightPanel > div > div > form > div > input")).click();
        return new AcctConfirmationPage(driver);
    }
}
