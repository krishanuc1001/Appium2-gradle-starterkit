package com.tw.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;

public class LocalBrowserDriver implements IDriver {

    public AndroidDriver getDriver(String browser) throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .withBrowserName(browser)
                .setDeviceName("Krish_Pixel_4_API_30")
                .skipDeviceInitialization()
                .skipServerInstallation();

        return new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
    }

    @Override
    public AndroidDriver getDriver() throws MalformedURLException {
        return null;
    }
}
