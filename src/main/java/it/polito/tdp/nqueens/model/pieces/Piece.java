package it.polito.tdp.nqueens.model.pieces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public abstract class Piece {
	protected List<Function<Integer, Integer[]>> moves;
	
	public Piece() {
		this.moves = new ArrayList<Function<Integer, Integer[]>>();
	}

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
