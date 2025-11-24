package co.edu.uniquindio.biblioteca.main;

import co.edu.uniquindio.biblioteca.clases.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static co.edu.uniquindio.biblioteca.clases.Grado.DOCTORADO;

/**
 * Texto -> Codigo + UML
 * Se necesita un sistema para gestionar los recursos de una biblioteca universitaria.
 * El sistema debe manejar diferentes tipos de materiales: Libros, Revistas y Tesis.
 * Todos los materiales tienen en común: código, título, añoPublicacion y estado (DISPONIBLE, PRESTADO, RESERVADO).
 *
 * Los Libros tienen adicionalmente: autor, ISBN, número de páginas.
 * Las Revistas tienen: volumen, número, ISSN.
 * Las Tesis tienen: autor, universidad, grado (MAESTRIA, DOCTORADO).
 *
 * El sistema debe:
 *
 *     Permitir agregar materiales a la biblioteca
 *
 *     Prestar materiales (solo si están DISPONIBLE)
 *
 *     Devolver materiales
 *
 *     Buscar materiales por id
 *
 *     Listar todos los materiales de un tipo específico
 *
 *     Calcular la multa por retraso (días * 5 dolares)
 *
 * Requisitos técnicos:
 *
 *     Usar herencia y enumeraciones
 *
 *     Usar ArrayList para almacenar materiales
 *
 *     Paquete: co.edu.uniquindio.biblioteca
 * */
public class biblioteca {
    /** Declaración de Objetos*/
     private static Scanner sc = new Scanner(System.in);
     private static List<Libro> listaLibros = new ArrayList<>();
     private static List<Revista> listaRevistas = new ArrayList<>();
     private static List<Tesis> listaTesis = new ArrayList<>();

    public static void main(String[] args) {
        int opci;
        do {
            menu();
            opci = sc.nextInt();
            switch (opci){
                case 1:
                    int tipo;
                    System.out.println("Seleccione el tipo de material a agregar:");
                    System.out.println("1. Libro");
                    System.out.println("2. Revista");
                    System.out.println("3. Tesis");
                    tipo = sc.nextInt();
                    sc.nextLine(); // Consumir salto de línea
                    switch (tipo){
                        case 1:
                            crearLibro();
                            break;

                        case 2:
                            crearRevista();
                            break;

                        case 3:
                            crearTesis();
                            break;

                        default:
                            System.out.println("Opción inválida.");
                    }
                    break;

                case 2:
                    prestarMaterial();
                    listarPrestados();
                    break;

                case 3:
                    devolverMaterial();
                    listarDisponibles();
                    break;

                case 4:
                    buscarMaterialPorId();
                    break;

                case 5:
                    System.out.println("Seleccione el tipo de material a listar:");
                    System.out.println("1. Libro");
                    System.out.println("2. Revista");
                    System.out.println("3. Tesis");
                    tipo = sc.nextInt();
                    sc.nextLine(); // Consumir salto de línea
                    switch (tipo){
                        case 1:
                            for (Libro libro : listaLibros) { // va de libro en libro dentro de la lista de libros
                                libro.imprimirInfo();
                                System.out.println("-----------------------");

                            }
                            break;

                        case 2:
                            for (Revista revista : listaRevistas) { // va de revista en revista dentro de la lista de revistas
                                revista.imprimirInfo();
                                System.out.println("-----------------------");
                            }
                            break;

                        case 3:
                            for (Tesis tesis : listaTesis) { // va de tesis en tesis dentro de la lista de tesis
                                tesis.imprimirInfo();
                                System.out.println("-----------------------");
                            }
                            break;

                        default:
                            System.out.println("Opción inválida.");
                    }
                    break;

                case 6:
                    calcularMultaPorRetraso();
                    break;

                case 7:
                    break;

                default:
                    break;
            }
        }while (opci != 7);


    }

    /** Declaracion de métodos*/
    private static void menu(){
        System.out.println("-----Menu Biblioteca-----");
        System.out.println("1. Agregar Material");
        System.out.println("2. Prestar Material");
        System.out.println("3. Devolver Material");
        System.out.println("4. Buscar Material por id");
        System.out.println("5. Listar Materiales por Tipo");
        System.out.println("6. Calcular Multa por Retraso");
        System.out.println("7. Salir");
        System.out.print("Seleccione una opción: ");
    }

    // Crear Libro
    private static void crearLibro(){
        System.out.println("-----Agregar Nuevo Libro-----");
        System.out.print("Ingrese el título del libro: ");
        String titulo = sc.nextLine();
        System.out.print("Ingrese el año de publicación: ");
        int anoPublicacion = sc.nextInt();
        sc.nextLine(); // Consumir salto de línea
        System.out.print("Ingrese el autor del libro: ");
        String autor = sc.nextLine();
        System.out.print("Ingrese el ISBN del libro: ");
        int ISBNN = sc.nextInt();
        System.out.print("Ingrese el número de páginas: ");
        int pags = sc.nextInt();
        sc.nextLine(); // Consumir salto de línea

        Estado estado = Estado.DISPONIBLE; // Por defecto al crear un libro

        Libro nuevoLibro = new Libro(titulo, anoPublicacion, estado, autor, ISBNN, pags);
        listaLibros.add(nuevoLibro);
        System.out.println("Libro agregado exitosamente con código: " + nuevoLibro.getCodigo());
    }

    // Crear Revista
    private static void crearRevista(){
        System.out.println("-----Agregar Nueva Revista-----");
        System.out.print("Ingrese el título de la revista: ");
        String titulo = sc.nextLine();
        System.out.print("Ingrese el año de publicación: ");
        int anoPublicacion = sc.nextInt();
        System.out.print("Ingrese el volumen de la revista: ");
        int volumen = sc.nextInt();
        System.out.print("Ingrese el ISSN de la revista: ");
        int ISNN = sc.nextInt();
        System.out.print("Ingrese el número de páginas: ");
        int pags = sc.nextInt();
        sc.nextLine(); // Consumir salto de línea

        Estado estado = Estado.DISPONIBLE; // Por defecto al crear una revista

        Revista nuevaRevista = new Revista(titulo, anoPublicacion, estado, volumen, ISNN, pags);
        listaRevistas.add(nuevaRevista);
        System.out.println("Revista agregada exitosamente con código: " + nuevaRevista.getCodigo());
    }

    // Crear Tesis
    private static void crearTesis(){
        System.out.println("-----Agregar Nueva Tesis-----");
        System.out.print("Ingrese el título de la tesis: ");
        String titulo = sc.nextLine();
        System.out.print("Ingrese el año de publicación: ");
        int anoPublicacion = sc.nextInt();
        sc.nextLine(); // Consumir salto de línea
        System.out.print("Ingrese el autor de la tesis: ");
        String autor = sc.nextLine();
        System.out.print("Ingrese la universidad: ");
        String universidad = sc.nextLine();
        System.out.print("Ingrese el grado (MAESTRIA (1) /DOCTORADO (2)): ");
        int opc = sc.nextInt();
        Grado grado;
        switch (opc) {
            case 1:
                grado =Grado.MAESTRIA;
                break;
            case 2:
                grado = Grado.DOCTORADO;
                break;
            default:
                System.out.println("Opción inválida. Se asignará MAESTRIA por defecto.");
                grado = Grado.MAESTRIA;
        }

        Estado estado = Estado.DISPONIBLE; // Por defecto al crear una tesis

        Tesis nuevaTesis = new Tesis(titulo, anoPublicacion, estado, autor, universidad, grado);
        listaTesis.add(nuevaTesis);
        System.out.println("Tesis agregada exitosamente con código: " + nuevaTesis.getCodigo());
    }

    // Prestar Material
    private static void prestarMaterial(){
        System.out.print("Ingrese el código del material a prestar: ");
        int codigo = sc.nextInt();
        // Buscar en libros
        for (Libro libro : listaLibros) {
            if (libro.getCodigo() == codigo) {
                if (libro.getEstado() == Estado.DISPONIBLE) {
                    libro.setEstado(Estado.PRESTADO);
                    System.out.println("Libro prestado exitosamente.");
                } else {
                    System.out.println("El libro no está disponible para préstamo.");
                }
                return;
            }
        }
        // Buscar en revistas
        for (Revista revista : listaRevistas) {
            if (revista.getCodigo() == codigo) {
                if (revista.getEstado() == Estado.DISPONIBLE) {
                    revista.setEstado(Estado.PRESTADO);
                    System.out.println("Revista prestada exitosamente.");
                } else {
                    System.out.println("La revista no está disponible para préstamo.");
                }
                return;
            }
        }
        // Buscar en tesis
        for (Tesis tesis : listaTesis) {
            if (tesis.getCodigo() == codigo) {
                if (tesis.getEstado() == Estado.DISPONIBLE) {
                    tesis.setEstado(Estado.PRESTADO);
                    System.out.println("Tesis prestada exitosamente.");
                } else {
                    System.out.println("La tesis no está disponible para préstamo.");
                }
                return;
            }
        }
        System.out.println("Material con código " + codigo + " no encontrado.");
    }

    // Devolver Material
    private static void devolverMaterial(){
        System.out.print("Ingrese el código del material a devolver: ");
        int codigo = sc.nextInt();
        // Buscar en libros
        for (Libro libro : listaLibros) {
            if (libro.getCodigo() == codigo) {
                libro.setEstado(Estado.DISPONIBLE);
                System.out.println("Libro devuelto exitosamente.");
                return;
            }
        }
        // Buscar en revistas
        for (Revista revista : listaRevistas) {
            if (revista.getCodigo() == codigo) {
                revista.setEstado(Estado.DISPONIBLE);
                System.out.println("Revista devuelta exitosamente.");
                return;
            }
        }
        // Buscar en tesis
        for (Tesis tesis : listaTesis) {
            if (tesis.getCodigo() == codigo) {
                tesis.setEstado(Estado.DISPONIBLE);
                System.out.println("Tesis devuelta exitosamente.");
                return;
            }
        }
        System.out.println("Material con código " + codigo + " no encontrado.");
    }

    // Listar Prestados
    private static void listarPrestados(){
        System.out.println("-----Materiales Prestados-----");
        System.out.println("Libros Prestados:");
        for (Libro libro : listaLibros) {
            if (libro.getEstado() == Estado.PRESTADO) {
                libro.imprimirInfo();
                System.out.println("-----------------------");
            }
        }
        System.out.println("Revistas Prestadas:");
        for (Revista revista : listaRevistas) {
            if (revista.getEstado() == Estado.PRESTADO) {
                revista.imprimirInfo();
                System.out.println("-----------------------");
            }
        }
        System.out.println("Tesis Prestadas:");
        for (Tesis tesis : listaTesis) {
            if (tesis.getEstado() == Estado.PRESTADO) {
                tesis.imprimirInfo();
                System.out.println("-----------------------");
            }
        }
    }

    // Listar Disponibles
    private static void listarDisponibles(){
        System.out.println("-----Materiales Disponibles-----");
        System.out.println("Libros Disponibles:");
        for (Libro libro : listaLibros) {
            if (libro.getEstado() == Estado.DISPONIBLE) {
                libro.imprimirInfo();
                System.out.println("-----------------------");
            }
        }
        System.out.println("Revistas Disponibles:");
        for (Revista revista : listaRevistas) {
            if (revista.getEstado() == Estado.DISPONIBLE) {
                revista.imprimirInfo();
                System.out.println("-----------------------");
            }
        }
        System.out.println("Tesis Disponibles:");
        for (Tesis tesis : listaTesis) {
            if (tesis.getEstado() == Estado.DISPONIBLE) {
                tesis.imprimirInfo();
                System.out.println("-----------------------");
            }
        }
    }

    // Buscar Material por ID
    private static void buscarMaterialPorId(){
        System.out.print("Ingrese el código del material a buscar: ");
        int codigo = sc.nextInt();
        // Buscar en libros
        for (Libro libro : listaLibros) {
            if (libro.getCodigo() == codigo) {
                libro.imprimirInfo();
                return;
            }
        }
        // Buscar en revistas
        for (Revista revista : listaRevistas) {
            if (revista.getCodigo() == codigo) {
                revista.imprimirInfo();
                return;
            }
        }
        // Buscar en tesis
        for (Tesis tesis : listaTesis) {
            if (tesis.getCodigo() == codigo) {
                tesis.imprimirInfo();
                return;
            }
        }
        System.out.println("Material con código " + codigo + " no encontrado.");
    }

    // Calcular materiales por retraso
    private static void calcularMultaPorRetraso(){
        System.out.print("Ingrese el número de días de retraso: ");
        int dias = sc.nextInt();
        int multa = dias * 5;
        System.out.println("La multa por " + dias + " días de retraso es: $" + multa);
    }

}