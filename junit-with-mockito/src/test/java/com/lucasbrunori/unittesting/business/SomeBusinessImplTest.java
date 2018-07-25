package com.lucasbrunori.unittesting.business;

import org.junit.*;

import static org.junit.Assert.*;

public class SomeBusinessImplTest {



    @Test
    public void calculateSum_basic(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[] { 1 , 2, 3});
        int expectedResult = 6;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSum_empty(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[] {});
        int expectedResult = 0;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSum_oneValue(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[] {5});
        int expectedResult = 5;

        assertEquals(expectedResult, actualResult);
    }
}
