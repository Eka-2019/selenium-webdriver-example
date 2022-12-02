package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HoverPage extends BasePageObject {

    By avatarsList = By.xpath("//div[@class='figure']");
    //By profileLink = By.linkText("View Profile");
    By profileLink = By.xpath(".//a[contains(text(), 'View profile')]");

    By h5 = By.xpath("//h5[not(@*)]");
    String pageUrl = "http://the-internet.herokuapp.com/hovers";

    public HoverPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    public void openPage() {
        logger.info("Opening page with url: " + pageUrl);
        openUrl(pageUrl);
        logger.info("Page is opened");
    }

    public String hoverMouseOnAvatarAndCheckText(int avatarNumber) {
        List<WebElement> avList = findAll(avatarsList);
        WebElement selectedUserAvatar = avList.get(avatarNumber - 1);
        moveMouseToAvatar(selectedUserAvatar);
        String text =  selectedUserAvatar.findElement(profileLink).getText();
        System.out.println(text);
        return text;
    }


    public void openUserProfile(int i) {
        List<WebElement> avList = findAll(avatarsList);
        WebElement selectedUserAvatar = avList.get(i - 1);
        moveMouseToAvatar(selectedUserAvatar);
        selectedUserAvatar.findElement(profileLink).click();
    }
}
