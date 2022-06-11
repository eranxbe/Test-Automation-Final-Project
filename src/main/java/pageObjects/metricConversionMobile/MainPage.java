package pageObjects.metricConversionMobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class MainPage {

    private AppiumDriver mobileDriver;

    public MainPage(AppiumDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, Duration.ofSeconds(3)), this);
    }

    @AndroidFindBy(xpath = "//*[@text='Temperature']")
    public AndroidElement btn_temp;

    @AndroidFindBy(xpath = "//*[@text='Length']")
    public AndroidElement btn_length;

    @AndroidFindBy(xpath = "//*[@text='Weight']")
    public AndroidElement btn_weight;

    @AndroidFindBy(xpath = "//*[@text='Time']")
    public AndroidElement btn_time;

    @AndroidFindBy(xpath = "//*[@text='Currency']")
    public AndroidElement btn_currency;

}
