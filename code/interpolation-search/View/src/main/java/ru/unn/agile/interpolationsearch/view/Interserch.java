package ru.unn.agile.interpolationsearch.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import ru.unn.agile.interpolationsearch.viewmodel.ViewModel;
import ru.unn.agile.interpolationsearch.infrastructure.TxtLogger;


import java.io.IOException;

public class Interserch {
    private static final String LOG_PATH = "log";
    @FXML
    private ViewModel viewModel;
    @FXML
    private TextField arrInput;
    @FXML
    private TextField keyInput;
    @FXML
    private Button button;
    @FXML
    private Label labelStat;
    @FXML
    private Label labelRes;
    @FXML
    private TextArea txtArea;
    void initialize() {
        try {
            TxtLogger txtLogger = new TxtLogger(LOG_PATH);
            viewModel.setLogger(txtLogger);
        } catch (IOException e) {
            e.printStackTrace();
        }
        arrInput.textProperty().bindBidirectional(viewModel.arrInputProperty());
        keyInput.textProperty().bindBidirectional(viewModel.keyInputProperty());
        labelStat.textProperty().bindBidirectional(viewModel.statusProperty());
        labelRes.textProperty().bindBidirectional(viewModel.resultProperty());

        txtArea.textProperty().bindBidirectional(viewModel.logProperty());

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {
                viewModel.interSearch();
            }
        });
    }
}
