package com.herokuapp.theinternet.iframetests;

import base.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.IFramePage;
import pages.WelcomePage;

public class IFrameTest extends TestUtilities {

    @Test
    public void defaultEditorValueTest() {
        logger.info("Starting 'Default Editor Value' test");
        WelcomePage welcomePage = new WelcomePage(driver, logger);
        welcomePage.openPage();
        IFramePage iFramePage = welcomePage.clickFramesLink();
        String editorialText = iFramePage.getFrameText();

        Assert.assertEquals(editorialText, "Your content goes here.", "Text is not expected. It's: " + editorialText);
    }
}
