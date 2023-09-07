package com.tw.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStackDriver implements IDriver {

    @Override
    public AndroidDriver getDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APP, "bs://ApiDemos-debug.apk");
        capabilities.setCapability("browserstack.user", "**********");
        capabilities.setCapability("browserstack.key", "**********");
        capabilities.setCapability("device", "Samsung Galaxy S22 Ultra");
        capabilities.setCapability("os_version", "12");
        capabilities.setCapability("project", "BS Appium Project");
        capabilities.setCapability("build", "BS Apium Java Android Buid");
        capabilities.setCapability("name", "BrowserStack test");

        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Krish_Pixel_4_API_30");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.appium.android.apis.ApiDemos");

        return new AndroidDriver(new URL("https://hub.browserstack.com/wd/hub"), capabilities);
    }

    @Override
    public AndroidDriver getDriver(String browser) throws MalformedURLException {
        return null;
    }
}
