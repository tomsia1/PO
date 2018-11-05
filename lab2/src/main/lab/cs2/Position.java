package lab.cs2;

import java.util.Objects;

public class Position {

    public final int x;
    public final int y;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return x == position.x &&
                y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public Boolean smaller(Position obj) {
        return this.x <= obj.x && this.y <= obj.y;
    }

    public Boolean larger(Position obj) {
        return this.x >= obj.x && this.y >= obj.y;
    }

    public Position upperRight(Position obj) {
        if (obj == null) return this;
        return new Position(Math.max(this.x, obj.x), Math.max(this.y, obj.y));
    }

    public Position lowerLeft(Position obj) {
        if (obj == null) return this;
        return new Position(Math.min(this.x, obj.x), Math.min(this.y, obj.y));
    }

    public Position add(Position obj) {
        return new Position(this.x + obj.x, this.y + obj.y);
    }

}
