//Comprobación de número

import java.util.Scanner;

public class Main8 {
    public static void main(String[] args) {
        
    try (Scanner scan = new Scanner(System.in)) {

        System.out.println("Ingresa el primer número");
        int number1 = scan.nextInt();

        System.out.println("Ingresa el segundo número");
        int number2 = scan.nextInt();

        System.out.println("Ingresa el tercer número");
        int number3 = scan.nextInt();

        if (number1 > number2 && number1 < number3){
            System.out.println("El primer número es mayor que el segundo y menor que el tercero");
        }
        else {
            System.out.println("El primer número no es mayor que el segundo y menor que el tercero");
        }
    }
    }
}
