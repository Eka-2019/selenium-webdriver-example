package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultiplyWindowsPage extends BasePageObject {

    private By newWindowLink = By.xpath("//a[@href = '/windows/new']");

    public MultiplyWindowsPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    public void openNewWindowPage() {
        logger.info("Clicking New Window link on the MultiplyWindow Page");
        click(newWindowLink);
    }

    public NewWindowPage switchToNewWindow() {
        logger.info("Looking for New Window Page");
        switchToWindowWithTitle("The Internet");
        return new NewWindowPage(driver, logger);
    }
}
