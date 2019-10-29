package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	public King(Board board, Color color) {
		super(board, color);
	}

	// Methods

	private boolean canMove(Position position) { // metodo que auxilia nos possiveis movimentos que o rei pode fazer
		ChessPiece piece = (ChessPiece) getBoard().piece(position);
		return piece == null || piece.getColor() != this.getColor();

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

		return mat;
	}

	@Override
	public String toString() {
		return "K";
	}

}
