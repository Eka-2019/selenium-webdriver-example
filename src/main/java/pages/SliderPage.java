package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SliderPage extends BasePageObject {
    String pageUrl = "http://the-internet.herokuapp.com/horizontal_slider";
    By slider = By.tagName("input");
    By sliderValue = By.id("range");

    public SliderPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    public void openPage() {
        logger.info("Openning page: " + pageUrl);
        openUrl(pageUrl);
        logger.info("Page is opened");
    }

    public void setSliderTo(String value) {
        logger.info("Move slider to " + value);
        int steps = (int) (Double.parseDouble(value) / 0.5);
        basePressKey(slider, Keys.CONTROL);
        for (int i = 1; i <= steps; i++) {
            basePressKey(slider, Keys.ARROW_RIGHT);
        }
    }

    public String getSliderValue() {
        return find(sliderValue).getText();
    }
}
