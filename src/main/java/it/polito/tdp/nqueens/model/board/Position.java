package it.polito.tdp.nqueens.model.board;

public class Position implements Comparable<Position>{
	public int x;
	public int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Position (Integer[] xy) {
		this.x = xy[0];
		this.y = xy[1];
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	public static Position sum(Position p1, Position p2) {
		return new Position(p1.x + p2.x, p1.y + p2.y);
	}

	@Override
	public String toString() {
		return "[" + x + ", " + y + "]";
	}
	
	public static Position deepClone(Position p) {
		return new Position(p.x, p.y);
	}

	@Override
	public int compareTo(Position arg0) {
		int dX = this.x - arg0.x;
		if (dX == 0) {
			return this.y - arg0.y;
		} else {
			return dX;
		}
	}
	
	
	
	
}
