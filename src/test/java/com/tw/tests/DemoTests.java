package com.tw.tests;

import base.BaseTest;
import com.tw.driver.DriverManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.PageActionsUtils;

import java.net.MalformedURLException;
import java.net.URL;

@Test
public class DemoTests extends BaseTest {

    @Test
    public void tapTest() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Krish_Pixel_4_API_30");
        options.setApp(System.getProperty("user.dir") + "/src/test/resources/apps/Android-MyDemoAppRN.1.3.0.build-244.apk");

        AndroidDriver androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        WebElement openMenu = DriverManager.getDriver().findElement(AppiumBy.accessibilityId("open menu"));
        PageActionsUtils.tap(openMenu, androidDriver);
    }

    @Test(groups = "longPress")
    public void verifyLongPress() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Krish_Pixel_4_API_30");
        options.setApp(System.getProperty("user.dir") + "/src/test/resources/apps/ApiDemos-debug.apk");

        AndroidDriver androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        androidDriver.findElement(AppiumBy.accessibilityId("Views")).click();
        androidDriver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
        androidDriver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();

        WebElement peopleName = androidDriver.findElement(AppiumBy.xpath(".//*[@text='People Names']"));

        // Method 1: Using Sequence class
        PageActionsUtils.longPress(peopleName, androidDriver);

        // Method 2: Using Actions class
         new Actions(androidDriver).clickAndHold(peopleName).perform();
    }

}
