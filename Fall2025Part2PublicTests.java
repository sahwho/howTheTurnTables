import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class Fall2025Part2PublicTests {

	/* Important: the @Test annotation above every test case is what allows the test
	 * to be run (and visualized) in Eclipse. Make sure not to delete it or comment it out.*/
	
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
		assertEquals(new Piece("e4", Piece.Color.BLACK).toString(), board[3][4].toString());
	}

	@Test
	public void testConstructorBlackPieceD5() {
		Board b = new Board();
		Piece[][] board = b.getBoard();
		assertEquals(new Piece("d5", Piece.Color.BLACK).toString(), board[4][3].toString());
	}

	@Test
	public void testConstructorWhitePieceD4() {
		Board b = new Board();
		Piece[][] board = b.getBoard();
		assertEquals(new Piece("d4", Piece.Color.WHITE).toString(), board[3][3].toString());
	}

	@Test
	public void testConstructorWhitePieceE5() {
		Board b = new Board();
		Piece[][] board = b.getBoard();
		assertEquals(new Piece("e5", Piece.Color.WHITE).toString(), board[4][4].toString());
	}

	

	@Test
	public void testDetermineWinnerEmpty() {
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
	//2 Point
	public void testCheckHorizontalRight2Point() {
		Board b = new Board();
		Piece p = new Piece("c4", Piece.Color.BLACK);
		Piece[] piecesToCapture = b.checkHorizontalRight(p);
		assertEquals(1, piecesToCapture.length);
		assertEquals(new Piece("d4", Piece.Color.WHITE).toString(), piecesToCapture[0].toString());
		assertEquals("d4W", piecesToCapture[0].toString());
	}

	@Test
	//2 Point
	public void testCheckHorizontalRightBoardState2Point() {
		Board b = new Board();
		Piece p = new Piece("c4", Piece.Color.BLACK);
		Piece[] piecesToCapture = b.checkHorizontalRight(p);
		assertEquals(1, piecesToCapture.length);
		assertEquals(new Piece("d4", Piece.Color.WHITE).toString(), piecesToCapture[0].toString());
		assertEquals("d4W", piecesToCapture[0].toString());

		//calling checkHorizontalRight() shouldn't have changed the state of the board, so verify this:
		assertEquals(60, b.countColorPieces(Piece.Color.EMPTY));
		assertEquals(2, b.countColorPieces(Piece.Color.BLACK));
		assertEquals(2, b.countColorPieces(Piece.Color.WHITE));

		assertEquals(new Piece("e5", Piece.Color.WHITE).toString(), b.getBoard()[4][4].toString());
		assertEquals(new Piece("d4", Piece.Color.WHITE).toString(), b.getBoard()[3][3].toString());
		assertEquals(new Piece("d5", Piece.Color.BLACK).toString(), b.getBoard()[4][3].toString());
		assertEquals(new Piece("e4", Piece.Color.BLACK).toString(), b.getBoard()[3][4].toString());
	}

	@Test
	//2 Point
	public void testCheckHorizontalRightEmptyBoardState2Point() {
		Board b = new Board();
		Piece p = new Piece("d3", Piece.Color.BLACK);
		Piece[] piecesToCapture = b.checkHorizontalRight(p);
		assertEquals(0, piecesToCapture.length);

		//calling checkHorizontalRight() shouldn't have changed the state of the board, so verify this:
		assertEquals(60, b.countColorPieces(Piece.Color.EMPTY));
		assertEquals(2, b.countColorPieces(Piece.Color.BLACK));
		assertEquals(2, b.countColorPieces(Piece.Color.WHITE));

		assertEquals(new Piece("e5", Piece.Color.WHITE).toString(), b.getBoard()[4][4].toString());
		assertEquals(new Piece("d4", Piece.Color.WHITE).toString(), b.getBoard()[3][3].toString());
		assertEquals(new Piece("d5", Piece.Color.BLACK).toString(), b.getBoard()[4][3].toString());
		assertEquals(new Piece("e4", Piece.Color.BLACK).toString(), b.getBoard()[3][4].toString());
	}

	@Test
	//2 Point
	public void testCheckVerticalDown2Point() {
		Board b = new Board();
		Piece p = new Piece("d3", Piece.Color.BLACK);
		Piece[] piecesToCapture = b.checkVerticalDown(p);
		assertEquals(1, piecesToCapture.length);
		assertEquals(new Piece("d4", Piece.Color.WHITE).toString(), piecesToCapture[0].toString());
		assertEquals("d4W", piecesToCapture[0].toString());
	}

	@Test
	//2 Point
	public void testCheckVerticalDownBoardState2Point() {
		Board b = new Board();
		Piece p = new Piece("d3", Piece.Color.BLACK);
		Piece[] piecesToCapture = b.checkVerticalDown(p);
		assertEquals(1, piecesToCapture.length);
		assertEquals(new Piece("d4", Piece.Color.WHITE).toString(), piecesToCapture[0].toString());
		assertEquals("d4W", piecesToCapture[0].toString());

		//calling checkVerticalDown() shouldn't have changed the state of the board, so verify this:
		assertEquals(60, b.countColorPieces(Piece.Color.EMPTY));
		assertEquals(2, b.countColorPieces(Piece.Color.BLACK));
		assertEquals(2, b.countColorPieces(Piece.Color.WHITE));

		assertEquals(new Piece("e5", Piece.Color.WHITE).toString(), b.getBoard()[4][4].toString());
		assertEquals(new Piece("d4", Piece.Color.WHITE).toString(), b.getBoard()[3][3].toString());
		assertEquals(new Piece("d5", Piece.Color.BLACK).toString(), b.getBoard()[4][3].toString());
		assertEquals(new Piece("e4", Piece.Color.BLACK).toString(), b.getBoard()[3][4].toString());
	}

	@Test
	//2 Point
	public void testCheckVerticalDownEmptyBoardState2Point() {
		Board b = new Board();
		Piece p = new Piece("c4", Piece.Color.BLACK);
		Piece[] piecesToCapture = b.checkVerticalDown(p);
		assertEquals(0, piecesToCapture.length);

		//calling checkVerticalDown() shouldn't have changed the state of the board, so verify this:
		assertEquals(60, b.countColorPieces(Piece.Color.EMPTY));
		assertEquals(2, b.countColorPieces(Piece.Color.BLACK));
		assertEquals(2, b.countColorPieces(Piece.Color.WHITE));

		assertEquals(new Piece("e5", Piece.Color.WHITE).toString(), b.getBoard()[4][4].toString());
		assertEquals(new Piece("d4", Piece.Color.WHITE).toString(), b.getBoard()[3][3].toString());
		assertEquals(new Piece("d5", Piece.Color.BLACK).toString(), b.getBoard()[4][3].toString());
		assertEquals(new Piece("e4", Piece.Color.BLACK).toString(), b.getBoard()[3][4].toString());
	}

	@Test
	//2 Point
	public void testCheckDiagonalUpLeftEmptyBoardState2Point() {
		Board b = new Board();
		Piece p = new Piece("f6", Piece.Color.BLACK);
		Piece[] piecesToCapture = b.checkDiagonalUpLeft(p);
		assertEquals(0, piecesToCapture.length);

		//calling checkDiagonalUpLeft() shouldn't have changed the state of the board, so verify this:
		assertEquals(60, b.countColorPieces(Piece.Color.EMPTY));
		assertEquals(2, b.countColorPieces(Piece.Color.BLACK));
		assertEquals(2, b.countColorPieces(Piece.Color.WHITE));

		assertEquals(new Piece("e5", Piece.Color.WHITE).toString(), b.getBoard()[4][4].toString());
		assertEquals(new Piece("d4", Piece.Color.WHITE).toString(), b.getBoard()[3][3].toString());
		assertEquals(new Piece("d5", Piece.Color.BLACK).toString(), b.getBoard()[4][3].toString());
		assertEquals(new Piece("e4", Piece.Color.BLACK).toString(), b.getBoard()[3][4].toString());
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
	//3 Points
	public void testPlayHorizontalCapture3Points() {
		Board b = new Board();
		Piece p = new Piece("c4", Piece.Color.BLACK);
		assertEquals(true, b.isValidMove(p));

		Piece[] returned = b.play(p);

		Piece captured = new Piece("d4", Piece.Color.WHITE);
		assertEquals(1, returned.length);
		assertEquals(captured.toString(), returned[0].toString());
	}

	@Test
	//3 Points
	public void testPlayVerticalCapture3Points() {
		Board b = new Board();
		Piece p = new Piece("d3", Piece.Color.BLACK);
		assertEquals(true, b.isValidMove(p));

		Piece[] returned = b.play(p);
		Piece captured = new Piece("d4", Piece.Color.WHITE);

		assertEquals(1, returned.length);
		assertEquals(captured.toString(), returned[0].toString());
	}

	@Test
	public void testPlayInvalidMoveNotCurrentPlayer() {
		Board b = new Board();
		Piece p = new Piece("c5", Piece.Color.WHITE);

		//invalid because it's not white's turn
		assertEquals(false, b.isValidMove(p));

		//play should return an empty array
		Piece[] pieces = b.play(p);

		System.out.println(Arrays.toString(pieces));

		assertArrayEquals(new Piece[0], pieces);
	}

	@Test
	public void testPlayInvalidMoveAlreadyFull() {
		Board b = new Board();
		Piece p = new Piece("d4", Piece.Color.BLACK);

		//invalid because d4 already has a piece there
		assertEquals(false, b.isValidMove(p));

		//play should return an empty array
		Piece[] pieces = b.play(p);

		assertArrayEquals(new Piece[0], pieces);
	}

	@Test
	public void testPrivateGame8Points() {
		// a private test worth 8 points...
	}
}
