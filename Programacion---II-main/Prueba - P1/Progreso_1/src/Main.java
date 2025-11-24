/*
 * Programación II - Examen del Progreso
 * Proyecto: AppStore de Juegos
 *
 * Descripción General:
 * Se construye una aplicación para manejar una AppStore que gestiona 4 juegos.
 * Cada juego tiene nombre único, categoría (rompecabezas, acción o deporte), tamaño en KB,
 * precio en pesos, cantidad de licencias disponibles y vendidas.
 *
 * Funcionalidades principales:
 * 1. Visualizar información detallada de cada juego.
 * 2. Comprar licencias de un juego.
 * 3. Vender licencias de un juego.
 * 4. Consultar el juego menos vendido.
 * 5. Consultar descuentos aplicados por volumen de compra.
 * 6. Salir del programa.
 *
 * Promociones vigentes:
 * - Promoción 1: Si se compran al menos 25 licencias de juegos de rompecabezas, se aplica 20% de descuento.
 * - Promoción 2: Si se compran al menos 20 licencias de deportes y 15 de acción, se aplica 15% de descuento.
 * - Si se cumplen ambas condiciones, se aplica solo la primera que se cumpla.
 *
 * Políticas de compra automática:
 * - Política porcentaje: Se deben comprar licencias si la cantidad actual es menor al 25% de las licencias del juego menos vendido.
 * - Política categoría:
 *    - Juegos de deporte y aventura: comprar si hay menos de 10 licencias.
 *    - Juegos de acción y velocidad: comprar si hay menos de 15 licencias.
 *
 * Requisitos específicos:
 * 1. Declarar constantes en AppStore para el porcentaje (25%) y límites por categoría (10 y 15).
 * 2. Método darJuegoMenosVendido(): retorna nombre del juego con menos licencias vendidas o "NINGUNO".
 * 3. Método darComprasPorPorcentaje(): retorna nombres de juegos con licencias por debajo del 25% del menos vendido o "NINGUNO".
 * 4. Modificar metodo1(): mostrar mensaje con juegos que deben comprarse según política porcentaje.
 * 5. Método seDebeComprarPorCategoria(String nombre): retorna true si el juego debe comprarse según su categoría.
 * 6. Modificar metodo2(): mostrar juegos que deben comprarse según política categoría o "NINGUNO".
 *
 * Rubrica de evaluación:
 * - Objetos correctamente creados: 1 punto
 * - Menú y estructura de casos: 0.5 puntos
 * - Visualización de juegos: 0.5 puntos
 * - Compra de licencias: 1 punto
 * - Venta de licencias: 1 punto
 * - Juego menos vendido: 0.5 puntos
 * - Descuentos por volumen: 0.5 puntos
 * - Constantes y políticas adicionales: 3.5 puntos
 *
 * Consideraciones:
 * - Se debe usar lógica condicional para aplicar promociones.
 * - Se debe validar existencia de juegos por nombre.
 * - Se debe mantener claridad en la interfaz y modularidad en el código.
 */


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /** Declaración de Objetos*/
        Scanner sc = new Scanner(System.in);
        AppStore juego1 = new AppStore();
        AppStore juego2 = new AppStore();
        AppStore juego3 = new AppStore();
        AppStore juego4 = new AppStore();

        /** Leer Datos */
        System.out.println("Ingrese los datos de los 4 juegos:");
        System.out.println("--- Juego 1 ---");
        System.out.println("Nombre:");
        juego1.setNombre(sc.nextLine());
        System.out.println("Categoría (rompecabezas, acción, deporte):");
        juego1.setCategoria(sc.nextLine());
        System.out.println("Tamaño en KB:");
        juego1.setTamanoKB(sc.nextInt());
        sc.nextLine(); // Limpiar buffer
        System.out.println("Precio en pesos:");
        juego1.setPrecioPesos(sc.nextDouble());
        sc.nextLine(); // Limpiar buffer
        System.out.println("Cantidad de licencias disponibles:");
        juego1.setLicenciasDisponibles(sc.nextInt());
        sc.nextLine(); // Limpiar buffer
        juego1.setLicenciasVendidas(0);


        System.out.println("--- Juego 2 ---");
        System.out.println("Nombre:");
        juego2.setNombre(sc.nextLine());
        System.out.println("Categoría (rompecabezas, acción, deporte):");
        juego2.setCategoria(sc.nextLine());
        System.out.println("Tamaño en KB:");
        juego2.setTamanoKB(sc.nextInt());
        sc.nextLine(); // Limpiar buffer
        System.out.println("Precio en pesos:");
        juego2.setPrecioPesos(sc.nextDouble());
        sc.nextLine(); // Limpiar buffer
        System.out.println("Cantidad de licencias disponibles:");
        juego2.setLicenciasDisponibles(sc.nextInt());
        sc.nextLine(); // Limpiar buffer
        juego2.setLicenciasVendidas(0);


        System.out.println("--- Juego 3 ---");
        System.out.println("Nombre:");
        juego3.setNombre(sc.nextLine());
        System.out.println("Categoría (rompecabezas, acción, deporte):");
        juego3.setCategoria(sc.nextLine());
        System.out.println("Tamaño en KB:");
        juego3.setTamanoKB(sc.nextInt());
        sc.nextLine(); // Limpiar buffer
        System.out.println("Precio en pesos:");
        juego3.setPrecioPesos(sc.nextDouble());
        sc.nextLine(); // Limpiar buffer
        System.out.println("Cantidad de licencias disponibles:");
        juego3.setLicenciasDisponibles(sc.nextInt());
        sc.nextLine(); // Limpiar buffer
        juego3.setLicenciasVendidas(0);


        System.out.println("--- Juego 4 ---");
        System.out.println("Nombre:");
        juego4.setNombre(sc.nextLine());
        System.out.println("Categoría (rompecabezas, acción, deporte):");
        juego4.setCategoria(sc.nextLine());
        System.out.println("Tamaño en KB:");
        juego4.setTamanoKB(sc.nextInt());
        sc.nextLine(); // Limpiar buffer
        System.out.println("Precio en pesos:");
        juego4.setPrecioPesos(sc.nextDouble());
        sc.nextLine(); // Limpiar buffer
        System.out.println("Cantidad de licencias disponibles:");
        juego4.setLicenciasDisponibles(sc.nextInt());
        sc.nextLine(); // Limpiar buffer
        juego4.setLicenciasVendidas(0);


        /** Menú de Opciones */
        int opc;
        do {
            System.out.println("\n--- Menú de Opciones ---");
            System.out.println("1. Visualizar información de los juegos");
            System.out.println("2. Comprar licencias de un juego");
            System.out.println("3. Vender licencias de un juego");
            System.out.println("4. Consultar el juego menos vendido");
            System.out.println("5. Consultar descuentos aplicados por volumen de compra");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción (1-6): ");
            opc = sc.nextInt();

            switch (opc) {
                case 1:
                    System.out.println("--- Información de los Juegos ---");
                    System.out.println("--- Juego 1 ---");
                    System.out.println("Nombre: " + juego1.getNombre());
                    System.out.println("Categoría: " + juego1.getCategoria());
                    System.out.println("Tamaño en KB: " + juego1.getTamanoKB());
                    System.out.println("Precio en pesos: " + juego1.getPrecioPesos());
                    System.out.println("Licencias disponibles: " + juego1.getLicenciasDisponibles());
                    System.out.println("Licencias vendidas: " + juego1.getLicenciasVendidas());

                    System.out.println("--- Juego 2 ---");
                    System.out.println("Nombre: " + juego2.getNombre());
                    System.out.println("Categoría: " + juego2.getCategoria());
                    System.out.println("Tamaño en KB: " + juego2.getTamanoKB());
                    System.out.println("Precio en pesos: " + juego2.getPrecioPesos());
                    System.out.println("Licencias disponibles: " + juego2.getLicenciasDisponibles());
                    System.out.println("Licencias vendidas: " + juego2.getLicenciasVendidas());

                    System.out.println("--- Juego 3 ---");
                    System.out.println("Nombre: " + juego3.getNombre());
                    System.out.println("Categoría: " + juego3.getCategoria());
                    System.out.println("Tamaño en KB: " + juego3.getTamanoKB());
                    System.out.println("Precio en pesos: " + juego3.getPrecioPesos());
                    System.out.println("Licencias disponibles: " + juego3.getLicenciasDisponibles());
                    System.out.println("Licencias vendidas: " + juego3.getLicenciasVendidas());

                    System.out.println("--- Juego 4 ---");
                    System.out.println("Nombre: " + juego4.getNombre());
                    System.out.println("Categoría: " + juego4.getCategoria());
                    System.out.println("Tamaño en KB: " + juego4.getTamanoKB());
                    System.out.println("Precio en pesos: " + juego4.getPrecioPesos());
                    System.out.println("Licencias disponibles: " + juego4.getLicenciasDisponibles());
                    System.out.println("Licencias vendidas: " + juego4.getLicenciasVendidas());
                    break;
                case 2:
                    int opc2;
                    do {
                        System.out.println("\n--- Comprar Licencias ---");
                        System.out.println("1. Comprar licencias de " + juego1.getNombre());
                        System.out.println("2. Comprar licencias de " + juego2.getNombre());
                        System.out.println("3. Comprar licencias de " + juego3.getNombre());
                        System.out.println("4. Comprar licencias de " + juego4.getNombre());
                        System.out.println("5. Volver al menú principal");
                        System.out.print("Seleccione una opción (1-5): ");
                        opc2 = sc.nextInt();

                        switch (opc2) {
                            case 1:
                                System.out.print("Ingrese la cantidad de licencias a comprar de " + juego1.getNombre() + ": ");
                                int cant1 = sc.nextInt();
                                int compradas1 = juego1.comprarLicencias(cant1);
                                System.out.println("Se compraron " + compradas1 + " licencias de " + juego1.getNombre());
                                break;
                            case 2:
                                System.out.print("Ingrese la cantidad de licencias a comprar de " + juego2.getNombre() + ": ");
                                int cant2 = sc.nextInt();
                                int compradas2 = juego2.comprarLicencias(cant2);
                                System.out.println("Se compraron " + compradas2 + " licencias de " + juego2.getNombre());
                                break;
                            case 3:
                                System.out.print("Ingrese la cantidad de licencias a comprar de " + juego3.getNombre() + ": ");
                                int cant3 = sc.nextInt();
                                int compradas3 = juego3.comprarLicencias(cant3);
                                System.out.println("Se compraron " + compradas3 + " licencias de " + juego3.getNombre());
                                break;
                            case 4:
                                System.out.print("Ingrese la cantidad de licencias a comprar de " + juego4.getNombre() + ": ");
                                int cant4 = sc.nextInt();
                                int compradas4 = juego4.comprarLicencias(cant4);
                                System.out.println("Se compraron " + compradas4 + " licencias de " + juego4.getNombre());
                                break;
                            case 5:
                                System.out.println("Volviendo al menú principal...");
                                break;
                            default:
                                System.out.println("Opción inválida. Por favor, seleccione una opción del 1 al 5.");
                        }
                    }while (opc2 != 5);
                    break;
                case 3:
                    int opc3;
                    do {
                        System.out.println("\n--- Vender Licencias ---");
                        System.out.println("1. Vender licencias de " + juego1.getNombre());
                        System.out.println("2. Vender licencias de " + juego2.getNombre());
                        System.out.println("3. Vender licencias de " + juego3.getNombre());
                        System.out.println("4. Vender licencias de " + juego4.getNombre());
                        System.out.println("5. Volver al menú principal");
                        System.out.print("Seleccione una opción (1-5): ");
                        opc3 = sc.nextInt();

                        switch (opc3)
                        {
                            case 1:
                                System.out.print("Ingrese la cantidad de licencias a vender de " + juego1.getNombre() + ": ");
                                int cant1 = sc.nextInt();
                                double total1 = juego1.venderLicencias(cant1);
                                System.out.println("Se vendieron licencias de " + juego1.getNombre() + ". Total a pagar: $" + total1);
                                break;
                            case 2:
                                System.out.print("Ingrese la cantidad de licencias a vender de " + juego2.getNombre() + ": ");
                                int cant2 = sc.nextInt();
                                double total2 = juego2.venderLicencias(cant2);
                                System.out.println("Se vendieron licencias de " + juego2.getNombre() + ". Total a pagar: $" + total2);
                                break;
                            case 3:
                                System.out.print("Ingrese la cantidad de licencias a vender de " + juego3.getNombre() + ": ");
                                int cant3 = sc.nextInt();
                                double total3 = juego3.venderLicencias(cant3);
                                System.out.println("Se vendieron licencias de " + juego3.getNombre() + ". Total a pagar: $" + total3);
                                break;
                            case 4:
                                System.out.print("Ingrese la cantidad de licencias a vender de " + juego4.getNombre() + ": ");
                                int cant4 = sc.nextInt();
                                double total4 = juego4.venderLicencias(cant4);
                                System.out.println("Se vendieron licencias de " + juego4.getNombre() + ". Total a pagar: $" + total4);
                                break;
                            case 5:
                                System.out.println("Volviendo al menú principal...");
                                break;
                            default:
                                System.out.println("Opción inválida. Por favor, seleccione una opción del 1 al 5.");
                        }
                    }while (opc3 != 5);

                    break;
                case 4:
                    System.out.println("El juego menos vendido es: " + AppStore.darJuegoMenosVendido(juego1, juego2, juego3, juego4));
                    break;
                case 5:
                    System.out.println("Descuentos aplicados por volumen de compra:");
                    double desc1 = juego1.calcularDescuento(juego1.getLicenciasVendidas());
                    double desc2 = juego2.calcularDescuento(juego2.getLicenciasVendidas());
                    double desc3 = juego3.calcularDescuento(juego3.getLicenciasVendidas());
                    double desc4 = juego4.calcularDescuento(juego4.getLicenciasVendidas());
                    System.out.println(juego1.getNombre() + ": " + (desc1 * 100) + "% de descuento");
                    System.out.println(juego2.getNombre() + ": " + (desc2 * 100) + "% de descuento");
                    System.out.println(juego3.getNombre() + ": " + (desc3 * 100) + "% de descuento");
                    System.out.println(juego4.getNombre() + ": " + (desc4 * 100) + "% de descuento");

                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción del 1 al 6.");
            }
        }while (opc != 6);




    }
}