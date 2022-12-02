package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DragAndDropPage extends BasePageObject {
    private String pageUrl = "http://the-internet.herokuapp.com/drag_and_drop";

    private By elementA = By.id("column-a");
    private By elementB = By.id("column-b");
    public DragAndDropPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    public void openPage() {
        logger.info("Opening page: " + pageUrl);
        openUrl(pageUrl);
        logger.info("Page opened!");
    }

    public void dragAToB(){
        logger.info("Dragging and dropping column A on column B");
        performDragAndDrop(elementA, elementB);
    }

    /** Getting Column A Text */
    public String getColumnAText() {
        String text = find(elementA).getText();
        logger.info("Column A Text: " + text);
        return text;
    }

    /** Getting Column B Text */
    public String getColumnBText() {
        String text = find(elementB).getText();
        logger.info("Column B Text: " + text);
        return text;
    }



}
