/*
 * (La clase Factura)
 *
 * Cree una clase llamada Factura que una ferretería podría utilizar para
 * representar una factura para un artículo vendido en la tienda.
 *
 * Una Factura debe incluir cuatro piezas de información como variables de instancia:
 * - Un número de pieza (tipo String)
 * - La descripción de la pieza (tipo String)
 * - La cantidad de artículos de ese tipo que se van a comprar (tipo int)
 * - El precio por artículo (double)
 *
 * Su clase debe tener un constructor que inicialice las cuatro variables de instancia.
 * Proporcione un método establecer y un método obtener para cada variable de instancia.
 *
 * Además, proporcione un método llamado obtenerMontoFactura, que calcule el monto
 * de la factura (es decir, que multiplique la cantidad de artículos por el precio
 * de cada uno) y después devuelva ese monto como un valor double.
 *
 * Si la cantidad no es positiva, debe establecerse en 0.
 * Si el precio por artículo no es positivo, debe establecerse en 0.0.
 *
 * Escriba una aplicación de prueba llamada PruebaFactura, que demuestre las
 * capacidades de la clase Factura.
 */


import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /** Declaración de Objetos*/
        Scanner sc = new Scanner(System.in);
        Factura factura1 = new Factura();
        Factura factura2 = new Factura("001", "Tornillos", 10, 0.5);

        /** Lectura de Datos */
        System.out.println("============================");
        System.out.println("Bienvenido a la Ferretería");
        System.out.println("============================");

        System.out.print("Ingrese el número de pieza: ");
        factura1.setNumeroPieza(sc.nextLine());

        System.out.print("Ingrese la descripción de la pieza: ");
        factura1.setDescripcionPieza(sc.nextLine());

        System.out.print("Ingrese la cantidad: ");
        factura1.setCantidad(sc.nextInt());

        System.out.print("Ingrese el precio por artículo: ");
        factura1.setPrecioPorArticulo(sc.nextDouble());

        /** Mostrar Resultados */
        double montoFactura1 = factura1.obtenerMontoFactura();
        double montoFactura2 = factura2.obtenerMontoFactura();

        System.out.println("\nDetalles de la Factura 1:"); // Datos Ingresados por el Usuario
        JOptionPane.showMessageDialog(null,
                "Número de Pieza: " + factura1.getNumeroPieza() +
                        "\n" + "Descripción de la Pieza: " + factura1.getDescripcionPieza() +
                        "\n" + "Cantidad de la Pieza: " + factura1.getCantidad() +
                        "\n" + "Precio por Artículo: $" + factura1.getPrecioPorArticulo() +
                        "\n" + "Monto de la Factura: $" + montoFactura1);

        System.out.println("\nDetalles de la Factura 2:"); // Datos Ingresados por el Usuario
        JOptionPane.showMessageDialog(null,
                "Número de Pieza: " + factura2.getNumeroPieza() +
                        "\n" + "Descripción de la Pieza: " + factura2.getDescripcionPieza() +
                        "\n" + "Cantidad de la Pieza: " + factura2.getCantidad() +
                        "\n" + "Precio por Artículo: $" + factura2.getPrecioPorArticulo() +
                        "\n" + "Monto de la Factura: $" + montoFactura2);

    }
}