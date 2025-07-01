package testCases;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginCredential;
import testBase.BaseClass;

public class TC001_Login extends BaseClass {

    public WebDriver driver;
    public WebDriverWait wait;
    LoginCredential loginPage;

    // Initialize logger
    private static final Logger logger = LogManager.getLogger(TC001_Login.class);

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://qa-reps.corenroll.com/");
        loginPage = new LoginCredential(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        logger.info("Browser launched and navigated to login page.");
    }

    @Test
    public void testLogin() {
        logger.info("*** TC001_LOGIN STARTED ***");

        try {
            loginPage.setUserEmail("testrepcts@gmail.com");
            loginPage.clickLogin();
            logger.info("Email entered and login clicked.");

            wait.until(ExpectedConditions.visibilityOf(loginPage.txtUserpassword));
            loginPage.setUserPassword("Cts@2019");
            logger.info("Password entered.");

            loginPage.clickNext();
            logger.info("Next clicked. Waiting for OTP page.");

            // Enter dummy OTP
            loginPage.setOtpDigit1("1");
            loginPage.setOtpDigit2("1");
            loginPage.setOtpDigit3("1");
            loginPage.setOtpDigit4("1");
            loginPage.setOtpDigit5("1");
            loginPage.setOtpDigit6("1");

            logger.info("OTP entered.");
        } catch (Exception e) {
            logger.error("Login test failed due to exception: ", e);
            Assert.fail("Login test failed.");
        }

        logger.info("*** TC001_LOGIN COMPLETED ***");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Browser closed.");
        }
    }
}
