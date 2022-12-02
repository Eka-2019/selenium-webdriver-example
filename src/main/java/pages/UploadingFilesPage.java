package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UploadingFilesPage extends BasePageObject {
    String pageUrl = "http://the-internet.herokuapp.com/upload";
    String filePath1 = "/src/main/resources/files/";
    By choosePathButton = By.xpath("//input[@id='file-upload']");
    By uploadButton = By.xpath("//input[@id='file-submit']");
    By uploadedFile = By.xpath("//div[@id='uploaded-files']");

    public UploadingFilesPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    public void openPage() {
        logger.info("Opening page: " + pageUrl);
        openUrl(pageUrl);
        logger.info("Page opened!");
    }

    public void selectFile(String fileName) {
        logger.info("Starting selecting " + fileName + " from folder");
        String filePath = System.getProperty("user.dir") + filePath1 + fileName;
        type(filePath, choosePathButton);
        logger.info("File selected");
    }

    public void sumbitFileToUpload() {
        find(uploadButton).click();
    }

    public String getUploadedFileName() {
        String fileName = find(uploadedFile).getText();
        logger.info("File name is: " + fileName);
        return fileName;
    }
}
