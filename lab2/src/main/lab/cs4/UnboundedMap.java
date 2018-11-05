package lab.cs4;

import lab.cs2.*;

import java.util.List;

public class UnboundedMap extends AbstractWorldMap {

    public UnboundedMap(List<HayStack> Stacks) throws IllegalArgumentException
    {
        super();
        for (HayStack s: Stacks)
        {
            if (isOccupied(s.getPosition()))
                throw new IllegalArgumentException("position: "+ s.getPosition() + " is already occupied");
            LL=s.getPosition().lowerLeft(LL);
            UR=s.getPosition().upperRight(UR);
            elements.put(s.getPosition(),s);
        }
    }

    @Override
    public boolean place(Car car)
    {
        if (!super.place(car)) return false;

        LL=car.getPosition().lowerLeft(LL);
        UR=car.getPosition().upperRight(UR);
        return true;
    }
}
