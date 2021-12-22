package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
    We are only making assertions on this page.
*/

public class TransactionResultsPage {

    private WebDriver driver;

    public TransactionResultsPage(WebDriver driver) {
        this.driver =driver;
    }
    public String getDateConfirmationText() {
        return driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/table/tbody/tr[1]/td[1]")).getText();
    }
    public String getAmountConfirmationText() {
        return driver.findElement(By.xpath("//*[@id=\"transactionTable\"]/tbody/tr/td[3]/span")).getText();
    }
}
