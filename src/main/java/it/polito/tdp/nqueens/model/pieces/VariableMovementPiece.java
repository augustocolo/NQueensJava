package it.polito.tdp.nqueens.model.pieces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public abstract class VariableMovementPiece extends Piece {

	public VariableMovementPiece() {
		super();
	}
	
	@Override
	public List<Integer[]> getPossibleMoves(int boardSize){
		List<Integer[]> out = new ArrayList<Integer[]>();
		for (int i = boardSize; i > 0; i--) {
			for (Function<Integer, Integer[]> f: this.moves) {
				out.add(f.apply(i));
			}
		}
		return out;
	}

}
