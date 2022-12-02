package com.herokuapp.theinternet.newwindowtests;

import base.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MultiplyWindowsPage;
import pages.NewWindowPage;
import pages.WelcomePage;

public class FocusNewWindowTest extends TestUtilities {

    @Test
    public void focusNewWindowTest() {
        logger.info("Starting focusNewWindowTest");
        WelcomePage welcomepage = new WelcomePage(driver, logger);
        welcomepage.openPage();

        MultiplyWindowsPage mpWindowPage = welcomepage.clickMultiplyWindowsLink();
        mpWindowPage.openNewWindowPage();

        NewWindowPage newWindowPage = mpWindowPage.switchToNewWindow();
        String pageSource = newWindowPage.getCurrentPageSource();

        Assert.assertTrue(pageSource.contains("New Window"), "New page Source does not contain 'New Window'");
    }
}
