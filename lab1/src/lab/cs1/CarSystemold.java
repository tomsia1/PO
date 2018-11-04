package lab.cs1;

import java.util.*;
import java.util.stream.Collectors;

public class CarSystemold {

    static void run(List<Directions> whatever)
    {
        //whatever.stream()
        whatever
                .forEach(s-> {
                    switch(s)
                    {
                        case Przod: System.out.println("brum brum"); break;
                        case Tyl: System.out.println("bip bip"); break;
                        case Lewo: System.out.println("lewo"); break;
                        case Prawo: System.out.println("prawo"); break;
                    }
                });
    }

    static List<Directions> convert (String[] args)
    {

        List <Directions> result= Arrays.stream(args)
                .filter(s-> s.equals("f") || s.equals("b") || s.equals("l") || s.equals("r"))
                .map (s -> {
                    switch(s)
                    {
                        case "f": return Directions.Przod;
                        case "b": return Directions.Tyl;
                        case "l": return Directions.Lewo;
                        case "r": return Directions.Prawo;
                        default: return Directions.Przod;
                    }
                }).collect(Collectors.toList());

        return result;
    }

    public static void main(String[] args)
    {
        System.out.println("dzialam");
        run(convert(args));
        System.out.println("nie dzialam");
    }
}
