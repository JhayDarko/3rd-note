public class Fibonacci {
    public static void main(String[] args) {
        long number1 = 0, number2 = 1, number, next;
        System.err.printf("1. %s%n2. %s%n", number1, number2);

        for (number = 2; number < 50; number++) {
            next = number1 + number2;
            System.err.printf("%s. %s%n", number+1, next);

            number1 = number2;
            number2 = next;
            
        }
    }
}
