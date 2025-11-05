import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**
* Unit test file for Reversi Project, Part 3 (ArrayList Refactor).
* A series of test cases written using JUnit 4, MBHS Fall 2025.
* 
* @author Vikash Sahu
* @date 11/5/2025
* @course ADSB, MBHS Fall 2025
* @aiusage None :)
*/

public class Fall2025Part3PublicTests {

	@Test
	public void testConstructorCurrentPlayer() {
		Board b = new Board();
		assertEquals(Piece.Color.BLACK, b.getCurrentPlayer());
	}

	@Test
	public void testConstructorCountColorPiecesBlack() {
		Board b = new Board();
		assertEquals(2, b.countColorPieces(Piece.Color.BLACK));
	}

	@Test
	public void testConstructorCountColorPiecesWhite() {
		Board b = new Board();
		assertEquals(2, b.countColorPieces(Piece.Color.WHITE));
	}

	@Test
	public void testConstructorCountColorPiecesEmpty() {
		Board b = new Board();
		assertEquals(60, b.countColorPieces(Piece.Color.EMPTY));
	}

	@Test
	public void testConstructorBlackPieceE4() {
		Board b = new Board();
		Piece[][] board = b.getBoard();
		assertEquals(new Piece("e4", Piece.Color.BLACK), board[3][4]);
	}

	@Test
	public void testConstructorBlackPieceD5() {
		Board b = new Board();
		Piece[][] board = b.getBoard();
		assertEquals(new Piece("d5", Piece.Color.BLACK), board[4][3]);
	}

	@Test
	public void testConstructorWhitePieceD4() {
		Board b = new Board();
		Piece[][] board = b.getBoard();
		assertEquals(new Piece("d4", Piece.Color.WHITE), board[3][3]);
	}

	@Test
	public void testConstructorWhitePieceE5() {
		Board b = new Board();
		Piece[][] board = b.getBoard();
		assertEquals(new Piece("e5", Piece.Color.WHITE), board[4][4]);
	}

	@Test
	public void testDetermineWinnerEmpty1() {
		Board b = new Board();
		assertEquals(Piece.Color.EMPTY, b.determineWinner());
	}

	@Test
	public void testDetermineWinnerBlack() {
		Board b = new Board();
		b.play(new Piece("c4", Piece.Color.BLACK));
		assertEquals(Piece.Color.BLACK, b.determineWinner());
	}

	@Test
	public void testDetermineWinnerWhite() {
		Board b = new Board();
		b.play(new Piece("c4", Piece.Color.BLACK));
		b.play(new Piece("e3", Piece.Color.WHITE));
		b.play(new Piece("f6", Piece.Color.BLACK));
		b.play(new Piece("b4", Piece.Color.WHITE));
		assertEquals(Piece.Color.WHITE, b.determineWinner());
	}

	@Test
	public void testCheckHorizontalRight() {
		Board b = new Board();
		Piece p = new Piece("c4", Piece.Color.BLACK);
		ArrayList<Piece> piecesToCapture = b.checkHorizontalRight(p);
		assertEquals(1, piecesToCapture.size());
		assertEquals(new Piece("d4", Piece.Color.WHITE), piecesToCapture.get(0));
		assertEquals("d4W", piecesToCapture.get(0).toString());
	}

	@Test
	public void testCheckHorizontalRightBoardState() {
		Board b = new Board();
		Piece p = new Piece("c4", Piece.Color.BLACK);
		ArrayList<Piece> piecesToCapture = b.checkHorizontalRight(p);
		assertEquals(1, piecesToCapture.size());
		assertEquals(new Piece("d4", Piece.Color.WHITE), piecesToCapture.get(0));
		assertEquals("d4W", piecesToCapture.get(0).toString());

		//calling checkHorizontalRight() shouldn't have changed the state of the board, so verify this:
		assertEquals(60, b.countColorPieces(Piece.Color.EMPTY));
		assertEquals(2, b.countColorPieces(Piece.Color.BLACK));
		assertEquals(2, b.countColorPieces(Piece.Color.WHITE));

		assertEquals(new Piece("e5", Piece.Color.WHITE), b.getBoard()[4][4]);
		assertEquals(new Piece("d4", Piece.Color.WHITE), b.getBoard()[3][3]);
		assertEquals(new Piece("d5", Piece.Color.BLACK), b.getBoard()[4][3]);
		assertEquals(new Piece("e4", Piece.Color.BLACK), b.getBoard()[3][4]);
	}

	@Test
	public void testCheckHorizontalRightEmptyBoardState() {
		Board b = new Board();
		Piece p = new Piece("d3", Piece.Color.BLACK);
		ArrayList<Piece> piecesToCapture = b.checkHorizontalRight(p);
		assertEquals(0, piecesToCapture.size());

		//calling checkHorizontalRight() shouldn't have changed the state of the board, so verify this:
		assertEquals(60, b.countColorPieces(Piece.Color.EMPTY));
		assertEquals(2, b.countColorPieces(Piece.Color.BLACK));
		assertEquals(2, b.countColorPieces(Piece.Color.WHITE));

		assertEquals(new Piece("e5", Piece.Color.WHITE), b.getBoard()[4][4]);
		assertEquals(new Piece("d4", Piece.Color.WHITE), b.getBoard()[3][3]);
		assertEquals(new Piece("d5", Piece.Color.BLACK), b.getBoard()[4][3]);
		assertEquals(new Piece("e4", Piece.Color.BLACK), b.getBoard()[3][4]);
	}

	@Test
	public void testCheckVerticalDown() {
		Board b = new Board();
		Piece p = new Piece("d3", Piece.Color.BLACK);
		ArrayList<Piece> piecesToCapture = b.checkVerticalDown(p);
		assertEquals(1, piecesToCapture.size());
		assertEquals(new Piece("d4", Piece.Color.WHITE), piecesToCapture.get(0));
		assertEquals("d4W", piecesToCapture.get(0).toString());
	}

	@Test
	public void testCheckVerticalDownBoardState() {
		Board b = new Board();
		Piece p = new Piece("d3", Piece.Color.BLACK);
		ArrayList<Piece> piecesToCapture = b.checkVerticalDown(p);
		assertEquals(1, piecesToCapture.size());
		assertEquals(new Piece("d4", Piece.Color.WHITE), piecesToCapture.get(0));
		assertEquals("d4W", piecesToCapture.get(0).toString());

		//calling checkVerticalDown() shouldn't have changed the state of the board, so verify this:
		assertEquals(60, b.countColorPieces(Piece.Color.EMPTY));
		assertEquals(2, b.countColorPieces(Piece.Color.BLACK));
		assertEquals(2, b.countColorPieces(Piece.Color.WHITE));

		assertEquals(new Piece("e5", Piece.Color.WHITE), b.getBoard()[4][4]);
		assertEquals(new Piece("d4", Piece.Color.WHITE), b.getBoard()[3][3]);
		assertEquals(new Piece("d5", Piece.Color.BLACK), b.getBoard()[4][3]);
		assertEquals(new Piece("e4", Piece.Color.BLACK), b.getBoard()[3][4]);
	}

	@Test
	public void testCheckVerticalDownEmptyBoardState() {
		Board b = new Board();
		Piece p = new Piece("c4", Piece.Color.BLACK);
		ArrayList<Piece> piecesToCapture = b.checkVerticalDown(p);
		assertEquals(0, piecesToCapture.size());

		//calling checkVerticalDown() shouldn't have changed the state of the board, so verify this:
		assertEquals(60, b.countColorPieces(Piece.Color.EMPTY));
		assertEquals(2, b.countColorPieces(Piece.Color.BLACK));
		assertEquals(2, b.countColorPieces(Piece.Color.WHITE));

		assertEquals(new Piece("e5", Piece.Color.WHITE), b.getBoard()[4][4]);
		assertEquals(new Piece("d4", Piece.Color.WHITE), b.getBoard()[3][3]);
		assertEquals(new Piece("d5", Piece.Color.BLACK), b.getBoard()[4][3]);
		assertEquals(new Piece("e4", Piece.Color.BLACK), b.getBoard()[3][4]);
	}

	@Test
	public void testCheckDiagonalUpLeftEmptyBoardState() {
		Board b = new Board();
		Piece p = new Piece("f6", Piece.Color.BLACK);
		ArrayList<Piece> piecesToCapture = b.checkDiagonalUpLeft(p);
		assertEquals(0, piecesToCapture.size());

		//calling checkDiagonalUpLeft() shouldn't have changed the state of the board, so verify this:
		assertEquals(60, b.countColorPieces(Piece.Color.EMPTY));
		assertEquals(2, b.countColorPieces(Piece.Color.BLACK));
		assertEquals(2, b.countColorPieces(Piece.Color.WHITE));

		assertEquals(new Piece("e5", Piece.Color.WHITE), b.getBoard()[4][4]);
		assertEquals(new Piece("d4", Piece.Color.WHITE), b.getBoard()[3][3]);
		assertEquals(new Piece("d5", Piece.Color.BLACK), b.getBoard()[4][3]);
		assertEquals(new Piece("e4", Piece.Color.BLACK), b.getBoard()[3][4]);
	}

	@Test
	public void testIsValidMove1() {
		Board b = new Board();
		Piece p = new Piece("c4", Piece.Color.BLACK);
		assertTrue(b.isValidMove(p));
	}

	@Test
	public void testIsValidMove2() {
		Board b = new Board();
		Piece p = new Piece("c4", Piece.Color.WHITE);
		assertFalse(b.isValidMove(p));
	}

	@Test
	public void testIsValidMove3() {
		Board b = new Board();
		Piece p = new Piece("q2", Piece.Color.WHITE);
		assertFalse(b.isValidMove(p));
	}

	@Test
	public void testIsValidMove4() {
		Board b = new Board();
		Piece p = new Piece("c4", Piece.Color.BLACK);
		assertTrue(b.isValidMove(p));

		b.play(p);

		Piece p2 = new Piece("e3", Piece.Color.WHITE);
		assertTrue(b.isValidMove(p2));
	}

	@Test
	public void testPlayHorizontalCapture() {
		Board b = new Board();
		Piece p = new Piece("c4", Piece.Color.BLACK);
		assertTrue(b.isValidMove(p));

		ArrayList<Piece> returned = b.play(p);

		ArrayList<Piece> captured = new ArrayList<Piece>();
		captured.add(new Piece("d4", Piece.Color.WHITE));

		assertEquals(captured, returned);
	}

	@Test
	public void testPlayVerticalCapture() {
		Board b = new Board();
		Piece p = new Piece("d3", Piece.Color.BLACK);
		assertTrue(b.isValidMove(p));

		ArrayList<Piece> returned = b.play(p);

		ArrayList<Piece> captured = new ArrayList<Piece>();
		captured.add(new Piece("d4", Piece.Color.WHITE));

		assertEquals(captured, returned);
	}

	@Test
	public void testPlayInvalidMoveNotCurrentPlayer() {
		Board b = new Board();
		Piece p = new Piece("c5", Piece.Color.WHITE);

		//invalid because it's not white's turn
		assertFalse(b.isValidMove(p));

		//play should return an empty ArrayList
		ArrayList<Piece> pieces = b.play(p);

		assertTrue(pieces.isEmpty());
	}

	@Test
	public void testPlayInvalidMoveAlreadyFull() {
		Board b = new Board();
		Piece p = new Piece("d4", Piece.Color.BLACK);

		//invalid because d4 already has a piece there
		assertFalse(b.isValidMove(p));

		//play should return an empty ArrayList
		ArrayList<Piece> pieces = b.play(p);

		assertTrue(pieces.isEmpty());
	}
}
