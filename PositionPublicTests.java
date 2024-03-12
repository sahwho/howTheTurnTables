import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

/*
 * @Author Vikash Sahu
 * Public Unit Tests for Position Class
 * Reversi Project
 * JUnit 4
 */

public class PositionPublicTests {

	@Test
	public void testConstructorRow() {
		Position p = new Position("d3", Position.Color.BLACK);
		assertEquals(2, p.getRow());
	}

	@Test
	public void testConstructorColumn() {
		Position p = new Position("d3", Position.Color.BLACK);
		assertEquals(3, p.getColumn());
	}

	@Test
	public void testConstructorPiece() {
		Position p = new Position("d1", Position.Color.BLACK);
		assertEquals(Position.Color.BLACK, p.getPiece());
	}

	@Test
	public void testToString1() {
		Position p = new Position(1, 3, Position.Color.BLACK);
		assertEquals("d2B", p.toString());
	}

	@Test
	public void testToString2() {
		Position p = new Position(1, 3, Position.Color.WHITE);
		assertEquals("d2W", p.toString());
	}

	@Test
	public void testToString3() {
		Position p = new Position(1, 3, Position.Color.EMPTY);
		assertEquals("d2", p.toString());
	}

	@Test
	public void testGetRowAndColFromStringPosition1() {
		int[] rowCol = Position.getRowAndColFromStringPosition("d4");
		assertTrue(Arrays.equals(new int[] {3,3}, rowCol));
	}

	@Test
	public void testGetRowAndColFromStringPosition2() {
		int[] rowCol = Position.getRowAndColFromStringPosition("D4");
		assertTrue(Arrays.equals(new int[] {3,3}, rowCol));
	}

	@Test
	public void testGetRowAndColFromStringPosition3() {
		int[] rowCol = Position.getRowAndColFromStringPosition("a1");
		assertTrue(Arrays.equals(new int[] {0,0}, rowCol));
	}

	@Test
	public void testGetRowAndColFromStringPosition4() {
		int[] rowCol = Position.getRowAndColFromStringPosition("h8");
		assertTrue(Arrays.equals(new int[] {7,7}, rowCol));
	}

	@Test
	public void testEquals1() {
		Position p = new Position("d5", Position.Color.WHITE);
		Position p2 = new Position("d5", Position.Color.WHITE);
		assertTrue(p.equals(p2));
	}

	@Test
	public void testEquals2() {
		Position p = new Position("d5", Position.Color.WHITE);
		Position p2 = new Position("d6", Position.Color.WHITE);
		assertFalse(p.equals(p2));
	}

	@Test
	public void testCompareTo1() {
		Position p = new Position("d5", Position.Color.WHITE);
		Position p2 = new Position("a5", Position.Color.BLACK);
		assertEquals(3, p.compareTo(p2));
	}

	@Test
	public void testCompareTo2() {
		Position p = new Position("d5", Position.Color.WHITE);
		Position p2 = new Position("a5", Position.Color.BLACK);
		assertEquals(-3, p2.compareTo(p));
	}

	@Test
	public void testCompareTo3() {
		Position p = new Position("d5", Position.Color.WHITE);
		Position p2 = new Position("d5", Position.Color.BLACK);
		assertEquals(0, p.compareTo(p2));
	}

	@Test
	public void testCompareTo4() {
		Position p = new Position("c3", Position.Color.BLACK);
		Position p2 = new Position("d4", Position.Color.WHITE);
		assertEquals(-1, p.compareTo(p2));
	}
}
