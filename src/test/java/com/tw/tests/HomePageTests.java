package com.tw.tests;

import base.BaseTest;
import com.tw.pages.HomePage;
import com.tw.tasks.DragAndDropPageTasks;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Test
public class HomePageTests extends BaseTest {

    HomePage homePage = new HomePage();

    @Test(groups = "dragDrop")
    public void verifyDragAndDrop() {
        String actualMessage = new DragAndDropPageTasks()
                .navigateToDragAndDrop()
                .getDragAndDropPage()
                .performDragAndDrop()
                .getDragAndDropSuccessMessage();

        assertThat(actualMessage)
                .isEqualTo("Dropped!");

    }

    @Test
    public void tapFirstMenu() {
        homePage.clickMenuItem("Drag and Drop");
    }

    @Test(groups = "verticalScrollTest")
    public void verifySwipeScroll() {
        homePage.clickViews()
                .scrollAndClickRadioGroup();
    }

}
