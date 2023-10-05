package com.tw.pages;

import com.tw.driver.DriverManager;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import com.tw.utilities.PageActionsUtils;

public class HomePage extends PageActionsUtils {

    public HomePage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }

    private static final By views = By.xpath("//android.widget.TextView[contains(@text, 'Views')]");
    private static final By menuItems = By.xpath("//android.widget.TextView");

    public ViewsLandingPage clickViews() {
        click(views, "Views");
        return new ViewsLandingPage();
    }

    public void clickMenuItem(String menu) {
        clickAnItemFromListOfWebElements(menuItems, menu);
    }

}
