package ru.unn.agile.interpolationsearch.model;

public class InterpolationSearch {

    private int[] array;

    public int[] getArray() {
        return array;
    }

    public InterpolationSearch(final int[] paramArray) {
        if (paramArray.length != 0) {
            array = paramArray;
        } else {
            throw new NullPointerException("Size of array is null");
        }
    }

    public boolean checkSortArray() {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                throw new NullPointerException("Array don't sort");
            }
        }
        return true;
    }

    public int interpSearch(final int elementToSearch) {

        int startIndex = 0;
        int lastIndex = array.length - 1;

        if (checkSortArray()) {
            while ((elementToSearch >= array[startIndex])
                    && (elementToSearch <= array[lastIndex])) {
                int pos = startIndex + ((elementToSearch - array[startIndex])
                * (lastIndex - startIndex))
                        / (array[lastIndex] - array[startIndex]);

                if (array[pos] == elementToSearch) {
                    return pos;
                }

                if (array[pos] < elementToSearch) {
                    startIndex = pos + 1;
                } else {
                    lastIndex = pos - 1;
                }
            }

        }
        return -1;
    }

}
