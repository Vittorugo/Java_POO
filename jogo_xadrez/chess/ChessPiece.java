package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece{
	
	private Color color;
	private int moveCont;
	
	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}
	
	// Methods
	
	protected boolean isThereOpponentPiece(Position position) { // verifica se a peça é aliada ou oponente
		ChessPiece piece = (ChessPiece) getBoard().piece(position);
		return piece != null && piece.getColor() != this.color;
	}
	
	public ChessPosition getChessPosition() {
		return ChessPosition.fromPosition(this.position);
	}
	
	public void increaseMoveCount() {
		this.moveCont++;
	}
	
	public void decreaseMoveCount() {
		this.moveCont--;
	}
	
	// Gettes and Setters 
	
	public Color getColor() {
		return this.color;
	}
	
	public int getMoveCount() {
		return this.moveCont;
	}
}
