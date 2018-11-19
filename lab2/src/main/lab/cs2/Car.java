package lab.cs2;

import lab.cs4.AbstractWorldMap;
import lab.cs4.PositionChangeObserver;

import java.util.HashSet;
import java.util.Set;

public class Car  implements AbstractMapElement{

    private Position position;
    private MapDirections head = MapDirections.NORTH;
    private AbstractWorldMap map;
    private Set<PositionChangeObserver> Observers=new HashSet<>();

    public Position getPosition() {
        return position;
    }

    public Car(AbstractWorldMap map) {
        this.position=new Position(2,2);

        this.map = map;
        map.place(this);
    }

    public Car(AbstractWorldMap map, Position initialPosition) {
        this.position=initialPosition;

        this.map = map;
        map.place(this);
    }

    public String toString() {
        return head.toString();
    }

    public MapDirections showDirection() {
        return head;
    }

    private void notifyObservers(Position newPosition)
    {
        for (PositionChangeObserver observer: Observers)
            observer.update(position,newPosition);
    }

    public void move(MoveDirections direction) {

        if (direction == MoveDirections.RIGHT)
            head = head.next();
        else if (direction == MoveDirections.LEFT)
            head = head.previous();
        else {
            int a;
            Position tmp;

            if (direction == MoveDirections.FORWARD) a = 1;
            else a = -1;

            switch (head) {
                case NORTH:
                    tmp = new Position(0, a).add(position);
                    break;
                case SOUTH:
                    tmp = new Position(0, -a).add(position);
                    break;
                case EAST:
                    tmp = new Position(a, 0).add(position);
                    break;
                default:
                    tmp = new Position(-a, 0).add(position);
                    break;
            }

            if (map.canMoveTo(tmp)) {
                notifyObservers(tmp);
                position = tmp;
            }
        }

    }

}
