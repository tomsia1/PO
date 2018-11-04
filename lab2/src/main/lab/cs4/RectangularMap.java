package lab.cs4;

import lab.cs2.Position;

public class RectangularMap extends AbstractWorldMap {

    public RectangularMap(int width, int height)
    {
        super();
        UR=new Position(width-1, height-1);
        LL=new Position(0,0);
    }


    private boolean inFrame(Position position)
    {
       return position.larger(LL) && position.smaller(UR);
    }

    @Override
    public boolean canMoveTo(Position position)
    {
        return super.canMoveTo(position) && inFrame(position);
    }

}
