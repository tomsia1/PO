package lab.cs4;

import lab.cs2.*;

import java.util.List;

public class UnboundedMap extends AbstractWorldMap {

    public UnboundedMap (List<HayStack> Stacks)
    {
        super();
        for (HayStack s: Stacks)
        {
            LL=s.getPosition().lowerLeft(LL);
            UR=s.getPosition().upperRight(UR);
            elements.add(s);
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
