package pageObjects.metricConversionWeb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BMIPage {

    @FindBy(how = How.CSS, using = "input[id=\"argumentConv2-2\"]")
    public WebElement txt_cm;

    @FindBy(how = How.CSS, using = "input[id=\"argumentConv4-1\"]")
    public WebElement txt_kg;

    @FindBy(how = How.CSS, using = "[id=\"result\"] p")
    public WebElement txt_bmiResult;

    @FindBy(how = How.XPATH, using = "//div/a[@class=\"convert greenButton\"]")
    public WebElement btn_goBMI;
}
