package com.example.demo.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class TestableClassTest {

    @Mock
    private DataService dataServiceMock;

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

    @Test
    public void test2() {
        Mockito.when(dataServiceMock.getDataById(ArgumentMatchers.any()))
                .thenReturn("dataItem");
        Assertions.assertNotNull(dataServiceMock.getDataById("f"));
    }

    @Test
    public void test3() {
        Mockito.when(dataServiceMock.getDataById(eq("idValue")))
                .thenReturn("dataItem");
        Assertions.assertEquals("dataItem", dataServiceMock.getDataById("idValue"));
    }

    @Test
    public void test4() {
        Mockito.when(dataServiceMock.getDataById(
                Mockito.argThat(arg -> arg == null || arg.length() > 5)))
                .thenReturn("dataItem");

        Assertions.assertEquals("dataItem", dataServiceMock.getDataById("idValueidValueidValue"));
    }

    @Test
    public void test5() {
        Mockito.when(dataServiceMock.getDataById(eq("invalidId")))
                .thenThrow(new IllegalArgumentException());


        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> dataServiceMock.getDataById("invalidId"));

        assertNotNull(exception);
    }
}