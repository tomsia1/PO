package lab.cs4;

import lab.cs2.AbstractMapElement;
import lab.cs2.Car;
import lab.cs2.MoveDirections;
import lab.cs2.Position;

import java.util.*;

public abstract class AbstractWorldMap implements IWorldMap, PositionChangeObserver {

    protected List<Car> cars = new ArrayList<>();
    protected MapVisualizer vis;
    protected Position LL = null;
    protected Position UR = null;
    protected Map<Position, AbstractMapElement> elements = new HashMap<>();


    protected AbstractWorldMap() {
        vis = new MapVisualizer(this);
    }

    public void update(Position oldPosition, Position newPosition) {
        AbstractMapElement elem= objectAt(oldPosition);
        elements.remove(oldPosition);
        elements.put(newPosition, elem);
    }

    @Override
    public boolean place(Car car) throws IllegalArgumentException {

        if (isOccupied(car.getPosition()))
            throw new IllegalArgumentException("position: " + car.getPosition().toString() + " is already occupied");

        elements.put(car.getPosition(), car);
        cars.add(car);
        return true;
    }

    @Override
    public void run(MoveDirections[] directions) {

        if (cars.isEmpty()) return;

        int i = 0;

        for (MoveDirections next : directions) {
            cars.get(i).move(next);
            i = (i + 1) % cars.size();
        }
    }

    public boolean isOccupied(Position position) {
        return objectAt(position) != null;
    }

    public AbstractMapElement objectAt(Position position) {
        return elements.getOrDefault(position, null);
    }

    public boolean canMoveTo(Position position) {
        return !isOccupied(position);
    }

    public String toString() {
        return vis.draw(LL, UR);
    }

}
