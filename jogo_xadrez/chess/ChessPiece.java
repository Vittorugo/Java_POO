package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece{
	
	private Color color;
	
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
	
	// Gettes and Setters 
	
	public Color getColor() {
		return this.color;
	}
	
	
}
