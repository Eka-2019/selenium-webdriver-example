package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IFramePage extends BasePageObject {
    private By frame = By.tagName("iframe");
    private By editorText = By.id("tinymce");

    public IFramePage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    public String getFrameText() {
        switchToFrame(frame);
        String text = find(editorText).getText();
        logger.info("Text from Editorial frame is: " + text);
        return text;
    }
}
