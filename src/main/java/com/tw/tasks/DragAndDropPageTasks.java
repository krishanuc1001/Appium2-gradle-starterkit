package com.tw.tasks;

import com.tw.pages.DragAndDropPage;
import com.tw.pages.HomePage;

public class DragAndDropPageTasks {

    public DragAndDropPageTasks navigateToDragAndDrop() {
        new HomePage()
                .clickViews()
                .clickAMenuItem("Drag and Drop");
        return this;
    }

    public DragAndDropPage getDragAndDropPage() {
        return new DragAndDropPage();
    }

}
