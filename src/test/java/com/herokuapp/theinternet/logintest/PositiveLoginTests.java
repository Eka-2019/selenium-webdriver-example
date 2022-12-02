package com.herokuapp.theinternet.logintest;

import base.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;
import pages.WelcomePage;

public class PositiveLoginTests extends TestUtilities {

    @Test
    public void logInTest() {
        logger.info("Starting logIn test");
        WelcomePage welcomePage = new WelcomePage(driver, logger);
        welcomePage.openPage();

        LoginPage loginPage = welcomePage.clickAuthForm();
        SecureAreaPage secureAreaPage = loginPage.logIn("tomsmith", "SuperSecretPassword!");

        Assert.assertEquals(secureAreaPage.getCurrentUrl(), secureAreaPage.getPageUrl());
        Assert.assertTrue(secureAreaPage.isLogOutButtonVisible(),
                "LogOut Button is not visible.");

        String expectedSuccessMessage = "You logged into a secure area!";
        String actualSuccessMessage = secureAreaPage.getSuccessMessageText();
        Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
                "actualMessage does not contain expectedMessage\nexpectedMessage: "
                        + expectedSuccessMessage + "\nactualMessage: " + actualSuccessMessage);
    }
}

