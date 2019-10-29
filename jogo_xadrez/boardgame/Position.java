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
	
	public void setValues(int row, int column){ //atualiza os valores de uma posição
		this.row = row;
		this.column = column;
	}
	
	@Override
	public String toString() {
		return this.row + ", " + this.column;
	}
	
	// Getters and Setters

	public Integer getRow() {
		return row;
	}
	

	public void setRow(Integer row) {
		this.row = row;
	}

	public Integer getColumn() {
		return column;
	}
	
	public void setColumn(Integer column) {
		this.column = column;
	}
	
}
