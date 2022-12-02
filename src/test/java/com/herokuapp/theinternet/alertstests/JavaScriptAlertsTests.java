package com.herokuapp.theinternet.alertstests;

import base.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.JavaScriptsAlertPage;
import pages.WelcomePage;

public class JavaScriptAlertsTests extends TestUtilities {

    @Test
    public void jsAlertsOkTest() {
        WelcomePage welcomePage = new WelcomePage(driver, logger);
        welcomePage.openPage();

        JavaScriptsAlertPage alertPage = welcomePage.clickJavaScriptAlertLink();
        alertPage.openJSAlert();

        String alertMessage = alertPage.getAlertText();
        alertPage.acceptAlert();

        String result = alertPage.getResult();

        Assert.assertEquals(alertMessage, "I am a JS Alert", "Alert message is not expected. " +
                "Should  be 'I am a JS Alert', but actual result is: " + alertMessage);
        Assert.assertEquals(result, "You successfully clicked an alert", "Result is not expected. Actual result: " + result);
    }

    @Test
    public void jsConfirmAcceptTest() {
        WelcomePage welcomePage = new WelcomePage(driver, logger);
        welcomePage.openPage();

        JavaScriptsAlertPage alertPage = welcomePage.clickJavaScriptAlertLink();
        alertPage.openJSConfirm();

        String alertMessage = alertPage.getAlertText();
        alertPage.acceptAlert();

        String result = alertPage.getResult();
        Assert.assertEquals(alertMessage, "I am a JS Confirm", "Alert message is not expected. " +
                "Should  be 'I am a JS Alert', but actual result is: " + alertMessage);
        Assert.assertEquals(result, "You clicked: Ok", "Result is not expected. Actual result: " + result);
    }

    @Test
    public void jsConfirmDismissTest() {
        WelcomePage welcomePage = new WelcomePage(driver, logger);
        welcomePage.openPage();

        JavaScriptsAlertPage alertPage = welcomePage.clickJavaScriptAlertLink();
        alertPage.openJSConfirm();

        String alertMessage = alertPage.getAlertText();
        alertPage.dismissAlert();

        String result = alertPage.getResult();

        Assert.assertEquals(alertMessage, "I am a JS Confirm", "Alert message is not expected. " +
                "Should  be 'I am a JS Alert', but actual result is: " + alertMessage);
        Assert.assertEquals(result, "You clicked: Cancel", "Result is not expected. Actual result: " + result);
    }


    @Test
    public void jsPromptOkTest() {
        WelcomePage welcomePage = new WelcomePage(driver, logger);
        welcomePage.openPage();

        JavaScriptsAlertPage alertPage = welcomePage.clickJavaScriptAlertLink();
        alertPage.openJSPrompt();

        String alertMessage = alertPage.getAlertText();
        alertPage.typeTextIntoAlert("Hello Alert, it's Katya here!");

        String result = alertPage.getResult();

        Assert.assertEquals(alertMessage, "I am a JS prompt", "Alert message is not expected. " +
                "Should  be 'I am a JS Alert', but actual result is: " + alertMessage);
        Assert.assertEquals(result, "You entered: Hello Alert, it's Katya here!", "Result is not expected. Actual result: " + result);
    }

    @Test
    public void jsPromptCancelTest() {
        WelcomePage welcomePage = new WelcomePage(driver, logger);
        welcomePage.openPage();

        JavaScriptsAlertPage alertPage = welcomePage.clickJavaScriptAlertLink();
        alertPage.openJSPrompt();

        String alertMessage = alertPage.getAlertText();
        alertPage.dismissAlert();

        String result = alertPage.getResult();

        Assert.assertEquals(alertMessage, "I am a JS prompt", "Alert message is not expected. " +
                "Should  be 'I am a JS Alert', but actual result is: " + alertMessage);
        Assert.assertEquals(result, "You entered: null", "Result is not expected. Actual result: " + result);
    }
}
