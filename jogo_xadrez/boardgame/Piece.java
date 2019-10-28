package boardgame;

public class Piece {
	
	protected  Position position; // toda peça tem uma posição 
	private Board board; // toda peça conhece o seu tabuleiro
	
	
	public Piece(Board board) {
		this.board = board;
		this.position = null; // toda peça começa com a posição nula
	}


	protected Board getBoard() { // apenas as peças poderão acessar este método
		return board;
	}

	
}
