
/*
 * This is the starter code for the Board class of the Reversi Project
 * in the Fall 2025 Semester.
 * 
 * @author Vikash Sahu 
 * @date 10/16/2025
 * @course ADSB, MBHS Fall 2025
 * @sources https://en.wikipedia.org/wiki/Reversi
 * @aiusage none :)
 */

import java.util.Arrays;

public class Fall2025BoardStarter { //TODO: rename to Board
	private Piece.Color currentPlayer;
	private Piece[][] board;

	public Board() { 
		// TODO
	}

	public Piece.Color getCurrentPlayer() { 
		return currentPlayer; 
	}

	public Piece[][] getBoard() { 
		return board;
	}

	public int countColorPieces(Piece.Color c) { 
		// TODO
		return 0;
	}

	public Piece.Color determineWinner() { 
		// TODO
		return Piece.Color.EMPTY;
	}

	public String toString() { 
		String colHeader = "  a b c d e f g h\n";

		String s = ""; 
		s+= colHeader; 
		for (int i=0; i<board.length; i++) { 
			s += i+1 + " "; 
			for (int j=0; j<board[i].length; j++) { 
				if(board[i][j].getColor()==Piece.Color.WHITE) {
					s += "W "; 
				} else if (board[i][j].getColor()==Piece.Color.BLACK) {
					s += "B "; 
				} else { 
					s += "  "; 
				} 
			} 
			s += i + 1 + "\n"; 
		} 

		s += colHeader;

		return s; 
	}

	public boolean isValidMove(Piece p) {
		// TODO
		return false; 
	}

	public Piece[] checkHorizontalRight(Piece startPosition) {
		// TODO
		return null;
	}

	public Piece[] checkVerticalDown(Piece startPosition) {
		// TODO
		return null;
	}

	public Piece[] checkDiagonalUpLeft(Piece startPosition) {
		// TODO
		return null;
	}

	public Piece[] play(Piece p) {
		// TODO
		return null;
	}

	public void capturePieces(Piece[] piecesToCapture) { 
		// TODO
	}

	public static void main(String[] args) { 
		Board b = new Board();
		System.out.println("Initial Board: ");
		System.out.println();
		System.out.println(b);

		//Horizontal Checks 
		System.out.print("Horizontal Right Check");

		Piece p2 = new Piece("c4", Piece.Color.BLACK);
		System.out.println(" of " + p2);
		System.out.println("Should output: [d4W], and is: " + 
				Arrays.toString(b.checkHorizontalRight(p2))); // should output [d4w]

		//Vertical Checks 
		System.out.println();
		System.out.print("Vertical Down Check");

		Piece p4 = new Piece("d3", Piece.Color.BLACK);
		System.out.println(" of " + p4);
		System.out.println("Should output: [d4W], and is: " +
				Arrays.toString(b.checkVerticalDown(p4))); // should output [d4w]

		//Test play() 
		System.out.println(); 
		System.out.println("play() checks");
		System.out.print("playing " + p2);
		System.out.println(" should output: [d4W], and is: " + Arrays.toString(b.play(p2)));
		System.out.println(b);

		Piece p5 = new Piece("e3", Piece.Color.WHITE);
		System.out.print("playing " + p5);
		System.out.println(" should output: [e4B], and is: " + Arrays.toString(b.play(p5)));
		System.out.println(b);

		//Diagonal Checks 
		System.out.println("Diagonal Up Left Check");

		Piece p9 = new Piece("f6", Piece.Color.BLACK);
		System.out.println("Should output: [e5W], and is: " + Arrays.toString(b.checkDiagonalUpLeft(p9)));

		System.out.println(); 
		System.out.println("play() check");
		System.out.print("playing " + p9);
		System.out.println(" should output: [e5W], and is: " + Arrays.toString(b.play(p9)));
		System.out.println();
		System.out.println(b); 
	}
}
