import java.util.Scanner;

public class PrimeNumber {
    
    public static boolean IsPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {

       try (Scanner scan = new Scanner(System.in)){
        System.err.println("Ingresa un número para saber si es primo");
        int prime = scan.nextInt();
        if (IsPrime(prime)) {
            System.out.printf("%s es primo%n", prime);
        }
        else {
            System.out.printf("%s no es primo%n", prime);
        }

        System.out.println("\nNúmeros primos entre 1 y 100:");
        for (int i = 1; i <= 100; i++) {
            if (IsPrime(i)) {
                System.out.printf("%s ",i);
                }

            }
        }
    }
}
