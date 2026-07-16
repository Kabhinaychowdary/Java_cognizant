package com.abhinay;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyServiceTest {

    @Test
    public void testFetchData() {
        ExternalAPI mockAPI = mock(ExternalAPI.class);

        when(mockAPI.getData()).thenReturn("WELCOME");

        MyService service = new MyService(mockAPI);

        assertEquals("WELCOME", service.fetchData());
    }
}