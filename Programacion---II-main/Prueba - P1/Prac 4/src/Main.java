/*
 * Clase Estudiante
 * Esta clase representa a un estudiante con los siguientes atributos:
 * - nombreCompleto: nombre completo del estudiante (String)
 * - numeroMatricula: número de matrícula (String)
 * - carrera: carrera que cursa el estudiante (String)
 * - promedioAcumulado: promedio acumulado (double), validado entre 0.0 y 10.0
 *
 * Métodos:
 * - Constructor Estudiante(String, String, String, double): inicializa los atributos
 * - Métodos establecer y obtener para cada atributo
 * - obtenerEstadoAcademico(): devuelve un String con el estado académico según el promedio
 *  - Si el promedio no está entre 0.0 y 10.0, debe establecerse en 0.0.
    "Excelente" si el promedio es >= 9.0 "Sobresaliente" si el promedio es >= 8.0 y < 9.0 "Bueno" si el promedio
* es >= 7.0 y < 8.0 "Regular" si el promedio es >= 6.0 y < 7.0 "Reprobado" si el promedio es < 6.0
  Escriba una aplicación de prueba llamada PruebaEstudiante que cree tres objetos Estudiante con diferentes
* promedios y muestre su estado académico.
 */

import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /** Declaración de Objetos*/
        Scanner sc = new Scanner(System.in);
        Estudiante estudiante1 = new Estudiante("Ana Pérez", "A001", "Ingeniería", 9.5);
        Estudiante estudiante2 = new Estudiante("Luis Gómez", "A002", "Medicina", 7.8);
        Estudiante estudiante3 = new Estudiante();

        /** Entrada de Datos*/
        System.out.println("Ingrese el nombre completo del estudiante:");
        estudiante3.setNombreCompleto(sc.nextLine());
        System.out.println("Ingrese el número de matrícula:");
        estudiante3.setNumeroMatricula(sc.nextLine());
        System.out.println("Ingrese la carrera:");
        estudiante3.setCarrera(sc.nextLine());
        System.out.println("Ingrese el promedio acumulado:");
        estudiante3.setPromedioAcumulado(sc.nextDouble());

        /** Establecer promedio con validación*/
        estudiante1.validarPromedio();
        estudiante2.validarPromedio();
        estudiante3.validarPromedio();

        System.out.println("--------------------------------");
        System.out.println("Por favor, revise la ventana emergente para ver el estado académico de los estudiantes.");


        /** Salida de Datos */
        JOptionPane.showMessageDialog(null, "Estado Académico de los Estudiantes:");
        estudiante1.mostrarEstadoAcademico();
        estudiante2.mostrarEstadoAcademico();
        estudiante3.mostrarEstadoAcademico();


    }
}