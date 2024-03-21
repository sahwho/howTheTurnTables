import java.util.ArrayList;

/*
 * @Author Vikash Sahu
 */

public class BoardStarter { //TODO: rename to Board
	private Position.Color currentPlayer;
	private Position[][] board;

	public Board() {
		//TODO
	}

	public Position.Color getCurrentPlayer() {
		return currentPlayer;
	}

	public Position[][] getBoard() {
		return board;
	}

	public int countColorPieces(Position.Color c) {
		//TODO
	}

	public Position.Color determineWinner() {
		//TODO
	}

	public static boolean piecesHaveSameColor(ArrayList<Position> pieces) {
		//TODO
	}

	public String toString() {
		String colHeader = "  a b c d e f g h\n";

		String s = "";
		s+= colHeader;
		for (int i=0; i<board.length; i++) {
			s += i+1 + " ";
			for (int j=0; j<board[i].length; j++) {
				if (board[i][j].getPiece()==Position.Color.WHITE) {
					s += "W ";
				} else if (board[i][j].getPiece()==Position.Color.BLACK) {
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

	public boolean isValidMove(Position p) {
		//TODO
	}

	public ArrayList<Position> checkHorizontalRight(Position startPosition) {
		//TODO
	}

	public ArrayList<Position> checkVerticalDown(Position startPosition) {
		//TODO
	}

	public ArrayList<Position> checkDiagonalUpLeft(Position startPosition) {
		//TODO
	}

	public ArrayList<Object> play(Position p) {
		//TODO
	}

	public void capturePieces(ArrayList<Position> piecesToCapture) {
		//TODO
	}

  //Some code below has been written for you to do some basic testing.
	//Make sure to write unit tests and pass the public test cases as well.
	public static void main(String[] args) {
		Board b = new Board();
		System.out.println(b);

		//Horizontal Checks
		System.out.println("Horizontal Right Check");

		Position p2 = new Position("c4", Position.Color.BLACK);
		System.out.println("Should output: [d4W], and is: " + b.checkHorizontalRight(p2)); // should output [d4w]

		//Vertical Checks
		System.out.println();
		System.out.println("Vertical Down Check");

		Position p4 = new Position("d3", Position.Color.BLACK);
		System.out.println("Should output: [d4W], and is: " + b.checkVerticalDown(p4)); // should output [d4w]

		//Test play()
		System.out.println();
		System.out.println("play() checks");
		System.out.println("Should output: [c4B, [d4W]], and is: " + b.play(p2));
		System.out.println(b);

		Position p5 = new Position("e3", Position.Color.WHITE);
		System.out.println("Should output: [e3W, [e4B]], and is: " + b.play(p5));
		System.out.println(b);

		//Diagonal Checks
		System.out.println("Diagonal Up Left Check");

		Position p9 = new Position("f6", Position.Color.BLACK);
		System.out.println("Should output: [e5W], and is: " + b.checkDiagonalUpLeft(p9));

		System.out.println();
		System.out.println("diagonal play() check");
		System.out.println("Should output: [f6B, [e5W]], and is: " + b.play(p9));
		System.out.println(b);
	}
}
