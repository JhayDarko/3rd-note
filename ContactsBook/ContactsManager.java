//Agenda de Contactos

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeMap;

public class ContactsManager {
    TreeMap<String, Integer> contacts = new TreeMap<>();
    Scanner scan = new Scanner(System.in);
    final String FILE_NAME = "ContactsBook/contacts.txt";

    public ContactsManager() {
        loadContacts();
    }

    public void addContact() {
        System.out.println("Ingrese el nombre: ");
        String name = scan.nextLine();
        if (contacts.containsKey(name)) {
            System.out.println("El contacto ya existe. ¿Desea sobrescribirlo? (Si/No)");
            String response = scan.nextLine();
            if (!response.equalsIgnoreCase("Si")) {
                System.out.println("Operación cancelada.");
                return;
            }
        }
        while (true) { 
            try {
                System.out.println("Ingrese el número de teléfono: ");
                Integer number = scan.nextInt();
                contacts.put(name, number);
                System.out.println("Contacto agregado.");
                saveContacts();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Ingrese un número.");
                scan.nextLine();
            }
        }
    }

    public void searchContact() {
        System.out.println("Ingrese el nombre del contacto a buscar: ");
        String name = scan.nextLine();
        Integer number = contacts.get(name);
        if (number != null) {
            System.out.printf("El número de %s es: %s.%n", name, number);
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }

    public void deleteContact() {
        System.out.println("Ingrese el nombre del contacto a eliminar: ");
        String name = scan.nextLine();
        System.out.printf("¿Está seguro de que desea eliminar a '%s' de la lista de contactos? (Si/No)", name);
        String response = scan.nextLine();
        if (!response.equalsIgnoreCase("Si")) {
            System.out.println("Operación cancelada.");
            return;
        }
        if (contacts.remove(name) != null) {
            System.out.println("Contacto eliminado.");
            saveContacts();
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }

    public void modifyContact() {
        if (contacts.isEmpty()) {
            System.out.println("La agenda está vacía.\n");
        } else {
            System.out.println("Ingrese el nombre del contacto: ");
            String name = scan.nextLine();
            if (!contacts.containsKey(name)) {
                System.out.println("Contacto no encontrado.");
            }
            else {
                System.out.println("Elija la opción que desea modificar:");
                System.out.println("1. Nombre");
                System.out.println("2. Número");
                String option = scan.nextLine();                
                while (true) { 
                    switch (option) {
                        case "1" -> {
                            modifyName(name);
                            return;
                        }
                        case "2" -> {
                            modifyNumber(name);
                            return;
                        }
                        default -> System.out.println("Opción no válida. Ingrese un número relacionado a la opción.\n");
                    }
                }
            }
        }
    }

    public void modifyName(String name) {
        System.out.println("Ingrese el nuevo nombre:");
        Integer number = contacts.remove(name);
        name = scan.nextLine();
        contacts.put(name, number);
        System.out.println("Nombre modificado.");
        saveContacts();
    }

    public void modifyNumber(String name) {
        System.out.println("Ingrese el nuevo número:");
        Integer number = scan.nextInt();
        contacts.put(name, number);
        System.out.println("Número modificado.");
        saveContacts();
    }

    public void showAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("La agenda está vacía.\n");
        } else {
            System.out.println("Todos los contactos:");
            for (String name : contacts.keySet()) {
                System.out.printf("Nombre: %s - Número: %s%n", name, contacts.get(name));
            }
        }
    }

    public void saveContacts() {
        try(FileWriter writer = new FileWriter(FILE_NAME)) {
            for (var entry : contacts.entrySet()) {
                writer.write(entry.getKey() + " - " + entry.getValue() + "\n");
            } 
        } catch (IOException e) {
            System.out.println("Error al guardar los contactos.");
        }
    }

    private void loadContacts() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" - ");
                if (parts.length == 2) {
                    String name = parts[0];
                    Integer number = Integer.valueOf(parts[1]);
                    contacts.put(name, number);
                }
            }
        } catch (IOException e) {
            System.out.println("No se pudo cargar el archivo de contactos. Puede que aún no exista.");
        } catch (NumberFormatException e) {
            System.out.println("Error al cargar los contactos: formato de número no válido.");
        }
    }

    public void exitApp() {
        System.out.println("Saliendo de la agenda...");
        scan.close();
    }

    public void run() {
        while (true) {
            System.out.println("\nElija una opción:");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Ver todos los contactos");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Modificar contacto");
            System.out.println("6. Salir");

            try {
                int opcion = scan.nextInt();
                scan.nextLine();
    
                switch (opcion) {
                    case 1 -> addContact();
                    case 2 -> searchContact();
                    case 3 -> showAllContacts();
                    case 4 -> deleteContact();
                    case 5 -> modifyContact();
                    case 6 -> {
                        exitApp();
                        return;
                    }
                default -> System.out.println("Opción no válida. Ingrese un número relacionado a la opción.\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Opción no válida. Ingrese un número relacionado a la opción.\n");
                scan.nextLine();
            }
        }
    }

    public static void main(String[] args) {
        ContactsManager app = new ContactsManager();
        app.run();
    }
}