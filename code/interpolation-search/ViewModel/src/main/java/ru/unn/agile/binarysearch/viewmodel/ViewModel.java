package ru.unn.agile.binarysearch.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import ru.unn.agile.interpolationsearch.model.InterpolationSearch;

public class ViewModel {
    private final StringProperty arrInput = new SimpleStringProperty();
    private final StringProperty keyInput = new SimpleStringProperty();
    private final StringProperty status = new SimpleStringProperty();
    private final StringProperty result = new SimpleStringProperty();

    private final String READY="Press Search";
    private final String NOT_RIGHT_ARRAY_FORMAT="Enter array of ints";
    private final String NOT_SORT_ARRAY="Array must be sorted";
    private final String NO_ELEMENT="Enter key to be searched";

    private InterpolationSearch search;
    private int key;

    public ViewModel() {
        arrInput.set("");
        keyInput.set("");
        status.set("");
        result.set("");
    }


}
