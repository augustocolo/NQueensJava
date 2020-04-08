package it.polito.tdp.nqueens.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import it.polito.tdp.nqueens.model.board.Board;
import it.polito.tdp.nqueens.model.board.Position;
import it.polito.tdp.nqueens.model.pieces.Piece;

public class Model {

	public Model() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Board> solveProblem(int boardSize, List<Piece> pieces) {
		Board b = new Board(boardSize);
		List<Board> resOne = this.recursive(b, pieces);
		return Board.cleanList(resOne);
	}
	
	private List<Board> recursive(Board board, List<Piece> pieces){
		
		//System.out.println(pieces.size());
		
		if (pieces.size() == 0) {
			Board[] out = {board};
			return Arrays.asList(out);
		}
		
		List<Board> out = new ArrayList<Board>();
		
		for (int i = 0; i < board.getBoardSize(); i++) {
			for (int j = 0; j < board.getBoardSize(); j++) {
				Position pos = new Position(i,j);
				if (board.getPiece(pos) == null) {
					Board newBoard = Board.deepClone(board); 
					newBoard.addPiece(pos, pieces.get(0));
					if (!newBoard.existsConflict()) {
						List<Piece> newPieces = new ArrayList<Piece>();
						newPieces.addAll(pieces);
						newPieces.remove(0);
						out.addAll(this.recursive(newBoard, newPieces));
					}
				}
			}
		}
		return out;
	}

}
