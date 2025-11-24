
/*
Ejercicio 4: La clase Vehiculo

Crea una clase llamada Vehiculo que represente un vehículo registrado en una base de datos de tránsito.
La clase debe incluir:
- Marca (String)
- Modelo (String)
- Año de fabricación (int)
- Kilometraje actual (double)

Requisitos:
- Constructor que inicialice todos los atributos.
- Métodos establecer y obtener para cada atributo.
- Si el año de fabricación es menor que 1900 o mayor que el año actual, debe establecerse en 2000.
- Si el kilometraje es negativo, debe establecerse en 0.
- Método calcularAntiguedad() que devuelva la antigüedad del vehículo en años.
- Método necesitaMantenimiento() que devuelva true si el vehículo tiene más de 10 años o más de 150,000 km.

Aplicación de prueba:
Crea una clase PruebaVehiculo que cree un objeto Vehiculo, muestre sus datos, calcule su antigüedad y
determine si necesita mantenimiento.
*/

import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /** Declaración de Objetos*/
        Scanner sc = new Scanner(System.in);
        Vehiculo vehiculo1 = new Vehiculo();

        /** Entrada de Datos*/
        int anioActual = 2025;

        System.out.println("Bienvenido al sistema de registro de vehículos.");
        System.out.println("---------------------------------------------");
        System.out.print("Ingrese la marca del vehículo: ");
        vehiculo1.setMarca(sc.nextLine());
        System.out.print("Ingrese el modelo del vehículo: ");
        vehiculo1.setModelo(sc.nextLine());

        System.out.println("Ingrese el año de fabricación del vehículo: ");
        int anioFabricacionInput = sc.nextInt();
        if (anioFabricacionInput < 1900 || anioFabricacionInput > anioActual) {
            vehiculo1.setAnioFabricacion(2000);
        } else {
            vehiculo1.setAnioFabricacion(anioFabricacionInput);
        }

        System.out.println("Ingrese el kilometraje actual del vehículo: ");
        double kilometrajeInput = sc.nextDouble();
        if (kilometrajeInput < 0) {
            vehiculo1.setKilometraje(0);
        } else {
            vehiculo1.setKilometraje(kilometrajeInput);
        }

        /** Salida de Datos*/
        vehiculo1.mostrarDatos();

        if (vehiculo1.mantenimiento(anioActual) == true) {
            JOptionPane.showMessageDialog(null,
                    "Antención: El vehículo necesita mantenimiento.");
        } else {
            JOptionPane.showMessageDialog(null,
                    "El vehículo no necesita mantenimiento.");
        }
    }
}