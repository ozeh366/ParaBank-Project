package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.WindowManager;
import java.util.concurrent.TimeUnit;

public class BaseTests{

    private WebDriver driver;
    protected HomePage homePage;


    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        //maximize the window
        driver.manage().window().maximize();
        // wait for the browser to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //go to homepage
        goHome();
    }

    @BeforeMethod
    public void goHome() {
        driver.get("https://parabank.parasoft.com/index.htm");
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
