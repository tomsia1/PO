package lab.cs4;

import lab.cs2.AbstractMapElement;
import lab.cs2.Car;
import lab.cs2.MoveDirections;
import lab.cs2.Position;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractWorldMap implements  IWorldMap{

    protected List<Car> cars=new ArrayList<>();
    protected List<AbstractMapElement> elements=new LinkedList<>();
    protected MapVisualizer vis;
    protected Position LL=null;
    protected Position UR=null;

    protected AbstractWorldMap ()
    {
        vis=new MapVisualizer(this);
    }

    @Override
    public boolean place(Car car) {

        if (isOccupied(car.getPosition())) return false;

        elements.add(car);
        cars.add(car);
        return true;
    }

    @Override
    public void run(MoveDirections[] directions) {

            if (cars.isEmpty()) return;

            int i=0;

            for (MoveDirections next: directions)
            {
                cars.get(i).move(next);
                i=(i+1)%cars.size();
            }
    }

    public boolean isOccupied(Position position)
    {
        return objectAt(position)!=null;
    }

    public Object objectAt(Position position) {

        for (AbstractMapElement elem: elements)
        {
            if (elem.getPosition().equals(position))
                return elem;
        }

        return null;
    }

    public boolean canMoveTo(Position position) {
        return !isOccupied(position);
    }

    public String toString()
    {
        return vis.draw(LL,UR);
    }

}
