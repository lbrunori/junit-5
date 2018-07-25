package com.lucasbrunori.unittesting.business;

import org.junit.*;
import org.mockito.*;

import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ListMockTest {

    List<String> mock = mock(List.class);

    @Test
    public void size_basic(){
        when(mock.size())
                .thenReturn(5);
        assertEquals(5, mock.size());
    }

    @Test
    public void returnDifferentValues(){
        when(mock.size())
                .thenReturn(5)
                .thenReturn(10);
        assertEquals(5,mock.size());
        assertEquals(10,mock.size());
    }

    @Test
    public void returnWithParameters(){
        when(mock.get(0))
                .thenReturn("lucas-brunori");
        assertEquals("lucas-brunori", mock.get(0));
        assertEquals(null, mock.get(1));
    }

    @Test
    public void returnWithGenericParameters(){
        when(mock.get(anyInt()))
                .thenReturn("lucas-brunori");
        assertEquals("lucas-brunori", mock.get(0));
        assertEquals("lucas-brunori", mock.get(1));
    }

    @Test
    public void verificationBasics() {
        String value1 = mock.get(0);
        String value2 = mock.get(1);


        verify(mock).get(0);
        verify(mock,times(2)).get(anyInt());
        verify(mock,atLeast(1)).get(anyInt());
        verify(mock,atMost(2)).get(anyInt());
        verify(mock, never()).get(2);
    }

    @Test
    public void argumentCapturing(){
        //SUT
        mock.add("SomeString");

        //verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());

        assertEquals("SomeString", captor.getValue());
    }

    @Test
    public void argumentCapturing_capturingMultipleValues(){
        //SUT
        mock.add("SomeString1");
        mock.add("SomeString2");

        //verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock, times(2)).add(captor.capture());

        List<String> values = captor.getAllValues();
        assertEquals("SomeString1", values.get(0));
        assertEquals("SomeString2", values.get(1));
    }

    @Test
    public void spying(){
        ArrayList arrayListSpy = spy(ArrayList.class);

        arrayListSpy.add("Test0");

        System.out.println(arrayListSpy.get(0)); // -> null
        System.out.println(arrayListSpy.size()); // -> 1

        System.out.println(arrayListSpy.add("Test"));
        System.out.println(arrayListSpy.add("Test2"));
        System.out.println(arrayListSpy.size());

        when(arrayListSpy.size()).thenReturn(5);
        System.out.println(arrayListSpy.size());

        arrayListSpy.add("Test4");
        System.out.println(arrayListSpy.size());

        verify(arrayListSpy).add("Test4)");
    }

}
