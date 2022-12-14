package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected WebDriver driver;
    protected Logger logger;

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser, ITestContext itContext) {
        String testName = itContext.getCurrentXmlTest().getName();
        logger = LogManager.getLogger(testName);

        BrowserDriverFactory factory = new BrowserDriverFactory(browser, logger);
        driver = factory.getDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        logger.info("Close driver");
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
