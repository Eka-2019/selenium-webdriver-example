package com.herokuapp.theinternet.filesupload;

import base.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UploadingFilesPage;

public class UploadFileTestWithDataProvider extends TestUtilities {

    @Test(dataProvider = "files")
    public void DataDrivenFileUploadTest(int testNum, String expectedFileName){
        logger.info("Starting Data Driven File Upload test" + testNum + "for " + expectedFileName);
        UploadingFilesPage uploadPage = new UploadingFilesPage(driver, logger);
        uploadPage.openPage();

        uploadPage.selectFile(expectedFileName);
        uploadPage.sumbitFileToUpload();

        String actualFileName = uploadPage.getUploadedFileName();

        Assert.assertTrue(actualFileName.contains(expectedFileName), "Expected File Name is not found. Instead we got: " + actualFileName);

    }
}
