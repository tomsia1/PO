package lab.cs4;

import lab.cs2.*;

import java.util.List;

public class UnboundedMap extends AbstractWorldMap {

    public UnboundedMap(List<HayStack> Stacks) throws IllegalArgumentException {
        super();
        for (HayStack s : Stacks) {
            if (isOccupied(s.getPosition()))
                throw new IllegalArgumentException("position: " + s.getPosition() + " is already occupied");
            elements.put(s.getPosition(), s);
        }
    }

    @Override
    public String toString() {
        for (Position pos : elements.keySet()) {
            LL = pos.lowerLeft(LL);
            UR = pos.upperRight(UR);
        }
        return vis.draw(LL, UR);
    }

}
