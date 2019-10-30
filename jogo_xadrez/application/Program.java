package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		ChessMatch chessMatch = new ChessMatch();
		
		while (true) {
			try {
				UI.clearScreen();
				UI.printMatch(chessMatch);
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(input);
				
				boolean[][] possibleMove = chessMatch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces(), possibleMove);
				
				System.out.println();
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(input);
				
				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
		
			}
			catch (ChessException e) {
				System.out.println(e.getMessage());
				System.out.println("Press Enter to continue");
				input.nextLine();
			}
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				System.out.println("Press Enter to continue");
				input.nextLine();
			}
		}
		
	}

}
