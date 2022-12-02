package com.herokuapp.theinternet.slider;

import base.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SliderPage;

public class HorisontalSliderTest extends TestUtilities {

    @Test
    public void horizontalSliderTest() {
        logger.info("Starting 'Horizontal Slider' test");
        SliderPage sliderPage = new SliderPage(driver, logger);
        sliderPage.openPage();
        String value = "3.5";
        sliderPage.setSliderTo(value);
        String sliderValue = sliderPage.getSliderValue();
        Assert.assertEquals(sliderValue, value, "Range is not correct");
    }
}
