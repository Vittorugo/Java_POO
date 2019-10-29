package chess;


import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
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
	
	public boolean[][] possibleMoves(ChessPosition sourcePosition){ // imprime as posi��es poss�veis a partir de uma posi��o de origem
		Position position = sourcePosition.toPosition();
		validateSourcePosition(position);
		return this.board.piece(position).possibleMoves();
	}
	
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {// valida a posi��o inicial, final e captura de  pe�as
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		
		validateSourcePosition(source);
		validateTargetPosition(source,target);
		Piece capturedPiece = makeMove(source, target);
		
		return (ChessPiece) capturedPiece;
	}
	
	private Piece makeMove(Position source, Position target) { // remove a pe�a da posi��o inicial para colocar na nova posi��o
		Piece piece = this.board.removePiece(source);
		Piece capturedPiece = this.board.removePiece(target); // captura pe�a caso exista uma na posi��o destino.
		
		this.board.placePiece(piece, target);
		return capturedPiece;
	}
	
	private void validateSourcePosition(Position position) { // valida��o das posi��es das pe�as da vez de jogar
		if(!this.board.thereIsAPiece(position)) {
			throw new ChessException("There is no piece source position.");
		}
		if (!this.board.piece(position).isThereAnyPossibleMove()) {
			throw new ChessException("There is no possible moves for the chosen piece");
		}
	}
	
	private void validateTargetPosition(Position source, Position target) { // valida��o das posi��es de destino das pe�as.
		if (!this.board.piece(source).possibleMove(target)) {
			throw new ChessException("The chosen piece can't move to target position");
		}
	}
	
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		this.board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	// metodo que inicializa o jogo colocando as pe�as na posi��o inicial.
	private void initialSetup() {
		placeNewPiece('a', 8, new Rook(this.board, Color.WHITE));
		placeNewPiece('h', 8, new Rook(this.board, Color.WHITE));
		
		placeNewPiece('e',8 ,new King(this.board, Color.WHITE));
		
		placeNewPiece('a', 1, new Rook(this.board, Color.BLACK));
		placeNewPiece('h', 1, new Rook(this.board, Color.BLACK));
		
		placeNewPiece('d',1,new King(this.board, Color.BLACK));
	}
}
