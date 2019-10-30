package chess;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	
	private Board  board;
	private int turn;
	private Color currentPlayer;
	private boolean check;
	private boolean checkMate;
	
	private List<Piece> piecesOnTheBoard = new ArrayList<>();
	private List<Piece> capturedPieces = new ArrayList<>();
	
	public ChessMatch() {
		this.board = new Board(8,8);
		this.turn = 1;
		this.currentPlayer = Color.WHITE;
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
		
		if(testCheck(currentPlayer)) {
			undoMove(source, target, capturedPiece);
			throw new ChessException("You can't put yourself in check");
		}
		
		this.check = (testCheck(opponentColor(currentPlayer))) ? true : false;
		
		if(testCheckMate(opponentColor(currentPlayer))) {
			checkMate = true;
		}
		else {
			nextTurn();
				
		}
		return (ChessPiece) capturedPiece;
	}
	
	private Piece makeMove(Position source, Position target) { // remove a peça da posição inicial para colocar na nova posição
		Piece piece = this.board.removePiece(source);
		Piece capturedPiece = this.board.removePiece(target); // captura peça caso exista uma na posição destino.
		
		this.board.placePiece(piece, target);
		
		if(capturedPiece != null) {
			piecesOnTheBoard.remove(capturedPiece);
			capturedPieces.add(capturedPiece);
		}
		
		return capturedPiece;
	}
	
	private void undoMove(Position source, Position target, Piece capturedPiece) {
		Piece piece = this.board.removePiece(target);
		this.board.placePiece(piece, source);
		
		if(capturedPiece != null) {
			this.board.placePiece(capturedPiece, target);
			capturedPieces.remove(capturedPiece);
			piecesOnTheBoard.add(capturedPiece);
		}
	}
		
	private void validateSourcePosition(Position position) { // validação das posições das peças da vez de jogar
		if(!this.board.thereIsAPiece(position)) {
			throw new ChessException("There is no piece source position.");
		}
		if(currentPlayer != ((ChessPiece)this.board.piece(position)).getColor()) {
			throw new ChessException("The chosen piece is not yours");
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
	
	// Metodo que troca de jogador e icrementa um turno
	private void nextTurn() {
		turn++;
		currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
	}
	
	private Color opponentColor(Color color) {
		return (color == Color.WHITE) ? Color.BLACK : Color.WHITE;
	}
	
	// Metodo que localiza o rei de uma determinada cor
	private ChessPiece king(Color color) {
		List<Piece> list = piecesOnTheBoard.stream().filter( x -> ((ChessPiece)x).getColor() == color).collect(Collectors.toList());
		for (Piece p: list) {
			if(p instanceof King) {
				return (ChessPiece)p;
			}
		}
		
		throw new IllegalStateException("There is no" + color + "King on the board");
	}
	
	private boolean testCheck(Color color) {
		Position kingPosition = king(color).getChessPosition().toPosition();
		List<Piece> opponentPieces = piecesOnTheBoard.stream().filter( x -> ((ChessPiece)x).getColor() == opponentColor(color)).collect(Collectors.toList());
		for (Piece p: opponentPieces) {
			boolean[][] mat = p.possibleMoves();
			if (mat[kingPosition.getRow()][kingPosition.getColumn()]) {
				return true;
			}
		}
		
		return false;
	}
	
	// metodo que testa se está em checkmate
	private boolean testCheckMate(Color color) {
		if(!testCheck(color)) {
			return false;
		}
		
		List<Piece> list = piecesOnTheBoard.stream().filter( x -> ((ChessPiece)x).getColor() == color).collect(Collectors.toList());
		for(Piece p: list) {
			boolean[][] mat = p.possibleMoves();
			for(int i=0; i < this.board.getRows(); i++) {
				for(int j=0; j < this.board.getColumns(); j++) {
					if (mat[i][j]) {
						Position source = ((ChessPiece)p).getChessPosition().toPosition();
						Position target = new Position(i,j);
						Piece capturedPiece = makeMove(source, target);
						boolean testAux = testCheck(color);
						undoMove(source, target, capturedPiece);
						if(!testAux) {
							return false;
						}
					}
				}
			}
		}
		
		return true;
	}
	
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		this.board.placePiece(piece, new ChessPosition(column, row).toPosition());
		piecesOnTheBoard.add(piece);
	}
	
	// metodo que inicializa o jogo colocando as peças na posição inicial.
	private void initialSetup() {
		
		// White Pieces
		placeNewPiece('a', 8, new Rook(this.board, Color.WHITE));
		placeNewPiece('h', 8, new Rook(this.board, Color.WHITE));
		
		placeNewPiece('e',8 ,new King(this.board, Color.WHITE));
		
		
		// Black Pieces
		placeNewPiece('a', 1, new Rook(this.board, Color.BLACK));
		placeNewPiece('h', 1, new Rook(this.board, Color.BLACK));
		
		placeNewPiece('d',1,new King(this.board, Color.BLACK));
	}


	// Getters ans Setters
	
	public int getTurn() {
		return turn;
	}

	public Color getCurrentPlayer() {
		return currentPlayer;
	}

	public boolean getCheck() {
		return this.check;
	}
	
	public boolean getCheckMate() {
		return this.checkMate;
	}
}
