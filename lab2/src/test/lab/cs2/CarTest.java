package lab.cs2;

import lab.cs4.IWorldMap;
import lab.cs4.RectangularMap;
import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CarTest {

    private IWorldMap map=new RectangularMap(5,5);

    private Car c1 = new Car(map);
    private Car c2 = new Car(map);

    private String[] tab1 = new String[]{"f", "haha", "l", "backward", "xd", "l", "forward"};
    private String[] tab2 = new String[]{"f", "f", "f", "f", "l", "l", "backward", "left"};
    private MoveDirections[] m1 = new MoveDirections[]{MoveDirections.FORWARD, MoveDirections.LEFT,
            MoveDirections.BACKWARD, MoveDirections.LEFT, MoveDirections.FORWARD};
    private MoveDirections[] m2 = new MoveDirections[]{MoveDirections.FORWARD, MoveDirections.FORWARD,
            MoveDirections.FORWARD, MoveDirections.FORWARD, MoveDirections.LEFT, MoveDirections.LEFT,
            MoveDirections.BACKWARD, MoveDirections.LEFT};

    @Test

    public void testParser() {
        Assert.assertArrayEquals(m1, OptionParser.parse(tab1));
        Assert.assertArrayEquals(m2, OptionParser.parse(tab2));
    }

    @Test
    public void testCar() {
        assertEquals(new Position(2, 2), c1.getPosition());
        assertEquals(MapDirections.NORTH, c1.showDirection());

        for (MoveDirections i : m1)
            c1.move(i);

        assertEquals(new Position(3, 2), c1.getPosition());
        assertEquals(MapDirections.SOUTH, c1.showDirection());

        for (MoveDirections j : m2)
            c2.move(j);

        assertEquals(new Position(2, 4), c2.getPosition());
        assertEquals(MapDirections.EAST, c2.showDirection());

    }


}
