package pageObjects.metricConversionMobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class MenuBar {

    private AppiumDriver mobileDriver;

    public MenuBar(AppiumDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, Duration.ofSeconds(3)), this);
    }

    @AndroidFindBy(xpath = "//*[@contentDescription='Convert']")
    public AndroidElement tab_convert;

    @AndroidFindBy(xpath = "//*[@contentDescription='History']")
    public AndroidElement tab_history;

    @AndroidFindBy(xpath = "//*[@contentDescription='Favorites']")
    public AndroidElement tab_favorites;

    @AndroidFindBy(xpath = "//*[@contentDescription='About']")
    public AndroidElement tab_about;

}
