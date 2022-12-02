package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
public class CheckBoxPage extends BasePageObject {
    private By checkbox = By.xpath("//input[@type='checkbox']");
    public CheckBoxPage(WebDriver driver, Logger logger){
        super(driver, logger);
    }
    public void selectAllCheckBoxes(){
        getLogger().info("Checking All unchecked checkboxes");
        List<WebElement> checkBoxes = findAll(checkbox);
        for(WebElement checkbox: checkBoxes)
        if(!checkbox.isSelected()){
            checkbox.click();
        }
    }
    public boolean checkAllCheckBoxesChecked() {
        //basePageLogger.info("Checking All checkboxes are checked");
        getLogger().info("Checking All checkboxes are checked");
        List<WebElement> checkBoxes = findAll(checkbox);
        for (WebElement checkbox : checkBoxes) {
            if (!checkbox.isSelected()) {
                return false;
            }
        }
        return true;
    }
}
