package exercise;

import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {
    public static boolean scrabble(String symbols, String word) {
        if (symbols.length() < word.length()) {
            return false;
        }
        List<Character> symbolsList = new ArrayList<>();
        for (int i = 0; i < symbols.length(); i++) {
            symbolsList.add(symbols.toLowerCase().charAt(i));
        }
        for (int i = 0; i < word.length(); i++) {
            char currentLetter = Character.toLowerCase(word.charAt(i));
            if (symbolsList.contains(currentLetter)) {
                symbolsList.remove((Character) currentLetter);
            } else {
                return false;
            }
        }
        return true;
    }
}
//END
