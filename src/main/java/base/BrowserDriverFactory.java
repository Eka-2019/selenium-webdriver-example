package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserDriverFactory {
    private WebDriver driver;
    private String browser;
    private Logger logger;
    public BrowserDriverFactory(String browser, Logger logger) {
        this.browser = browser.toLowerCase();
        this.logger = logger;
    }

    public WebDriver getDriver() {
        logger.info("Get driver: " + browser);

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            default:
                logger.info("Do not know how to start: " + browser + ", starting chrome.");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

        }
        return driver;
    }
}
