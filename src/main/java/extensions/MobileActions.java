package extensions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class MobileActions extends UIActions {

    @Step("Tap on element")
    public static void tap(MobileElement elem){
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        TouchAction touchAction = new TouchAction(mobileDriver);
        touchAction.tap(new TapOptions().withElement(ElementOption.element(elem))).perform();
    }

    @Step("Swipe")
    public static void swipeScreen(Direction dir) {
        System.out.println("swipeScreen(): dir: '" + dir + "'"); // always log your actions


        final int ANIMATION_TIME = 200; // ms

        final int PRESS_TIME = 200; // ms

        int edgeBorder = 10; // better avoid edges
        PointOption pointOptionStart, pointOptionEnd;

        // init screen variables
        Dimension dims = driver.manage().window().getSize();

        // init start point = center of screen
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

        switch (dir) {
            case DOWN: // center of footer
                pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
                break;
            case UP: // center of header
                pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
                break;
            case LEFT: // center of left side
                pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
                break;
            case RIGHT: // center of right side
                pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
        }

        // execute swipe using TouchAction
        try {
            new TouchAction(mobileDriver)
                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        // always allow swipe action to complete
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
            // ignore
        }
    }

    @Step("Pinch element")
    public static void pinch(MobileElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        int x = elem.getLocation().getX() + elem.getSize().getWidth() / 2;
        int y = elem.getLocation().getY() + elem.getSize().getHeight() / 2;
        TouchAction finger1 = new TouchAction(mobileDriver);
        finger1.press(new ElementOption().withElement(elem)
                .withCoordinates(x, y - 100)).moveTo(new ElementOption()
                .withElement(elem)
                .withCoordinates(x,y - 10));

        TouchAction finger2 = new TouchAction(mobileDriver);
        finger1.press(new ElementOption().withElement(elem)
                .withCoordinates(x, y + 100)).moveTo(new ElementOption()
                .withElement(elem)
                .withCoordinates(x, y + 10));

        MultiTouchAction multiTouchAction = new MultiTouchAction(mobileDriver);
        multiTouchAction.add(finger1).add(finger2).perform();
    }

    @Step("Zoom element")
    public static void zoom(MobileElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        int x = elem.getLocation().getX() + elem.getSize().getWidth() / 2;
        int y = elem.getLocation().getY() + elem.getSize().getHeight() / 2;
        TouchAction finger1 = new TouchAction(mobileDriver);
        finger1.press(new ElementOption().withElement(elem)
                .withCoordinates(x, y + 100)).moveTo(new ElementOption()
                .withElement(elem)
                .withCoordinates(x,y + 10));

        TouchAction finger2 = new TouchAction(mobileDriver);
        finger1.press(new ElementOption().withElement(elem)
                .withCoordinates(x, y - 100)).moveTo(new ElementOption()
                .withElement(elem)
                .withCoordinates(x, y - 10));

        MultiTouchAction multiTouchAction = new MultiTouchAction(mobileDriver);
        multiTouchAction.add(finger1).add(finger2).perform();
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT;
    }

    @Step("Drag and drop")
    public static void dragAndDropElement(MobileElement start, MobileElement finish){
        TouchAction action = new TouchAction(mobileDriver);
        action.moveTo(new ElementOption()
                        .withElement(start)).moveTo(new ElementOption()
                        .withElement(finish))
                .release()
                .perform();

    }

    @Step("Get Locator using visible text")
    public static String getLocatorByVisibleText(String text) {
        return String.format("//*[@text='%s']",text);
    }



}
