package com.herokuapp.theinternet.javascriptexecutor;

import base.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.IFramePage;
import pages.WelcomePage;

public class JavaScriptExecutorTest extends TestUtilities {

    @Test
    public void javaScriptExecutorExampleTest() throws InterruptedException {
        logger.info("Starting JSExecutor test");

        WelcomePage welcomePage = new WelcomePage(driver, logger);
        welcomePage.openPage();
        welcomePage.scrollToBottom();

        IFramePage iFramePage = welcomePage.clickFramesLink();
        String editorialText = iFramePage.getFrameText();

        Assert.assertTrue(editorialText.equals("Your content goes here."), "Text is not expected. It's: " + editorialText);
    }
}
