package com.tw.extentreporting;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.tw.utilities.ReadProperties;
import com.tw.utilities.ScreenshotUtils;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ExtentLogger {

    public static void pass(String message) {
        ExtentManager.getExtentDriver().pass(message);
    }

    public static void pass(String message, boolean isScreenshotNeeded) {

        if (ReadProperties.getValue("passedstepsscreenshots").equalsIgnoreCase("yes")
                && isScreenshotNeeded) {

            ExtentManager.getExtentDriver().pass(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        } else {
            pass(message);
        }

    }

    public static void fail(String message) {
        ExtentManager.getExtentDriver().fail(message);
    }

    public static void fail(String message, boolean isScreenshotNeeded) {

        if (ReadProperties.getValue("failedstepsscreenshots").equalsIgnoreCase("yes")
                && isScreenshotNeeded) {

            ExtentManager.getExtentDriver().fail(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());

        } else {
            fail(message);
        }
    }

    public static void skip(String message) {
        ExtentManager.getExtentDriver().skip(message);
    }

    public static void skip(String message, boolean isScreenshotNeeded) {

        if (ReadProperties.getValue("skippedstepsscreenshots").equalsIgnoreCase("yes")
                && isScreenshotNeeded) {

            ExtentManager.getExtentDriver().skip(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());

        } else {
            skip(message);
        }
    }

}
