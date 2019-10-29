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
	
	public boolean[][] possibleMoves(ChessPosition sourcePosition){ // imprime as posições possíveis a partir de uma posição de origem
		Position position = sourcePosition.toPosition();
		validateSourcePosition(position);
		return this.board.piece(position).possibleMoves();
	}
	
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {// valida a posição inicial, final e captura de  peças
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		
		validateSourcePosition(source);
		validateTargetPosition(source,target);
		Piece capturedPiece = makeMove(source, target);
		
		return (ChessPiece) capturedPiece;
	}
	
	private Piece makeMove(Position source, Position target) { // remove a peça da posição inicial para colocar na nova posição
		Piece piece = this.board.removePiece(source);
		Piece capturedPiece = this.board.removePiece(target); // captura peça caso exista uma na posição destino.
		
		this.board.placePiece(piece, target);
		return capturedPiece;
	}
	
	private void validateSourcePosition(Position position) { // validação das posições das peças da vez de jogar
		if(!this.board.thereIsAPiece(position)) {
			throw new ChessException("There is no piece source position.");
		}
		if (!this.board.piece(position).isThereAnyPossibleMove()) {
			throw new ChessException("There is no possible moves for the chosen piece");
		}
	}
	
	private void validateTargetPosition(Position source, Position target) { // validação das posições de destino das peças.
		if (!this.board.piece(source).possibleMove(target)) {
			throw new ChessException("The chosen piece can't move to target position");
		}
	}
	
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		this.board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	// metodo que inicializa o jogo colocando as peças na posição inicial.
	private void initialSetup() {
		placeNewPiece('a', 8, new Rook(this.board, Color.WHITE));
		placeNewPiece('h', 8, new Rook(this.board, Color.WHITE));
		
		placeNewPiece('e',8 ,new King(this.board, Color.WHITE));
		
		placeNewPiece('a', 1, new Rook(this.board, Color.BLACK));
		placeNewPiece('h', 1, new Rook(this.board, Color.BLACK));
		
		placeNewPiece('d',1,new King(this.board, Color.BLACK));
	}
}
