import java.util.TreeSet;

public class MajorOfThree {

    public static int major(int a, int b, int c) {
        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.add(a);
        numbers.add(b);
        numbers.add(c);
        return numbers.last();
    }

        public static void main(String[] args) {
            System.out.println(major(17, 5, 9));
    }
}
