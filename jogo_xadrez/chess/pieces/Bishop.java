package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {

	public Bishop(Board board, Color color) {
		super(board, color);
	}

	// Methods

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position auxPosition = new Position(0, 0);

		// upper main diagonal

		auxPosition.setValues(position.getRow() - 1, position.getColumn() -1);

		while (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
			mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
			auxPosition.setValues(auxPosition.getRow() - 1, auxPosition.getColumn() -1);
		}

		if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)) {
			mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
		}

		// upper secondary diagonal

		auxPosition.setValues(position.getRow() -1, position.getColumn() + 1);

		while (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
			mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
			auxPosition.setValues(auxPosition.getRow() - 1, auxPosition.getColumn() + 1);
		}

		if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)) {
			mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
		}
		
		// lower secondary diagonal
		
		auxPosition.setValues(position.getRow() + 1, position.getColumn() + 1);

		while (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
			mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
			auxPosition.setValues(auxPosition.getRow() + 1, auxPosition.getColumn() + 1);		}

		if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)) {
			mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
		}
		
		// lower primary diagonal
		
		auxPosition.setValues(position.getRow() + 1, position.getColumn() - 1);

		while (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
			mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
			auxPosition.setValues(auxPosition.getRow() + 1, auxPosition.getColumn() - 1);
		}

		if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)) {
			mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
		}
		
		
		return mat;
		
	}

	@Override
	public String toString() {
		return "B";
	}

}
