package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPosition;

class ChessExceptionTest {
		
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void canNotChooseOffBoardPosition() {
		
		// Teste Limites inferiores 
		ChessException exceptionLower = assertThrows(ChessException.class, () -> new ChessPosition('`', 0));
		assertEquals("Error instantiating ChessPosition. Valid values are from a1 to h8.", exceptionLower.getMessage());
		

		ChessException exceptionUpper = assertThrows(ChessException.class, () -> new ChessPosition('g', 9));
		assertEquals("Error instantiating ChessPosition. Valid values are from a1 to h8.", exceptionUpper.getMessage());
	
	}
		
	@Test
	public void breakIntoPositionOfTheSameTeamPiece() {
				
		// source
		char sourceColumn = 'a';
		int  sourceRow    = 8;
		
		// target
		char targetColumn = 'e';
		int  targetRow    = 8;
		
		ChessMatch moveChessMatch = new ChessMatch();
				
		ChessPosition sourPosition = new ChessPosition(sourceColumn, sourceRow);
		ChessPosition targetPosition = new ChessPosition(targetColumn, targetRow);
		
		
		ChessException thrown = assertThrows(ChessException.class, () -> moveChessMatch.performChessMove(sourPosition,targetPosition));
		assertEquals("The chosen piece can't move to target position", thrown.getMessage());
	}

}
