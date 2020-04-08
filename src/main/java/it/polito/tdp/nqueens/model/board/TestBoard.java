package it.polito.tdp.nqueens.model.board;

import it.polito.tdp.nqueens.model.pieces.Queen;

public class TestBoard {

	public static void main(String[] args) {
		Board bb = new Board(5);
		
		Position pos = new Position(1,1);
		System.out.println("Aggiungo una regina");
		Queen qq = new Queen();
		boolean bool = bb.addPiece(pos, qq);
		System.out.println(bb.getPieces());
		System.out.println(bb.existsConflict());
		
		
		Position pos2 = new Position(3,4);
		System.out.println("Aggiungo una regina");
		Queen qq2 = new Queen();
		boolean bool2 = bb.addPiece(pos2, qq2);
		System.out.println(bb.getPieces());
		System.out.println(bb.existsConflict());
		
		Position pos3 = new Position(3,1);
		System.out.println("Aggiungo una regina");
		Queen qq3 = new Queen();
		boolean bool3 = bb.addPiece(pos3, qq3);
		System.out.println(bb.getPieces());
		System.out.println(bb.existsConflict());
		
		Board bb2 = Board.deepClone(bb);
		
		Position pos4 = new Position(4, 1);
		Queen qq4 = new Queen();
		bb2.addPiece(pos4, qq4);
		System.out.println(bb2.getPieces());
	}

}
