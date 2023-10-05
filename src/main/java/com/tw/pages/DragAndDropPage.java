package com.tw.pages;

import org.openqa.selenium.By;
import com.tw.utilities.PageActionsUtils;

public class DragAndDropPage extends PageActionsUtils {

    private static final By source = By.id("io.appium.android.apis:id/drag_dot_1");
    private static final By target = By.id("io.appium.android.apis:id/drag_dot_2");
    private static final By dropConfirmMessage = By.id("io.appium.android.apis:id/drag_result_text");

    public DragAndDropPage performDragAndDrop() {
        dragAndDrop(source, target);
        return this;
    }

    public String getDragAndDropSuccessMessage() {
        return getText(dropConfirmMessage);
    }

}
