package it.polito.tdp.nqueens.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import it.polito.tdp.nqueens.model.board.Board;
import it.polito.tdp.nqueens.model.board.Position;
import it.polito.tdp.nqueens.model.pieces.Bishop;
import it.polito.tdp.nqueens.model.pieces.King;
import it.polito.tdp.nqueens.model.pieces.Knight;
import it.polito.tdp.nqueens.model.pieces.Pawn;
import it.polito.tdp.nqueens.model.pieces.Piece;
import it.polito.tdp.nqueens.model.pieces.Queen;
import it.polito.tdp.nqueens.model.pieces.Rook;

public class Model {

	public Model() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Board> solveProblem(ModelInfoTransport modelInfo) {
		List<Piece> pieces = new ArrayList<Piece>();
		// generate queens
		for (int i = 0; i<modelInfo.getNumQueens(); i++) {
			pieces.add(new Queen());
		}
		// generate rooks
		for (int i = 0; i<modelInfo.getNumRooks(); i++) {
			pieces.add(new Rook());
		}
		// generate bishops
		for (int i = 0; i<modelInfo.getNumBishops(); i++) {
			pieces.add(new Bishop());
		}
		// generate knights
				for (int i = 0; i<modelInfo.getNumKnights(); i++) {
					pieces.add(new Knight());
				}
		// generate kings
		for (int i = 0; i<modelInfo.getNumKings(); i++) {
			pieces.add(new King());
		}
		// generate pawns
		for (int i = 0; i<modelInfo.getNumPawns(); i++) {
			pieces.add(new Pawn());
		}
		Board b = new Board(modelInfo.getBoardSize());
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
