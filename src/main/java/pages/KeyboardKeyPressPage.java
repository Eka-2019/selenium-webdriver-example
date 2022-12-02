package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyboardKeyPressPage extends BasePageObject {
    private String pageUrl = "http://the-internet.herokuapp.com/key_presses?";

    private By body = By.xpath("//body");
    private By input = By.xpath("//input[@id='target']");
    private By resultText = By.xpath("//p[@id='result']");

    public KeyboardKeyPressPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    public void openPage() {
        logger.info("Opening page: " + pageUrl);
        openUrl(pageUrl);
        //driver.get(pageUrl);
        logger.info("Page opened!");
    }

    public void pressKey(Keys key) {
        logger.info("Pressing keyboard key: " + key);
        basePressKey(input, key);
    }

    public String getResultText() {
        String result = find(resultText).getText();
        logger.info("Result text: " + result);
        return result;
    }
}
