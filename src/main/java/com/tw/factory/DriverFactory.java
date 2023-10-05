package com.tw.factory;

import com.tw.driver.BrowserStackDriver;
import com.tw.driver.LocalBrowserDriver;
import com.tw.driver.LocalDriver;
import com.tw.driver.SauceLabsDriver;
import com.tw.enums.RunMode;
import com.tw.exceptions.FrameworkException;
import io.appium.java_client.AppiumDriver;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.net.MalformedURLException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DriverFactory {

    public static AppiumDriver getDr(RunMode runMode) throws MalformedURLException {
        AppiumDriver driver;

        if (runMode.equals(RunMode.LOCAL)) {
            driver = new LocalDriver().getDriver();
        } else if (runMode.equals(RunMode.LOCALBROWSER)) {
            driver = new LocalBrowserDriver().getDriver("chrome");
        } else if (runMode.equals(RunMode.BROWSERSTACK)) {
            driver = new BrowserStackDriver().getDriver();
        } else if (runMode.equals(RunMode.SAUCELABS)) {
            driver = new SauceLabsDriver().getDriver();
        } else {
            throw new FrameworkException("<<======= Run mode " + runMode + "provided is not configured =======>");
        }

        return driver;
    }


}
