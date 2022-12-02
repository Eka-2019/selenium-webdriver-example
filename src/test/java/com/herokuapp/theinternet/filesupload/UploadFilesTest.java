package com.herokuapp.theinternet.filesupload;

import base.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UploadingFilesPage;

public class UploadFilesTest extends TestUtilities {

    @Test
    public void fileUploadTest() {
        logger.info("Starting File Upload test");
        UploadingFilesPage uploadPage = new UploadingFilesPage(driver, logger);
        uploadPage.openPage();

        String expectedFileName = "OfficeZoom.jpg";
        uploadPage.selectFile(expectedFileName);
        uploadPage.sumbitFileToUpload();

        String actualFileName = uploadPage.getUploadedFileName();

        Assert.assertTrue(actualFileName.contains(expectedFileName), "Expected File Name is not found. Instead we got: " + actualFileName);
    }
}
