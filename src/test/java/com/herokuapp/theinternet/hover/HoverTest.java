package com.herokuapp.theinternet.hover;

import base.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HoverPage;

public class HoverTest extends TestUtilities {

    @Test
    public void hoverOverTest() {
        logger.info("Starting Hover Test");
        HoverPage hoverPage = new HoverPage(driver, logger);
        hoverPage.openPage();

        Assert.assertTrue(hoverPage.hoverMouseOnAvatarAndCheckText(2).contains("View profile"), "Avatar text is unexpected.");
        hoverPage.openUserProfile(2);
        Assert.assertTrue(hoverPage.getCurrentUrl().contains("/users/2"), "Current URL does not contain User 2");
    }
}
