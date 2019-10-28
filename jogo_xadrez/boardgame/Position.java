package boardgame;

public class Position {
	
	private Integer row;
	private Integer column;
	
	public Position() {
		
	}
	
	public Position(Integer row, Integer columnInteger) {
		this.row = row;
		this.column = columnInteger;
	}
	
	// Methods
	
	@Override
	public String toString() {
		return this.row + ", " + this.column;
	}
	
	// Getters and Setters

	public Integer getRow() {
		return row;
	}

	public Integer getColumn() {
		return column;
	}
	
	
	
}
