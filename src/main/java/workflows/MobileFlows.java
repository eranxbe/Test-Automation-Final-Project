package workflows;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.MobileActions;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utilities.CommonOps;
import java.util.concurrent.TimeUnit;

public class MobileFlows extends CommonOps {

    public static void swipeLeftForTimes(int times) {
        for (int i = 0; i < times; i++){
            MobileActions.swipeScreen(MobileActions.Direction.LEFT);
            Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        }
    }

    public static void swipeRightForTimes(int times) {
        for (int i = 0; i < times; i++) {
            MobileActions.swipeScreen(MobileActions.Direction.RIGHT);
            Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        }
    }

    @Step("Navigate to Tab")
    public static void navigateTo(AndroidElement tab) {
        tab.click();
    }

    @Step("Select conversion type, parameters, and value")
    public static void convert(AndroidElement type, String convertFrom, String convertTo, String value) {
        MobileFlows.navigateTo(mobileMenuBar.tab_convert);
        type.click();
        searchAndSelectConversionFromList(convertFrom);
        searchAndSelectConversionFromList(convertTo);
        mobileConvPage.input_conversionArgument.click();
        mobileConvPage.input_conversionArgument.sendKeys(value);
        mobileConvPage.btn_convert.click();

    }

    @Step("Search conversion parameter from list and select")
    public static void searchAndSelectConversionFromList(String option) {
        mobileConvMenu.txt_search.sendKeys(option);
        mobileConvMenu.option_from_search.click();
    }

    @Step("Add conversion as favorite")
    public static void addAsFavorite() {
        mobileConvPage.btn_add_favorite.click();
    }

    @Step("Get Conversion from-to title")
    public static String getConversionTitle() {
       return mobileConvPage.txt_from_to.getText();
    }

    @Step("Get favorite element by text")
    public static MobileElement getFavoriteElement(String text) {
        return  (MobileElement) mobileDriver.findElement(By.xpath(String.format("//*[@id='list']//*[@text='%s']", text)));
    }

    @Step("Click delete favorite")
    public static void deleteFavorite() {
        mobileFavoritesPage.btn_deleteFavorite.click();
    }

    @Step("Click delete favorite")
    public static void deleteHistory() {
        mobileHistoryPage.btn_deleteHistory.click();
    }
}
