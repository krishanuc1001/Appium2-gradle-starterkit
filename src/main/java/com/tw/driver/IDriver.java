package com.tw.driver;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;

public interface IDriver {

    public AndroidDriver getDriver() throws MalformedURLException;
    public AndroidDriver getDriver(String browser) throws MalformedURLException;
}
