import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Creacion de objetos
        Automovil auto1 = new Automovil();
        Automovil auto2 = new Automovil(3.2, "i320", "BMW");


        // Llenar valores de forma simple
        auto1.cilindraje = 3.2;
        auto1.marca = "BMW";
        auto1.modelo = "i320";
        auto1.color = "negro";

        // llenar mediante metodos
        auto2.detalle();


        //Desplegar el valor de los objetos
        System.out.println("auto1.marca : " + auto1.marca);
        System.out.println("auto1.modelo : " + auto1.modelo);
        System.out.println("auto1.color : " + auto1.color);
        System.out.println("auto1.cilindraje : " + auto1.cilindraje);
        System.out.println("===================================================");
        System.out.printf("\n");

        // Ejercios clase
        // Crear los objtos
        Motos moto1 = new Motos();
        Motos moto2 = new Motos();

        // Llenar valores
        moto1.precio = 1500;
        moto1.marca = "kawasaki";
        moto1.modelo = "650R";
        moto1.hp = 700;

        moto2.precio = 2000;
        moto2.marca = "KTM";
        moto2.modelo = "Duke";
        moto2.hp = 950;

        // llamar a través de los metodos
        System.out.printf("Moto 1 \n");
        moto1.Detalles();

        System.out.printf("Moto 2 \n");
        moto2.Detalles();

        // Desplegar valores
        System.out.printf("Moto 1 \n");
        System.out.println("marca: " + moto1.marca);
        System.out.println("modelo: " + moto1.modelo);
        System.out.println("precio: " + moto1.precio);
        System.out.println("hp: " + moto1.hp);
        System.out.println("===================================================");
        System.out.printf("\n");

        System.out.printf("Moto 2\n");
        System.out.println("marca: " + moto2.marca);
        System.out.println("modelo: " + moto2.modelo);
        System.out.println("precio: " + moto2.precio);
        System.out.println("hp: " + moto2.hp);
        System.out.println("===================================================");
        System.out.printf("\n");

        //Ejercicio 2
        // Crear los objetos y pedir al usuario los valores por terminal
        Estudiantes estudiante1 = new Estudiantes();
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        /*System.out.println("Ingrese el nombre del estudiante 1: ");
        estudiante1.nombre = br.readLine();

        System.out.println("Ingrese la edad del estudiante 1: ");
        estudiante1.edad = Integer.parseInt(br.readLine());
        // Cuento se piden valores numericos, se debe convertir
        // con Integer.parseInt de int a String
        // Si es double, se usa Double.parseDouble

        System.out.println("Ingrese la carrera del estudiante 1: ");
        estudiante1.carrera = br.readLine();

        // Desplegar los valores
        System.out.println("===================================================");
        System.out.printf("Estudiante 1 \n");
        System.out.println("Nombre: " + estudiante1.nombre);
        System.out.println("Edad: " + estudiante1.edad);
        System.out.println("Carrera: " + estudiante1.carrera);
        System.out.println("===================================================");*/

        // Pedir datos mediante cuadro de dialogo
        Estudiantes estudiante2 = new Estudiantes();
        estudiante2.nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante 2: ");
        estudiante2.edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del estudiante 2: "));
        // Cuento se piden valores numericos, se debe convertir
        // con Integer.parseInt de int a String
        // Si es double, se usa Double.parseDouble

        estudiante2.carrera = JOptionPane.showInputDialog("Ingrese la carrera del estudiante 2: ");

        // Desplegar los valores
        JOptionPane.showMessageDialog(null, "Nombre: " + estudiante2.nombre +
                "\nEdad: " + estudiante2.edad +
                "\nCarrera: " + estudiante2.carrera);
        // El null es para que no tenga ventana padre y sea independiente
        // ademas el "\n" es para salto de linea y se ve de manera ordenada

        // No se puede mezclar ambos tipos de entrada de datos
        // por ende la primera salida esta comentada
    }
}
