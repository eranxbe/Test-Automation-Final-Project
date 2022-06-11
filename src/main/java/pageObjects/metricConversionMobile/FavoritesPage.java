package pageObjects.metricConversionMobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class FavoritesPage {

    private AppiumDriver mobileDriver;

    public FavoritesPage(AppiumDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, Duration.ofSeconds(3)), this);
    }

    @AndroidFindBy(id = "favorite_delete_button")
    public AndroidElement btn_deleteFavorite;

}
