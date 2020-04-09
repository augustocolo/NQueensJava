package it.polito.tdp.nqueens.model.pieces;

public class Knight extends FixedMovementPiece {

	public Knight() {
		super();
		this.moves.add((Integer boardSize) -> {
			Integer[] aa = { 2, 1 };
			return aa;
		});
		this.moves.add((Integer boardSize) -> {
			Integer[] aa = { 2, -1 };
			return aa;
		});
		this.moves.add((Integer boardSize) -> {
			Integer[] aa = { -2, 1 };
			return aa;
		});
		this.moves.add((Integer boardSize) -> {
			Integer[] aa = { -2, -1 };
			return aa;
		});
		this.moves.add((Integer boardSize) -> {
			Integer[] aa = { 1, 2 };
			return aa;
		});
		this.moves.add((Integer boardSize) -> {
			Integer[] aa = { 1, -2 };
			return aa;
		});
		this.moves.add((Integer boardSize) -> {
			Integer[] aa = { -1, 2 };
			return aa;
		});
		this.moves.add((Integer boardSize) -> {
			Integer[] aa = { -1, -2 };
			return aa;
		});
	}
	
	@Override
	public String toString() {
		return "Knight";
	}


}
