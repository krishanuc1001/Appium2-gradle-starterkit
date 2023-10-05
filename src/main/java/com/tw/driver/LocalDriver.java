package com.tw.driver;

import com.tw.constants.FrameworkConstants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class LocalDriver implements IDriver {

    @Override
    public AppiumDriver getDriver() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Krish_Pixel_4_API_30");
//        options.setApp(FrameworkConstants.getAPKFILEPATH_DEMOAPP());
        options.setApp(FrameworkConstants.APKFILEPATH_APIDEMOS);
        return new AppiumDriver(new URL("http://127.0.0.1:4723"), options);
    }

    @Override
    public AppiumDriver getDriver(Map<String, String> map) throws MalformedURLException {
        return null;
    }

    @Override
    public AppiumDriver getDriver(String browser, Map<String, String> map) throws MalformedURLException {
        return null;
    }
}
