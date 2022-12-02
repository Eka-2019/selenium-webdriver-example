package com.herokuapp.theinternet.dropdowntests;

import base.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DropDownPage;
import pages.WelcomePage;

public class DropDownTest extends TestUtilities {

    @Test
    public void selectOptionTwoTest(){
        logger.info("Starting selectingTwoCheckBoxesTest");

        WelcomePage welcomePage = new WelcomePage(driver, logger);
        welcomePage.openPage();
        DropDownPage ddPage = welcomePage.clickDropDownLink();
        String preselectedOption = ddPage.getSelectedOption();
        System.out.println("Option before selection: " + preselectedOption.toString());


        ddPage.selectOption(2);
        String selectedOption = ddPage.getSelectedOption();
        Assert.assertTrue(selectedOption.equals("Option 2"), "Option_2 is not selected. Instead selected: " +selectedOption);

    }
}
