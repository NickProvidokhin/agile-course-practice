package ru.unn.agile.interpolationsearch.viewmodel;

import org.junit.Before;

import java.io.IOException;

import static org.junit.Assert.*;

public class ViewModelTests {
    private ViewModel viewModel;
    private ILogger logg;
    public void createViewModelWithLogger(final ILogger logg) {
        viewModel = new ViewModel();
        viewModel.setLogger(logg);
    }

    @Before
    public void  setUp() throws IOException {
        logg = new FakeLogger();
        this.createViewModelWithLogger(logg);
    }
    public void doInitArray() {
        ViewModel viewModel = new ViewModel();

        assertEquals("", viewModel.getArrayInputProperty());
    }
    public void doInitElement() {
        ViewModel viewModel = new ViewModel();

        assertEquals("", viewModel.getkeyInputProperty());
    }
    public void canSetArrayValue() {
        ViewModel viewModel = new ViewModel();
        int[] expected = new int[] {0, 2, 3};

        viewModel.setArrayInputProperty("0,2,3");

        assertArrayEquals(expected, viewModel.getIntepolationSearchArray());
    }
    public void canSearchKey() {
        ViewModel viewModel = new ViewModel();

        viewModel.setArrayInputProperty("1,2,3");
        viewModel.setKeyInputProperty("2");
        viewModel.interSearch();

        assertEquals(viewModel.getResultProperty(), viewModel.resultProperty().get());
    }
    public void canGetStatus() {
        ViewModel viewModel = new ViewModel();

        viewModel.setKeyInputProperty("wrong str");

        assertEquals(viewModel.getStatusProperty(), viewModel.statusProperty().get());
    }

}
