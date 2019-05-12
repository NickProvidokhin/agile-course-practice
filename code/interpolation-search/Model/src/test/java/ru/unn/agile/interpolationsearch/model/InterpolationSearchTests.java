package ru.unn.agile.interpolationsearch.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InterpolationSearchTests {

    @Test
    public void initializeInterpolationSearch() throws ExeptionWrongArrray {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7};
        InterpolationSearch interpolationSearch = new InterpolationSearch(array);
        assertEquals(array, interpolationSearch.getArray());
    }

    @Test(expected = ExeptionWrongArrray.class)
    public void canFindEmptyArray() throws ExeptionWrongArrray {
        int[] array = {};
        InterpolationSearch interpolationSearch = new InterpolationSearch(array);
    }

    @Test(expected = ExeptionWrongArrray.class)
    public void identifyUnsortedArray()throws ExeptionWrongArrray {
        int[] array = {0, 9, 5, 3, 6};
        InterpolationSearch interpolationSearch = new InterpolationSearch(array);
        interpolationSearch.checkSortArray();
    }

    @Test
    public void searchKeyInMiddle() throws ExeptionWrongArrray {
        int[] array = {0, 1, 2, 3, 5, 6, 7};
        int key = 3;
        InterpolationSearch interpolationSearch = new InterpolationSearch(array);
        assertEquals(3, interpolationSearch.interpSearch(key));
    }

    @Test
    public void searchKeyInLeft() throws ExeptionWrongArrray {
        int[] array = {0, 1, 2, 3, 5, 6, 7};
        int key = 1;
        InterpolationSearch interpolationSearch = new InterpolationSearch(array);
        assertEquals(1, interpolationSearch.interpSearch(key));
    }

    @Test
    public void searchKeyRight() throws ExeptionWrongArrray {
        int[] array = {0, 1, 2, 3, 5, 6, 7};
        int key = 6;
        InterpolationSearch interpolationSearch = new InterpolationSearch(array);
        assertEquals(5, interpolationSearch.interpSearch(key));
    }

    @Test
    public void searchIsNotKey() throws ExeptionWrongArrray {
        int[] array = {0, 1, 2, 3, 5, 6, 7};
        int key = 4;
        InterpolationSearch interpolationSearch = new InterpolationSearch(array);
        assertEquals(-1, interpolationSearch.interpSearch(key));
    }




}
