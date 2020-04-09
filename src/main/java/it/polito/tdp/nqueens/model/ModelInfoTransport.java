package it.polito.tdp.nqueens.model;

public class ModelInfoTransport {
	
	private int boardSize;
	private int numKings;
	private int numQueens;
	private int numRooks;
	private int numBishops;
	private int numKnights;
	private int numPawns;
	public ModelInfoTransport(int boardSize, int numKings, int numQueens, int numRooks, int numBishops, int numKnights,
			int numPawns) {
		super();
		this.boardSize = boardSize;
		this.numKings = numKings;
		this.numQueens = numQueens;
		this.numRooks = numRooks;
		this.numBishops = numBishops;
		this.numKnights = numKnights;
		this.numPawns = numPawns;
	}
	public int getBoardSize() {
		return boardSize;
	}
	public int getNumKings() {
		return numKings;
	}
	public int getNumQueens() {
		return numQueens;
	}
	public int getNumRooks() {
		return numRooks;
	}
	public int getNumBishops() {
		return numBishops;
	}
	public int getNumKnights() {
		return numKnights;
	}
	public int getNumPawns() {
		return numPawns;
	}
	
	
	
	

}
