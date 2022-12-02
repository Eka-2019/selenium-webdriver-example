package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptsAlertPage extends BasePageObject {
    private By jsAlertButton = By.xpath("//button[@onclick = 'jsAlert()']");
    private By jsConfirmButton = By.xpath("//button[@onclick = 'jsConfirm()']");
    private By jsPromptButton = By.xpath("//button[@onclick = 'jsPrompt()']");
    private By result = By.id("result");

    public JavaScriptsAlertPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    public void openJSAlert() {
        logger.info("Clicking on 'Click for JS Alert' button to open alert");
        click(jsAlertButton);
    }

    public void openJSConfirm() {
        logger.info("Clicking on 'Click for JS Confirm' button to open confirm");
        click(jsConfirmButton);
    }

    public void openJSPrompt() {
        logger.info("Clicking on 'Click for JS Prompt' button to open prompt");
        click(jsPromptButton);
    }

    public String getAlertText() {
        Alert alert = switchToAlert();
        String alertText = alert.getText();
        logger.info("Alert says: " + alertText);
        return alertText;
    }

    public void acceptAlert() {
        logger.info("Switching to alert and pressing OK");
        Alert alert = switchToAlert();
        alert.accept();
    }

    public void dismissAlert() {
        logger.info("Switching to alert and pressing Cancel");
        Alert alert = switchToAlert();
        alert.dismiss();
    }

    public void typeTextIntoAlert(String text) {
        logger.info("Switching to alert and typing text into aleert field");
        Alert alert = switchToAlert();
        alert.sendKeys(text);
        alert.accept();
    }

    public String getResult() {
        String resultText = find(result).getText();
        logger.info("Result text: " + resultText);
        return resultText;
    }
}
