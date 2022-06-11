package pageObjects.metricConversionWeb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ConvPage {


    @FindBy(how = How.CSS, using = "a[href=\"/length/meters-to-feet.htm\"]")
    public WebElement btn_meters2feet;

    @FindBy(how = How.CSS, using = "a[href=\"/length/centimeters-to-inches.htm\"]")
    public WebElement btn_cm2inch;

    @FindBy(how = How.CSS, using = "a[href=\"/weight/pounds-to-kilograms.htm\"]")
    public WebElement btn_lbs2kg;

    @FindBy(how = How.CSS, using = "a[href=\"href=\"/weight/kilograms-to-pounds.htm\"]")
    public WebElement btn_kg2lbs;

    @FindBy(how = How.CSS, using = "a[href=\"/temperature/fahrenheit-to-celsius.htm\"]")
    public WebElement btn_far2cel;

    @FindBy(how = How.CSS, using = "a[href=\"/temperature/celsius-to-fahrenheit.htm\"]")
    public WebElement btn_cel2far;

    @FindBy(how = How.CSS, using = "input[name=\"argumentConv\"]")
    public WebElement txt_convertArgument;

    @FindBy(how = How.CSS, using = "p[id=\"answer\"]")
    public WebElement txt_convAnswer;

    @FindBy(how = How.CSS, using = "select[id=\"format\"]")
    public WebElement select_format;

    @FindBy(how = How.CSS, using = "select[id=\"sigfig\"]")
    public WebElement select_accuracy;

    @FindBy(how = How.CSS, using = "a[href=\"/health-conversion.htm\"]")
    public WebElement btn_healthWellbeing;

}
