package it.polito.tdp.nqueens.model.pieces;

public class Rook extends VariableMovementPiece {

	public Rook() {
		super();
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
	}
	
	@Override
	public String toString() {
		return "Rook";
	}

}
