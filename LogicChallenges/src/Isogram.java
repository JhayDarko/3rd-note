import java.text.Normalizer;
import java.util.HashSet;
import java.util.Set;

public class Isogram {

    public static boolean isIsogram(String word) {
        word = Normalizer.normalize(word.trim(), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").toLowerCase();
        if (word.isEmpty()) {
            return true;
        }
        if (word.contains(" ")) {
            return false;
        }
        Set<Character> characters = new HashSet<>();
        for (char character : word.toCharArray()) {
            if (!characters.add(character)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Murciélago: " + isIsogram("Murciélago"));
        System.out.println("reto: " + isIsogram("reto"));
        System.out.println("Casa: " + isIsogram("Casa"));
        System.out.println("PeRrO: " + isIsogram("PeRrO"));
        System.out.println("GaTo: " + isIsogram("GaTo"));
    }
}
