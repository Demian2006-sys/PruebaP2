package udla.mcastillo.ejercicio4.main;

/*
El banco El Ahorrador Feliz requiere la construcción de un sistema que le permita controlar las cuentas de sus
clientes, y para ello las clasifica en dos tipos: cuentas de ahorros y cuentas corrientes.

Todas las cuentas del banco tienen los siguientes datos:
- Número de cuenta (dato numérico).
- Nombre del cliente (cadena). (Esta debe de ser otra clase, pues un cliente puede tener varias cuentas). (Composición).
- Saldo (dato numérico con fracción decimal).
- Tipo de inversion (enum).

Con cada cuenta se pueden realizar las siguientes operaciones:
- Consultar datos: a través de sus propiedades.
- Depositar: incrementa el saldo con la cantidad de dinero que se deposita.
- Retirar: antes de hacer el retiro, se debe verificar la suficiencia de saldo y, en caso de aprobarlo,
  se disminuye el saldo.

Las cuentas de ahorros presentan las siguientes características:
- Porcentaje de interés mensual.
- Método para depositar los intereses el primer día de cada mes.
- Solamente se puede retirar un monto menor o igual al saldo.

Las cuentas corrientes presentan las siguientes características:
- Cobro del 4x1.000 en cada transacción.
- Se puede sobregirar hasta en $300.000 cuando el saldo no es suficiente para el retiro.
*/

import udla.mcastillo.ejercicio4.objetos.*;

import java.util.Scanner;

public class Banco {
    public static void main(String[] args) {
        /** Declaracion de Objetos*/
        Scanner sc = new Scanner(System.in);
        //Mediante el constructor con parámetros
        Cliente cliente1 = new Cliente("Nicolai Acosta", new CtaAhorro(123456, 500000.0, Inversion.PV, 0.05));

        // Mediante el constructor vacío
        Cliente cliente2 = new Cliente();

        /** Asignar valores a los clientes*/
        System.out.println("Bienvenido al Banco El Ahorrador Feliz");
        System.out.println("");
        System.out.println("Cuenta 1 creada exitosamente .....");
        System.out.println("");
        System.out.println("Creando cuenta para el cliente 2...");
        System.out.println("Ingrese el nombre del cliente 2: ");
        cliente2.setNombre(sc.nextLine());

        System.out.println("Ingrese el número de cuenta del cliente 2: ");
        int numCuenta = sc.nextInt();
        System.out.println("Ingrese el saldo inicial del cliente 2: ");
        double saldoInicial = sc.nextDouble();
        System.out.println("Seleccione el tipo de inversión (1: PV, 2: PF, 3: INDEXADAS): ");
        int tipoInv = sc.nextInt();
        Inversion inversionTipo; // variable de tipo Inversion (enum) para almacenar el tipo de inversión seleccionado

        switch (tipoInv) {
            case 1:
                inversionTipo = Inversion.PV;
                break;

            case 2:
                inversionTipo = Inversion.PF;
                break;

            case 3:
                inversionTipo = Inversion.INDEXADAS;
                break;
            default:
                System.out.println("Tipo de inversión inválido. Se asignará PV por defecto.");
                inversionTipo = Inversion.PV;
                break;
        }

        System.out.println("Seleccione el tipo de cuenta (1: Ahorros, 2: Corriente): ");
        int tipoCuenta = sc.nextInt();

        if (tipoCuenta == 1) {
            System.out.println("Ingrese el porcentaje de interés mensual (por ejemplo, 0.05 para 5%): ");
            double interesMensual = sc.nextDouble();
            cliente2.setCuenta(new CtaAhorro(numCuenta, saldoInicial, inversionTipo, interesMensual));
        } else if (tipoCuenta == 2) {
            System.out.println("La linea de credito por defecto son de $300 000");
            cliente2.setCuenta(new CtaCorriente(numCuenta, saldoInicial, inversionTipo, 300000));
        } else {
            System.out.println("Tipo de cuenta inválido. Se creará una cuenta de ahorros por defecto.");
            cliente2.setCuenta(new CtaAhorro(numCuenta, saldoInicial, inversionTipo, 0.03));
        }

        /** Uso de métodos y atributos*/
        // Variable para ejecutar bucle debe estar fuera del do-while
        // e inicializada en blanco para evitar errores
        String retry = "";

        do {
            System.out.println("");
            System.out.println("-----Menú de Operaciones Bancarias-----");
            System.out.println("Ingrese el numero de cuenta para realizar operaciones: ");
            System.out.println("Si desea salir del sistema, selecciones cero (0)");
            int cuentaInput = sc.nextInt();

            if (cuentaInput == cliente1.getCuenta().getNumeroCuenta()) {
                int opc;
                do {
                    System.out.println("");
                    System.out.println("-----Menú de Operaciones Bancarias-----");
                    System.out.println("1. Datos de la Cuenta");
                    System.out.println("2. Depositar");
                    System.out.println("3. Retirar");
                    System.out.println("4. Regresar al menú principal");
                    System.out.println("5. Salir");
                    System.out.println("Seleccione una opción: ");
                    opc = sc.nextInt();
                    switch (opc) {
                        case 1:
                            System.out.println("Datos del Cliente:");
                            System.out.println("Nombre: " + cliente1.getNombre());

                            // Validar si es cuenta de ahorro o corriente para mostrar datos específicos
                            if (cliente1.getCuenta() instanceof CtaAhorro) {
                                CtaAhorro ctaAhorro = (CtaAhorro) cliente1.getCuenta();
                                ctaAhorro.consultarInteres();
                            } else if (cliente1.getCuenta() instanceof CtaCorriente) {
                                CtaCorriente ctaCorriente = (CtaCorriente) cliente1.getCuenta();
                                ctaCorriente.consultarLineaCredito();
                            }
                            break;

                        case 2:
                            System.out.println("Ingrese el monto a depositar: ");
                            double montoDeposito = sc.nextDouble();

                            // Validar si es cuenta corriente para usar método específico
                            if (cliente1.getCuenta() instanceof CtaCorriente) {
                                // Se realiza casting para acceder a los métodos específicos de CtaCorriente
                                // por lo que se crea una nueva variable de tipo CtaCorriente
                                CtaCorriente ctaCorriente = (CtaCorriente) cliente1.getCuenta();

                                double nuevoSaldo = ctaCorriente.depositarCorriente(montoDeposito);
                                System.out.println("Depósito exitoso (con cobro 4x1000). Nuevo saldo: " + nuevoSaldo);
                            } else {
                                double nuevoSaldo = cliente1.getCuenta().depositar(montoDeposito);
                                System.out.println("Depósito exitoso. Nuevo saldo: " + nuevoSaldo);
                            }
                            break;

                        case 3:
                            System.out.println("Ingrese el monto a retirar: ");
                            double montoRetiro = sc.nextDouble();

                            // Validar si es cuenta corriente
                            if (cliente1.getCuenta() instanceof CtaCorriente) {
                                CtaCorriente ctaCorriente = (CtaCorriente) cliente1.getCuenta();
                                ctaCorriente.retirarCorriente(montoRetiro);
                            } else {
                                cliente1.getCuenta().retirar(montoRetiro);
                            }
                            break;

                        case 4:
                            System.out.println("Regresando al menú principal...");
                            retry = "s";
                            break;

                        case 5:
                            System.out.println("Gracias por usar el sistema bancario");
                            retry = "n";
                            break;

                        default:
                            System.out.println("Opción inválida.");
                            break;
                    }
                }while(opc !=5 && opc !=4);


            } else if (cuentaInput == cliente2.getCuenta().getNumeroCuenta()) {
                int opc;
                do {
                    System.out.println("");
                    System.out.println("-----Menú de Operaciones Bancarias-----");
                    System.out.println("1. Datos de la Cuenta");
                    System.out.println("2. Depositar");
                    System.out.println("3. Retirar");
                    System.out.println("4. Regresar al menú principal");
                    System.out.println("5. Salir");
                    System.out.println("Seleccione una opción: ");
                    opc = sc.nextInt();
                    switch (opc) {
                        case 1:
                            System.out.println("Datos del Cliente:");
                            System.out.println("Nombre: " + cliente2.getNombre());

                            // Validar si es cuenta de ahorro o corriente para mostrar datos específicos
                            if (cliente2.getCuenta() instanceof CtaAhorro) {
                                CtaAhorro ctaAhorro = (CtaAhorro) cliente2.getCuenta();
                                ctaAhorro.consultarInteres();
                            } else if (cliente2.getCuenta() instanceof CtaCorriente) {
                                CtaCorriente ctaCorriente = (CtaCorriente) cliente2.getCuenta();
                                ctaCorriente.consultarLineaCredito();
                            }
                            break;

                        case 2:
                            System.out.println("Ingrese el monto a depositar: ");
                            double montoDeposito = sc.nextDouble();

                            if (cliente2.getCuenta() instanceof CtaCorriente) {
                                CtaCorriente ctaCorriente = (CtaCorriente) cliente2.getCuenta();
                                double nuevoSaldo = ctaCorriente.depositarCorriente(montoDeposito);
                                System.out.println("Depósito exitoso (con cobro 4x1000). Nuevo saldo: " + nuevoSaldo);
                            } else {
                                double nuevoSaldo = cliente2.getCuenta().depositar(montoDeposito);
                                System.out.println("Depósito exitoso. Nuevo saldo: " + nuevoSaldo);
                            }
                            break;

                        case 3:
                            System.out.println("Ingrese el monto a retirar: ");
                            double montoRetiro = sc.nextDouble();

                            if (cliente2.getCuenta() instanceof CtaCorriente) {
                                CtaCorriente ctaCorriente = (CtaCorriente) cliente2.getCuenta();
                                ctaCorriente.retirarCorriente(montoRetiro);
                            } else {
                                cliente2.getCuenta().retirar(montoRetiro);
                            }
                            break;
                        case 4:
                            System.out.println("Regresando al menú principal...");
                            retry = "s";
                            break;

                        case 5:
                            System.out.println("Gracias por usar el sistema bancario");
                            retry = "n";
                            break;

                        default:
                            System.out.println("Opción inválida.");
                            break;
                    }
                }while (opc !=5 && opc !=4);

            } else if (cuentaInput == 0) {
                System.out.println("Gracias por usar el sistema bancario");
                break;

            } else {
                System.out.println("Número de cuenta no encontrado.");
                System.out.println("¿Desea intentar de nuevo? (s/n): ");
                sc.nextLine(); // Consumir el salto de línea pendiente
                retry = sc.nextLine();

                do {
                    if (retry.equals("n") || retry.equals("N")) {
                        System.out.println("Gracias por usar el sistema bancario");
                        break;
                    } else if (retry.equals("s") || retry.equals("S")) {
                        // Entrada válida 's', salir del bucle
                        break;
                    } else {
                        System.out.println("Entrada inválida. Por favor ingrese 's' para sí o 'n' para no: ");
                        retry = sc.nextLine();
                    }
                } while (!retry.equals("s") && !retry.equals("S") && !retry.equals("n") && !retry.equals("N"));
            }
        } while (retry.equals("s") || retry.equals("S"));
        // se usa retry.equals para evitar errores de compilacion
        // en java usar == para comparar cadenas puede causar errores inesperados
    }
}