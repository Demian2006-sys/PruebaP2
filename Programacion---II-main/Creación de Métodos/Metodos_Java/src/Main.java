import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /** Declaracion de Objetos */
        Proveedor vendor1 = new Proveedor();
        Scanner sc = new Scanner(System.in);

        /** Lectura de Datos */
        String ruc, razon, dir, deta;
        System.out.println("Proveedor RUC: ");
        vendor1.setRUC(sc.nextLine());
        System.out.println();

        System.out.println("Proveedor Razon Social: ");
        razon = sc.nextLine();
        System.out.println();

        System.out.println("Proveedor Direccion: ");
        dir = sc.nextLine();
        System.out.println();

        deta = vendor1.detallesProve(vendor1.getRUC(),razon,dir);
        //Se ingresa al metodo con las variables que contienen los datos

        //Crear metodo que entre como parametro "deta" y lo imprima en una ventana
        vendor1.mostrarMensaje(deta);

        /** Imprimir Datos*/
        System.out.println("Info Proveedor\n"+deta);
        // Imrimir esto en una ventana, pero traerlo e las clases a ttraves de un metodo

        vendor1.detalle2();
    }
}