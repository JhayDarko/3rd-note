//Ejercicio con 'if'

import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        
    try (Scanner scan = new Scanner(System.in)){

        System.out.println("Ingresa tu edad");
        int age = scan.nextInt();

        if (age >= 18) {
            System.out.println("Puedes entrar");
        }
        else if (age >= 14) {
            System.out.println("Puedes entrar con un acompañante mayor de edad");
        }
        else {
            System.out.println("No puedes entrar");

        }
    }
    }
}
