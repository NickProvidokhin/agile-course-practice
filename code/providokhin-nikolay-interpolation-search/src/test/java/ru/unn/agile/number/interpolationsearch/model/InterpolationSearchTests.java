package ru.unn.agile.number.interpolationsearch.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
    public void notSearchKey() {
        int[] array = {0, 1, 2, 3, 5, 6};
        int key = 4;
        InterpolationSearch interpolationSearch = new InterpolationSearch(array);

        assertEquals(-1, interpolationSearch.interpSearch(key));
    }

}