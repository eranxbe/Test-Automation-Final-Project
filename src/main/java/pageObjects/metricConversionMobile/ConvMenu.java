package pageObjects.metricConversionMobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ConvMenu {
    private AppiumDriver mobileDriver;

    public ConvMenu(AppiumDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, Duration.ofSeconds(3)), this);
    }

    @AndroidFindBy(xpath = "//*[@id='search']")
    public AndroidElement txt_search;

    @AndroidFindBy(xpath = "//*[@id='list']/*[@index=\"0\"]")
    public AndroidElement option_from_search;

}
