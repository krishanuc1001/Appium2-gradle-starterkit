package com.tw.driver;

import com.tw.enums.RunMode;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public final class DriverFactory {

    private DriverFactory() {
    }

//    private static Supplier<AndroidDriver> local = () -> {
//        try {
//            return new LocalDriver().getDriver();
//        } catch (MalformedURLException e) {
//            throw new RuntimeException(e);
//        }
//    };

    public static AndroidDriver getDr(RunMode runMode) throws MalformedURLException {
        AndroidDriver androidDriver = null;
        WebDriver driver = null;

        if (runMode.equals(RunMode.LOCAL)) {
            androidDriver = new LocalDriver().getDriver();
        } else if (runMode.equals(RunMode.LOCALBROWSER)) {
            androidDriver = new LocalBrowserDriver().getDriver("chrome");
        } else if (runMode.equals(RunMode.BROWSERSTACK)) {
            androidDriver = new BrowserStackDriver().getDriver();
        } else if (runMode.equals(RunMode.SAUCELABS)) {
            androidDriver = new SauceLabsDriver().getDriver();
        }

        return androidDriver;
    }


}
