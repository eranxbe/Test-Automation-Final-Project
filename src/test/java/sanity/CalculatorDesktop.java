package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.DesktopFlows;


public class CalculatorDesktop extends CommonOps {

    @Test(description = "Test 01 - Calculate Addition of Numbers")
    @Description("This test adds 2 numbers and validates result")
    public void test01_validateAdditionCommand()  {
        DesktopFlows.calculateAddition(calcMain.btn_one, calcMain.btn_eight);
        Verifications.assertTextContains("9", calcMain.field_result.getText());
    }

    @Test(description = "Test 02 - Calculate Using DDT", dataProvider = "data-provider-calculator", dataProviderClass = utilities.ManageDDT.class)
    @Description("This test calculates various equations using DDT file")
    public void test02_calculateUsingDDT(String num1, String operation, String num2, String expectedAnswer) {

        DesktopFlows.calculateUsingDDT(num1, operation, num2, expectedAnswer);

    }
}
