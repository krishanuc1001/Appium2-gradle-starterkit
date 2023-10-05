package com.tw.constants;

import com.tw.utilities.ReadProperties;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FrameworkConstants {

    private static final String PATH_TO_RESOURCES = System.getProperty("user.dir") + "/src/test/resources";
    public static final String APKFILEPATH_APIDEMOS = PATH_TO_RESOURCES + "/apps/ApiDemos-debug.apk";

    @Getter
    private static final String APKFILEPATH_DEMOAPP = PATH_TO_RESOURCES + "/apps/Android-MyDemoAppRN.1.3.0.build-244.apk";

    @Getter
    private static final String CONFIGPROPFILEPATH = PATH_TO_RESOURCES + "/config/config.properties";

    @Getter
    private static final String JSONFILEPATH = PATH_TO_RESOURCES + "/config/device_config1.json";
    @Getter
    private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir") + "/ExtentReports-output/";

    @Getter
    private static final int FLUENTWAITTIME = 30;

    @Getter
    private static final int FLUENTWAITPOLLINGTIME = 1;

    public static final String EXTENTREPORTFILEPATH = createReportPath();

    public static String createReportPath() {
        if (ReadProperties.getValue("overridereports").equalsIgnoreCase("no")) {
            return EXTENTREPORTFOLDERPATH + new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss").format(new Date()) + "/"
                    + new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss").format(new Date()) + "_ExtentReport.html";
        } else {
            return EXTENTREPORTFOLDERPATH + "/" + "ExtentReport.html";
        }
    }

}
