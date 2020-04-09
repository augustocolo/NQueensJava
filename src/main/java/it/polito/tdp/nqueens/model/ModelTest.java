package it.polito.tdp.nqueens.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.nqueens.model.board.Board;
import it.polito.tdp.nqueens.model.pieces.*;


public class ModelTest {

	public static void main(String[] args) {
		for (int t = 0; t < 1; t++) {
			Model m = new Model();
			List<Piece> listPieces = new ArrayList<Piece>();
			int ss = 4;
			for (int i = 0; i < ss; i++) {
				listPieces.add(new Rook());

			}
			long start = System.nanoTime();
			for (Board b : m.solveProblem(ss, listPieces)) {
				System.out.println(b);
			}
			long end = System.nanoTime();

			long time = end - start;

			System.out.println(time + " ");
		}

		System.out.println("done");

	}

}
