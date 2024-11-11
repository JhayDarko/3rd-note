import java.util.ArrayList;
import java.util.List;

public class ZerosToEnd {

    public static List<Object> moveZeros(List<Object> array) {
        List<Object> zerosInEnd = new ArrayList<>();
        for (Object element : array) {
            if (!(element instanceof Integer && (Integer) element == 0)) {
                zerosInEnd.add(element);
            }
        }
        while (zerosInEnd.size() < array.size()) {
            zerosInEnd.add(0);
        }
        return zerosInEnd;
    }

    public static void main(String[] args) {
        List<Object> array = List.of(false, 1, 0, 1, 2, 0, 1, 3, "a");
        System.out.println(moveZeros(array));
    }
}