package boardgame;

public class Piece {
	
	protected  Position position; // toda peça tem uma posição 
	private Board board;
	
	
	public Piece(Board board) {
		this.board = board;
		this.position = null;
	}


	protected Board getBoard() { // apenas as peças poderão acessar este método
		return board;
	}

	
}
