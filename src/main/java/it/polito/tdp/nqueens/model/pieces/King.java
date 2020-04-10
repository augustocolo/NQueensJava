package it.polito.tdp.nqueens.model.pieces;

public class King extends FixedMovementPiece {

	public King() {
		super();
		this.moves.add((Integer boardSize) -> {
			Integer[] aa = { 1, 1 };
			return aa;
		});
		this.moves.add((Integer boardSize) -> {
			Integer[] aa = { 1, -1 };
			return aa;
		});
		this.moves.add((Integer boardSize) -> {
			Integer[] aa = { -1, 1 };
			return aa;
		});
		this.moves.add((Integer boardSize) -> {
			Integer[] aa = { -1, -1 };
			return aa;
		});
		this.moves.add((Integer boardSize) -> {
			Integer[] aa = { 1, 0 };
			return aa;
		});
		this.moves.add((Integer boardSize) -> {
			Integer[] aa = { 0, 1 };
			return aa;
		});
		this.moves.add((Integer boardSize) -> {
			Integer[] aa = { -1, 0 };
			return aa;
		});
		this.moves.add((Integer boardSize) -> {
			Integer[] aa = { 0, -1 };
			return aa;
		});
		
		this.pathToImage = "112072-chess/png/king.png";

	}
	
	
	@Override
	public String toString() {
		return "King";
	}

	

}
