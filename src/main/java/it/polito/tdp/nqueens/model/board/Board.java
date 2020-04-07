package it.polito.tdp.nqueens.model.board;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import it.polito.tdp.nqueens.model.pieces.Piece;

public class Board {
	private int boardSize;
	private Map<Position, Piece> grid;
	
	public Board(int boardSize) {
		this.boardSize = boardSize;
		
		this.grid = new HashMap<Position, Piece>();
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				Position ij = new Position(i, j);
				grid.put(ij , null);
			}
		}
	}
	
	private boolean isInBounds(Position p) {
		return p.x < boardSize && p.y < boardSize;
	}
	
	public boolean addPiece(Position pos, Piece piece) {
		if (this.isInBounds(pos) && grid.get(pos) == null) {
			grid.put(pos, piece);
			return true;
		} else {
			return false;
		}
	}
	
	public Collection<Piece> getPieces(){
		Collection<Piece> ll = this.grid.values();
		return ll;
	}
	
	public boolean existsConflict() {
		for (Position ij: this.grid.keySet()) {
			Piece pp = this.grid.get(ij);
			if (pp != null) {
				for (Integer[] xy: pp.getPossibleMoves(this.boardSize)) {
					Position somma = Position.sum(ij, new Position(xy));
					if(this.grid.get(somma) != null) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	
}
