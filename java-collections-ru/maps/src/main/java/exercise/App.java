package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        Map<String, Integer> wordCount = new HashMap<>();
        if (sentence.equals("")) {
            return wordCount;
        }
        String[] words = sentence.split(" ");
        for (String word: words) {
            int count = 1;
            if (!wordCount.containsKey(word)) {
                wordCount.put(word, count);
            } else {
                int newCount = wordCount.get(word) + 1;
                wordCount.replace(word, newCount);
            }
        }
        return wordCount;
    }

    public static String toString(Map<String, Integer> map) {
        StringBuilder result = new StringBuilder();
        result.append("{");
        if (!map.isEmpty()) {
            result.append("\n");
        }
        for (Map.Entry<String, Integer> word: map.entrySet()) {
            result.append("  ")
                    .append(word.getKey())
                    .append(": ")
                    .append(word.getValue())
                    .append("\n");
        }
        result.append("}");
        return result.toString();
    }
}
//END
