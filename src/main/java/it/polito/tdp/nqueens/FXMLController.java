package it.polito.tdp.nqueens;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.nqueens.model.Model;
import it.polito.tdp.nqueens.model.ModelInfoTransport;
import it.polito.tdp.nqueens.model.board.Board;
import it.polito.tdp.nqueens.model.board.Position;
import it.polito.tdp.nqueens.model.pieces.Piece;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FXMLController {

	Model model;

	List<Board> doneBoards;

	int currentBoard = 1;
	
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
	private VBox vBoxChess;
	
	@FXML
	private Button btnNext;
	
	@FXML
	private Button btnPrev;

	@FXML
	void doCalculate(ActionEvent event) {
		
		this.doneBoards = model.solveProblem(new ModelInfoTransport((int) sliderBoard.getValue(),
				spinnerKing.getValue(), spinnerQueen.getValue(), spinnerRook.getValue(), spinnerBishop.getValue(),
				spinnerKnight.getValue(), spinnerPawn.getValue()));
		
		lblNum1.setText("0");
		lblNum2.setText("0");
		btnPrev.setDisable(true);
		btnNext.setDisable(true);
		
		if (this.doneBoards.size() != 0) {
			this.currentBoard = 1;
			
			this.showBoard(this.doneBoards.get(currentBoard - 1));
			
			
			if(this.doneBoards.size() > 1) {
				btnNext.setDisable(false);
			}
		} else {
			this.clearGrid();
			vBoxChess.getChildren().add(new Label("NO SOLUTION FOUND"));
		}
		
		

	}

	@FXML
	void doNext(ActionEvent event) {
		this.currentBoard++;
		this.showBoard(this.doneBoards.get(currentBoard - 1));
		
		if (this.currentBoard == this.doneBoards.size()) {
			btnNext.setDisable(true);
		}
		
		btnPrev.setDisable(false);
	}

	@FXML
	void doPrevious(ActionEvent event) {
		this.currentBoard--;
		this.showBoard(this.doneBoards.get(currentBoard - 1));
		
		if (this.currentBoard == 1) {
			btnPrev.setDisable(true);
		}
		
		btnNext.setDisable(false);
	}
	
	@FXML
	void showBoard(Board b) {
		lblNum1.setText(String.valueOf(this.currentBoard));
		lblNum2.setText(String.valueOf(this.doneBoards.size()));
		this.clearGrid();
		for (int i = b.getBoardSize(); i > 0; i--) {
			HBox hb = new HBox();
			for (int j = 0; j < b.getBoardSize(); j++) {
				Position pos = new Position(i-1, j);
				Piece p = b.getPiece(pos);
				Image image;
				if (p != null) {
					File f = new File(Config.IMAGE_DIR + p.getPathToImage());
					image = new Image(f.toURI().toString());
				} else {
					File f = new File(Config.IMAGE_DIR + "empty.png");
					image = new Image(f.toURI().toString());
				}
				ImageView iv = new ImageView();
				iv.setImage(image);
				iv.setFitWidth(Config.CHESSBOARD_WIDTH/b.getBoardSize());
				iv.setPreserveRatio(true);
				iv.setSmooth(true);
				iv.setCache(true);
				hb.getChildren().add(iv);
			}
			vBoxChess.getChildren().add(hb);
		}
	}

	void clearGrid() {

		vBoxChess.getChildren().clear();

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
		assert vBoxChess != null : "fx:id=\"vBoxChess\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnNext != null : "fx:id=\"btnCalculate\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnPrev != null : "fx:id=\"btnCalculate\" was not injected: check your FXML file 'Scene.fxml'.";


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
		
		
		//Disable buttons
		btnNext.setDisable(true);
		btnPrev.setDisable(true);

	}

	void setModel(Model model) {
		this.model = model;
	}
}
