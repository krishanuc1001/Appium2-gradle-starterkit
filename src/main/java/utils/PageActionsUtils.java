package utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;

public class PageActionsUtils {

    private PageActionsUtils() {
    }

    private static final String FINGER1 = "finger1";

    public static void tap(WebElement element, AndroidDriver androidDriver) {
        Point centerOfElement = getCenterOfElement(element);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, FINGER1);
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofSeconds(5)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        androidDriver.perform(Collections.singletonList(sequence));
    }

    public static void doubleTap(WebElement element, AndroidDriver androidDriver) {
        Point centerOfElement = getCenterOfElement(element);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, FINGER1);
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(100)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(100)))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(100)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        androidDriver.perform(Collections.singletonList(sequence));
    }

    public static void longPress(WebElement element, AndroidDriver androidDriver) {
        Point centerOfElement = getCenterOfElement(element);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, FINGER1);
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofSeconds(2)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        androidDriver.perform(Collections.singletonList(sequence));
    }

    public static void zoom(WebElement element, AndroidDriver androidDriver) {
        Point centerOfElement = getCenterOfElement(element);

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

        androidDriver.perform(Arrays.asList(sequenceFinger1, sequenceFinger2));
    }

    public static void verticalScroll(AndroidDriver androidDriver) {
        Dimension size = androidDriver.manage().window().getSize();
        int startX = size.getWidth() / 2;
        int startY = size.getHeight() / 2;
        int endY = (int) (size.getHeight() * 0.25);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, FINGER1);

        Sequence sequenceFinger1 = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(200)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(),
                        startX, endY))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        androidDriver.perform(Collections.singletonList(sequenceFinger1));
    }

    public static void dragDrop(WebElement source, WebElement target, AndroidDriver androidDriver) {
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

        androidDriver.perform(Collections.singletonList(sequenceFinger1));
    }

    public static Point getCenterOfElement(WebElement element) {
        Point location = element.getLocation();
        Dimension size = element.getSize();
        return new Point(location.getX() + size.getWidth() / 2, location.getY() + size.getHeight() / 2);
    }

}
