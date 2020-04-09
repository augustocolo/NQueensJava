package it.polito.tdp.nqueens;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.nqueens.model.Model;
import it.polito.tdp.nqueens.model.ModelInfoTransport;
import it.polito.tdp.nqueens.model.board.Board;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.GridPane;

public class FXMLController {

	Model model;
	
	List<Board> doneBoards;
	
	int currentBoard = 1;
	
	int currentGridSize = 8;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Slider sliderBoard;

	@FXML
	private Spinner<Integer> spinnerKing;

	@FXML
	private Spinner<Integer> spinnerQueen;

	@FXML
	private Spinner<Integer> spinnerRook;

	@FXML
	private Spinner<Integer> spinnerBishop;

	@FXML
	private Spinner<Integer> spinnerKnight;

	@FXML
	private Spinner<Integer> spinnerPawn;

	@FXML
	private Label lblBoard;

	@FXML
	private Label lblPieces;

	@FXML
	private Button btnCalculate;

	@FXML
	private Label lblNum1;

	@FXML
	private Label lblNum2;

	@FXML
	private GridPane gridBoard;

	@FXML
	void doCalculate(ActionEvent event) {
		/*this.doneBoards = model.solveProblem(new ModelInfoTransport((int) sliderBoard.getValue(),
				spinnerKing.getValue(), spinnerQueen.getValue(), spinnerRook.getValue(), spinnerBishop.getValue(),
				spinnerKnight.getValue(), spinnerPawn.getValue()));*/
		this.clearGrid();
		
	}

	@FXML
	void doNext(ActionEvent event) {

	}

	@FXML
	void doPrevious(ActionEvent event) {

	}
	
	void showBoard(Board b) {
		
	}
	
	void clearGrid() {
		while (this.currentGridSize != 0) {
			currentGridSize--;
			gridBoard.getChildren().removeIf(node -> GridPane.getRowIndex(node) == this.currentGridSize);
		}
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
		assert lblNum1 != null : "fx:id=\"lblNum\" was not injected: check your FXML file 'Scene.fxml'.";
		assert lblNum2 != null : "fx:id=\"lblNum\" was not injected: check your FXML file 'Scene.fxml'.";
		assert gridBoard != null : "fx:id=\"gridBoard\" was not injected: check your FXML file 'Scene.fxml'.";

		// Configure spinners
		SpinnerValueFactory<Integer> kingVF = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Config.NUM_PIECES,
				0, 1);
		spinnerKing.setValueFactory(kingVF);
		SpinnerValueFactory<Integer> queenVF = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Config.NUM_PIECES,
				0, 1);
		spinnerQueen.setValueFactory(queenVF);
		SpinnerValueFactory<Integer> rookVF = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Config.NUM_PIECES,
				0, 1);
		spinnerRook.setValueFactory(rookVF);
		SpinnerValueFactory<Integer> bishopVF = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Config.NUM_PIECES,
				0, 1);
		spinnerBishop.setValueFactory(bishopVF);
		SpinnerValueFactory<Integer> knightVF = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Config.NUM_PIECES,
				0, 1);
		spinnerKnight.setValueFactory(knightVF);
		SpinnerValueFactory<Integer> pawnVF = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Config.NUM_PIECES,
				0, 1);
		spinnerPawn.setValueFactory(pawnVF);

		// CHANGE LISTENERS

		sliderBoard.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
				lblBoard.textProperty().setValue(String.valueOf(newValue.intValue()));
			};
		});

		ChangeListener<Number> cl2 = new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
				int previous = Integer.parseInt(lblPieces.getText());
				int modify = newValue.intValue() - oldValue.intValue();
				lblPieces.textProperty().setValue(String.valueOf(previous + modify));
			};
		};

		spinnerKing.valueProperty().addListener(cl2);
		spinnerQueen.valueProperty().addListener(cl2);
		spinnerRook.valueProperty().addListener(cl2);
		spinnerBishop.valueProperty().addListener(cl2);
		spinnerKnight.valueProperty().addListener(cl2);
		spinnerPawn.valueProperty().addListener(cl2);

	}

	void setModel(Model model) {
		this.model = model;
	}
}
