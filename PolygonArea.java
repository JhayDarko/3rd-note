import java.util.Scanner;

public class PolygonArea {
    Scanner scan = new Scanner(System.in);

    public void triangle() {
        System.out.println("Ingresa la base");
        int base = scan.nextInt();
        System.out.println("Ingresa la altura");
        int height = scan.nextInt();

        double area = (double)base * height / 2;
        System.out.println("El área del triángulo es de : " + area);
    }

    public void square() {
        System.out.println("Ingresa el lado");
        int side = scan.nextInt();

        int area = side * side;
        System.out.println("El área del cuadrado es de : " + area);
    }

    public  void rectangle() {
        System.out.println("Ingresa la base");
        int base = scan.nextInt();
        System.out.println("Ingresa la altura");
        int height = scan.nextInt();

        int area = base * height;
        System.out.println("El área del rectángulo es de : " + area);
    }

    public void exit() {
        System.out.println("Saliendo de la calculadora de áreas");
        scan.close();
    }

    public void run() {

        while (true) { 
            System.out.println("Elige un polígono para calcular su área: ");
            System.out.println("1. Triángulo");
            System.out.println("2. Cuadrado");
            System.out.println("3. Rectángulo");
            System.out.println("4. Salir");
            int opcion = scan.nextInt();
            scan.nextLine();
    
            switch (opcion) {
                case 1 -> triangle();
                case 2 -> square();
                case 3 -> rectangle();
                case 4 -> {
                    exit();
                    return;
                }
                default -> System.out.println("Polígono no soportado. Ingresa una opción válida.");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        PolygonArea app = new PolygonArea();
        app.run();
    }
}
