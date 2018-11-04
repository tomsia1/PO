package lab.cs2;

import org.junit.Test;

import static org.junit.Assert.*;

public class MapDirectionsTest {

    @Test
    public void testNext() {
        assertEquals(MapDirections.EAST, MapDirections.NORTH.next());
        assertEquals(MapDirections.SOUTH, MapDirections.EAST.next());
        assertEquals(MapDirections.WEST, MapDirections.SOUTH.next());
        assertEquals(MapDirections.NORTH, MapDirections.WEST.next());
    }

    @Test
    public void testPrevious() {
        assertEquals(MapDirections.WEST, MapDirections.NORTH.previous());
        assertEquals(MapDirections.NORTH, MapDirections.EAST.previous());
        assertEquals(MapDirections.EAST, MapDirections.SOUTH.previous());
        assertEquals(MapDirections.SOUTH, MapDirections.WEST.previous());
    }
}
