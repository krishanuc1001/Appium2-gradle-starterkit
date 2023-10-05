package com.tw.utilities;

import com.tw.driver.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static com.tw.extentreporting.ExtentLogger.pass;
import static io.netty.util.internal.PlatformDependent.isAndroid;

public class PageActionsUtils {

    private static final String FINGER1 = "finger1";

    protected String getText(By by) {
        return DriverManager.getDriver().findElement(by).getText();
    }

    protected static void click(By by, String elementName) {
        WebElement element = DriverManager.getDriver().findElement(by);
        element.click();
        pass("<<======= Clicked on ========>> " + elementName, true);
    }

    public static void click(String locatorType, String value, String elementName) {
        if (locatorType.equalsIgnoreCase("xpath")) {
            click(By.xpath(value), elementName);
        } else if (locatorType.equalsIgnoreCase("id")) {
            click(By.id(value), elementName);
        }
    }

    protected void clickAnItemFromListOfWebElements(By by, String elementName) {
        DriverManager.getDriver().findElements(by)
                .parallelStream()
                .filter(e -> e.getText().contains(elementName))
                .findFirst()
                .ifPresent(WebElement::click);
    }

    public static void tap(By by) {
        Point centerOfElement = getCenterOfElement(by);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, FINGER1);
        Sequence sequenceFinger1 = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofSeconds(5)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        ((AppiumDriver) (DriverManager.getDriver())).perform(Collections.singletonList(sequenceFinger1));
    }

    protected static void doubleTap(By by) {
        Point centerOfElement = getCenterOfElement(by);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, FINGER1);
        Sequence sequenceFinger1 = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(100)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(100)))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(100)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        ((AppiumDriver) (DriverManager.getDriver())).perform(Collections.singletonList(sequenceFinger1));
    }

    public static void longPress(By by) {
        Point centerOfElement = getCenterOfElement(by);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, FINGER1);
        Sequence sequenceFinger1 = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofSeconds(2)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        ((AppiumDriver) (DriverManager.getDriver())).perform(Collections.singletonList(sequenceFinger1));
    }

    public static void zoom(By by) {
        Point centerOfElement = getCenterOfElement(by);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, FINGER1);
        PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");

        Sequence sequenceFinger1 = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(200)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(),
                        centerOfElement.getX() + 100, centerOfElement.getY() - 100))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));


        Sequence sequenceFinger2 = new Sequence(finger2, 1)
                .addAction(finger2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
                .addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(200)))
                .addAction(finger2.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(),
                        centerOfElement.getX() - 100, centerOfElement.getY() + 100))
                .addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        ((AppiumDriver) (DriverManager.getDriver())).perform(Arrays.asList(sequenceFinger1, sequenceFinger2));
    }

    public static void performScrollAndClick(By by) {
        Dimension size = DriverManager.getDriver().manage().window().getSize();
        int startX = size.getWidth() / 2;
        int startY = size.getHeight() / 2;
        int endY = (int) (size.getHeight() * 0.25);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, FINGER1);

        Sequence sequenceFinger1 = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(200)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(),
                        startX, endY))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));

        ((AppiumDriver) (DriverManager.getDriver())).perform(Collections.singletonList(sequenceFinger1));

        if (!DriverManager.getDriver().findElements(by).isEmpty()) {
            DriverManager.getDriver().findElement(by).click();
        }
    }

    private static boolean isNotEndOfPage(String previousPageSource) {
        return !previousPageSource.equals(DriverManager.getDriver().getPageSource());
    }

    private static boolean isElementNotEnabled(WebElement element) {
        try {
            return !element.isDisplayed();
        } catch (NoSuchElementException e) {
            return true;
        }
    }

    private static boolean isElementNotEnabled(By by) {
        List<WebElement> elements = DriverManager.getDriver().findElements(by);

        if (isAndroid()) {
            return elements.isEmpty();
        }

        if (!elements.isEmpty()) { // Check for iOS webview
            return elements.get(0).getAttribute("visible").equalsIgnoreCase("false");
        }

        return true;
    }

    public static void dragAndDrop(By source, By target) {
        Point sourceCenter = getCenterOfElement(source);
        Point targetCenter = getCenterOfElement(target);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, FINGER1);

        Sequence sequenceFinger1 = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), sourceCenter))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(500)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(),
                        targetCenter))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        ((AppiumDriver) (DriverManager.getDriver())).perform(Collections.singletonList(sequenceFinger1));
    }

    protected static Point getCenterOfElement(By by) {
        Point location = DriverManager.getDriver().findElement(by).getLocation();
        Dimension size = DriverManager.getDriver().findElement(by).getSize();
        return new Point(location.getX() + size.getWidth() / 2, location.getY() + size.getHeight() / 2);
    }

}
