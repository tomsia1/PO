package lab.cs4;

import lab.cs2.Position;

public interface PositionChangeObserver {
    void update(Position oldPosition, Position newPosition);
}
