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
		
		this.pathToImage = "112072-chess/png/pawn.png";

	}
	
	@Override
	public String toString() {
		return "Pawn";
	}

}
