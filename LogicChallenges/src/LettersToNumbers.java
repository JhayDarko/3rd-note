import java.text.Normalizer;

public class LettersToNumbers {

    public static String replaceLettersWithNumbers(String text) {
        text = Normalizer.normalize(text, Normalizer.Form.NFD).replaceAll("[^a-zA-Z]", "").toLowerCase();
        StringBuilder numbers = new StringBuilder();
        for (char character : text.toCharArray()) {
            int number = character - 'a' + 1;
            numbers.append(number).append(" ");
        }
        return numbers.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println("abc def: " + replaceLettersWithNumbers("abc def"));
    }
}
