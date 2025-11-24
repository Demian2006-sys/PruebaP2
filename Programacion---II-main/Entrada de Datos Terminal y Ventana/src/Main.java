// Los paquetes se importan de manera automatica en java, no es necesario importarlas manualmente
// cada que escribes una funcionalidad que pertenece a "x" paquete
// pero si es necesario importarlas si se van a usar en el codigo

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        Proveedor prov1 = new Proveedor();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader es una clase que permite leer texto de una entrada de caracteres, en este caso
        // la entrada estandar (teclado)

        /*System.out.println("Escribe el nombre del proveedor: ");
        prov1.nombre = br.readLine();
        System.out.println("El nombre del proveedor es: " + prov1.nombre); */

        prov1.nombre = JOptionPane.showInputDialog("Escribe el nombre del proveedor: ");
        JOptionPane.showMessageDialog(null, "El nombre del proveedor es: " + prov1.nombre);
        // JOptionPane es una clase que permite crear cuadros de dialogo para interactuar con el usuario
        // en este caso, se usa para pedir el nombre del proveedor y mostrarlo en un cuadro de dialogo

        // Hay que tener en cuenta que no se pueden mezclar ambos tipos de entrada/salida
        // es decir, no se puede usar BufferedReader y JOptionPane en el mismo programa
        // ya que uno usa la consola y el otro usa cuadros de dialogo
        // por eso esta comentado la parte de BufferedReader
    }
}
