package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WelcomePage extends BasePageObject {
    private String baseURL = "http://the-internet.herokuapp.com/";
    private By loginPageLink = By.linkText("Form Authentication");
    private By checkBoxesPageLink = By.linkText("Checkboxes");
    private By dropDownPageLink = By.linkText("Dropdown");
    private By alertPageLink = By.linkText("JavaScript Alerts");
    private By multiplyWindowsLink = By.linkText("Multiple Windows");
    private By frameLink = By.linkText("WYSIWYG Editor");

    public WelcomePage(WebDriver webDriver, Logger logger) {
        super(webDriver, logger);
    }

    public void openPage() {
        logger.info("Opening URL: " + baseURL);
        openUrl(baseURL);
        logger.info("Page is opened");
    }

    public LoginPage clickAuthForm() {
        logger.info("Clicking Auth link on Welcome page");
        click(loginPageLink);
        return new LoginPage(driver, logger);
    }

    public CheckBoxPage clickCheckBoxesLink() {
        logger.info("Clicking CheckBoxes link on Welcome page");
        click(checkBoxesPageLink);
        return new CheckBoxPage(driver, logger);
    }

    public DropDownPage clickDropDownLink() {
        logger.info("Clicking DropDown link on Welcome page");
        click(dropDownPageLink);
        return new DropDownPage(driver, logger);
    }

    public JavaScriptsAlertPage clickJavaScriptAlertLink() {
        logger.info("Clicking JavaScriptAlert link on Welcome page");
        click(alertPageLink);
        return new JavaScriptsAlertPage(driver, logger);
    }

    public MultiplyWindowsPage clickMultiplyWindowsLink() {
        logger.info("Clicking MultiplyWindows link on Welcome page");
        click(multiplyWindowsLink);
        return new MultiplyWindowsPage(driver, logger);
    }

    public IFramePage clickFramesLink() {
        logger.info("Clicking IFrames link on Welcome page");
        click(frameLink);
        return new IFramePage(driver, logger);
    }

    public void scrollToBottom() {
        logger.info("Scrolling on the bottom of the page");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void scrollIntoView() {
        logger.info("Scrolling to the specific element on the page");
        WebElement element = driver.findElement(By.linkText("Hovers"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(false);", element);
    }
}
