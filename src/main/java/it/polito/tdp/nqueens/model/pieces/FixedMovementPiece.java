package it.polito.tdp.nqueens.model.pieces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public abstract class FixedMovementPiece extends Piece {

	public FixedMovementPiece() {
		super();
	}
	
	@Override
	public List<Integer[]> getPossibleMoves(int boardSize){
		List<Integer[]> out = new ArrayList<Integer[]>();
		for (Function<Integer, Integer[]> f: this.moves) {
				out.add(f.apply(boardSize));
		}
		return out;
	}

}
