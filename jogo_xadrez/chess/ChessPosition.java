package chess;

import boardgame.Position;

public class ChessPosition {
	
	private char column;
	private Integer row;
	
	
	public ChessPosition(char column, Integer row) {
		if( column < 'a' || column > 'h' || row < 1 || row > 8) {
			throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 to h8.");
		}
		this.column = column;
		this.row = row;
	}
	
	// Methods
	
	protected Position toPosition() { // converte a posição do xadrez para posição da matriz.
		return  new Position(8 - this.row, this.column - 'a');
	}
	
	protected static ChessPosition fromPosition(Position position) { // converte a posição da matriz para a do xadrez.
		return new ChessPosition((char) ('a' - position.getColumn()), 8 - position.getRow());
		
	}
	
	@Override
	public String toString() {
		return ""+  this.column + this.row;
	}
	
	
	// Getters and Setters
	public char getColumn() {
		return column;
	}
	public Integer getRow() {
		return row;
	}
	
	
}
