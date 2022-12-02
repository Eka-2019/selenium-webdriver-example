package com.herokuapp.theinternet.checkboxtests;

import base.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckBoxPage;
import pages.WelcomePage;

public class CheckBoxTest extends TestUtilities {

    @Test
    public void selectingTwoCheckBoxesTest(){
        logger.info("Starting selectingTwoCheckBoxesTest");

        WelcomePage welcomePage = new WelcomePage(driver, logger);
        welcomePage.openPage();
        CheckBoxPage checkBoxPage = welcomePage.clickCheckBoxesLink();
        checkBoxPage.selectAllCheckBoxes();
        Assert.assertTrue(checkBoxPage.checkAllCheckBoxesChecked(), "Not all checkboxes are checked");
    }
}
