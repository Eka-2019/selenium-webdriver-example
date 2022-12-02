package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownPage extends BasePageObject {

    private By optionList = By.id("dropdown");
    //private By optionTwo = By.xpath("//option[@value = '2']");
    public DropDownPage(WebDriver driver, Logger logger){
        super(driver, logger);
    }

//    public void getDropDownList(){
//        logger.info("Getting dropdown list");
//        click(dropDownList);
//    }

    public void getDropDownList() {
        List<WebElement> options = findAll(optionList);
        click(optionList);
    }


    public void selectOption(int i){
        logger.info("Selecting option: " + i + " from dropdown");
        WebElement dropdownElement = find(optionList);
        Select dropdown = new Select(dropdownElement);
        // There are three ways to use Select class
        // #1
        // dropdown.selectByIndex(i);

        // #2
        dropdown.selectByValue("" + i);

        // #3
        // dropdown.selectByVisibleText("Option " + i);
    }
    public String getSelectedOption() {
        WebElement dropdownElement = find(optionList);
        Select dropdown = new Select(dropdownElement);
        String selectedOption = dropdown.getFirstSelectedOption().getText();
        logger.info(selectedOption + " is selected in dropdown");
        return selectedOption;
    }

}
