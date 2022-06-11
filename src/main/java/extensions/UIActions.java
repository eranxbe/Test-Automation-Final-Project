package extensions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilities.CommonOps;

import java.util.concurrent.TimeUnit;


public class UIActions extends CommonOps {

    @Step("Click Element")
    public static void clickElement(WebElement elem){
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }

    @Step("Click element and fill text")
    public static void fillText(WebElement elem, String text) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(text);
    }

    @Step("Click element and fill text")
    public static void insertKey(WebElement elem, Keys key) {
        elem.sendKeys(key);
    }

    @Step("Click element and fill text as human")
    public static void fillTextAsHuman(WebElement elem, String text) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        for (char ch: text.toCharArray()) {
            Uninterruptibles.sleepUninterruptibly(300, TimeUnit.MILLISECONDS);
            elem.sendKeys(ch + "");
        }

    }

    @Step("Select from a dropdown by value")
    public static void selectFromDropDownByValue(WebElement elem, String option) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        Select dropdown = new Select(elem);
        dropdown.selectByValue(option);
    }

    @Step("Select from a dropdown by text")
    public static void selectFromDropDownByText(WebElement elem, String text) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        Select dropdown = new Select(elem);
        dropdown.selectByVisibleText(text);
    }

    @Step("Mouse hover over 2 elements")
    public static void mouseHover(WebElement elem1, WebElement elem2) {
        action.moveToElement(elem1).moveToElement(elem2).click().build().perform();
    }

    @Step("Mouse hover over 1 element")
    public static void mouseHover(WebElement elem1) {
        action.moveToElement(elem1).click().build().perform();
    }

    @Step("Return to home page")
    public static void returnHome () {
        if (!driver.getCurrentUrl().equals(getData("url"))) {
            driver.navigate().to(getData("url"));
        }
    }

    @Step("Paste using ctrl + v")
    public static void pasteWithCtrlV() {
        action.sendKeys(Keys.chord(Keys.LEFT_CONTROL, "v")).build().perform();
    }

    //this method closes the white ad popup, it's used in some specific scenarios on the web part
    public static void disableWeirdMessage() {
        WebElement x = driver.findElement(By.cssSelector("span[class=\"ezmob-footer-close\"]"));
        if (x.isEnabled()) {
            x.click();
        }
    }
}
