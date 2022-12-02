package com.herokuapp.theinternet.keyboardkeypress;

import base.TestUtilities;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KeyboardKeyPressPage;

public class KeyboardKeyPressTest extends TestUtilities {

    @Test
    public void keyboardKeyPressTest() {
        logger.info("Starting keyboardKeyPress test");
        KeyboardKeyPressPage keyPressPage = new KeyboardKeyPressPage(driver, logger);
        keyPressPage.openPage();
        keyPressPage.pressKey(Keys.ENTER);
        String result = keyPressPage.getResultText();

        Assert.assertTrue(result.equals("You entered: ENTER"),
                "result is not expected. \nShould be 'You entered: ENTER', but it is '" + result + "'");
    }

    @Test
    public void keyboardKeyPressWithActionsTest() {
        logger.info("Starting keyboardKeyPressWithActions test");
        KeyboardKeyPressPage keyPressPage = new KeyboardKeyPressPage(driver, logger);
        keyPressPage.openPage();
        keyPressPage.basePressKeyWithAction(Keys.SPACE);

        String result = keyPressPage.getResultText();

        Assert.assertTrue(result.equals("You entered: SPACE"),
                "result is not expected. \nShould be 'You entered: ENTER', but it is '" + result + "'");
    }
}
