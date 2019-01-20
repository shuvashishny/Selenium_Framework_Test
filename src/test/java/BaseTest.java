import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.Page;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public Page page;

    @BeforeMethod
    @Parameters({"browser"})
    public void setUp(String bValue ) {
        System.out.println("Browser is "+bValue);

        String browser = bValue;
        switch (browser.toUpperCase()) {
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                //Create a Chrome driver. All test classes use this.
                driver = new ChromeDriver();
                break;

            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }
        WebDriverManager.chromedriver().setup();

        //Create a Chrome driver. All test classes use this.
        driver = new ChromeDriver();

        //Create a wait. All test classes use this.
        wait = new WebDriverWait(driver,30);

        //Maximize Window
        driver.manage().window().maximize();

        //Instantiate the Page Class
        page = new Page(driver,wait);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
