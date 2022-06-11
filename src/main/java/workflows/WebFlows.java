package workflows;

import extensions.Verifications;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pageObjects.metricConversionWeb.LanguagesToSelectEnum;
import utilities.CommonOps;
import extensions.UIActions;

public class WebFlows extends CommonOps {

    @Step("Business Flow: Select Language")
    public static void selectLanguage(LanguagesToSelectEnum language) {
        UIActions.selectFromDropDownByValue(topToolbar.dropdown_language, String.valueOf(language));
    }

    @Step("Business Flow: Get Conversion answer")
    public static String getConversionAnswer () {
        String string = convPage.txt_convAnswer.getText();
        return string.split("=")[1];
    }

    @Step("Business Flow: Convert value by conversion type and operation")
    public static void convert(WebElement type, WebElement operation, String value) {
        UIActions.clickElement(type);
        UIActions.disableWeirdMessage();
        UIActions.clickElement(operation);
        UIActions.fillText(convPage.txt_convertArgument, value);
    }

    @Step("Business Flow: Select from Format dropdown")
    public static void selectFormat(String formatOption) {
        Select format = new Select(convPage.select_format);
        format.selectByVisibleText(formatOption);
    }

    @Step("Business Flow: Select from Accuracy dropdown")
    public static void selectAccuracy(int accuracyOption) {
        Select format = new Select(convPage.select_accuracy);
        format.selectByValue(String.valueOf(accuracyOption));
    }

    @Step("Business Flow: calculate BMI using DDT")
    public static void calculateBMI(String heightInCm, String weightInKg, String expectedBMI, String shouldBeCorrect) {
        UIActions.disableWeirdMessage();
        UIActions.clickElement(convPage.btn_healthWellbeing);
        UIActions.clickElement(bmiPage.btn_goBMI);
        UIActions.fillText(bmiPage.txt_cm, heightInCm);
        UIActions.fillText(bmiPage.txt_kg, weightInKg);
        String result = bmiPage.txt_bmiResult.getText().split(":")[1];
        if (shouldBeCorrect.equalsIgnoreCase("correct")) {
            Verifications.assertTextContains(expectedBMI, result);
        }
        else if (shouldBeCorrect.equalsIgnoreCase("incorrect")) {
            Verifications.verifyConversionFail(expectedBMI, result);
        }
        else {
            throw new RuntimeException("Invalid shouldBeCorrect parameter, expected \"correct\" OR \"incorrect\"");
        }

    }

}
