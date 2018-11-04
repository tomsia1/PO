package lab.cs2;

public class Position {

    public final int x;
    public final int y;

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
        if (obj==null) return this;
        return new Position(Math.max(this.x, obj.x), Math.max(this.y, obj.y));
    }

    public Position lowerLeft(Position obj) {
        if (obj==null) return this;
        return new Position(Math.min(this.x, obj.x), Math.min(this.y, obj.y));
    }

    public Position add(Position obj) {
        return new Position(this.x + obj.x, this.y + obj.y);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Position))
            return false;

        Position myObj = (Position) obj;
        return this.x == myObj.x && this.y == myObj.y;
    }

}
