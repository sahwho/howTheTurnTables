import java.util.ArrayList;

/*
 * Starter Code Written by @Author Vikash Sahu
 */

public class BoardStarter { //TODO: rename to "Board"
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

	@Override
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

	//TODO
	public boolean isValidMove(Position.Color c, Position p) {

	}

	public ArrayList<Position> checkHorizontalLeft(Position startPosition) {
		//TODO
	}

	public ArrayList<Position> checkHorizontalRight(Position startPosition) {
		//TODO
	}

	public ArrayList<Position> checkVerticalUp(Position startPosition) {
		//TODO
	}

	public ArrayList<Position> checkVerticalDown(Position startPosition) {
		//TODO
	}

	public ArrayList<Object> play(Position p) {
		if (!isValidMove(p.getPiece(), p)) {
			return new ArrayList<Object>();
		}

		//TODO
	}

	public void capturePieces(ArrayList<Position> piecesToCapture) {
		//TODO
	}

	public static void main(String[] args) {
		// contains some ideas for testing through the main method;
		// you should also write some unit tests
		Board b = new Board();
		System.out.println(b);

		Position p = new Position("f5", Position.Color.BLACK);
		System.out.println(b.checkHorizontalLeft(p)); // should output [e5w]

		Position p2 = new Position("c4", Position.Color.BLACK);
		System.out.println(b.checkHorizontalRight(p2)); // should output [d4w]

		Position p3 = new Position("e6", Position.Color.BLACK);
		System.out.println(b.checkVerticalUp(p3)); // should output [e5w]

		Position p4 = new Position("d3", Position.Color.BLACK);
		System.out.println(b.checkVerticalDown(p4)); // should output [d4w]

		//Test play()
		System.out.println(b.play(p)); // should output: [f5B, [e5W]]
		System.out.println(b);

		Position p5 = new Position("d6", Position.Color.WHITE);
		System.out.println(b.play(p5)); // should output: [d6W, [d5B]]
		System.out.println(b);
	}
}
