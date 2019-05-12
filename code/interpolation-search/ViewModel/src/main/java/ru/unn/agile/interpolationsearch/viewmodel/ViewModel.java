package ru.unn.agile.interpolationsearch.viewmodel;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.StringProperty;
import ru.unn.agile.interpolationsearch.model.ExeptionWrongArrray;
import ru.unn.agile.interpolationsearch.model.InterpolationSearch;
import java.util.ArrayList;
import java.util.List;

public class ViewModel {
    private final StringProperty arrInput = new SimpleStringProperty();
    private final StringProperty keyInput = new SimpleStringProperty();
    private final StringProperty status = new SimpleStringProperty();
    private final StringProperty result = new SimpleStringProperty();
    private final BooleanProperty searchDisabled = new SimpleBooleanProperty();
    private InterpolationSearch search;
    private int key;
    private boolean arrayCorrect;
    private boolean elementCorrect;
    private final List<ValChanList> valueChangedListeners = new ArrayList<>();
    private ILogger logg;
    public ViewModel() {
        arrInput.set("");
        keyInput.set("");
        status.set("");
        result.set("");
        arrayCorrect = false;
        elementCorrect = false;
        BooleanBinding couldSearch = new BooleanBinding() {
            {
                super.bind(arrInput, keyInput);
            }
            @Override
            protected boolean computeValue() {
                return arrayCorrect && elementCorrect;
            }
        };
        searchDisabled.bind(couldSearch.not());

        final List<StringProperty> fields = new ArrayList<StringProperty>() { {
            add(arrInput);
            add(keyInput);
        }};
        for (StringProperty field: fields) {
            final ValChanList listener = new ValChanList();
            field.addListener(listener);
            valueChangedListeners.add(listener);
        }
    }
    private class ValChanList implements ChangeListener<String> {
        @Override
        public void changed(final ObservableValue<? extends String> observable,
                            final String oldValue, final String newValue) {
            status.set(getStatus().toString());
        }
    }
    public final void setLogger(final ILogger loger) {
        if (logg == null) {
            throw new IllegalArgumentException("Logger param can't be null");
        }
        this.logg = loger;
    }
    public StringProperty arrInputProperty() {
        return arrInput;
    }
    public StringProperty keyInputProperty() {
        return keyInput;
    }
    public StringProperty statusProperty() {
        return status;
    }
    public StringProperty resultProperty() {
        return result;
    }
    public void setKeyInputProperty(final String input) {
        keyInput.set(input);
    }
    public String getArrayInputProperty() {
        return arrInput.get();
    }

    public String getkeyInputProperty() {
        return keyInput.get();
    }

    public String getStatusProperty() {
        return status.get();
    }

    public void setArrayInputProperty(final String input) {
        arrInput.set(input);
    }

    public int[] getIntepolationSearchArray() {
        return search.getArray();
    }

    private void setResultProperty(final String res) {
        result.set(res);
    }
    public String getResultProperty() {
        return result.get();
    }
    public void interSearch() {
        if (searchDisabled.get()) {
            return;
        }
        int position = search.interpSearch(key);
        if (position == -1) {
            setResultProperty("Key not found");
        } else {
            setResultProperty("Position key, index " + Integer.toString(position));
        }
    }
    public boolean isSearchDisabled() {
        return searchDisabled.get();
    }
    public Status getStatus() {
        Status status = Status.READY;
        try {
            String[] str = arrInput.get().split(",");
            int[] mas = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                mas[i] = Integer.parseInt(str[i]);
            }
            arrayCorrect = true;
            search = new InterpolationSearch(mas);
        } catch (NumberFormatException nfe) {
            status = Status.WRONG_FORMAT_ARR;
        } catch (ExeptionWrongArrray bae) {
            status = Status.NOT_SORT_ARRAY;
        }
        try {
            key = Integer.parseInt(keyInput.get());
            elementCorrect = true;
        } catch (NumberFormatException nfe) {
            status = Status.WRONG_FORMAT_ELEMENT;
        }
        return status;
    }

}
enum Status {
    READY("Press  button"),
    WRONG_FORMAT_ARR("Enter array of ints"),
    NOT_SORT_ARRAY("Array must be sorted"),
    WRONG_FORMAT_ELEMENT("Enter key to be searched");
    private final String res;

    Status(final String res) {
        this.res = res;
    }

    public String toString() {
        return res;
    }
}
