//Agenda de Contactos

import java.io.*;
import java.util.Scanner;
import java.util.TreeMap;

public class ContactsManager {
    TreeMap<String, String> contacts = new TreeMap<>();
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
        String number = validateNumber();
                contacts.put(name, number);
                System.out.println("Contacto agregado.");
                saveContacts();
    }

    public void searchContact() {
        System.out.println("Ingrese el nombre del contacto a buscar: ");
        String name = scan.nextLine();
        String number = contacts.get(name);
        if (number != null) {
            System.out.printf("El número de %s es: %s.%n", name, number);
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }

    public void deleteContact() {
        System.out.println("Ingrese el nombre del contacto a eliminar: ");
        String name = scan.nextLine();
        System.out.printf("¿Está seguro de que desea eliminar a '%s' de la lista de contactos? (Si/No)%n", name);
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
                        default -> System.err.println("Opción no válida. Ingrese un número relacionado a la opción.\n");
                    }
                }
            }
        }
    }

    public void modifyName(String name) {
        System.out.println("Ingrese el nuevo nombre:");
        String number = contacts.remove(name);
        name = scan.nextLine();
        contacts.put(name, number);
        System.out.println("Nombre modificado.");
        saveContacts();
    }

    public void modifyNumber(String name) {
        String number = validateNumber();
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
            System.err.println("Error al guardar los contactos.");
        }
    }

    private void loadContacts() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" - ");
                if (parts.length == 2) {
                    String name = parts[0];
                    String number = parts[1];
                    if (number.matches("\\d{10}")) {
                        contacts.put(name, number);
                    } else {
                        System.err.printf("Número de teléfono inválido para el contacto '%s'. No se cargará.%n", name);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("No se pudo cargar el archivo de contactos. Puede que aún no exista.");
        }
    }
    

    public String validateNumber() {
        String number;
        while (true) {
            System.out.println("Ingrese el número de teléfono (debe contener diez dígitos): ");
            number = scan.nextLine();
            if (number.matches("\\d{10}")) {
                return number;
            } else {
                System.err.println("Formato de número inválido.");
            }
        }
    }

    public void exitApp() {
        System.out.println("Saliendo de la agenda...");
        scan.close();
    }

    public void run() {
        System.out.println("¡Bienvenido a su Agenda de Contactos!");
        String option;
        while (true) {
            System.out.println("\nElija una opción:");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Ver todos los contactos");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Modificar contacto");
            System.out.println("6. Salir");
            option = scan.nextLine();
            switch (option) {
                case "1" -> addContact();
                case "2" -> searchContact();
                case "3" -> showAllContacts();
                case "4" -> deleteContact();
                case "5" -> modifyContact();
                case "6" -> {
                    exitApp();
                    break;
                }
            default -> System.err.println("Opción no válida. Debe ingresar el número de alguna opción.");
            }
        }
    }

    public static void main(String[] args) {
        ContactsManager app = new ContactsManager();
        app.run();
    }
}