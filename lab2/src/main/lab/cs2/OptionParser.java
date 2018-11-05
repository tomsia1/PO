package lab.cs2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class OptionParser {

    static MoveDirections[] parse(String[] tab) throws IllegalArgumentException {
        return Arrays.stream(tab).map(s -> {
            switch (s) {
                case "f":
                case "forward":
                    return MoveDirections.FORWARD;
                case "b":
                case "backward":
                    return MoveDirections.BACKWARD;
                case "l":
                case "left":
                    return MoveDirections.LEFT;
                case "r":
                case "right":
                    return MoveDirections.RIGHT;
                default:
                    throw new IllegalArgumentException(s + " is not legal move specification");
            }
        }).toArray(MoveDirections[]::new);
    }

}

