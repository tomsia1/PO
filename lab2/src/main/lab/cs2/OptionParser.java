package lab.cs2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class OptionParser {

    static MoveDirections[] parse(String[] tab) {

        Set<String> Q= new HashSet<>(Arrays.asList("f","b","r","l","forward","backward","left","right"));
        return Arrays.stream(tab).filter(s ->
                Q.contains(s)
        ).map(s -> {
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
                default:
                    return MoveDirections.RIGHT;
            }
        }).toArray(MoveDirections[]::new);
    }

}

