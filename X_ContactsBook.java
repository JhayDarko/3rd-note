import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeMap;

public class X_ContactsBook {
    TreeMap<String, Integer> contacts = new TreeMap<>();
    Scanner scan = new Scanner(System.in);

    public void addContact() {
        System.out.println("Ingresa el nombre: ");
        String name = scan.nextLine();
        if (contacts.containsKey(name)) {
            System.out.println("El contacto ya existe. ¿Deseas sobrescribirlo? (Si/No)");
            String response = scan.nextLine();
            if (!response.equalsIgnoreCase("Si")) {
                System.out.println("Operación cancelada.");
                return;
            }
        }
        while (true) { 
            try {
                System.out.println("Ingresa el número de teléfono: ");
                Integer number = scan.nextInt();
                contacts.put(name, number);
                System.out.println("Contacto agregado.");
                break;
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Ingresa un número.");
                scan.nextLine();
            }
        }
    }

    public void searchContact() {
        System.out.println("Ingresa el nombre del contacto a buscar: ");
        String name = scan.nextLine();
        Integer number = contacts.get(name);
        if (number != null) {
            System.out.printf("El número de %s es: %s.", name, number);
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }

    public void deleteContact() {
        System.out.println("Ingresa el nombre del contacto a eliminar: ");
        String name = scan.nextLine();
        System.out.printf("¿Está seguro de que desea eliminar a '%s' de la lista de contactos? (Si/No)", name);
        String response = scan.nextLine();
        if (!response.equalsIgnoreCase("Si")) {
            System.out.println("Operación cancelada.");
            return;
        }
        if (contacts.remove(name) != null) {
            System.out.println("Contacto eliminado.");
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }

    public void showAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("La agenda está vacía.");
        } else {
            System.out.println("Todos los contactos:");
            for (String name : contacts.keySet()) {
                System.out.printf("Nombre: %s - Número: %s%n", name, contacts.get(name));
            }
        }
    }

    public void exitApp() {
        System.out.println("Saliendo de la agenda...");
        scan.close();
    }

    public void run() {
        while (true) {
            System.out.println("Elige una opción:");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Ver todos los contactos");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Salir");

            try {
                int opcion = scan.nextInt();
                scan.nextLine();
    
                switch (opcion) {
                    case 1 -> addContact();
                    case 2 -> searchContact();
                    case 3 -> showAllContacts();
                    case 4 -> deleteContact();
                    case 5 -> {
                        exitApp();
                        return;
                    }
                default -> System.out.println("Opción no válida. Ingresa un número relacionado a la opción.\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Opción no válida. Ingresa un número relacionado a la opción.\n");
                scan.nextLine();
            }
        }
    }

    public static void main(String[] args) {
        X_ContactsBook app = new X_ContactsBook();
        app.run();
    }
}