package ru.unn.agile.interpolationsearch.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InterpolationSearchTests {

    @Test
    public void initializeInterpolationSearch() {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7};
        InterpolationSearch interpolationSearch = new InterpolationSearch(array);
        assertEquals(array, interpolationSearch.getArray());
    }

    @Test(expected = NullPointerException.class)
    public void canFindEmptyArray() {
        int[] array = {};
        InterpolationSearch interpolationSearch = new InterpolationSearch(array);
    }

    @Test(expected = NullPointerException.class)
    public void identifyUnsortedArray() {
        int[] array = {0, 9, 5, 3, 6};
        InterpolationSearch interpolationSearch = new InterpolationSearch(array);
        interpolationSearch.checkSortArray();
    }

    @Test
    public void searchKeyInMiddle() {
        int[] array = {0, 1, 2, 3, 5, 6,7};
        int key = 3;
        InterpolationSearch interpolationSearch = new InterpolationSearch(array);
        assertEquals(3, interpolationSearch.interpSearch(key));
    }

    @Test
    public void searchKeyInLeft() {
        int[] array = {0, 1, 2, 3, 5, 6,7};
        int key = 1;
        InterpolationSearch interpolationSearch = new InterpolationSearch(array);
        assertEquals(1, interpolationSearch.interpSearch(key));
    }

    @Test
    public void searchKeyRight() {
        int[] array = {0, 1, 2, 3, 5, 6,7};
        int key = 6;
        InterpolationSearch interpolationSearch = new InterpolationSearch(array);
        assertEquals(5, interpolationSearch.interpSearch(key));
    }

    @Test
    public void searchIsNotKey() {
        int[] array = {0, 1, 2, 3, 5, 6,7};
        int key = 4;
        InterpolationSearch interpolationSearch = new InterpolationSearch(array);
        assertEquals(-1, interpolationSearch.interpSearch(key));
    }




}
