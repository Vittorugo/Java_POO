package boardgame;

public abstract class Piece {
	
	protected  Position position; // toda peça tem uma posição 
	private Board board; // toda peça conhece o seu tabuleiro
	
	
	public Piece(Board board) {
		this.board = board;
		this.position = null; // toda peça começa com a posição nula
	}

	// Methods
	
	public abstract boolean[][] possibleMoves(); // metodo com possíveis movimentos das peças
	
	public boolean possibleMove(Position position) { // retorna uma matriz booleana com os possíveis movimentos das peças
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	public boolean isThereAnyPossibleMove() { // percorre matriz e verifica se existe posição que a peça pode percorrer
		boolean[][] mat = possibleMoves();
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				if(mat[i][j]) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	// Getters and Setters 
	
	protected Board getBoard() { // apenas as peças poderão acessar este método
		return board;
	}

	
}
