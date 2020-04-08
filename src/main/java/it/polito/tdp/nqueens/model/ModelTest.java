package it.polito.tdp.nqueens.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.nqueens.model.board.Board;
import it.polito.tdp.nqueens.model.pieces.Piece;
import it.polito.tdp.nqueens.model.pieces.Queen;

public class ModelTest {

	public static void main(String[] args) {
		for (int t = 0; t < 2; t++) {
			Model m = new Model();
			List<Piece> listPieces = new ArrayList<Piece>();
			int ss = 7;
			for (int i = 0; i < ss; i++) {
				listPieces.add(new Queen());
			}
			long start = System.nanoTime();
			for (Board b : m.solveProblem(ss, listPieces)) {
				//System.out.println(b);
			}
			long end = System.nanoTime();

			long time = end - start;

			System.out.println(time + " ");
		}

		System.out.println("done");

	}

}
