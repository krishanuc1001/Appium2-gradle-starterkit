package com.tw.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;

public class LocalDriver implements IDriver {

    @Override
    public AndroidDriver getDriver() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Krish_Pixel_4_API_30");
        options.setApp(System.getProperty("user.dir") + "/src/test/resources/apps/Android-MyDemoAppRN.1.3.0.build-244.apk");
        return new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
    }

    @Override
    public AndroidDriver getDriver(String browser) throws MalformedURLException {
        return null;
    }
}
