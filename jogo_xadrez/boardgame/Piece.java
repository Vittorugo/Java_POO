package boardgame;

public abstract class Piece {
	
	protected  Position position; // toda pe�a tem uma posi��o 
	private Board board; // toda pe�a conhece o seu tabuleiro
	
	
	public Piece(Board board) {
		this.board = board;
		this.position = null; // toda pe�a come�a com a posi��o nula
	}

	// Methods
	
	public abstract boolean[][] possibleMoves(); // metodo com poss�veis movimentos das pe�as
	
	public boolean possibleMove(Position position) { // retorna uma matriz booleana com os poss�veis movimentos das pe�as
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	public boolean isThereAnyPossibleMove() { // percorre matriz e verifica se existe posi��o que a pe�a pode percorrer
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
	
	protected Board getBoard() { // apenas as pe�as poder�o acessar este m�todo
		return board;
	}

	
}
