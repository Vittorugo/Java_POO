package boardgame;

public class Piece {
	
	protected  Position position; // toda pe�a tem uma posi��o 
	private Board board; // toda pe�a conhece o seu tabuleiro
	
	
	public Piece(Board board) {
		this.board = board;
		this.position = null; // toda pe�a come�a com a posi��o nula
	}


	protected Board getBoard() { // apenas as pe�as poder�o acessar este m�todo
		return board;
	}

	
}
