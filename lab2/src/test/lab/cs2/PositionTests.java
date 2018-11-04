package lab.cs2;

import org.junit.Test;

import static org.junit.Assert.*;

public class PositionTests {

    private Position pos1 = new Position(0, 0);
    private Position pos2 = new Position(1, 1);
    private Position pos3 = new Position(1, 0);
    private Position pos4 = new Position(0, 0);
    private Position pos5 = new Position(2, 2);
    private Position pos6 = new Position(-1, 3);
    private Position pos7 = new Position(1, 3);
    private Position pos8 = new Position(0, 1);

    @Test
    public void testEquals() {
        assertEquals(true, pos1.equals(pos1));
        assertEquals(true, pos1.equals(pos4));
        assertEquals(false, pos1.equals(pos2));
        assertEquals(false, pos1.equals("abrakadabra"));
    }


    @Test
    public void testToString() {
        assertEquals("(0,0)", pos1.toString());
        assertEquals("(1,1)", pos2.toString());
        assertEquals("(1,0)", pos3.toString());
    }

    @Test
    public void testSmaller() {
        assertEquals(true, pos1.smaller(pos2));
        assertEquals(true, pos1.smaller(pos3));
        assertEquals(false, pos5.smaller(pos1));
    }

    @Test
    public void testLarger() {
        assertEquals(false, pos1.larger(pos2));
        assertEquals(false, pos1.larger(pos3));
        assertEquals(true, pos5.larger(pos1));
    }

    @Test
    public void testUpperRight() {
        assertEquals(pos7, pos2.upperRight(pos6));
        assertEquals(pos2, pos1.upperRight(pos2));
    }

    @Test
    public void testLowerLeft() {
        assertEquals(pos1, pos8.lowerLeft(pos3));
        assertEquals(pos3, pos3.lowerLeft(pos5));
    }

    @Test
    public void testAdd() {
        assertEquals(pos3, pos3.add(pos1));
        assertEquals(pos5, pos2.add(pos2));
    }

}
