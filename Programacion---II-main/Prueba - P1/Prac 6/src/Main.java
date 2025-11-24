/*
La clase Tiempo
Cree una clase llamada Tiempo que incluya tres variables de instancia:
 hora (tipo int),
 minuto (tipo int) y
 segundo (tipo int), todos en formato de 24 horas.

Su clase debe tener un constructor que inicialice las tres variables.
Proporcione métodos establecer y obtener que validen: hora (0-23), minuto (0-59), segundo (0-59).
Si los valores no son válidos, establézcalos en 0.
Proporcione métodos que:

mostrarTiempo24(): muestre el tiempo en formato 24 horas (HH:MM:SS)
mostrarTiempo12(): muestre el tiempo en formato 12 horas (HH:MM:SS AM/PM)
convertirASegundos(): devuelva el tiempo total en segundos desde medianoche
agregarSegundos(int segundos): añada segundos al tiempo actual, ajustando minutos y horas
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /** Declaración de Objetos*/
        Scanner sc = new Scanner(System.in);
        Tiempo tiempo1 = new Tiempo();

        /** Entrada de Datos*/
        System.out.println("---------------------------");
        System.out.println("Ingrese la hora (0-23): ");
        int hora = sc.nextInt();
        if (hora < 0 || hora > 23) {
            tiempo1.setHora(0);
        } else {
            tiempo1.setHora(hora);
        }

        System.out.println("Ingrese el minuto (0-59): ");
        int minuto = sc.nextInt();
        if (minuto < 0 || minuto > 59) {
            tiempo1.setMinuto(0);
        } else {
            tiempo1.setMinuto(minuto);
        }

        System.out.println("Ingrese el segundo (0-59): ");
        int segundo = sc.nextInt();
        if (segundo < 0 || segundo > 59) {
            tiempo1.setSegundo(0);
        } else {
            tiempo1.setSegundo(segundo);
        }

        /** Salida de Datos*/

        System.out.println("---------------------------");
        int opc;
        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Mostrar tiempo en formato 24 horas");
            System.out.println("2. Mostrar tiempo en formato 12 horas");
            System.out.println("3. Convertir a segundos desde medianoche");
            System.out.println("4. Agregar segundos");
            System.out.println("5. Salir");
            opc = sc.nextInt();

            switch (opc) {
                case 1:
                    tiempo1.mostrarTiempo24();
                    break;
                case 2:
                    tiempo1.mostratTiempo12();
                    break;
                case 3:
                    int totalSegundos = tiempo1.convertirASegundos();
                    System.out.println("Total de segundos desde medianoche: " + totalSegundos);
                    break;
                case 4:
                    System.out.println("Ingrese la cantidad de segundos a agregar: ");
                    int segundosAAgregar = sc.nextInt();
                    if (segundosAAgregar < 0) {
                        System.out.println("No se pueden agregar segundos negativos.");
                        break;
                    }
                    tiempo1.agregarSegundos(segundosAAgregar);
                    System.out.println("Segundos agregados.");
                    break;
                case 5:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
            System.out.println("---------------------------");
        } while (opc != 5);
    }
}