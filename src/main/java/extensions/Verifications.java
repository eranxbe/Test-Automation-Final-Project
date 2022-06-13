package extensions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import utilities.CommonOps;

import static org.testng.Assert.*;
import static org.testng.FileAssert.fail;

public class Verifications extends CommonOps {

    @Step("Verify language URL extension")
    public static void verifyLanguageURL(String urlExtension) {
        softAssert.assertTrue(driver.getCurrentUrl().contains(urlExtension));
    }

    @Step("Verify Conversion value equals expected value")
    public static void assertTextContains(String expected, String actual) {
        assertTrue(actual.contains(expected));
    }

    @Step("Verify Conversion value is different than expected value")
    public static void verifyConversionFail (String expected, String actual) {
        assertFalse(actual.contains(expected));
    }

    @Step("Soft assert visibility of element")
    public static void visibilityOfElement(WebElement elem) {
        softAssert.assertTrue(elem.isDisplayed(), "LOGO IS NOT DISPLAYED");
    }

    @Step("Verify element visually")
    public static void visualElement(String expectedImageName)  {
        try{
        screen.find(getData("ImageRepo") + expectedImageName + ".PNG");
        }
        catch (FindFailed findFailed) {
           fail("Error comparing image file: " + findFailed);
        }
    }

    @Step("Verify text is equal")
    public static void assertText(String actual, String expected) {
        assertEquals(actual, expected);

    }

    @Step("Verify numbers are equal")
    public static void assertNumber(int actual, int expected) {
        assertEquals(actual, expected);

    }

    @Step("Verify element is selected")
    public static void verifyMobileElementIsSelected(MobileElement elem) {
        softAssert.assertTrue(elem.isSelected(), "Element Is Not Selected");
    }

    @Step("Verify element is selected")
    public static void verifyWebElementIsDisplayed(WebElement elem) {
        assertTrue(elem.isDisplayed(), "Element Is Not Displayed");
    }

    @Step("Soft assert visibility of a mobile element")
    public static void visibilityOfMobileElement(MobileElement elem) {
        assertTrue(elem.isDisplayed(), "Element Is Not Displayed");
    }

    @Step("Verify Non visibility of a mobile element")
    public static void nonVisibilityOfMobileElement(MobileElement elem) {
        assertFalse(elem.isDisplayed());
    }



}
