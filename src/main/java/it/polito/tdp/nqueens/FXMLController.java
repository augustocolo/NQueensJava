package it.polito.tdp.nqueens;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.layout.GridPane;

public class FXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Slider sliderBoard;

    @FXML
    private Spinner<?> spinnerKing;

    @FXML
    private Spinner<?> spinnerQueen;

    @FXML
    private Spinner<?> spinnerRook;

    @FXML
    private Spinner<?> spinnerBishop;

    @FXML
    private Spinner<?> spinnerKnight;

    @FXML
    private Spinner<?> spinnerPawn;

    @FXML
    private Label lblBoard;

    @FXML
    private Label lblPieces;

    @FXML
    private Button btnCalculate;

    @FXML
    private Label lblNum;

    @FXML
    private GridPane gridBoard;

    @FXML
    void doCalculate(ActionEvent event) {

    }

    @FXML
    void doNext(ActionEvent event) {

    }

    @FXML
    void doPrevious(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert sliderBoard != null : "fx:id=\"sliderBoard\" was not injected: check your FXML file 'Scene.fxml'.";
        assert spinnerKing != null : "fx:id=\"spinnerKing\" was not injected: check your FXML file 'Scene.fxml'.";
        assert spinnerQueen != null : "fx:id=\"spinnerQueen\" was not injected: check your FXML file 'Scene.fxml'.";
        assert spinnerRook != null : "fx:id=\"spinnerRook\" was not injected: check your FXML file 'Scene.fxml'.";
        assert spinnerBishop != null : "fx:id=\"spinnerBishop\" was not injected: check your FXML file 'Scene.fxml'.";
        assert spinnerKnight != null : "fx:id=\"spinnerKnight\" was not injected: check your FXML file 'Scene.fxml'.";
        assert spinnerPawn != null : "fx:id=\"spinnerPawn\" was not injected: check your FXML file 'Scene.fxml'.";
        assert lblBoard != null : "fx:id=\"lblBoard\" was not injected: check your FXML file 'Scene.fxml'.";
        assert lblPieces != null : "fx:id=\"lblPieces\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCalculate != null : "fx:id=\"btnCalculate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert lblNum != null : "fx:id=\"lblNum\" was not injected: check your FXML file 'Scene.fxml'.";
        assert gridBoard != null : "fx:id=\"gridBoard\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
