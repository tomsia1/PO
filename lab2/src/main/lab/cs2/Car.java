package lab.cs2;

import lab.cs4.IWorldMap;

public class Car  extends AbstractMapElement{

    private MapDirections head = MapDirections.NORTH;
    private IWorldMap map;

    public Car(IWorldMap map) {
        super (new Position(2,2));

        this.map = map;
        map.place(this);
    }

    public Car(IWorldMap map, Position initialPosition) {
        super(initialPosition);

        this.map = map;
        map.place(this);
    }

    public String toString() {
        return new String(head.toString());
    }

    public MapDirections showDirection() {
        return head;
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
                position = tmp;
            }
        }

    }

}