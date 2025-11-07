
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
	
	@Test
	public void testGameWithSorting1() {
		Board b = new Board();
		Piece p = new Piece("c4", Piece.Color.BLACK);
		assertEquals(Piece.Color.BLACK, b.getCurrentPlayer());
		b.play(p);

		/* verify state of board after playing c4B */
		assertEquals(59, b.countColorPieces(Piece.Color.EMPTY));
		assertEquals(4, b.countColorPieces(Piece.Color.BLACK));
		assertEquals(1, b.countColorPieces(Piece.Color.WHITE));
		assertEquals(p.toString(), b.getBoard()[3][2].toString());
		assertEquals(Piece.Color.BLACK, b.getBoard()[3][3].getColor());
		assertEquals(Piece.Color.BLACK, b.getBoard()[3][4].getColor());
		assertEquals(Piece.Color.BLACK, b.getBoard()[4][3].getColor());
		assertEquals(Piece.Color.WHITE, b.getBoard()[4][4].getColor());
		/* end verification of state of board after playing c4B*/

		assertEquals(Piece.Color.WHITE, b.getCurrentPlayer());
		Piece p2 = new Piece("e3", Piece.Color.WHITE);
		b.play(p2);

		/* verify state of board after playing e3W */
		assertEquals(58, b.countColorPieces(Piece.Color.EMPTY));
		assertEquals(3, b.countColorPieces(Piece.Color.BLACK));
		assertEquals(3, b.countColorPieces(Piece.Color.WHITE));
		assertEquals(p2.toString(), b.getBoard()[2][4].toString());
		assertEquals(Piece.Color.BLACK, b.getBoard()[3][2].getColor());
		assertEquals(Piece.Color.BLACK, b.getBoard()[3][3].getColor());
		assertEquals(Piece.Color.BLACK, b.getBoard()[4][3].getColor());
		assertEquals(Piece.Color.WHITE, b.getBoard()[2][4].getColor());
		assertEquals(Piece.Color.WHITE, b.getBoard()[3][4].getColor());
		assertEquals(Piece.Color.WHITE, b.getBoard()[4][4].getColor());
		/* end verification of state of board after playing e3W*/

		Piece p3 = new Piece("f6", Piece.Color.BLACK);
		ArrayList<Piece> piecesToCapture = b.checkDiagonalUpLeft(p3);

		assertEquals(1, piecesToCapture.size());
		//check that other direction checks are empty
		assertEquals(0, b.checkHorizontalRight(p3).size());
		assertEquals(0, b.checkVerticalDown(p3).size());
		assertEquals(new Piece("e5", Piece.Color.WHITE), piecesToCapture.get(0));

		assertEquals(Piece.Color.BLACK, b.getCurrentPlayer());
		b.play(p3);

		/* verify state of board after playing f6B */
		assertEquals(57, b.countColorPieces(Piece.Color.EMPTY));
		assertEquals(5, b.countColorPieces(Piece.Color.BLACK));
		assertEquals(2, b.countColorPieces(Piece.Color.WHITE));
		assertEquals(p3.toString(), b.getBoard()[5][5].toString());
		assertEquals(Piece.Color.BLACK, b.getBoard()[3][2].getColor());
		assertEquals(Piece.Color.BLACK, b.getBoard()[3][3].getColor());
		assertEquals(Piece.Color.BLACK, b.getBoard()[4][3].getColor());
		assertEquals(Piece.Color.BLACK, b.getBoard()[4][4].getColor());
		assertEquals(Piece.Color.BLACK, b.getBoard()[5][5].getColor());
		assertEquals(Piece.Color.WHITE, b.getBoard()[2][4].getColor());
		assertEquals(Piece.Color.WHITE, b.getBoard()[3][4].getColor());
		/* end verification of state of board after playing f6B*/

		//should capture 2 black pieces (horizontal right only)
		Piece p4 = new Piece("b4", Piece.Color.WHITE);
		piecesToCapture = b.checkHorizontalRight(p4);
		//check that other direction checks are empty
		assertEquals(0, b.checkDiagonalUpLeft(p4).size());
		assertEquals(0, b.checkVerticalDown(p4).size());
		assertEquals(2, piecesToCapture.size());
		assertEquals("c4B", piecesToCapture.get(0).toString());
		assertEquals("d4B", piecesToCapture.get(1).toString());

		assertEquals(Piece.Color.WHITE, b.getCurrentPlayer());
	}
	
	@Test
	public void testGameWithSorting2() {
		Board b = new Board();
		Piece p = new Piece("c4", Piece.Color.BLACK);
		assertEquals(Piece.Color.BLACK, b.getCurrentPlayer());
		b.play(p);

		/* verify state of board after playing c4B */
		assertEquals(59, b.countColorPieces(Piece.Color.EMPTY));
		assertEquals(4, b.countColorPieces(Piece.Color.BLACK));
		assertEquals(1, b.countColorPieces(Piece.Color.WHITE));
		assertEquals(p.toString(), b.getBoard()[3][2].toString());
		assertEquals(Piece.Color.BLACK, b.getBoard()[3][3].getColor());
		assertEquals(Piece.Color.BLACK, b.getBoard()[3][4].getColor());
		assertEquals(Piece.Color.BLACK, b.getBoard()[4][3].getColor());
		assertEquals(Piece.Color.WHITE, b.getBoard()[4][4].getColor());
		/* end verification of state of board after playing c4B*/

		assertEquals(Piece.Color.WHITE, b.getCurrentPlayer());
		Piece p2 = new Piece("e3", Piece.Color.WHITE);
		b.play(p2);

		/* verify state of board after playing e3W */
		assertEquals(58, b.countColorPieces(Piece.Color.EMPTY));
		assertEquals(3, b.countColorPieces(Piece.Color.BLACK));
		assertEquals(3, b.countColorPieces(Piece.Color.WHITE));
		assertEquals(p2.toString(), b.getBoard()[2][4].toString());
		assertEquals(Piece.Color.BLACK, b.getBoard()[3][2].getColor());
		assertEquals(Piece.Color.BLACK, b.getBoard()[3][3].getColor());
		assertEquals(Piece.Color.BLACK, b.getBoard()[4][3].getColor());
		assertEquals(Piece.Color.WHITE, b.getBoard()[2][4].getColor());
		assertEquals(Piece.Color.WHITE, b.getBoard()[3][4].getColor());
		assertEquals(Piece.Color.WHITE, b.getBoard()[4][4].getColor());
		/* end verification of state of board after playing e3W*/

		Piece p3 = new Piece("f6", Piece.Color.BLACK);
		ArrayList<Piece> piecesToCapture = b.checkDiagonalUpLeft(p3);

		assertEquals(1, piecesToCapture.size());
		//check that other direction checks are empty
		assertEquals(0, b.checkHorizontalRight(p3).size());
		assertEquals(0, b.checkVerticalDown(p3).size());
		assertEquals(new Piece("e5", Piece.Color.WHITE), piecesToCapture.get(0));

		assertEquals(Piece.Color.BLACK, b.getCurrentPlayer());
		b.play(p3);

		/* verify state of board after playing f6B */
		assertEquals(57, b.countColorPieces(Piece.Color.EMPTY));
		assertEquals(5, b.countColorPieces(Piece.Color.BLACK));
		assertEquals(2, b.countColorPieces(Piece.Color.WHITE));
		assertEquals(p3.toString(), b.getBoard()[5][5].toString());
		assertEquals(Piece.Color.BLACK, b.getBoard()[3][2].getColor());
		assertEquals(Piece.Color.BLACK, b.getBoard()[3][3].getColor());
		assertEquals(Piece.Color.BLACK, b.getBoard()[4][3].getColor());
		assertEquals(Piece.Color.BLACK, b.getBoard()[4][4].getColor());
		assertEquals(Piece.Color.BLACK, b.getBoard()[5][5].getColor());
		assertEquals(Piece.Color.WHITE, b.getBoard()[2][4].getColor());
		assertEquals(Piece.Color.WHITE, b.getBoard()[3][4].getColor());
		/* end verification of state of board after playing f6B*/

		//should capture 2 black pieces (horizontal right only)
		Piece p4 = new Piece("b4", Piece.Color.WHITE);
		piecesToCapture = b.checkHorizontalRight(p4);
		//check that other direction checks are empty
		assertEquals(0, b.checkDiagonalUpLeft(p4).size());
		assertEquals(0, b.checkVerticalDown(p4).size());
		assertEquals(2, piecesToCapture.size());
		assertEquals("c4B", piecesToCapture.get(0).toString());
		assertEquals("d4B", piecesToCapture.get(1).toString());

		assertEquals(Piece.Color.WHITE, b.getCurrentPlayer());

		b.play(p4);

		/* verify state of board after playing b4W */
		assertEquals(56, b.countColorPieces(Piece.Color.EMPTY));
		assertEquals(3, b.countColorPieces(Piece.Color.BLACK));
		assertEquals(5, b.countColorPieces(Piece.Color.WHITE));
		assertEquals(p4.toString(), b.getBoard()[3][1].toString());
		assertEquals(Piece.Color.WHITE, b.getBoard()[3][1].getColor());
		assertEquals(Piece.Color.WHITE, b.getBoard()[3][2].getColor());
		assertEquals(Piece.Color.WHITE, b.getBoard()[3][3].getColor());
		assertEquals(Piece.Color.BLACK, b.getBoard()[4][3].getColor());
		assertEquals(Piece.Color.BLACK, b.getBoard()[4][4].getColor());
		assertEquals(Piece.Color.BLACK, b.getBoard()[5][5].getColor());
		assertEquals(Piece.Color.WHITE, b.getBoard()[2][4].getColor());
		assertEquals(Piece.Color.WHITE, b.getBoard()[3][4].getColor());
		/* end verification of state of board after playing b4W*/

		//Should capture 2 white pieces (vertical down only)
		Piece p5 = new Piece("e2", Piece.Color.BLACK);
		piecesToCapture = b.checkVerticalDown(p5);
		//check that other direction checks are empty
		assertEquals(0, b.checkHorizontalRight(p5).size());
		assertEquals(0, b.checkDiagonalUpLeft(p5).size());
		assertEquals(2, piecesToCapture.size());
		assertEquals("e3W", piecesToCapture.get(0).toString());
		assertEquals("e4W", piecesToCapture.get(1).toString());

		assertEquals(Piece.Color.BLACK, b.getCurrentPlayer());

		b.play(p5);

		/* verify state of board after playing e2B */
		assertEquals(55, b.countColorPieces(Piece.Color.EMPTY));
		assertEquals(6, b.countColorPieces(Piece.Color.BLACK));
		assertEquals(3, b.countColorPieces(Piece.Color.WHITE));
		assertEquals(p5.toString(), b.getBoard()[1][4].toString());
		assertEquals(Piece.Color.BLACK, b.getBoard()[1][4].getColor());
		assertEquals(Piece.Color.BLACK, b.getBoard()[2][4].getColor());
		assertEquals(Piece.Color.BLACK, b.getBoard()[3][4].getColor());
		assertEquals(Piece.Color.BLACK, b.getBoard()[4][4].getColor());
		assertEquals(Piece.Color.BLACK, b.getBoard()[5][5].getColor());
		assertEquals(Piece.Color.BLACK, b.getBoard()[4][3].getColor());

		assertEquals(Piece.Color.WHITE, b.getBoard()[3][1].getColor());
		assertEquals(Piece.Color.WHITE, b.getBoard()[3][2].getColor());
		assertEquals(Piece.Color.WHITE, b.getBoard()[3][3].getColor());
		/* end verification of state of board after playing e2B*/

		Piece p6 = new Piece("g7", Piece.Color.WHITE);
		piecesToCapture = b.checkDiagonalUpLeft(p6);
		assertEquals(2, piecesToCapture.size());
		//check that other direction checks are empty
		assertEquals(0, b.checkHorizontalRight(p6).size());
		assertEquals(0, b.checkVerticalDown(p6).size());
		assertEquals("e5B", piecesToCapture.get(0).toString());
		assertEquals("f6B", piecesToCapture.get(1).toString());

		assertEquals(Piece.Color.WHITE, b.getCurrentPlayer());

		b.play(p6);

		/* verify state of board after playing g7W */
		assertEquals(54, b.countColorPieces(Piece.Color.EMPTY));
		assertEquals(4, b.countColorPieces(Piece.Color.BLACK));
		assertEquals(6, b.countColorPieces(Piece.Color.WHITE));
		assertEquals(p6.toString(), b.getBoard()[6][6].toString());
		assertEquals(Piece.Color.WHITE, b.getBoard()[6][6].getColor());

		assertEquals(Piece.Color.BLACK, b.getBoard()[1][4].getColor());
		assertEquals(Piece.Color.BLACK, b.getBoard()[2][4].getColor());
		assertEquals(Piece.Color.BLACK, b.getBoard()[3][4].getColor());
		assertEquals(Piece.Color.BLACK, b.getBoard()[4][3].getColor());

		assertEquals(Piece.Color.WHITE, b.getBoard()[4][4].getColor());
		assertEquals(Piece.Color.WHITE, b.getBoard()[5][5].getColor());
		assertEquals(Piece.Color.WHITE, b.getBoard()[3][1].getColor());
		assertEquals(Piece.Color.WHITE, b.getBoard()[3][2].getColor());
		assertEquals(Piece.Color.WHITE, b.getBoard()[3][3].getColor());
		/* end verification of state of board after playing g7W*/

		assertEquals(Piece.Color.BLACK, b.getCurrentPlayer());

		Piece p7 = new Piece("a4", Piece.Color.BLACK);
		piecesToCapture = b.checkHorizontalRight(p7);
		assertEquals(3, piecesToCapture.size());
		//check that other direction checks are empty
		assertEquals(0, b.checkDiagonalUpLeft(p7).size());
		assertEquals(0, b.checkVerticalDown(p7).size());

		assertEquals("b4W", piecesToCapture.get(0).toString());
		assertEquals("c4W", piecesToCapture.get(1).toString());
		assertEquals("d4W", piecesToCapture.get(2).toString());

		b.play(p7);

		/* verify state of board after playing a4B */
		assertEquals(53, b.countColorPieces(Piece.Color.EMPTY));
		assertEquals(8, b.countColorPieces(Piece.Color.BLACK));
		assertEquals(3, b.countColorPieces(Piece.Color.WHITE));
		assertEquals(p7.toString(), b.getBoard()[3][0].toString());
		assertEquals(Piece.Color.BLACK, b.getBoard()[3][0].getColor());

		assertEquals(Piece.Color.WHITE, b.getBoard()[6][6].getColor());
		assertEquals(Piece.Color.WHITE, b.getBoard()[4][4].getColor());
		assertEquals(Piece.Color.WHITE, b.getBoard()[5][5].getColor());

		assertEquals(Piece.Color.BLACK, b.getBoard()[1][4].getColor());
		assertEquals(Piece.Color.BLACK, b.getBoard()[2][4].getColor());
		assertEquals(Piece.Color.BLACK, b.getBoard()[3][4].getColor());
		assertEquals(Piece.Color.BLACK, b.getBoard()[4][3].getColor());
		assertEquals(Piece.Color.BLACK, b.getBoard()[3][1].getColor());
		assertEquals(Piece.Color.BLACK, b.getBoard()[3][2].getColor());
		assertEquals(Piece.Color.BLACK, b.getBoard()[3][3].getColor());
		/* end verification of state of board after playing a4B*/

		Piece p8 = new Piece("e1", Piece.Color.WHITE);
		piecesToCapture = b.checkVerticalDown(p8);
		assertEquals(3, piecesToCapture.size());
		//check that other direction checks are empty
		assertEquals(0, b.checkHorizontalRight(p8).size());
		assertEquals(0, b.checkDiagonalUpLeft(p8).size());
		assertEquals("e2B", piecesToCapture.get(0).toString());
		assertEquals("e3B", piecesToCapture.get(1).toString());
		assertEquals("e4B", piecesToCapture.get(2).toString());

		assertEquals(Piece.Color.WHITE, b.getCurrentPlayer());

		b.play(p8);
		/* verify state of board after playing e1W */
		assertEquals(52, b.countColorPieces(Piece.Color.EMPTY));
		assertEquals(5, b.countColorPieces(Piece.Color.BLACK));
		assertEquals(7, b.countColorPieces(Piece.Color.WHITE));
		assertEquals(p8.toString(), b.getBoard()[0][4].toString());
		assertEquals(Piece.Color.WHITE, b.getBoard()[0][4].getColor());

		assertEquals(Piece.Color.WHITE, b.getBoard()[6][6].getColor());
		assertEquals(Piece.Color.WHITE, b.getBoard()[4][4].getColor());
		assertEquals(Piece.Color.WHITE, b.getBoard()[5][5].getColor());
		assertEquals(Piece.Color.WHITE, b.getBoard()[1][4].getColor());
		assertEquals(Piece.Color.WHITE, b.getBoard()[2][4].getColor());
		assertEquals(Piece.Color.WHITE, b.getBoard()[3][4].getColor());

		assertEquals(Piece.Color.BLACK, b.getBoard()[3][0].getColor());
		assertEquals(Piece.Color.BLACK, b.getBoard()[4][3].getColor());
		assertEquals(Piece.Color.BLACK, b.getBoard()[3][1].getColor());
		assertEquals(Piece.Color.BLACK, b.getBoard()[3][2].getColor());
		assertEquals(Piece.Color.BLACK, b.getBoard()[3][3].getColor());
		/* end verification of state of board after playing e1W*/

		assertEquals(Piece.Color.BLACK, b.getCurrentPlayer());

		Piece p9 = new Piece("h8", Piece.Color.BLACK);
		piecesToCapture = b.checkDiagonalUpLeft(p9);
		assertEquals(3, piecesToCapture.size());
		//check that other direction checks are empty
		assertEquals(0, b.checkHorizontalRight(p9).size());
		assertEquals(0, b.checkVerticalDown(p9).size());
		assertEquals("e5W", piecesToCapture.get(0).toString());
		assertEquals("f6W", piecesToCapture.get(1).toString());
		assertEquals("g7W", piecesToCapture.get(2).toString());	
	}
}
