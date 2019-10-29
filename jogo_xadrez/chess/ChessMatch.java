package chess;


import boardgame.Board;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	
	private Board  board;
	
	public ChessMatch() {
		this.board = new Board(8,8);
		initialSetup();
	}
	
	public ChessPiece[][] getPieces(){
		ChessPiece[][] mat = new ChessPiece[this.board.getRows()][this.board.getColumns()];
		for (int i = 0; i < this.board.getRows(); i++) {
			for (int j = 0; j < this.board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) this.board.piece(i,j);
			}
		}
		
		return mat;
	}
	
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	// metodo que inicializa o jogo colocando as peças na posição inicial.
	private void initialSetup() {
		placeNewPiece('a', 8, new Rook(board, Color.WHITE));
		placeNewPiece('h', 8, new Rook(board, Color.WHITE));
		
		placeNewPiece('e',8 ,new King(board, Color.WHITE));
		
		placeNewPiece('a', 1, new Rook(board, Color.BLACK));
		placeNewPiece('h', 1, new Rook(board, Color.BLACK));
		
		placeNewPiece('d',1,new King(board, Color.BLACK));
	}
}
