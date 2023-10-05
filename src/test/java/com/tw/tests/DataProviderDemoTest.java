package com.tw.tests;

import base.BaseTest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tw.constants.FrameworkConstants;
import com.tw.tasks.DragAndDropPageTasks;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class DataProviderDemoTest extends BaseTest {

    @Test(dataProvider = "getData")
    public void verifyDragAndDropWithDataProvider() {
        String actualMessage = new DragAndDropPageTasks()
                .navigateToDragAndDrop()
                .getDragAndDropPage()
                .performDragAndDrop()
                .getDragAndDropSuccessMessage();

        assertThat(actualMessage)
                .isEqualTo("Dropped!");
    }

    @DataProvider(parallel = true)
    public Object[] getData() throws IOException {
        List<Map<String, String>> dataList = new ObjectMapper().readValue(
                new File(FrameworkConstants.getJSONFILEPATH()),
                new TypeReference<>() {
                });

        return dataList.toArray();
    }

}
