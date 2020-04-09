package it.polito.tdp.nqueens.model;

import it.polito.tdp.nqueens.model.board.Board;


public class ModelTest {

	public static void main(String[] args) {
		for (int t = 0; t < 1; t++) {
			Model m = new Model();
			ModelInfoTransport modelInfo = new ModelInfoTransport(6, 1, 1, 2, 2, 1, 1);
			long start = System.nanoTime();
			for (Board b : m.solveProblem(modelInfo)) {
				System.out.println(b);
			}
			long end = System.nanoTime();

			long time = end - start;

			System.out.println(time + " ");
		}

		System.out.println("done");

	}

}
