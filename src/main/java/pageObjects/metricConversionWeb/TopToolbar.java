package pageObjects.metricConversionWeb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class TopToolbar {

    @FindBy(how = How.CSS, using = "nav a[class='home']")
    public WebElement btn_home;

    @FindBy(how = How.CSS, using = "nav a[class='sitemap']")
    public WebElement btn_siteMap;

    @FindBy(how = How.CSS, using = "nav a[class='contact']")
    public WebElement btn_contact;

    @FindBy(how = How.CSS, using = "nav a[class='links']")
    public WebElement btn_links;

    @FindBy(how = How.XPATH, using = "//aside[@id='language']/select")
    public WebElement dropdown_language;

    @FindBy(how = How.CSS, using = "a[class='home']")
    public WebElement button_home;

    @FindBy (how = How.CSS, using = "div[id=\"logo\"]")
    public WebElement logo;



}
