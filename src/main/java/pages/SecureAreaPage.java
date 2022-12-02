package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePageObject {
    private String pageUrl = "http://the-internet.herokuapp.com/secure";
    private By logOutButton = By.xpath("//a[@class='button secondary radius']");
    private By successMessage = By.id("flash-messages");

    public SecureAreaPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public boolean isLogOutButtonVisible() {
        return find(logOutButton).isDisplayed();
    }

    public String getSuccessMessageText() {
        return find(successMessage).getText();
    }
}
