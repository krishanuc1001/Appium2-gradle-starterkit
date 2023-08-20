package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected AndroidDriver driver;

//    UiAutomator2Options options = new UiAutomator2Options();
//    XCUITestOptions options = new XCUITestOptions();

    @BeforeMethod(alwaysRun = true)
    public void setup(ITestContext context) throws MalformedURLException {
        if (System.getProperty("groups").contains("android")) {
            new UiAutomator2Options()
                    .setDeviceName("Krish_Pixel_4_API_30")
                    .setApp(System.getProperty("user.dir") + "/src/test/resources/apps/Android-MyDemoAppRN.1.3.0.build-244.apk");
        } else {
            new XCUITestOptions()
                    .setDeviceName("iPhone 14 Pro Max")
                    .setApp(System.getProperty("user.dir") + "/src/test/resources/apps/iOS-Simulator-MyRNDemoApp.1.3.0-162.zip");
        }

//        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
    }

    @AfterMethod(alwaysRun = true)
    public void teardown() {
        driver.quit();
    }

}
