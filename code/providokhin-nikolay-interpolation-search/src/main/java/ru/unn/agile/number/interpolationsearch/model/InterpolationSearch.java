package ru.unn.agile.number.interpolationsearch.model;

public class InterpolationSearch {

    public int size;
    public int[] array;

    public InterpolationSearch(final int[] _array) {
        if (_array.length != 0) {
            array = _array;
            size = _array.length;
        } else {
            throw new NullPointerException("Size of array is null");
        }
    }

    public int[] getArray() {
        return array;
    }

    public boolean checkSortArray() {
        for (int i = 0; i < size-1; i++) {
            if (array[i] > array[i-1]) {
                throw new NullPointerException("Array don't sort");
            }
        }
        return true;
    }
    public int interpSearch(int elementToSearch) {

        int startIndex = 0;
        int lastIndex = size - 1;

        if(checkSortArray()){
            while ((startIndex <= lastIndex) && (elementToSearch >= array[startIndex]) &&
                (elementToSearch <= array[lastIndex])) {
            int pos = startIndex + (((lastIndex-startIndex) /
                    (array[lastIndex]-array[startIndex]))*
                    (elementToSearch - array[startIndex]));

            if (array[pos] == elementToSearch)
                return pos;

            if (array[pos] < elementToSearch)
                startIndex = pos + 1;

            else
                lastIndex = pos - 1;
            }
        }
        return -1;
    }
}