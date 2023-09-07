package base;

import com.tw.driver.Driver;
import io.appium.java_client.android.AndroidDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public class BaseTest {

    protected AndroidDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp(ITestContext context) throws MalformedURLException {

        Driver.initDriver();


//        if (System.getProperty("groups").contains("android")) {
//            new UiAutomator2Options()
//                    .setDeviceName("Krish_Pixel_4_API_30")
//                    .setApp(System.getProperty("user.dir") + "/src/test/resources/apps/Android-MyDemoAppRN.1.3.0.build-244.apk");
//        } else {
//            new XCUITestOptions()
//                    .setDeviceName("iPhone 14 Pro Max")
//                    .setApp(System.getProperty("user.dir") + "/src/test/resources/apps/iOS-Simulator-MyRNDemoApp.1.3.0-162.zip");
//        }

//        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        Driver.quitDriver();
    }

}
