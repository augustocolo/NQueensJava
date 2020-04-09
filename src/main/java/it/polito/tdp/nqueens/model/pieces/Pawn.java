package it.polito.tdp.nqueens.model.pieces;

public class Pawn extends FixedMovementPiece {

	public Pawn() {
		super();
		this.moves.add((Integer boardSize) -> {
			Integer[] aa = { 1, 1 };
			return aa;
		});
		this.moves.add((Integer boardSize) -> {
			Integer[] aa = { -1, 1 };
			return aa;
		});
	}
	
	@Override
	public String toString() {
		return "Pawn";
	}

}
