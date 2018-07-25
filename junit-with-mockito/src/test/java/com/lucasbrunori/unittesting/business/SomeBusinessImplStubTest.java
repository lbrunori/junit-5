package com.lucasbrunori.unittesting.business;

import com.lucasbrunori.unittesting.data.*;
import org.junit.*;

import static org.junit.Assert.*;

class SomeDataServiceStub implements SomeDataService {
    public int[] retreiveAllData() {
        return new int[]{1, 2, 3};
    }
}

class SomeDataServiceEmptyStub implements SomeDataService {
    public int[] retreiveAllData() {
        return new int[]{};
    }
}

class SomeDataServiceOneElemetStub implements SomeDataService {
    public int[] retreiveAllData() {
        return new int[]{5};
    }
}

public class SomeBusinessImplStubTest {

    @Test
    public void calculateSumUsingDataService_basic() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomedateService(new SomeDataServiceStub());
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;

        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void calculateSumUsingDataService_empty() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomedateService(new SomeDataServiceEmptyStub());
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 0;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumUsingDataService_oneValue() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomedateService(new SomeDataServiceOneElemetStub());
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 5;

        assertEquals(expectedResult, actualResult);
    }
}
