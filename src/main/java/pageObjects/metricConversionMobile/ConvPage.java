package pageObjects.metricConversionMobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ConvPage {

    private AppiumDriver mobileDriver;

    public ConvPage(AppiumDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, Duration.ofSeconds(3)), this);
    }

    @AndroidFindBy(className = "android.widget.EditText")
    public AndroidElement input_conversionArgument;

    @AndroidFindBy(id = "question_and_answer_text")
    public AndroidElement txt_answer;

    @AndroidFindBy(id = "button_convert")
    public AndroidElement btn_convert;

    @AndroidFindBy(id = "add_favorites_button")
    public AndroidElement btn_add_favorite;

    @AndroidFindBy(id = "from_to_text")
    public AndroidElement txt_from_to;




}
