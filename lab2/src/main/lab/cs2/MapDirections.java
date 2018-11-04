package lab.cs2;

public enum MapDirections {
    NORTH, EAST, SOUTH, WEST;

    public String toString() {
        switch (this) {
            case NORTH:
                return "^";
            case SOUTH:
                return "↓";
            case WEST:
                return "<";
            default:
                return ">";
        }
    }

    MapDirections next() {
        return MapDirections.values()[((this.ordinal() + 1) % (MapDirections.values().length))];
    }

    MapDirections previous() {
        int len = MapDirections.values().length;
        return MapDirections.values()[((this.ordinal() + len - 1) % len)];
    }
}
