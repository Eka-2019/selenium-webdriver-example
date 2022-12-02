package com.herokuapp.theinternet.dragAndDropPage;

import base.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DragAndDropPage;

public class DragAndDropPageTest extends TestUtilities {

    @Test
    public void DragAAfterBTest() {
        logger.info("DragAAfterB test");

        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver, logger);
        dragAndDropPage.openPage();

        String elementATextBefore = dragAndDropPage.getColumnAText();
        dragAndDropPage.dragAToB();
        String elementATextAfter = dragAndDropPage.getColumnAText();

        Assert.assertEquals(elementATextBefore, "A", "Element before drag and drop is not: " + elementATextBefore);
        Assert.assertEquals(elementATextAfter, "B", "Element after drag and drop is not: " + elementATextAfter);
    }
}
