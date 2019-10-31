package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	public Pawn(Board board, Color color) {
		super(board, color);
	}

	// Methods

	@Override
	public boolean[][] possibleMoves() {

		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position piecePosition = new Position(0, 0);

		if (this.getColor() == Color.WHITE) {
			
			piecePosition.setValues(this.position.getRow() - 1, this.position.getColumn());
			if (this.getBoard().positionExists(piecePosition) && !this.getBoard().thereIsAPiece(piecePosition)) {
				mat[piecePosition.getRow()][piecePosition.getColumn()] = true;
			}

			piecePosition.setValues(this.position.getRow() - 2, this.position.getColumn());
			Position position = new Position(this.position.getRow() -1, this.position.getColumn()); // posicao auxiliar para verificar se a posição em frente ao pião está livre podendo assim ele saltar duas posições para frente no primeiro lance.
			if (this.getBoard().positionExists(piecePosition) && !this.getBoard().thereIsAPiece(piecePosition) && this.getBoard().positionExists(position) && !this.getBoard().thereIsAPiece(position) && this.getMoveCount() == 0) {
				mat[piecePosition.getRow()][piecePosition.getColumn()] = true;
			}
			
			piecePosition.setValues(this.position.getRow() - 1, this.position.getColumn() - 1);
			if (this.getBoard().positionExists(piecePosition) && this.isThereOpponentPiece(piecePosition)) {
				mat[piecePosition.getRow()][piecePosition.getColumn()] = true;
			}
			
			piecePosition.setValues(this.position.getRow() - 1, this.position.getColumn() + 1);
			if (this.getBoard().positionExists(piecePosition) && this.isThereOpponentPiece(piecePosition)) {
				mat[piecePosition.getRow()][piecePosition.getColumn()] = true;
			}
		}
		
		else {
			
			piecePosition.setValues(this.position.getRow() + 1, this.position.getColumn());
			if (this.getBoard().positionExists(piecePosition) && !this.getBoard().thereIsAPiece(piecePosition)) {
				mat[piecePosition.getRow()][piecePosition.getColumn()] = true;
			}

			piecePosition.setValues(this.position.getRow() + 2, this.position.getColumn());
			Position position = new Position(this.position.getRow() -1, this.position.getColumn()); // posicao auxiliar para verificar se a posição em frente ao pião está livre podendo assim ele saltar duas posições para frente no primeiro lance.
			if (this.getBoard().positionExists(piecePosition) && !this.getBoard().thereIsAPiece(piecePosition) && this.getBoard().positionExists(position) && !this.getBoard().thereIsAPiece(position) && this.getMoveCount() == 0) {
				mat[piecePosition.getRow()][piecePosition.getColumn()] = true;
			}
			
			piecePosition.setValues(this.position.getRow() + 1, this.position.getColumn() - 1);
			if (this.getBoard().positionExists(piecePosition) && this.isThereOpponentPiece(piecePosition)) {
				mat[piecePosition.getRow()][piecePosition.getColumn()] = true;
			}
			
			piecePosition.setValues(this.position.getRow() + 1, this.position.getColumn() + 1);
			if (this.getBoard().positionExists(piecePosition) && this.isThereOpponentPiece(piecePosition)) {
				mat[piecePosition.getRow()][piecePosition.getColumn()] = true;
			}
			
		}

		return mat;
	}
	
	@Override
	public String toString() {
		return "P";
	}
}
