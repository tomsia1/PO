package lab.cs2;

public abstract class AbstractMapElement {
    protected Position position;

    public AbstractMapElement(Position position)
    {
        this.position=position;
    }

    public Position getPosition() {
        return position;
    }

}