package it.polito.tdp.nqueens.model.pieces;

import java.util.Arrays;

public class TestPieces {
	
	public static void main(String[] args) {
		Queen qq = new Queen();
		for (Integer[] ii: qq.getPossibleMoves(8)) {
			System.out.println(Arrays.deepToString(ii));
		}
	}

}
