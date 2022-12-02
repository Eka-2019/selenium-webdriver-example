package com.herokuapp.theinternet.logintest;

import base.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.WelcomePage;

public class NegativeLoginTests extends TestUtilities {

    @Parameters({"username", "password", "expectedMessage"})
    @Test(priority = 1)
    public void negativeTest(String username, String password, String expectedErrorMessage) {
        logger.info("Starting negativeTest");
        WelcomePage welcomePage = new WelcomePage(driver, logger);
        welcomePage.openPage();

        LoginPage loginPage = welcomePage.clickAuthForm();
        loginPage.logIn(username, password);
        loginPage.waitForErrorMessage();

        String actualErrorMessage = loginPage.getErrorMessageText();

        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
                "actualMessage does not contain expectedMessage\nexpectedMessage: "
                        + expectedErrorMessage + "\nactualMessage: " + actualErrorMessage);
    }

}

