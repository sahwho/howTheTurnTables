import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class BoardPublicTests {

	@Test
	//0.5 Points
	public void testConstructorCurrentPlayerHalfPoint() {
		Board b = new Board();
		assertEquals(Position.Color.BLACK, b.getCurrentPlayer());
	}

	@Test
	//0.5 Points
	public void testConstructorCountColorPiecesBlackHalfPoint() {
		Board b = new Board();
		assertEquals(2, b.countColorPieces(Position.Color.BLACK));
	}

	@Test
	//0.5 Points
	public void testConstructorCountColorPiecesWhiteHalfPoint() {
		Board b = new Board();
		assertEquals(2, b.countColorPieces(Position.Color.WHITE));
	}

	@Test
	//0.5 Points
	public void testConstructorCountColorPiecesEmptyHalfPoint() {
		Board b = new Board();
		assertEquals(60, b.countColorPieces(Position.Color.EMPTY));
	}

	@Test
	//0.5 Point
	public void testConstructorBlackPieceE4HalfPoint() {
		Board b = new Board();
		Position[][] board = b.getBoard();
		assertEquals(new Position("e4", Position.Color.BLACK), board[3][4]);
	}

	@Test
	//0.5 Point
	public void testConstructorBlackPieceD5HalfPoint() {
		Board b = new Board();
		Position[][] board = b.getBoard();
		assertEquals(new Position("d5", Position.Color.BLACK), board[4][3]);
	}

	@Test
	//0.5 Point
	public void testConstructorWhitePieceD4HalfPoint() {
		Board b = new Board();
		Position[][] board = b.getBoard();
		assertEquals(new Position("d4", Position.Color.WHITE), board[3][3]);
	}

	@Test
	//0.5 Point
	public void testConstructorWhitePieceE5HalfPoint() {
		Board b = new Board();
		Position[][] board = b.getBoard();
		assertEquals(new Position("e5", Position.Color.WHITE), board[4][4]);
	}

	@Test
	//0.5 Points
	public void testPiecesHaveSameColorHalfPoint() {
		ArrayList<Position> pieces = new ArrayList<Position>();
		pieces.add(new Position("d4", Position.Color.BLACK));
		pieces.add(new Position("d5", Position.Color.BLACK));
		assertTrue(Board.piecesHaveSameColor(pieces));
	}

	@Test
	//0.5 Points
	public void testPiecesHaveSameColor2HalfPoint() {
		ArrayList<Position> pieces = new ArrayList<Position>();
		pieces.add(new Position("d4", Position.Color.BLACK));
		pieces.add(new Position("d5", Position.Color.WHITE));
		assertFalse(Board.piecesHaveSameColor(pieces));
	}

	@Test
	//0.5 Points
	public void testPiecesHaveSameColor3HalfPoint() {
		ArrayList<Position> pieces = new ArrayList<Position>();
		pieces.add(new Position("c4", Position.Color.BLACK));
		pieces.add(new Position("d4", Position.Color.BLACK));
		pieces.add(new Position("e4", Position.Color.BLACK));
		pieces.add(new Position("d5", Position.Color.WHITE));
		assertFalse(Board.piecesHaveSameColor(pieces));
	}

	@Test
	//0.5 Points
	public void testPiecesHaveSameColor4HalfPoint() {
		ArrayList<Position> pieces = new ArrayList<Position>();
		pieces.add(new Position("d4", Position.Color.BLACK));
		assertTrue(Board.piecesHaveSameColor(pieces));
	}

	@Test
	//1 Point
	public void testDetermineWinnerEmpty1Point() {
		Board b = new Board();
		assertEquals(Position.Color.EMPTY, b.determineWinner());
	}

	@Test
	//1 Point
	public void testDetermineWinnerBlack1Point() {
		Board b = new Board();
		b.play(new Position("c4", Position.Color.BLACK));
		assertEquals(Position.Color.BLACK, b.determineWinner());
	}

	@Test
	//1 point
	public void testDetermineWinnerWhite1Point() {
		Board b = new Board();
		b.play(new Position("c4", Position.Color.BLACK));
		b.play(new Position("e3", Position.Color.WHITE));
		b.play(new Position("f6", Position.Color.BLACK));
		b.play(new Position("b4", Position.Color.WHITE));
		assertEquals(Position.Color.WHITE, b.determineWinner());
	}

	@Test
	//2 Point
	public void testCheckHorizontalRight2Point() {
		Board b = new Board();
		Position p = new Position("c4", Position.Color.BLACK);
		ArrayList<Position> piecesToCapture = b.checkHorizontalRight(p);
		assertEquals(1, piecesToCapture.size());
		assertEquals(new Position("d4", Position.Color.WHITE), piecesToCapture.get(0));
		assertEquals("d4W", piecesToCapture.get(0).toString());
	}

	@Test
	//2 Point
	public void testCheckHorizontalRightBoardState2Point() {
		Board b = new Board();
		Position p = new Position("c4", Position.Color.BLACK);
		ArrayList<Position> piecesToCapture = b.checkHorizontalRight(p);
		assertEquals(1, piecesToCapture.size());
		assertEquals(new Position("d4", Position.Color.WHITE), piecesToCapture.get(0));
		assertEquals("d4W", piecesToCapture.get(0).toString());

		//calling checkHorizontalRight() shouldn't have changed the state of the board, so verify this:
		assertEquals(60, b.countColorPieces(Position.Color.EMPTY));
		assertEquals(2, b.countColorPieces(Position.Color.BLACK));
		assertEquals(2, b.countColorPieces(Position.Color.WHITE));

		assertEquals(new Position("e5", Position.Color.WHITE), b.getBoard()[4][4]);
		assertEquals(new Position("d4", Position.Color.WHITE), b.getBoard()[3][3]);
		assertEquals(new Position("d5", Position.Color.BLACK), b.getBoard()[4][3]);
		assertEquals(new Position("e4", Position.Color.BLACK), b.getBoard()[3][4]);
	}

	@Test
	//2 Point
	public void testCheckHorizontalRightEmptyBoardState2Point() {
		Board b = new Board();
		Position p = new Position("d3", Position.Color.BLACK);
		ArrayList<Position> piecesToCapture = b.checkHorizontalRight(p);
		assertEquals(0, piecesToCapture.size());

		//calling checkHorizontalRight() shouldn't have changed the state of the board, so verify this:
		assertEquals(60, b.countColorPieces(Position.Color.EMPTY));
		assertEquals(2, b.countColorPieces(Position.Color.BLACK));
		assertEquals(2, b.countColorPieces(Position.Color.WHITE));

		assertEquals(new Position("e5", Position.Color.WHITE), b.getBoard()[4][4]);
		assertEquals(new Position("d4", Position.Color.WHITE), b.getBoard()[3][3]);
		assertEquals(new Position("d5", Position.Color.BLACK), b.getBoard()[4][3]);
		assertEquals(new Position("e4", Position.Color.BLACK), b.getBoard()[3][4]);
	}

	@Test
	//2 Point
	public void testCheckVerticalDown2Point() {
		Board b = new Board();
		Position p = new Position("d3", Position.Color.BLACK);
		ArrayList<Position> piecesToCapture = b.checkVerticalDown(p);
		assertEquals(1, piecesToCapture.size());
		assertEquals(new Position("d4", Position.Color.WHITE), piecesToCapture.get(0));
		assertEquals("d4W", piecesToCapture.get(0).toString());
	}

	@Test
	//2 Point
	public void testCheckVerticalDownBoardState2Point() {
		Board b = new Board();
		Position p = new Position("d3", Position.Color.BLACK);
		ArrayList<Position> piecesToCapture = b.checkVerticalDown(p);
		assertEquals(1, piecesToCapture.size());
		assertEquals(new Position("d4", Position.Color.WHITE), piecesToCapture.get(0));
		assertEquals("d4W", piecesToCapture.get(0).toString());

		//calling checkVerticalDown() shouldn't have changed the state of the board, so verify this:
		assertEquals(60, b.countColorPieces(Position.Color.EMPTY));
		assertEquals(2, b.countColorPieces(Position.Color.BLACK));
		assertEquals(2, b.countColorPieces(Position.Color.WHITE));

		assertEquals(new Position("e5", Position.Color.WHITE), b.getBoard()[4][4]);
		assertEquals(new Position("d4", Position.Color.WHITE), b.getBoard()[3][3]);
		assertEquals(new Position("d5", Position.Color.BLACK), b.getBoard()[4][3]);
		assertEquals(new Position("e4", Position.Color.BLACK), b.getBoard()[3][4]);
	}

	@Test
	//2 Point
	public void testCheckVerticalDownEmptyBoardState2Point() {
		Board b = new Board();
		Position p = new Position("c4", Position.Color.BLACK);
		ArrayList<Position> piecesToCapture = b.checkVerticalDown(p);
		assertEquals(0, piecesToCapture.size());

		//calling checkVerticalDown() shouldn't have changed the state of the board, so verify this:
		assertEquals(60, b.countColorPieces(Position.Color.EMPTY));
		assertEquals(2, b.countColorPieces(Position.Color.BLACK));
		assertEquals(2, b.countColorPieces(Position.Color.WHITE));

		assertEquals(new Position("e5", Position.Color.WHITE), b.getBoard()[4][4]);
		assertEquals(new Position("d4", Position.Color.WHITE), b.getBoard()[3][3]);
		assertEquals(new Position("d5", Position.Color.BLACK), b.getBoard()[4][3]);
		assertEquals(new Position("e4", Position.Color.BLACK), b.getBoard()[3][4]);
	}

	@Test
	//2 Point
	public void testCheckDiagonalUpLeftEmptyBoardState2Point() {
		Board b = new Board();
		Position p = new Position("f6", Position.Color.BLACK);
		ArrayList<Position> piecesToCapture = b.checkDiagonalUpLeft(p);
		assertEquals(0, piecesToCapture.size());

		//calling checkDiagonalUpLeft() shouldn't have changed the state of the board, so verify this:
		assertEquals(60, b.countColorPieces(Position.Color.EMPTY));
		assertEquals(2, b.countColorPieces(Position.Color.BLACK));
		assertEquals(2, b.countColorPieces(Position.Color.WHITE));

		assertEquals(new Position("e5", Position.Color.WHITE), b.getBoard()[4][4]);
		assertEquals(new Position("d4", Position.Color.WHITE), b.getBoard()[3][3]);
		assertEquals(new Position("d5", Position.Color.BLACK), b.getBoard()[4][3]);
		assertEquals(new Position("e4", Position.Color.BLACK), b.getBoard()[3][4]);
	}

	@Test
	//0.5 Points
	public void testIsValidMove1HalfPoint() {
		Board b = new Board();
		Position p = new Position("c4", Position.Color.BLACK);
		assertTrue(b.isValidMove(p));
	}

	@Test
	//0.5 Points
	public void testIsValidMove2HalfPoint() {
		Board b = new Board();
		Position p = new Position("c4", Position.Color.WHITE);
		assertFalse(b.isValidMove(p));
	}

	@Test
	//0.5 Points
	public void testIsValidMove3HalfPoint() {
		Board b = new Board();
		Position p = new Position("q2", Position.Color.WHITE);
		assertFalse(b.isValidMove(p));
	}

	@Test
	//0.5 Points
	public void testIsValidMove4HalfPoint() {
		Board b = new Board();
		Position p = new Position("c4", Position.Color.BLACK);
		assertTrue(b.isValidMove(p));

		b.play(p);

		Position p2 = new Position("e3", Position.Color.WHITE);
		assertTrue(b.isValidMove(p2));
	}

	@Test
	//3 Points
	public void testPlayHorizontalCapture3Points() {
		Board b = new Board();
		Position p = new Position("c4", Position.Color.BLACK);
		assertTrue(b.isValidMove(p));

		ArrayList<Object> returned = b.play(p);
		assertEquals(p, (Position)returned.get(0));

		ArrayList<Position> captured = new ArrayList<Position>();
		captured.add(new Position("d4", Position.Color.WHITE));

		assertEquals(captured, (ArrayList<Position>)returned.get(1));
	}

	@Test
	//3 Points
	public void testPlayVerticalCapture3Points() {
		Board b = new Board();
		Position p = new Position("d3", Position.Color.BLACK);
		assertTrue(b.isValidMove(p));

		ArrayList<Object> returned = b.play(p);
		assertEquals((Position)returned.get(0), p);

		ArrayList<Position> captured = new ArrayList<Position>();
		captured.add(new Position("d4", Position.Color.WHITE));

		assertEquals(captured, (ArrayList<Position>)returned.get(1));
	}

	@Test
	//0.5 Point
	public void testPlayInvalidMoveNotCurrentPlayerHalfPoint() {
		Board b = new Board();
		Position p = new Position("c5", Position.Color.WHITE);

		//invalid because it's not white's turn
		assertFalse(b.isValidMove(p));

		//play should return an empty ArrayList
		ArrayList<Object> pieces = b.play(p);

		assertTrue(pieces.isEmpty());
	}

	@Test
	//0.5 Point
	public void testPlayInvalidMoveAlreadyFullHalfPoint() {
		Board b = new Board();
		Position p = new Position("d4", Position.Color.BLACK);

		//invalid because d4 already has a piece there
		assertFalse(b.isValidMove(p));

		//play should return an empty ArrayList
		ArrayList<Object> pieces = b.play(p);

		assertTrue(pieces.isEmpty());
	}

	//SECRET: 8 Points
	@Test
	public void testSecretGame8Points() {
		//Plays many moves...
	}
}
