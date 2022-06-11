package utilities;

import extensions.UIActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;
import workflows.ElectronFlows;
import java.lang.reflect.Method;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;


//Common Operations such as initializing browsers, drivers, sessions
public class CommonOps extends Base {

    public static String getData(String nodeName) {
        File fXmlFile;
        DocumentBuilderFactory dbFactory;
        DocumentBuilder dBuilder;
        Document doc = null;
        try {
            fXmlFile = new File("./Configuration/DataConfig.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

        } catch (Exception e) {
            System.out.println("Error reading XML file: " + e);
        } finally {
           return doc.getElementsByTagName(nodeName).item(0).getTextContent();
        }

    }

    public static void initBrowser(String browserName){
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = initChromeDriver();
        }
        else if (browserName.equalsIgnoreCase("firefox")) {
            driver = initFirefoxDriver();
        }
        else if (browserName.equalsIgnoreCase("ie")) {
            driver = initIEDriver();
        }
        else {
            throw new RuntimeException("Invalid browser name");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Integer.parseInt(getData("Timeout")));
        driver.get(getData("url"));
        ManagePages.initMetricConversionWeb();
        action = new Actions(driver);

    }

    public static WebDriver initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public static WebDriver initFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    public static WebDriver initIEDriver() {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }

    public static void initMobile() {
        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("AppPackage"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("AppActivity"));
        try {
            mobileDriver = new AndroidDriver<>(new URL(getData("AppiumServer")), dc);
        } catch (Exception e) {
            System.out.println("Error while trying to connect to Appium server: " + e) ;
        }
        ManagePages.initMetricConversionMobile();
        mobileDriver.manage().timeouts().implicitlyWait(Integer.parseInt(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(mobileDriver, Integer.parseInt(getData("Timeout")));

    }

    public static void initAPI() {
        RestAssured.baseURI = getData("urlAPI");
        request = RestAssured.given();
    }

    public static void initElectron() {
        System.setProperty("webdriver.chrome.driver", getData("electronDriverPath"));
        ChromeOptions opt = new ChromeOptions();
        opt.setBinary(getData("electronAppPath"));
        dc.setBrowserName("chrome");
        dc.setCapability("chromeOptions", opt);
        driver = new ChromeDriver(dc);
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Integer.parseInt(getData("Timeout")));
        ManagePages.initElectron();
        action = new Actions(driver);

    }

    public static void initDesktop() {
        dc.setCapability("app", getData("CalculatorApp"));
        try {
            driver = new WindowsDriver(new URL(getData("AppiumServerDesktop")), dc);
        } catch (Exception e) {
            System.out.println("Can't connect to appium server, " + e);
        }

        ManagePages.initCalculator();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Integer.parseInt(getData("Timeout")));

    }


    @BeforeClass
    @Parameters({"PlatformName"})
    public void startSession(String PlatformName) {
        platform = PlatformName;
        if (platform.equalsIgnoreCase("web")) {
            initBrowser(getData("BrowserName"));
        }
        else if (platform.equalsIgnoreCase("mobile")) {
            initMobile();
        }
        else if (platform.equalsIgnoreCase("api")) {
            initAPI();
        }
        else if (platform.equalsIgnoreCase("electron")) {
            initElectron();
        }
        else if (platform.equalsIgnoreCase("desktop")) {
            initDesktop();
        }
        else {
            throw new RuntimeException("Invalid platform name");
        }
        softAssert = new SoftAssert();
        screen = new Screen();
        ManageDB.startConnection(getData("DBUrl"), getData("DBUsername"), getData("DBPassword"));

    }

    @BeforeMethod
    public void beforeMethod(Method method) throws Exception {
        if (!platform.equalsIgnoreCase("api")) {
            MonteScreenRecorder.startRecord(method.getName());
        }

    }

    @AfterMethod
    public void afterMethod() {
        if (platform.equalsIgnoreCase("web")) {
            UIActions.returnHome();
        }
        else if (platform.equalsIgnoreCase("electron")) {
            ElectronFlows.removeAllTasks();
        }
    }


    @AfterClass
    public void endSession() {
        ManageDB.endConnection();
        if (!platform.equalsIgnoreCase("api")) {
            if (!platform.equalsIgnoreCase("mobile")) {
                driver.quit();
            }
            else {
                mobileDriver.quit();
            }
        }

    }

}
