package utilities;

import io.appium.java_client.AppiumDriver;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


//Declaring Objects

public class Base {

    //General
    protected static WebDriverWait wait;
    protected static Actions action;
    protected static SoftAssert softAssert;
    protected static Screen screen;
    protected static String platform;

    //Web
    protected static WebDriver driver;

    //Mobile
    protected static AppiumDriver mobileDriver;
    protected static DesiredCapabilities dc = new DesiredCapabilities();

    //Rest API
    protected static RequestSpecification request;
    protected static Response response;
    protected static JSONObject params = new JSONObject();
    protected static JsonPath jp;


    //Page objects  - web
    protected static pageObjects.metricConversionWeb.MainPage webMainPage;
    protected static pageObjects.metricConversionWeb.TopToolbar topToolbar;
    protected static pageObjects.metricConversionWeb.ConvPage convPage;
    protected static pageObjects.metricConversionWeb.BMIPage bmiPage;

    //Page objects - mobile
    protected static pageObjects.metricConversionMobile.MainPage mobileMainPage;
    protected static pageObjects.metricConversionMobile.MenuBar mobileMenuBar;
    protected static pageObjects.metricConversionMobile.ConvPage mobileConvPage;
    protected static pageObjects.metricConversionMobile.ConvMenu mobileConvMenu;
    protected static pageObjects.metricConversionMobile.FavoritesPage mobileFavoritesPage;
    protected static pageObjects.metricConversionMobile.HistoryPage mobileHistoryPage;

    //Page objects - electron
    protected static pageObjects.todoElectron.todoMain todoMain;

    //Page objects - desktop
    protected static pageObjects.calculator.MainPage calcMain;

    //Database
    protected static Connection con;
    protected static Statement stmt;
    protected static ResultSet rs;


}
