package boardgame;

public class Board {
	
	private Integer rows;
	private Integer columns;
	private Piece[][] pieces;
	
	public Board(Integer rows, Integer columns) {
		if( rows < 1 || columns <1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	// Methods
	
	public Piece piece(int row, int column) { // retorna a pe�a localizada nas coordenadas passadas.
		if(!positionExists(row,column)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[row][column];
	}
	
	public Piece piece(Position position) { // sobrecarga que retorna a pe�a pela posi��o 
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece( Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position " + position);
		}
		this.pieces[position.getRow()][position.getColumn()] = piece; // marcando a posi��o da pe�a no tabuleiro da pe�a
		piece.position = position; // adicionando nova posi��o a pe�a
	}
	
	public Piece removePiece(Position position) { // metodo para remover pe�a da posi��o
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		if (piece(position) == null) {
			return null;
		}
		Piece auxPiece = piece(position);
		auxPiece.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		
		return auxPiece;
	}
	
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < this.rows && column >= 0 && column < this.columns; // retorna se a linha e coluna est�o dentro dos limites do tabuleiro.
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPiece(Position position) { // verifica se tem uma pe�a na posi��o escolhida.
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return piece(position) != null;  
	}
	
	
	// Getters and Setters
	
	public Integer getRows() {
		return rows;
	}

	public Integer getColumns() {
		return columns;
	}

		
}
