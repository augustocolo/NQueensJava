package it.polito.tdp.nqueens.model.pieces;

import java.util.function.Function;

public class Queen extends VariableMovementPiece {

	public Queen() {
		super();
		this.moves.add((Integer boardSize) -> {
			Integer[] aa = { boardSize, boardSize };
			return aa;
		});
		this.moves.add((Integer boardSize) -> {
			Integer[] aa = { boardSize, -boardSize };
			return aa;
		});
		this.moves.add((Integer boardSize) -> {
			Integer[] aa = { -boardSize, boardSize };
			return aa;
		});
		this.moves.add((Integer boardSize) -> {
			Integer[] aa = { -boardSize, -boardSize };
			return aa;
		});
		this.moves.add((Integer boardSize) -> {
			Integer[] aa = { boardSize, 0 };
			return aa;
		});
		this.moves.add((Integer boardSize) -> {
			Integer[] aa = { -boardSize, 0 };
			return aa;
		});
		this.moves.add((Integer boardSize) -> {
			Integer[] aa = { 0, boardSize };
			return aa;
		});
		this.moves.add((Integer boardSize) -> {
			Integer[] aa = { 0, -boardSize };
			return aa;
		});
		
		this.pathToImage = "112072-chess/png/queen.png";

	}

	@Override
	public String toString() {
		return "Queen";
	}
	
	

}
