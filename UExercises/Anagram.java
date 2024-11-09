import java.util.Arrays;
import java.util.Scanner;

public class Anagram {

    public static boolean isAnagram(String word1, String word2) {
        char[] array1 = word1.toLowerCase().toCharArray();
        char[] array2 = word2.toLowerCase().toCharArray();

        Arrays.sort(array1);
        Arrays.sort(array2);

        return Arrays.equals(array1, array2);   
    }

    public static void message(boolean isAnagram) {
        if (isAnagram) {
            System.out.println("Es un anagrama");
        } else {
            System.out.println("No es un anagrama");
        }
    }

    public static void main(String[] args) {
        
        try (Scanner scan = new Scanner(System.in)) {
            
            System.out.println("Ingresa la primera palabra");
            String word1 = scan.nextLine();

            System.out.println("Ingresa la segunda palabra");
            String word2 = scan.nextLine();

            if (word1.length() != word2.length() || word1.equalsIgnoreCase(word2)) {
                message(false);
            } else {
                message(isAnagram(word1, word2));
            }
        }
    }
}
