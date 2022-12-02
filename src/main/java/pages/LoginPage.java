package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject {
    private By username = By.id("username");
    private By password = By.name("password");
    private By logInButton = By.tagName("button");
    private By errorMessage = By.id("flash-messages");

    public LoginPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    public SecureAreaPage logIn(String login, String pass) {
        logger.info("Executing login with username: [" + login + "] and password: [" + pass + "]");
        type(login, username);
        type(pass, password);
        click(logInButton);
        return new SecureAreaPage(driver, logger);
    }

    public String getErrorMessageText() {
        return find(errorMessage).getText();
    }

    public void waitForErrorMessage() {
        waitForVisibilityOf(errorMessage, 30);
    }

}
