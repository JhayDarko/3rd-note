import java.util.HashMap;
import java.util.Map;

public class Palimdrome {

    public static boolean palindromeChecker(int number) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        String numberString = String.valueOf(number);
        for (char digit : numberString.toCharArray()) {
            frequencyMap.put(digit, frequencyMap.getOrDefault(digit, 0) + 1);
        }
        int oddCount = 0;
        for (int count : frequencyMap.values()) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }
        return oddCount < 2;
    }

    public static void main(String[] args) {
        System.out.println("5: " + palindromeChecker(5));
        System.out.println("2121: " + palindromeChecker(2121));
        System.out.println("1331: " + palindromeChecker(1331));
        System.out.println("3357665: " + palindromeChecker(3357665));
        System.out.println("1294: " + palindromeChecker(1294));
    }
}
