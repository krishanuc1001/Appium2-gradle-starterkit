package com.tw.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class BrowserStackDriver implements IDriver {

    @Override
    public AppiumDriver getDriver(Map<String, String> map) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        map.forEach(capabilities::setCapability);
        capabilities.setCapability(MobileCapabilityType.APP, "bs://ApiDemos-debug.apk");
        capabilities.setCapability("browserstack.user", "**********");
        capabilities.setCapability("browserstack.key", "**********");
        capabilities.setCapability("project", "BS Appium Project");
        capabilities.setCapability("build", "BS Appium Build");
        capabilities.setCapability("name", "BrowserStack test");

        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.appium.android.apis.ApiDemos");

        capabilities.asMap().forEach((k, v) -> System.out.println(k + ":" + v));

        return new AppiumDriver(new URL("https://hub.browserstack.com/wd/hub"), capabilities);
    }

    @Override
    public AppiumDriver getDriver() throws MalformedURLException {
        return null;
    }


    @Override
    public AppiumDriver getDriver(String browser, Map<String, String> map) throws MalformedURLException {
        return null;
    }
}
