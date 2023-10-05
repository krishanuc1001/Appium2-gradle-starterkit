package com.tw.utilities;

import com.tw.driver.DriverManager;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ScreenshotUtils {

    public static String getBase64Image() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }

}
