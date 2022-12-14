package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class BasePageObject {
    protected WebDriver driver;
    protected Logger logger;

    public BasePageObject(WebDriver webDriver, Logger logger) {
        this.driver = webDriver;
        this.logger = logger;
    }
    protected void openUrl(String url) {
        driver.get(url);
    }

    public Logger getLogger() {
        return logger;
    }
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getCurrentPageTitle(){
        return driver.getTitle();
    }
    public String getCurrentPageSource(){
        return driver.getPageSource();
    }

    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }
    protected List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }

    protected void click(By locator) {
        waitForVisibilityOf(locator, 5);
        find(locator).click();
    }
    protected void type(String text, By locator) {
        waitForVisibilityOf(locator, 5);
        find(locator).sendKeys(text);
    }
    private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(condition);
    }
    protected void waitForVisibilityOf(By locator, Integer timeOutInSeconds) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
                        timeOutInSeconds);
            } catch (StaleElementReferenceException ignored) {
            }
            attempts++;
        }
    }

//    protected void waitForVisibilityOf(By locator) {
//        waitForVisibilityOf(locator, 30);
//    }

    protected Alert switchToAlert() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();
    }
    public void switchToWindowWithTitle(String expectedTitle) {
        String firstWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        Iterator<String> windowsIterator = allWindows.iterator();

        while (windowsIterator.hasNext()) {
            String childWindowHandle = windowsIterator.next();
            if (!childWindowHandle.equalsIgnoreCase(firstWindow)) {
                driver.switchTo().window(childWindowHandle);
                if (getCurrentPageTitle().equals(expectedTitle)){
                    break;
                }
            }
        }
    }
    protected void switchToFrame(By frameLocator){
        driver.switchTo().frame(find(frameLocator));
    }
    protected void basePressKey(By locator, Keys key){
        find(locator).sendKeys(key);
    }
    public void basePressKeyWithAction(Keys key){
        logger.info("Pressing: " + key+ " using Actions class.");
        Actions action = new Actions(driver);
        action.sendKeys(key).build().perform();
    }
    public void performDragAndDrop(By from, By to){
        logger.info("Perform draging and dropping: " + from + " on " + to );
//        Actions dragAndDrop = new Actions(basePageDriver);
//        dragAndDrop.dragAndDrop(find(from), find(to)).build().perform();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript(
                "function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
                        + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n"
                        + "data: {},\n" + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
                        + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n"
                        + "return event;\n" + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
                        + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
                        + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
                        + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n"
                        + "}\n" + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
                        + "var dragStartEvent =createEvent('dragstart');\n"
                        + "dispatchEvent(element, dragStartEvent);\n" + "var dropEvent = createEvent('drop');\n"
                        + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
                        + "var dragEndEvent = createEvent('dragend');\n"
                        + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
                        + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
                        + "simulateHTML5DragAndDrop(source,destination);",
                find(from), find(to));
    }
    public void moveMouseToAvatar(WebElement element) {
        Actions hover = new Actions(driver);
        hover.moveToElement(element).build().perform();
    }
}
