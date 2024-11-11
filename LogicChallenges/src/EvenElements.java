import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvenElements {

    public static <T> List<T> createEvenArray(T[] array) {
        Map<T, Integer> counter = new HashMap<>();
        for (T element : array) {
            counter.put(element, counter.getOrDefault(element, 0) + 1);
        }
        List<T> evenArray = new ArrayList<>();
        for (Map.Entry<T, Integer> entry : counter.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                evenArray.add(entry.getKey());
            }
        }
        return evenArray;
    }

    public static void main(String[] args) {
        String[] arrayStrings = { "A", "B", "A", "C", "C", "C", "C" };
        System.out.println("Resultado para String: " + createEvenArray(arrayStrings));
        Integer[] arrayIntegers = { 1, 2, 3, 1, 2 };
        System.out.println("Resultado para Integer: " + createEvenArray(arrayIntegers));
    }
}
