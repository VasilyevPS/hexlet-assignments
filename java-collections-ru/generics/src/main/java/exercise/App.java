package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
public class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> where) {
        List<Map<String, String>> result = new ArrayList<>();
        for (Map<String, String> book: books) {
            boolean hasInside = true;
            for (Map.Entry<String, String> bookData: where.entrySet()) {
                String key = bookData.getKey();
                String value = bookData.getValue();
                if (!(book.get(key).equals(value))) {
                    hasInside = false;
                }
            }
            if (hasInside) {
                result.add((book));
            }
        }
        return result;
    }
}
//END
