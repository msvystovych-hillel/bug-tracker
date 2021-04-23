package com.example.demo.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

class TestableClassTest {


    @Test
    public void test() {
        DataService dataServiceMock = Mockito.mock(DataService.class);
        Assertions.assertTrue(true);
    }

    @Test
    public void test1() {
        DataService dataServiceMock = Mockito.mock(DataService.class);
        List<String> data = new ArrayList<>();
        data.add("dataItem");
        Mockito.when(dataServiceMock.getData()).thenReturn(data);

        Assertions.assertFalse(data.isEmpty());
    }
}