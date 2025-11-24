import javax.swing.*;

/*
La clase CuentaBancaria
Cree una clase llamada CuentaBancaria que un banco podría utilizar para gestionar las cuentas de sus clientes.
Una CuentaBancaria debe incluir cuatro variables de instancia:
número de cuenta (tipo String),
nombre del titular (tipo String),
saldo actual (tipo double) y
tipo de cuenta (tipo String - puede ser "Ahorro" o "Corriente").
Su clase debe tener un constructor que inicialice las cuatro variables de instancia.
Proporcione un método establecer y un método obtener para cada variable de instancia. Además, proporcione dos métodos:

depositar(double monto): que añada el monto al saldo. Si el monto no es positivo, no debe realizar ninguna operación.
retirar(double monto): que reste el monto del saldo. Si el monto es mayor al saldo o no es positivo,
no debe realizar ninguna operación.
obtenerSaldo(): que devuelva el saldo actual.

Escriba una aplicación de prueba llamada PruebaCuentaBancaria que demuestre las capacidades
de la clase CuentaBancaria, realizando varios depósitos y retiros.
* */
public class Main {
    public static void main(String[] args) {
        /** Declaración de Objetos*/
        CuentaBancaria cuenta1 = new CuentaBancaria("987654321", "María Gómez", 500.0, "Corriente");
        CuentaBancaria cuenta2 = new CuentaBancaria( "123456789", "Juan Pérez", 1000.0, "Ahorro");

        /** Menú de Opciones*/
        int opcCuenta = Integer.parseInt(JOptionPane.showInputDialog("Seleccione la cuenta con la que desea operar:\n" +
                "1. Cuenta de María Gómez\n" +
                "Numero de Cuenta: 987654321\n" +
                "\n" +
                "2. Cuenta de Juan Pérez\n"+
                "Numero de Cuenta: 123456789\n"));

        switch (opcCuenta){
            case 1:
                JOptionPane.showMessageDialog(null, "Ha seleccionado la cuenta de María Gómez\n");
                int opc1;
                do {
                    opc1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la opción\n" +
                            "1. Depositar\n" +
                            "2. Retirar\n" +
                            "3. Mostrar Saldo\n" +
                            "4. Salir"));

                    switch (opc1){
                        case 1:
                            double montoDeposito = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto a depositar:"));
                            cuenta1.depositar(montoDeposito);
                            JOptionPane.showMessageDialog(null, "Depósito realizado. Nuevo saldo: " + cuenta1.obtenerSaldo());
                            break;
                        case 2:
                            double montoRetiro = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto a retirar:"));
                            cuenta1.retirar(montoRetiro);
                            JOptionPane.showMessageDialog(null, "Retiro realizado. Nuevo saldo: " + cuenta1.obtenerSaldo());
                            break;
                        case 3:
                            JOptionPane.showMessageDialog(null, "El saldo actual es: " + cuenta1.obtenerSaldo());
                            break;
                        case 4:
                            JOptionPane.showMessageDialog(null, "Saliendo del programa.");
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opción no válida. Saliendo del programa.");
                    }
                }while (opc1 != 4);
                break;

            case 2:
                JOptionPane.showMessageDialog(null, "Ha seleccionado la cuenta de Juan Pérez");
                int opc2;
                do {
                    opc2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la opción\n" +
                            "1. Depositar\n" +
                            "2. Retirar\n" +
                            "3. Mostrar Saldo\n" +
                            "4. Salir"));

                    switch (opc2){
                        case 1:
                            double montoDeposito = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto a depositar:"));
                            cuenta2.depositar(montoDeposito);
                            JOptionPane.showMessageDialog(null, "Depósito realizado. Nuevo saldo: " + cuenta2.obtenerSaldo());
                            break;
                        case 2:
                            double montoRetiro = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto a retirar:"));
                            cuenta2.retirar(montoRetiro);
                            JOptionPane.showMessageDialog(null, "Retiro realizado. Nuevo saldo: " + cuenta2.obtenerSaldo());
                            break;
                        case 3:
                            JOptionPane.showMessageDialog(null, "El saldo actual es: " + cuenta2.obtenerSaldo());
                            break;
                        case 4:
                            JOptionPane.showMessageDialog(null, "Saliendo del programa.");
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opción no válida. Saliendo del programa.");
                    }
                }while (opc2 != 4);
                break;

            default:
                JOptionPane.showMessageDialog(null, "Opción no válida. Saliendo del programa.");
                //System.exit(0);
        }
    }
}