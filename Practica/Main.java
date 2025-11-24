package src;

import java.util.ArrayList;
import java.util.Scanner;

// Clase Principal
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Biblioteca biblioteca = null;
    static ArrayList<Bibliotecario> bibliotecarios = new ArrayList<>();
    
    public static void main(String[] args) {
        int opcion;
        
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            switch (opcion) {
                case 1:
                    crearBiblioteca();
                    break;
                case 2:
                    agregarLibro();
                    break;
                case 3:
                    agregarRevista();
                    break;
                case 4:
                    agregarBibliotecario();
                    break;
                case 5:
                    mostrarInformacionCompleta();
                    break;
                case 6:
                    mostrarSoloLibros();
                    break;
                case 7:
                    mostrarSoloRevistas();
                    break;
                case 8:
                    System.out.println("\n¡Gracias por usar el sistema!");
                    break;
                default:
                    System.out.println("\nOpción inválida. Intente de nuevo.");
            }
        } while (opcion != 8);
        
        scanner.close();
    }
    
    static void mostrarMenu() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║    SISTEMA DE GESTIÓN BIBLIOTECA      ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("1. Crear Biblioteca");
        System.out.println("2. Agregar Libro");
        System.out.println("3. Agregar Revista");
        System.out.println("4. Agregar Bibliotecario");
        System.out.println("5. Mostrar Información Completa");
        System.out.println("6. Mostrar Solo Libros");
        System.out.println("7. Mostrar Solo Revistas");
        System.out.println("8. Salir");
        System.out.print("\nSeleccione una opción: ");
    }
    
    static void crearBiblioteca() {
        System.out.println("\n--- CREAR BIBLIOTECA ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Capacidad: ");
        int capacidad = scanner.nextInt();
        scanner.nextLine();
        
        biblioteca = new Biblioteca(nombre, direccion, telefono, capacidad);
        System.out.println("✓ Biblioteca creada exitosamente!");
    }
    
    static void agregarLibro() {
        if (biblioteca == null) {
            System.out.println("\n⚠ Primero debe crear una biblioteca (opción 1)");
            return;
        }
        
        System.out.println("\n--- AGREGAR LIBRO ---");
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();
        System.out.print("¿Está disponible? (true/false): ");
        boolean disponible = scanner.nextBoolean();
        System.out.print("Número de páginas: ");
        int paginas = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Editorial: ");
        String editorial = scanner.nextLine();
        
        Libro libro = new Libro(titulo, autor, isbn, precio, disponible, paginas, editorial);
        biblioteca.agregarRecurso(libro);
        System.out.println("✓ Libro agregado exitosamente!");
    }
    
    static void agregarRevista() {
        if (biblioteca == null) {
            System.out.println("\n⚠ Primero debe crear una biblioteca (opción 1)");
            return;
        }
        
        System.out.println("\n--- AGREGAR REVISTA ---");
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();
        System.out.print("¿Está disponible? (true/false): ");
        boolean disponible = scanner.nextBoolean();
        System.out.print("Número de edición: ");
        int edicion = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Mes de publicación: ");
        String mes = scanner.nextLine();
        
        Revista revista = new Revista(titulo, autor, isbn, precio, disponible, edicion, mes);
        biblioteca.agregarRecurso(revista);
        System.out.println("✓ Revista agregada exitosamente!");
    }
    
    static void agregarBibliotecario() {
        if (biblioteca == null) {
            System.out.println("\n⚠ Primero debe crear una biblioteca (opción 1)");
            return;
        }
        
        System.out.println("\n--- AGREGAR BIBLIOTECARIO ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Turno: ");
        String turno = scanner.nextLine();
        System.out.print("Salario: ");
        double salario = scanner.nextDouble();
        scanner.nextLine();
        
        Bibliotecario bibliotecario = new Bibliotecario(nombre, id, turno, salario);
        bibliotecario.asignarBiblioteca(biblioteca);
        bibliotecarios.add(bibliotecario);
        System.out.println("✓ Bibliotecario agregado exitosamente!");
    }
    
    static void mostrarInformacionCompleta() {
        if (biblioteca == null) {
            System.out.println("\n⚠ No hay información para mostrar");
            return;
        }
        
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║      INFORMACIÓN COMPLETA              ║");
        System.out.println("╚════════════════════════════════════════╝");
        
        System.out.println("\n--- BIBLIOTECA ---");
        System.out.println(biblioteca);
        
        if (!bibliotecarios.isEmpty()) {
            System.out.println("\n--- BIBLIOTECARIOS ---");
            for (Bibliotecario b : bibliotecarios) {
                System.out.println(b);
            }
        }
        
        if (!biblioteca.getRecursos().isEmpty()) {
            System.out.println("\n--- TODOS LOS RECURSOS ---");
            for (Recurso r : biblioteca.getRecursos()) {
                System.out.println(r);
            }
        } else {
            System.out.println("\n⚠ No hay recursos agregados");
        }
    }
    
    static void mostrarSoloLibros() {
        if (biblioteca == null || biblioteca.getRecursos().isEmpty()) {
            System.out.println("\n⚠ No hay libros para mostrar");
            return;
        }
        
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║           SOLO LIBROS                  ║");
        System.out.println("╚════════════════════════════════════════╝");
        
        boolean hayLibros = false;
        for (Recurso r : biblioteca.getRecursos()) {
            if (r instanceof Libro) {
                System.out.println(r);
                hayLibros = true;
            }
        }
        
        if (!hayLibros) {
            System.out.println("⚠ No hay libros agregados");
        }
    }
    
    static void mostrarSoloRevistas() {
        if (biblioteca == null || biblioteca.getRecursos().isEmpty()) {
            System.out.println("\n⚠ No hay revistas para mostrar");
            return;
        }
        
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║          SOLO REVISTAS                 ║");
        System.out.println("╚════════════════════════════════════════╝");
        
        boolean hayRevistas = false;
        for (Recurso r : biblioteca.getRecursos()) {
            if (r instanceof Revista) {
                System.out.println(r);
                hayRevistas = true;
            }
        }
        
        if (!hayRevistas) {
            System.out.println("⚠ No hay revistas agregadas");
        }
    }
}
