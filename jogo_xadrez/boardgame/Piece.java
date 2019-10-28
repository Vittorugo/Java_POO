package boardgame;

public class Piece {
	
	protected  Position position; // toda pe�a tem uma posi��o 
	private Board board;
	
	
	public Piece(Board board) {
		this.board = board;
		this.position = null;
	}


	protected Board getBoard() { // apenas as pe�as poder�o acessar este m�todo
		return board;
	}

	
}
