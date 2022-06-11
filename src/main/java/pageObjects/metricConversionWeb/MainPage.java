package pageObjects.metricConversionWeb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class MainPage {

    //------ Upper Blue Selection Menu ------

    @FindBy(how = How.CSS, using = "div[id='typeMenu'] a[title='Temperature Conversion']")
    public WebElement btn_temperature;

    @FindBy(how = How.CSS, using = "div[id='typeMenu'] a[title='Weight Conversion']")
    public WebElement btn_weight;

    @FindBy(how = How.CSS, using = "div[id='typeMenu'] a[title='Length Conversion']")
    public WebElement btn_length;

    @FindBy(how = How.CSS, using = "div[id='typeMenu'] a[title='Speed Conversion']")
    public WebElement btn_speed;


    //------ Lower Grey Selection Menu ------
    @FindBy(how = How.CSS, using = "div[id='mainLinks'] a:has-text(\"km to miles\")")
    public WebElement btn_kmsToMiles;

    @FindBy(how = How.CSS, using = "div[id='mainLinks'] a:has-text(\"mile to kms\")")
    public WebElement btn_milesToKms;

    @FindBy(how = How.CSS, using = "div[id='mainLinks'] a:has-text(\"pounds to kg\")")
    public WebElement btn_poundToKg;

    @FindBy(how = How.CSS, using = "div[id='mainLinks'] a:has-text(\"Feet to Meters\")")
    public WebElement btn_feetToMeters;


}
