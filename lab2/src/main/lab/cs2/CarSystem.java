package lab.cs2;

import lab.cs4.IWorldMap;
import lab.cs4.MapVisualizer;
import lab.cs4.RectangularMap;
import lab.cs4.UnboundedMap;

import java.util.LinkedList;
import java.util.List;

public class CarSystem {

    public static void main(String[] args) {

        List<HayStack> hays=new LinkedList<>();
        hays.add(new HayStack(new Position(-4,-4)));
        hays.add(new HayStack(new Position(7,7)));
        hays.add(new HayStack(new Position(3,6)));
        hays.add(new HayStack(new Position(2,0)));

        int i=0;
        System.out.print("car 1: ");
        for (String s: args)
        {
            if (i%2==0) System.out.print(s+" ");
            i++;
        }

        i=0;
        System.out.print("\n car 2: ");
        for (String s: args)
        {
            if (i%2==1) System.out.print(s+" ");
            i++;
        }
        System.out.println("\n \n");

        MoveDirections[] directions = new OptionParser().parse(args);

        IWorldMap map = new UnboundedMap(hays);
        new Car(map);
        new Car(map,new Position(3,4));
        map.run(directions);

        System.out.println(map);
    }
}
