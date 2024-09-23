//Se importan las utilidades con las que se trabajará
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class GestionNotas {
    public static void main(String[] args) {
        //Con el Locale se estandariza la entrada para que en todos los casos reciba puntos en los decimales
        Locale.setDefault(Locale.US);

        //Se definen las constantes (número de materias y límite de aprovación)
        final int NUMBER_OF_SUBJECTS = 3;
        final double APROVAL_LIMIT = 3.0;
        
        //Definición del contador para el número de estudiantes
        int studentsCount = 0;        

        //Se define la ArrayList para ingresar a los estudiantes
        ArrayList<Object[]> students = new ArrayList<>();

        //Se inicia el escaner para pedir datos de entrada
        try (Scanner scan = new Scanner(System.in)) {
            //Definición de una variable para guardar la elección del usuario más adelante
            String continueProcess;

            //Se suma un estudiante al contador
            studentsCount++;

            //Se da la bienvenida al usuario y se explica el funcionamiento
            System.out.println("¡Bienvenido al sistema de gestión de notas!");
            System.err.println("Una vez haya terminado de ingresar los estudiantes, verá el informe final.\n");
            do {
                //Se define una matriz para guardar los datos de cada estudiante por separado 
                Object[] student = new Object[NUMBER_OF_SUBJECTS + 4];//La longitud depende del número de materias

                //Se piden los datos del estudiante y se guardan en su matriz
                System.out.println("Ingrese el nombre del estudiante " + studentsCount);
                student[0] = scan.nextLine();

                System.out.println("Ingrese el código del estudiante " + studentsCount);
                student[1] = scan.nextLine();

                //Definición de una variable para la suma de las notas
                double gradesSum = 0;
                //Ciclo para pedir las notas según el número de materias
                for (int i = 0; i < NUMBER_OF_SUBJECTS; i++) {
                    //Definicíon de variable para guardar las notas
                    double grade;

                    //Estructura para pedir las notas y guardarlas en la variable
                    do {
                        System.out.println("Ingrese la nota de la materia N° " + (i + 1) + " (entre 0.0 y 5.0):");
                        grade = scan.nextDouble();

                        //Estructura para validar que la nota sea un valor válido e informar del error
                        if (grade < 0.0 || grade > 5.0) {
                            System.out.println("Valor inválido. La nota debe estar entre 0.0 y 5.0.");
                        }
                    } while (grade < 0.0 || grade > 5.0);
    
                    //Se guarda la nota de cada materia en un espacio de la matriz
                    student[i + 2] = grade;
                    //Se suma cada nota a la variable de la suma
                    gradesSum += grade;
                }
                //Definición de la variable para el promedio
                double average = gradesSum / NUMBER_OF_SUBJECTS;
                //Se guarda el promedio en la matriz
                student[NUMBER_OF_SUBJECTS + 2] = average;

                //Definición de la variable del estado, la cual depende el límite de aprovación
                String state = (average >= APROVAL_LIMIT) ? "Aprobado" : "Reprobado";
                //Se guarda el estado en la matriz
                student[NUMBER_OF_SUBJECTS + 3] = state;

                //Se limpia el buffer
                scan.nextLine();

                //Se añade la matriz con todos los datos del estudiante a la ArrayList
                students.add(student);

                //Se le pregunta al usurio si desea agregar otro estudiante antes de ver el informe
                System.out.println("¿Desea agregar otro estudiante? (si/no)");
                //se guarda la elección
                continueProcess = scan.nextLine(); 
                //Se evalua la elección para saber si se repite el proceso de ingreso o no
            } while (continueProcess.equalsIgnoreCase("si"));

            System.out.println("\nReporte Final:");
            //Se usa un ciclo for each para recorrer toda la ArrayList
            for (Object[] student : students) {
                //Se hace un formato para el informe y se imprime por cada estudiante
                System.out.printf("%s (ID: %s) - Promedio: %.2f - %s%n", student[0], student[1], student[NUMBER_OF_SUBJECTS + 2], student[NUMBER_OF_SUBJECTS + 3]);
            }
        }
    }
}
