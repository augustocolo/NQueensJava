package it.polito.tdp.nqueens.model.pieces;

public class Bishop extends VariableMovementPiece {

	public Bishop() {
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
	}
	
	@Override
	public String toString() {
		return "Bishop";
	}

}
