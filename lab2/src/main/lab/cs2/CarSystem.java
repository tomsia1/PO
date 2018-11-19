package lab.cs2;

import lab.cs4.*;
import java.util.LinkedList;
import java.util.List;

public class CarSystem {

    public static void main(String[] args) {

        List<HayStack> hays = new LinkedList<>();
        hays.add(new HayStack(new Position(-4, -4)));
        hays.add(new HayStack(new Position(7, 7)));
        hays.add(new HayStack(new Position(3, 6)));
        hays.add(new HayStack(new Position(2, 0)));
        //hays.add(new HayStack(new Position(2,0)));

        try {
            MoveDirections[] directions = new OptionParser().parse(args);

            AbstractWorldMap map = new UnboundedMap(hays);
            new Car(map);
            //new Car(map);
            new Car(map, new Position(3, 4));
            //new Car(map,new Position(2,0));
            map.run(directions);

            System.out.println(map);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
