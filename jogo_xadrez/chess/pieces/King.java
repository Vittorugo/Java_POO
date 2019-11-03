package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	private ChessMatch chessMatch;

	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}

	// Methods

	private boolean canMove(Position position) { // metodo que auxilia nos possiveis movimentos que o rei pode fazer
		ChessPiece piece = (ChessPiece) getBoard().piece(position);
		return piece == null || piece.getColor() != this.getColor();

	}

	private boolean testRookCastling(Position position) { // verifica se é possível ou não fazer o movimento de rook com
															// a torre
		ChessPiece piece = (ChessPiece) this.getBoard().piece(position);
		return piece != null && piece instanceof Rook && piece.getColor() == this.getColor()
				&& piece.getMoveCount() == 0;
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position position = new Position(0, 0);

		// above

		position.setValues(this.position.getRow() - 1, this.position.getColumn());
		if (getBoard().positionExists(position) && canMove(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}

		// below

		position.setValues(this.position.getRow() + 1, this.position.getColumn());
		if (getBoard().positionExists(position) && canMove(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}

		// Left

		position.setValues(this.position.getRow(), this.position.getColumn() - 1);
		if (getBoard().positionExists(position) && canMove(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}

		// Right

		position.setValues(this.position.getRow(), this.position.getColumn() + 1);
		if (getBoard().positionExists(position) && canMove(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}

		// upper main diagonal

		position.setValues(this.position.getRow() - 1, this.position.getColumn() - 1);
		if (getBoard().positionExists(position) && canMove(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}

		// upper secondary diagonal

		position.setValues(this.position.getRow() - 1, this.position.getColumn() + 1);
		if (getBoard().positionExists(position) && canMove(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}

		// lower secondary diagonal

		position.setValues(this.position.getRow() + 1, this.position.getColumn() - 1);
		if (getBoard().positionExists(position) && canMove(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}

		// lower primary diagonal

		position.setValues(this.position.getRow() + 1, this.position.getColumn() + 1);
		if (getBoard().positionExists(position) && canMove(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}

		// move rook
		if (this.getMoveCount() == 0 && !this.chessMatch.getCheck()) {
			// movimento de rook com torre mais próxima ( direita ).
			Position posT1 = new Position(this.position.getRow(), this.position.getColumn() + 3);
			if (testRookCastling(posT1)) {
				Position p1 = new Position(this.position.getRow(), this.position.getColumn() + 1);
				Position p2 = new Position(this.position.getRow(), this.position.getColumn() + 2);

				if (this.getBoard().piece(p1) == null && this.getBoard().piece(p2) == null) {
					mat[this.position.getRow()][this.position.getColumn() + 2] = true;
				}
			}

			// movimento de rook com torre mais longe ( esquerda).
			Position posT2 = new Position(this.position.getRow(), this.position.getColumn() - 4);
			if (testRookCastling(posT2)) {
				Position p1 = new Position(this.position.getRow(), this.position.getColumn() - 1);
				Position p2 = new Position(this.position.getRow(), this.position.getColumn() - 2);
				Position p3 = new Position(this.position.getRow(), this.position.getColumn() - 3);

				if (this.getBoard().piece(p1) == null && this.getBoard().piece(p2) == null
						&& this.getBoard().piece(p3) == null) {
					mat[this.position.getRow()][this.position.getColumn() - 2] = true;
				}
			}
		}

		return mat;
	}

	@Override
	public String toString() {
		return "K";
	}

}
