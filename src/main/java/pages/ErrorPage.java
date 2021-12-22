package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/*
   We are only making an assertion on this page.
*/

public class ErrorPage {

    private WebDriver driver;

    public ErrorPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getErrorText(){
        return driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/p")).getText();
    }
}
