
import java.util.HashMap;
//import java.util.Locale;
import java.util.Map;

public class Main {
    public static String txt = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt" +
            "ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris" +
            "nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit" +
            "esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt" +
            "in culpa qui officia deserunt mollit anim id est laborum.";

    public static void main(String[] args) {
        txt = txt.toLowerCase();
        Map<Character, Integer> letters = new HashMap<>();

        for (int i = 0; i < txt.length(); i++) {
            if (Character.isLetter(txt.charAt(i))) {
                if (letters.containsKey(txt.charAt(i))) {
                    int y = letters.get(txt.charAt(i));
                    letters.put(txt.charAt(i), ++y);
                } else {
                    letters.put(txt.charAt(i), 1);
                }
            }
        }
        Integer max = getMaxFreq(letters);
        Integer min = getMinFreq(letters);

        System.out.println("Чаще всего встречается буква(ы): ");
        for (Map.Entry<Character, Integer> maxSymbol : letters.entrySet()) {
            if (maxSymbol.getValue() == max) {
                System.out.println(maxSymbol.getKey() + " - " + maxSymbol.getValue());
            }
        }
        System.out.println("Реже всего встречается буква(ы): ");
        for (Map.Entry<Character, Integer> minSymbol : letters.entrySet()) {
            if (minSymbol.getValue() == min) {
                System.out.println(minSymbol.getKey() + " - " + minSymbol.getValue());
            }
        }
    }
    public static Integer getMaxFreq(Map<Character, Integer> letters) {
        int maxFreq = 0;
        for (char kv : letters.keySet()) {
            if (letters.get(kv) > maxFreq) {
                maxFreq = letters.get(kv);
            }
        }
        return maxFreq;
    }
    public static Integer getMinFreq(Map<Character, Integer> letters) {
        int minFreq = Integer.MAX_VALUE;
        for (char kv : letters.keySet()) {
            if (letters.get(kv) < minFreq) {
                minFreq = letters.get(kv);
            }
        }
        return minFreq;
    }
}
