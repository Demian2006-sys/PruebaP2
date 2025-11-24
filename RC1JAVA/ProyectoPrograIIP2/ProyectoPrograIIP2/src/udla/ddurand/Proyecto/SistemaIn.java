package udla.ddurand.Proyecto;

import udla.ddurand.Proyecto.Bodega.ReporteInventario;
import udla.ddurand.Proyecto.Producto.ProductoTia;
import udla.ddurand.Proyecto.Bodega.Almacen;
import udla.ddurand.Proyecto.transacciones.Compra;
import udla.ddurand.Proyecto.transacciones.Transaccion;
import udla.ddurand.Proyecto.transacciones.Venta;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaIn {
    private static Scanner scanner = new Scanner(System.in);
    //Listas para almacenar los productos

    private static List<Almacen> listaAlmacenes = new ArrayList<>();

    private static List<Transaccion> listaTransacciones = new ArrayList<>();

    private static List<Compra> listaCompras = new ArrayList<>();

    private static List<Venta> listaVentas = new ArrayList<>();

    private static List<ReporteInventario> listaReportes = new ArrayList<>();

    private static List<ProductoTia> listaproductos = new ArrayList<>();


    public static void main(String[] args) {
        int opc;
        do {
            mostrarMenu();
            if (scanner.hasNextInt()) {
                opc = scanner.nextInt();
                scanner.nextLine(); // Consumir la línea pendiente

                switch (opc) {
                    case 1:
                        ingresarProducto();
                        break;
                    case 2:
                        gestionBodega();
                        break;
                    case 3:
                        realizarVenta();
                        break;
                    case 4:
                        reabastecerProducto();
                        break;
                    case 5:
                        editarProducto();
                        break;
                    case 6:
                        eliminarProducto();
                        break;
                    case 7:

                        break;
                    case 8:
                        System.out.println("\n Saliendo de la aplicación. ¡Hasta pronto!");
                        break;
                    default:
                        System.out.println("\n Opción no válida. Inténtelo de nuevo.");
                }
            } else {
                System.out.println("\n Entrada no válida. Por favor, ingrese un número.");
                scanner.nextLine(); // Consumir la entrada no válida
                opc = 0; // Para que el bucle continúe
            }

            if (opc != 8) {
                System.out.println("\n-------------------------------------------");
            }
        } while (opc != 8);
        scanner.close();


    }

    private static void mostrarMenu() {
        System.out.println("\n===========================================");
        System.out.println("          SISTEMA DE GESTIÓN INVENTARIO          ");
        System.out.println("===========================================");
        System.out.println("1.  Ingresar Nuevo Producto");
        System.out.println("2.  Control de Bodega ");
        System.out.println("3.  Realizar venta");
        System.out.println("4.  Reabastecer producto");
        System.out.println("5.  Editar Producto");
        System.out.println("6.  Eliminar Producto");
        System.out.println("7.  Mostrar reporte");
        System.out.println("8. Salir");
        System.out.print(">>> Ingrese su opcion: ");
    }

    private static void ingresarProducto() {
        System.out.println("\n--- Ingreso de Nuevo Producto ---");
        System.out.print("Ingrese nombre del producto: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese precio: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Ingrese tipo: ");
        String tipo = scanner.nextLine();

        System.out.print("Ingrese fecha de elaboración (dd/mm/aaaa): ");
        String fechaElaboracion = scanner.nextLine();

        System.out.print("Ingrese fecha de vencimiento (dd/mm/aaaa): ");
        String fechaVencimiento = scanner.nextLine();

        System.out.print("Ingrese garantía en meses: ");
        int garantiaMeses = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese cantidad: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\nDisponibilidad:");
        System.out.println("1. Disponible");
        System.out.println("2. No disponible");
        System.out.print(">>> Seleccione disponibilidad: ");
        int opci = scanner.nextInt();
        scanner.nextLine();

        String disponibilidad = (opci == 1) ? "Disponible" : "No disponible";

        System.out.println("\nNivel de demanda:");
        System.out.println("1. Alta");
        System.out.println("2. Media");
        System.out.println("3. Baja");
        System.out.print(">>> Seleccione nivel de demanda: ");
        int opcionDemanda = scanner.nextInt();
        scanner.nextLine();

        int demandaAlta = 0, demandaMedia = 0, demandaBaja = 0;

        switch (opcionDemanda) {
            case 1:
                demandaAlta = 1;
                break;
            case 2:
                demandaMedia = 1;
                break;
            case 3:
                demandaBaja = 1;
                break;
            default:
                demandaBaja = 1;
                break;
        }

        ProductoTia nuevoProducto = new ProductoTia(
                nombre,
                precio,
                tipo,
                fechaElaboracion,
                fechaVencimiento,
                garantiaMeses,
                tipo,
                disponibilidad,
                cantidad,
                demandaAlta,
                demandaMedia,
                demandaBaja
        );

        listaproductos.add(nuevoProducto);
        System.out.println("\nProducto ingresado con éxito. Código asignado: " + nuevoProducto.getCodigo());
    }

    private static void gestionBodega() {
        System.out.println("\n--- Gestión de Bodega ---");
        System.out.println("Ingrese la capacidad máxima de la bodega");
        long capacidadMaxima = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Ingrese la cantidad máxima de productos");
        int cantidadMaxima = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese la ubicación de la bodega");
        String ubicacion = scanner.nextLine();
    }

    private static void realizarVenta() {
        if (listaproductos.isEmpty()) {
            System.out.println("\n No hay productos para vender.");
            return;
        }

        System.out.println("\n--- Realizar Venta ---");
        System.out.print("Ingrese el código del producto: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        boolean encontrado = false;
        for (int i = 0; i < listaproductos.size(); i++) {
            if (listaproductos.get(i).getCodigo() == codigo) {
                ProductoTia producto = listaproductos.get(i);

                System.out.print("Cantidad a vender: ");
                int cantidad = scanner.nextInt();
                scanner.nextLine();

                if (cantidad <= 0) {
                    System.out.println("\n La cantidad debe ser mayor que cero.");
                    return;
                }

                if (cantidad > producto.getCantidadP()) {
                    System.out.println("\n Stock insuficiente. Cantidad disponible: " + producto.getCantidadP());
                    return;
                }

                double monto = producto.getPrecio() * cantidad;

                System.out.print("Ingrese nombre del cliente: ");
                String cliente = scanner.nextLine();

                System.out.print("Ingrese fecha (dd/mm/aaaa): ");
                String fecha = scanner.nextLine();

                String numeroTransaccion = "V-" + (listaVentas.size() + 1);

                Venta venta = new Venta(fecha, monto, numeroTransaccion, cliente);
                listaVentas.add(venta);
                listaTransacciones.add(venta);

                producto.setCantidadP(producto.getCantidadP() - cantidad);

                encontrado = true;
                System.out.println("\n Venta realizada con éxito. Stock restante: " + producto.getCantidadP());
                break;
            }
        }

        if (!encontrado) {
            System.out.println("\n No se encontró ningún producto con código " + codigo + ".");
        }
    }

    private static void reabastecerProducto() {
        if (listaproductos.isEmpty()) {
            System.out.println("\n No hay productos registrados.");
            return;
        }

        System.out.println("\n--- Reabastecer Producto ---");
        System.out.print("Ingrese el código del producto: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        boolean encontrado = false;
        for (int i = 0; i < listaproductos.size(); i++) {
            if (listaproductos.get(i).getCodigo() == codigo) {
                ProductoTia producto = listaproductos.get(i);

                System.out.print("Ingrese la cantidad a reabastecer: ");
                int cantidad = scanner.nextInt();
                scanner.nextLine();

                if (cantidad <= 0) {
                    System.out.println("\n La cantidad debe ser mayor que cero.");
                    return;
                }

                producto.setCantidadP(producto.getCantidadP() + cantidad);

                System.out.print("Ingrese fecha de reabastecimiento (dd/mm/aaaa): ");
                String fecha = scanner.nextLine();

                encontrado = true;
                System.out.println("\n Producto reabastecido con éxito.");
                break;
            }
        }
        if (!encontrado) {
            System.out.println("\n No se encontró ningún producto con código " + codigo + ".");
        }
    }

    private static void eliminarProducto() {
        if (listaproductos.isEmpty()) {
            System.out.println("\n No hay productos para eliminar.");
            return;
        }

        System.out.println("\n--- Eliminar Producto ---");
        System.out.print("Ingrese el código del producto a eliminar: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        boolean encontrado = false;
        for (int i = 0; i < listaproductos.size(); i++) {
            if (listaproductos.get(i).getCodigo() == codigo) {
                listaproductos.remove(i);
                encontrado = true;
                System.out.println("\n Producto con código " + codigo + " eliminado con éxito.");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("\n No se encontró ningún producto con código " + codigo + ".");
        }
    }

    private static void editarProducto() {
        if (listaproductos.isEmpty()) {
            System.out.println("\n No hay productos para editar.");
            return;
        }

        System.out.println("\n--- Editar Producto ---");
        System.out.print("Ingrese el código del producto a editar: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        boolean encontrado = false;
        for (int i = 0; i < listaproductos.size(); i++) {
            if (listaproductos.get(i).getCodigo() == codigo) {
                ProductoTia producto = listaproductos.get(i);

                System.out.println("\n--- Datos Actuales ---");
                System.out.println("Nombre: " + producto.getNombre());
                System.out.println("Precio: " + producto.getPrecio());
                System.out.println("Cantidad: " + producto.getCantidadP());

                System.out.println("\n--- Ingrese los Nuevos Datos ---");

                System.out.print("Nuevo nombre: ");
                String nuevoNombre = scanner.nextLine();

                System.out.print("Nuevo precio: ");
                double nuevoPrecio = scanner.nextDouble();
                scanner.nextLine();

                System.out.print("Nueva cantidad: ");
                int nuevaCantidad = scanner.nextInt();
                scanner.nextLine();

                producto.setNombre(nuevoNombre);
                producto.setPrecio(nuevoPrecio);
                producto.setCantidadP(nuevaCantidad);

                encontrado = true;
                System.out.println("\n Producto actualizado con éxito.");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("\n No se encontró ningún producto con código " + codigo + ".");
        }
    }
}

