package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.metricConversionWeb.*;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class MetricConversionsWeb extends CommonOps {


    @Test(description = "Test 01 - Verify Logo")
    @Description("This test verifies the existence of the Logo using a soft assertion")
    public void test01_verifyLogo() {

        Verifications.visibilityOfElement(topToolbar.logo);
    }

    @Test(description = "Test 02 - Verify crossroad button visually")
    @Description("This test verifies the existence of the crossroad button using sikuli")
    public void test02_verifyCrossroadButton() {

        Verifications.visualElement("crossroadIcon");
    }

    @Test(description = "Test 03 - Select Language")
    @Description("This test selects languages and verify url extensions")
    public void test03_selectLanguage() {

        WebFlows.selectLanguage(LanguagesToSelectEnum.ITALIAN);
        Verifications.verifyLanguageURL(String.valueOf(LanguagesToSelectEnum.ITALIAN));

        WebFlows.selectLanguage(LanguagesToSelectEnum.SPANISH);
        Verifications.verifyLanguageURL(String.valueOf(LanguagesToSelectEnum.SPANISH));

        WebFlows.selectLanguage(LanguagesToSelectEnum.AFRIKAANS);
        Verifications.verifyLanguageURL(String.valueOf(LanguagesToSelectEnum.AFRIKAANS));
    }

    @Test(description = "Test 04 - Convert Temperature")
    @Description("This test converts temperature in a simple way")
    public void test04_convertTemperature() throws NullPointerException{

        WebFlows.convert(webMainPage.btn_temperature, convPage.btn_cel2far, "180");
        Verifications.assertTextContains("356", WebFlows.getConversionAnswer());
    }

    @Test(description = "Test 05 - Convert Length")
    @Description("This test converts length using the format and accuracy dropdowns")
    public void test05_convertLength() {

        WebFlows.convert(webMainPage.btn_length, convPage.btn_cm2inch, "26");
        WebFlows.selectFormat("Decimal");
        WebFlows.selectAccuracy(2);
        Verifications.assertTextContains("10", WebFlows.getConversionAnswer());
    }

    @Test(description = "Test 06 - Calculate BMI Using DDT", dataProvider = "data-provider-bmi", dataProviderClass = utilities.ManageDDT.class)
    @Description("This test calculates BMI using DDT file")
    public void test06_calculateBMI(String height, String weight, String expectedBMI, String shouldBeCorrect) {

        WebFlows.calculateBMI(height, weight, expectedBMI, shouldBeCorrect);
    }



}
