package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.MobileFlows;


@Listeners(utilities.Listeners.class)
public class MetricConversionsMobile extends CommonOps {

    @Test(description = "Test 01: Navigate Between tabs")
    @Description("Business Flow: This test navigates between tabs and verifies the relevant tab is selected")
    public static void test01_verifyNavigationWithSwipes() {
        MobileFlows.navigateTo(mobileMenuBar.tab_about);
        Verifications.verifyMobileElementIsSelected(mobileMenuBar.tab_about);

        MobileFlows.navigateTo(mobileMenuBar.tab_history);
        Verifications.verifyMobileElementIsSelected(mobileMenuBar.tab_history);

        MobileFlows.navigateTo(mobileMenuBar.tab_favorites);
        Verifications.verifyMobileElementIsSelected(mobileMenuBar.tab_favorites);

        MobileFlows.navigateTo(mobileMenuBar.tab_convert);
        Verifications.verifyMobileElementIsSelected(mobileMenuBar.tab_convert);
    }

    @Test(description = "Test 02: Convert Temperature Celsius to Fahrenheit")
    @Description("Business Flow: This test converts Temperature from Celsius to Fahrenheit")
    public static void test02_convertTempCelToFar() {
        MobileFlows.convert(mobileMainPage.btn_temp, "Celsius", "Fahrenheit", "180");
        Verifications.assertTextContains("356", mobileConvPage.txt_answer.getAttribute("text"));
    }

    @Test(description = "Test 03: Add Temperature Celsius to Fahrenheit to Favorites")
    @Description("Business Flow: This test adds Celsius to Fahrenheit to favorites and validates")
    public static void test03_addConversionToFavorites() {
        MobileFlows.addAsFavorite();
        String conversionTitle = MobileFlows.getConversionTitle();
        MobileFlows.navigateTo(mobileMenuBar.tab_favorites);
        Verifications.visibilityOfMobileElement(MobileFlows.getFavoriteElement(conversionTitle));

    }

}
