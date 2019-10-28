package boardgame;

public class Board {
	
	private Integer rows;
	private Integer columns;
	private Piece[][] pieces;
	
	public Board() {
		
	}
	
	public Board(Integer rows, Integer columns) {
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	// Methods
	
	public Piece piece(int row, int column) { // retorna a peça localizada nas coordenadas passadas.
		return pieces[row][column];
	}
	
	public Piece piece(Position position) { // sobrecarga que retorna a peça pela posição 
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece( Piece piece, Position position) {
		this.pieces[position.getRow()][position.getColumn()] = piece; // marcando a posição da peça no tabuleiro da peça
		piece.position = position; // adicionando nova posição a peça
	}
	
	// Getters and Setters
	
	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getColumns() {
		return columns;
	}

	public void setColumns(Integer columns) {
		this.columns = columns;
	}
	
		
}
