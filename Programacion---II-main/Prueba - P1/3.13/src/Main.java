
/**
 * EJERCICIO: Clase Fecha
 *
 * Requisitos:
 * Crear una clase llamada Fecha con tres variables de instancia:
 *   - mes (tipo int)
 *   - día (tipo int)
 *   - año (tipo int)
 *
 * Implementar un constructor que inicialice las tres variables.
 * Asumir que los valores proporcionados son correctos.
 *
 * Proporcionar métodos establecer (set) y obtener (get) para cada variable.
 *
 * Implementar el método mostrarFecha() que retorne la fecha en formato: día/mes/año
 *
 * Crear una aplicación de prueba llamada PruebaFecha que demuestre
 *    las capacidades de la clase Fecha.
 */

import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        /**Creación del objeto*/
        Fecha fecha1 = new Fecha();
        fecha1.obtenerfecha();
        JOptionPane.showMessageDialog(null, "La fecha del día es: " + fecha1.mostrarFecha());
    }
}