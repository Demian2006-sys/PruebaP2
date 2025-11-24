/*
Ejercicio 2: La clase Libro

Crea una clase llamada Libro que represente un libro en una biblioteca.
La clase debe incluir:
- Título (String)
- Autor (String)
- Año de publicación (int)
- Número de páginas (int)

Requisitos:
- Constructor que inicialice todos los atributos.
- Métodos establecer y obtener para cada atributo.
- Método esLibroLargo() que devuelva true si el libro tiene más de 300 páginas, y false en caso contrario.

Aplicación de prueba (con ventana emergente):
Crea una clase PruebaLibro que solicite los datos del libro al usuario usando JOptionPane, cree un objeto Libro, y muestre si el libro es largo o no.
*/

public class Main {
    public static void main(String[] args) {
        /** Declaración de Objetos */
        Libro libro1 = new Libro();

        /** Lectura de Datos */
        libro1.leerDatos();

        /** Salida de Datos */
        libro1.mostrarDatos();


    }
}