package lab.cs2;

public class HayStack implements AbstractMapElement {
    private Position position;

    public Position getPosition() {
        return position;
    }

    public HayStack (Position position)
    {
        this.position=position;
    }

    public String toString()
    {
        return "s";
    }
}
