package com.tw.pages;

import org.openqa.selenium.By;
import com.tw.utilities.PageActionsUtils;

import static com.tw.utilities.DynamicXpathUtil.getXPath;

public class ViewsLandingPage extends PageActionsUtils {

    private static final String GENERIC_XPATH = "//android.widget.TextView[@content-desc='%s']";
    private static final By radioGroup = By.xpath("//android.widget.TextView[@content-desc='Radio Group']");

    public void clickAMenuItem(String menuName) {
        String myXpath = getXPath(GENERIC_XPATH, menuName);
        click("xpath", myXpath, menuName);
    }

    public void scrollAndClickRadioGroup() {
        performScrollAndClick(radioGroup);
    }

}
