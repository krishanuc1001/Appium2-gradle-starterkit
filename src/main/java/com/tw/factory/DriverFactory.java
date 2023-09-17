package com.tw.factory;

import com.tw.driver.BrowserStackDriver;
import com.tw.driver.LocalBrowserDriver;
import com.tw.driver.LocalDriver;
import com.tw.driver.SauceLabsDriver;
import com.tw.enums.RunMode;
import io.appium.java_client.AppiumDriver;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.net.MalformedURLException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DriverFactory {

//    private static Supplier<AndroidDriver> local = () -> {
//        try {
//            return new LocalDriver().getDriver();
//        } catch (MalformedURLException e) {
//            throw new RuntimeException(e);
//        }
//    };

    public static AppiumDriver getDr(RunMode runMode) throws MalformedURLException {
        AppiumDriver driver = null;

        if (runMode.equals(RunMode.LOCAL)) {
            driver = new LocalDriver().getDriver();
        } else if (runMode.equals(RunMode.LOCALBROWSER)) {
            driver = new LocalBrowserDriver().getDriver("chrome");
        } else if (runMode.equals(RunMode.BROWSERSTACK)) {
            driver = new BrowserStackDriver().getDriver();
        } else if (runMode.equals(RunMode.SAUCELABS)) {
            driver = new SauceLabsDriver().getDriver();
        }

        return driver;
    }


}
