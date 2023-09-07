package android;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.util.concurrent.Uninterruptibles;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utils.PageActionsUtils;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

@Test(groups = "mobTests")
public class SampleTests {

    ExtentReports extentReports;

    @BeforeSuite
    public void setup() {
        extentReports = new ExtentReports();
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/ExtentReports/index.html");
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setReportName("Automation Report");
        extentSparkReporter.config().setDocumentTitle("Appium Extent Report");

        extentReports.attachReporter(extentSparkReporter);
    }

    @Test(groups = "androidTest")
    public void verifyLaunchPageAndroid() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Krish_Pixel_4_API_30");
        options.setApp(System.getProperty("user.dir") + "/src/test/resources/apps/Android-MyDemoAppRN.1.3.0.build-244.apk");

        ExtentTest extentTest = extentReports.createTest("Appium test");

        AndroidDriver androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        androidDriver.findElement(AppiumBy.accessibilityId("open menu")).click();
        androidDriver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='menu item log in']")).click();

        androidDriver.findElement(AppiumBy.accessibilityId("Username input field")).sendKeys("bob@example.com");
        androidDriver.findElement(AppiumBy.accessibilityId("Password input field")).sendKeys("10203040");
        androidDriver.findElement(AppiumBy.accessibilityId("Login button")).click();

        extentTest.pass("<<============== User logged in ==============>>");
        extentTest.pass(MediaEntityBuilder.
                createScreenCaptureFromBase64String(((TakesScreenshot) androidDriver).getScreenshotAs(OutputType.BASE64)).build());

    }

    @Test(groups = "iOSTest")
    public void verifyLaunchPageIOS() throws MalformedURLException {
        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone 14 Pro Max");
        options.setApp(System.getProperty("user.dir") + "/src/test/resources/apps/iOS-Simulator-MyRNDemoApp.1.3.0-162.zip");

        IOSDriver iosDriver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);

        iosDriver.findElement(AppiumBy.accessibilityId("tab bar option menu")).click();
        iosDriver.findElement(AppiumBy.accessibilityId("menu item log in")).click();

        iosDriver.findElement(AppiumBy.accessibilityId("Username input field")).sendKeys("bob@example.com");
        iosDriver.findElement(AppiumBy.accessibilityId("Password input field")).sendKeys("10203040");
        iosDriver.findElement(AppiumBy.accessibilityId("Login button")).click();

    }

    @Test(groups = "tapTest")
    public void verifyTapAction() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Krish_Pixel_4_API_30");
        options.setApp(System.getProperty("user.dir") + "/src/test/resources/apps/Android-MyDemoAppRN.1.3.0.build-244.apk");

        AndroidDriver androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        WebElement openMenu = androidDriver.findElement(AppiumBy.accessibilityId("open menu"));
        PageActionsUtils.tap(openMenu, androidDriver);
    }

    @Test(groups = "longPressTest")
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

    @Test(groups = "zoomTest")
    public void verifyZoom() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Krish_Pixel_4_API_30");
        options.setApp(System.getProperty("user.dir") + "/src/test/resources/apps/Android-MyDemoAppRN.1.3.0.build-244.apk");

        AndroidDriver androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        androidDriver.findElement(AppiumBy.accessibilityId("open menu")).click();
        androidDriver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='menu item drawing']")).click();

        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(1));

        WebElement drawingScreen = androidDriver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"drawing screen\"]/android.view.ViewGroup[2]/android.view.ViewGroup/android.webkit.WebView"));

        PageActionsUtils.zoom(drawingScreen, androidDriver);
    }

    @Test(groups = "verticalScrollTest")
    public void verifySwipeScroll() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Krish_Pixel_4_API_30");
        options.setApp(System.getProperty("user.dir") + "/src/test/resources/apps/ApiDemos-debug.apk");

        AndroidDriver androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        androidDriver.findElement(AppiumBy.accessibilityId("Views")).click();

//        PageActionsUtils.verticalScroll(androidDriver);

        androidDriver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UISelector()).scrollIntoView(text(\"Radio Group\"))"));

    }

    @Test(groups = "dragDropTest")
    public void verifyDragDrop() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Krish_Pixel_4_API_30");
        options.setApp(System.getProperty("user.dir") + "/src/test/resources/apps/ApiDemos-debug.apk");

        AndroidDriver androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        androidDriver.findElement(AppiumBy.accessibilityId("Views")).click();
        androidDriver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();

        WebElement source = androidDriver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
        WebElement target = androidDriver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_2"));

        PageActionsUtils.dragDrop(source, target, androidDriver);

        String actualDropMessage = androidDriver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_result_text")).getText().trim();

        Assert.assertEquals(actualDropMessage, "Dropped!", "The drag and drop is unsuccessful");
    }

    @Test(groups = "bsAppTest")
    public void browserStackTest(Method method) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APP, "bs://ApiDemos-debug.apk");
        capabilities.setCapability("browserstack.user", "krishanuchakrabo_rze2Zn");
        capabilities.setCapability("browserstack.key", "u6s21DfkU3FYqxthXS2P");
        capabilities.setCapability("device", "Samsung Galaxy S22 Ultra");
        capabilities.setCapability("os_version", "12");
        capabilities.setCapability("project", "BS Appium Project");
        capabilities.setCapability("build", "BS Apium Java Android Buid");
        capabilities.setCapability("name", method.getName());

        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Krish_Pixel_4_API_30");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.appium.android.apis.ApiDemos");

        AndroidDriver androidDriver = new AndroidDriver(new URL("https://hub.browserstack.com/wd/hub"), capabilities);
        androidDriver.findElement(AppiumBy.accessibilityId("Views")).click();
    }

    @Test(groups = "browserTest")
    public void browserTest() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .withBrowserName("Chrome")
                .setDeviceName("Krish_Pixel_4_API_30")
                .skipDeviceInitialization()
                .skipServerInstallation();

        AndroidDriver androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        androidDriver.get("https://www.selenium.dev");
        System.out.println("Page Title: " + androidDriver.getTitle());
    }

    @AfterSuite
    public void tearDown() {
        extentReports.flush();
    }
}
