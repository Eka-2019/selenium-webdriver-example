package com.herokuapp.theinternet.logintest;

import base.CsvDataProvider;
import base.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.WelcomePage;

import java.util.Map;

public class NegativeLoginTestCSVDataProvider extends TestUtilities {

    @Test(priority = 1, dataProvider = "csvReadr", dataProviderClass = CsvDataProvider.class)
    public void negativeLoginTest(Map<String, String> testData) {
        String n = testData.get("n");
        String userName = testData.get("username");
        String password = testData.get("password");
        String message = testData.get("expectedMessage");
        String description = testData.get("testDescription");

        logger.info("Starting negativeTestWithDataProvider N: " + n + " and for " + description);

        WelcomePage welcomePage = new WelcomePage(driver, logger);
        welcomePage.openPage();

        LoginPage loginPage = welcomePage.clickAuthForm();

        loginPage.logIn(userName, password);
        loginPage.waitForErrorMessage();

        String actualErrorMessage = loginPage.getErrorMessageText();
        Assert.assertTrue(actualErrorMessage.contains(message),
                "actualMessage does not contain expectedMessage\nexpectedMessage: "
                        + message + "\nactualMessage: " + actualErrorMessage);
    }

}
