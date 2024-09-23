//Tabla de Multiplicar

import java.util.Scanner;

public class Exercise5 {
   public static void main(String[] args) {
      
    try (Scanner scanner = new Scanner(System.in)) {
        System.out.println("Ingresa un número para conocer su tabla de multiplicar");
        int number = scanner.nextInt();

    for (int x=0;x<=10;x++) {
        int result = number * x;
        String line = number + " x " + x + " = " + result;
        System.out.println(line);
    }
    }
   } 
}
