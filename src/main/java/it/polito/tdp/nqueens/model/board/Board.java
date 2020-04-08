package it.polito.tdp.nqueens.model.board;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.List;

import it.polito.tdp.nqueens.model.pieces.Piece;

public class Board {
	private int boardSize;
	private Map<Position, Piece> grid;
	
	public Board(int boardSize) {
		this.boardSize = boardSize;
		
		this.grid = new TreeMap<Position, Piece>();
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				Position ij = new Position(i, j);
				grid.put(ij , null);
			}
		}
	}
	
	public static Board deepClone(Board b) {
		Board clonedBoard = new Board(b.getBoardSize());
		for (Position p: b.getGrid().keySet()) {;
			clonedBoard.addPiece(p, b.getPiece(p));
		}
		return clonedBoard;
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

	public int getBoardSize() {
		return boardSize;
	}
	
	public Piece getPiece(Position pos) {
		return this.grid.get(pos);
	}

	private Map<Position, Piece> getGrid() {
		return grid;
	}
	
	public String toString() {
		String out = "";
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				Position pos = new Position(i,j);
				if (this.grid.get(pos) != null) {
					out += this.grid.get(pos) + " " + pos + "\t";
				}
			}
		}
		return out;
	}
	
	public static List<Board> cleanList(List<Board> boards){
		return boards.stream().distinct().collect(Collectors.toList());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + boardSize;
		result = prime * result + ((grid == null) ? 0 : grid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		return this.toString().contentEquals(obj.toString());
	}
	
	
	
}
