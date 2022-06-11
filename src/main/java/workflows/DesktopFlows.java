package workflows;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import utilities.CommonOps;

public class DesktopFlows extends CommonOps {

    @Step("Calculate Addition")
    public static void calculateAddition(WebElement elem1, WebElement elem2) {
        UIActions.clickElement(calcMain.btn_clear);
        UIActions.clickElement(elem1);
        UIActions.clickElement(calcMain.btn_plus);
        UIActions.clickElement(elem2);
        UIActions.clickElement(calcMain.btn_equals);
    }
    @Step("Calculate Subtraction")
    public static void calculateSubtraction(WebElement elem1, WebElement elem2) {
        UIActions.clickElement(calcMain.btn_clear);
        UIActions.clickElement(elem1);
        UIActions.clickElement(calcMain.btn_minus);
        UIActions.clickElement(elem2);
        UIActions.clickElement(calcMain.btn_equals);
    }

    @Step("Calculate Multiplication")
    public static void calculateMultiplication(WebElement elem1, WebElement elem2) {
        UIActions.clickElement(calcMain.btn_clear);
        UIActions.clickElement(elem1);
        UIActions.clickElement(calcMain.btn_multiply);
        UIActions.clickElement(elem2);
        UIActions.clickElement(calcMain.btn_equals);
    }

    @Step("Calculate Division")
    public static void calculateDivision(WebElement elem1, WebElement elem2) {
        UIActions.clickElement(calcMain.btn_clear);
        UIActions.clickElement(elem1);
        UIActions.clickElement(calcMain.btn_divide);
        UIActions.clickElement(elem2);
        UIActions.clickElement(calcMain.btn_equals);
    }

    public static void calculateUsingDDT(String num1, String operation, String num2, String expectedResult) {
        if (operation.equals("+")) {
            calculateAddition(calcMain.buttonsMap(num1), calcMain.buttonsMap(num2));
            Verifications.assertTextContains(expectedResult, calcMain.field_result.getText());
        }
        else if (operation.equals("-")) {
            calculateSubtraction(calcMain.buttonsMap(num1), calcMain.buttonsMap(num2));
            Verifications.assertTextContains(expectedResult, calcMain.field_result.getText());
        }
        else if (operation.equals("*")) {
            calculateMultiplication(calcMain.buttonsMap(num1), calcMain.buttonsMap(num2));
            Verifications.assertTextContains(expectedResult, calcMain.field_result.getText());
        }
        else if (operation.equals(":")) {
            calculateDivision(calcMain.buttonsMap(num1), calcMain.buttonsMap(num2));
            Verifications.assertTextContains(expectedResult, calcMain.field_result.getText());
        }
    }
}
