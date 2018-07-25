package com.lucasbrunori.unittesting.business;

import com.lucasbrunori.unittesting.data.*;
import org.junit.*;
import org.junit.runner.*;
import org.mockito.*;
import org.mockito.junit.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessImplMockTest {

    @InjectMocks
    SomeBusinessImpl business = new SomeBusinessImpl();

    @Mock
    SomeDataService dataServiceMock = mock(SomeDataService.class);

    @Test
    public void calculateSumUsingDataService_basic() {
        when(dataServiceMock.retreiveAllData())
                .thenReturn(new int[]{1,2,3});

        assertEquals(6, business.calculateSumUsingDataService());

    }

    @Test
    public void calculateSumUsingDataService_empty() {
        when(dataServiceMock.retreiveAllData())
                .thenReturn(new int[] {});

        assertEquals(0, business.calculateSumUsingDataService());
    }

    @Test
    public void calculateSumUsingDataService_oneValue() {
        when(dataServiceMock.retreiveAllData())
                .thenReturn(new int[]{5});

        assertEquals(5, business.calculateSumUsingDataService());
    }

}
