package exercise;

import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> apartments, int number) {
        return apartments.stream()
                .sorted(Home::compareTo)
                .map(Object::toString)
                .limit(number)
                .collect(Collectors.toList());
    }
}
// END
