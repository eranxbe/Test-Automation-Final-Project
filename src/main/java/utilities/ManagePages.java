package utilities;

import org.openqa.selenium.support.PageFactory;
import pageObjects.metricConversionWeb.BMIPage;
import pageObjects.metricConversionWeb.MainPage;
import pageObjects.metricConversionWeb.ConvPage;
import pageObjects.metricConversionWeb.TopToolbar;


//Initializing variables using PageFactory
public class ManagePages extends Base {

    public static void initMetricConversionWeb() {
        webMainPage = PageFactory.initElements(driver, MainPage.class);
        topToolbar = PageFactory.initElements(driver, TopToolbar.class);
        convPage = PageFactory.initElements(driver, ConvPage.class);
        bmiPage = PageFactory.initElements(driver, BMIPage.class);
    }

    public static void initMetricConversionMobile() {
        mobileMainPage = new pageObjects.metricConversionMobile.MainPage(mobileDriver);
        mobileMenuBar = new pageObjects.metricConversionMobile.MenuBar(mobileDriver);
        mobileConvPage = new pageObjects.metricConversionMobile.ConvPage(mobileDriver);
        mobileConvMenu = new pageObjects.metricConversionMobile.ConvMenu(mobileDriver);
        mobileFavoritesPage = new pageObjects.metricConversionMobile.FavoritesPage(mobileDriver);
        mobileHistoryPage = new pageObjects.metricConversionMobile.HistoryPage(mobileDriver);
    }

    public static void initElectron() {
        todoMain = PageFactory.initElements(driver, pageObjects.todoElectron.todoMain.class);
    }

    public static void initCalculator() {
        calcMain = PageFactory.initElements(driver, pageObjects.calculator.MainPage.class);
    }
}
