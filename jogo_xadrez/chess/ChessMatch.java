package chess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.Bishop;
import chess.pieces.King;
import chess.pieces.Knight;
import chess.pieces.Pawn;
import chess.pieces.Queen;
import chess.pieces.Rook;

public class ChessMatch {

	private Board board;
	private int turn;
	private Color currentPlayer;
	private boolean check;
	private boolean checkMate;

	private List<Piece> piecesOnTheBoard = new ArrayList<>();
	private List<Piece> capturedPieces = new ArrayList<>();

	public ChessMatch() {
		this.board = new Board(8, 8);
		this.turn = 1;
		this.currentPlayer = Color.WHITE;
		initialSetup();
	}

	public ChessPiece[][] getPieces() {
		ChessPiece[][] mat = new ChessPiece[this.board.getRows()][this.board.getColumns()];
		for (int i = 0; i < this.board.getRows(); i++) {
			for (int j = 0; j < this.board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) this.board.piece(i, j);
			}
		}

		return mat;
	}

	public boolean[][] possibleMoves(ChessPosition sourcePosition) { // imprime as posi��es poss�veis a partir de uma
																		// posi��o de origem
		Position position = sourcePosition.toPosition();
		validateSourcePosition(position);
		return this.board.piece(position).possibleMoves();
	}

	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {// valida a posi��o
																									// inicial, final e
																									// captura de pe�as
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();

		validateSourcePosition(source);
		validateTargetPosition(source, target);
		Piece capturedPiece = makeMove(source, target);

		if (testCheck(currentPlayer)) {
			undoMove(source, target, capturedPiece);
			throw new ChessException("You can't put yourself in check");
		}

		this.check = (testCheck(opponentColor(currentPlayer))) ? true : false;

		if (testCheckMate(opponentColor(currentPlayer))) {
			checkMate = true;
		} else {
			nextTurn();

		}
		return (ChessPiece) capturedPiece;
	}

	private Piece makeMove(Position source, Position target) { // remove a pe�a da posi��o inicial para colocar na nova
																// posi��o
		ChessPiece piece = (ChessPiece) this.board.removePiece(source);
		piece.increaseMoveCount();
		Piece capturedPiece = this.board.removePiece(target); // captura pe�a caso exista uma na posi��o destino.

		this.board.placePiece(piece, target);

		if (capturedPiece != null) {
			piecesOnTheBoard.remove(capturedPiece);
			capturedPieces.add(capturedPiece);
		}

		// movimento rook maior

		if (piece instanceof King && target.getColumn() == source.getColumn() - 2) {
			Position sourceRookPosition = new Position(source.getRow(), source.getColumn() - 4);
			Position targetRookPosition = new Position(source.getRow(), source.getColumn() - 1);

			ChessPiece rook = (ChessPiece) this.board.removePiece(sourceRookPosition);
			this.board.placePiece(rook, targetRookPosition);
			rook.increaseMoveCount();

		}

		// rook menor

		if (piece instanceof King && target.getColumn() == source.getColumn() + 2) {
			Position sourceRookPosition = new Position(source.getRow(), source.getColumn() + 3);
			Position targetRookPosition = new Position(source.getRow(), source.getColumn() + 1);

			ChessPiece rook = (ChessPiece) this.board.removePiece(sourceRookPosition);
			this.board.placePiece(rook, targetRookPosition);
			rook.increaseMoveCount();

		}

		return capturedPiece;
	}

	private void undoMove(Position source, Position target, Piece capturedPiece) { // desfazer movimentos
		ChessPiece piece = (ChessPiece) this.board.removePiece(target);
		piece.decreaseMoveCount();
		this.board.placePiece(piece, source);

		if (capturedPiece != null) {
			this.board.placePiece(capturedPiece, target);
			capturedPieces.remove(capturedPiece);
			piecesOnTheBoard.add(capturedPiece);
		}

		// movimento rook maior

		if (piece instanceof King && target.getColumn() == source.getColumn() - 2) {
			Position sourceRookPosition = new Position(source.getRow(), source.getColumn() - 4);
			Position targetRookPosition = new Position(source.getRow(), source.getColumn() - 1);

			ChessPiece rook = (ChessPiece) this.board.removePiece(targetRookPosition);
			this.board.placePiece(rook, sourceRookPosition);
			rook.decreaseMoveCount();

		}

		// rook menor

		if (piece instanceof King && target.getColumn() == source.getColumn() + 2) {
			Position sourceRookPosition = new Position(source.getRow(), source.getColumn() + 3);
			Position targetRookPosition = new Position(source.getRow(), source.getColumn() + 1);

			ChessPiece rook = (ChessPiece) this.board.removePiece(targetRookPosition);
			this.board.placePiece(rook, sourceRookPosition);
			rook.decreaseMoveCount();

		}

	}

	private void validateSourcePosition(Position position) { // valida��o das posi��es das pe�as da vez de jogar
		if (!this.board.thereIsAPiece(position)) {
			throw new ChessException("There is no piece source position.");
		}
		if (currentPlayer != ((ChessPiece) this.board.piece(position)).getColor()) {
			throw new ChessException("The chosen piece is not yours");
		}
		if (!this.board.piece(position).isThereAnyPossibleMove()) {
			throw new ChessException("There is no possible moves for the chosen piece");
		}
	}

	private void validateTargetPosition(Position source, Position target) { // valida��o das posi��es de destino das
																			// pe�as.
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
		List<Piece> list = piecesOnTheBoard.stream().filter(x -> ((ChessPiece) x).getColor() == color)
				.collect(Collectors.toList());
		for (Piece p : list) {
			if (p instanceof King) {
				return (ChessPiece) p;
			}
		}

		throw new IllegalStateException("There is no" + color + "King on the board");
	}

	private boolean testCheck(Color color) {
		Position kingPosition = king(color).getChessPosition().toPosition();
		List<Piece> opponentPieces = piecesOnTheBoard.stream()
				.filter(x -> ((ChessPiece) x).getColor() == opponentColor(color)).collect(Collectors.toList());
		for (Piece p : opponentPieces) {
			boolean[][] mat = p.possibleMoves();
			if (mat[kingPosition.getRow()][kingPosition.getColumn()]) {
				return true;
			}
		}

		return false;
	}

	// metodo que testa se est� em checkmate
	private boolean testCheckMate(Color color) {
		if (!testCheck(color)) {
			return false;
		}

		List<Piece> list = piecesOnTheBoard.stream().filter(x -> ((ChessPiece) x).getColor() == color)
				.collect(Collectors.toList());
		for (Piece p : list) {
			boolean[][] mat = p.possibleMoves();
			for (int i = 0; i < this.board.getRows(); i++) {
				for (int j = 0; j < this.board.getColumns(); j++) {
					if (mat[i][j]) {
						Position source = ((ChessPiece) p).getChessPosition().toPosition();
						Position target = new Position(i, j);
						Piece capturedPiece = makeMove(source, target);
						boolean testAux = testCheck(color);
						undoMove(source, target, capturedPiece);
						if (!testAux) {
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

	// metodo que inicializa o jogo colocando as pe�as na posi��o inicial.
	private void initialSetup() {

		// White Pieces
		placeNewPiece('a', 1, new Rook(this.board, Color.WHITE));
		placeNewPiece('b', 1, new Knight(this.board, Color.WHITE));
		placeNewPiece('c', 1, new Bishop(this.board, Color.WHITE));
		placeNewPiece('d', 1, new Queen(this.board, Color.WHITE));
		placeNewPiece('e', 1, new King(this.board, Color.WHITE, this));
		placeNewPiece('f', 1, new Bishop(this.board, Color.WHITE));
		placeNewPiece('g', 1, new Knight(this.board, Color.WHITE));
		placeNewPiece('h', 1, new Rook(this.board, Color.WHITE));

		placeNewPiece('a', 2, new Pawn(this.board, Color.WHITE));
		placeNewPiece('b', 2, new Pawn(this.board, Color.WHITE));
		placeNewPiece('c', 2, new Pawn(this.board, Color.WHITE));
		placeNewPiece('d', 2, new Pawn(this.board, Color.WHITE));
		placeNewPiece('e', 2, new Pawn(this.board, Color.WHITE));
		placeNewPiece('f', 2, new Pawn(this.board, Color.WHITE));
		placeNewPiece('g', 2, new Pawn(this.board, Color.WHITE));
		placeNewPiece('h', 2, new Pawn(this.board, Color.WHITE));

		// Black Pieces
		placeNewPiece('a', 8, new Rook(this.board, Color.BLACK));
		placeNewPiece('b', 8, new Knight(this.board, Color.BLACK));
		placeNewPiece('c', 8, new Bishop(this.board, Color.BLACK));
		placeNewPiece('e', 8, new King(this.board, Color.BLACK, this));
		placeNewPiece('d', 8, new Queen(this.board, Color.BLACK));
		placeNewPiece('f', 8, new Bishop(this.board, Color.BLACK));
		placeNewPiece('g', 8, new Knight(this.board, Color.BLACK));
		placeNewPiece('h', 8, new Rook(this.board, Color.BLACK));

		placeNewPiece('a', 7, new Pawn(this.board, Color.BLACK));
		placeNewPiece('b', 7, new Pawn(this.board, Color.BLACK));
		placeNewPiece('c', 7, new Pawn(this.board, Color.BLACK));
		placeNewPiece('d', 7, new Pawn(this.board, Color.BLACK));
		placeNewPiece('e', 7, new Pawn(this.board, Color.BLACK));
		placeNewPiece('f', 7, new Pawn(this.board, Color.BLACK));
		placeNewPiece('g', 7, new Pawn(this.board, Color.BLACK));
		placeNewPiece('h', 7, new Pawn(this.board, Color.BLACK));
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
