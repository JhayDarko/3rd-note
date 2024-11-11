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
            if (oddCount > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(palindromeChecker(5));
        System.out.println(palindromeChecker(2121));
        System.out.println(palindromeChecker(1331));
        System.out.println(palindromeChecker(3357665));
        System.out.println(palindromeChecker(1294));
    }
}
