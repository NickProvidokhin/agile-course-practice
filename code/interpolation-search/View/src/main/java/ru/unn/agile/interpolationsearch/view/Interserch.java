package ru.unn.agile.interpolationsearch.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ru.unn.interpolationsearch.viewmodel.ViewModel;

import java.io.IOException;

public class Interserch {
    @FXML
    private ViewModel viewModel;
    @FXML
    private TextField arrInput;
    @FXML
    private TextField keyInput;
    @FXML
    private Button button;
    @FXML
    private Label labelStatus;
    @FXML
    private Label labelResult;
    void initialize() {
        arrInput.textProperty().bindBidirectional(viewModel.arrInputProperty());
        keyInput.textProperty().bindBidirectional(viewModel.keyInputProperty());
        labelStatus.textProperty().bindBidirectional(viewModel.statusProperty());
        labelResult.textProperty().bindBidirectional(viewModel.resultProperty());

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {
                viewModel.interSearch();
            }
        });
    }
}
