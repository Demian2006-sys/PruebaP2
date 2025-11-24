/*
Ejercicio 1: La clase ProductoInventario

Crea una clase llamada ProductoInventario que represente un artículo en el inventario de una tienda.
La clase debe incluir:
- Código del producto (String)
- Nombre del producto (String)
- Cantidad disponible (int)
- Precio unitario (double)

Requisitos:
- Constructor que inicialice todos los atributos.
- Métodos establecer y obtener para cada atributo.
- Método calcularValorTotal() que devuelva el valor total del inventario para ese producto (cantidad × precio).
- Si la cantidad o el precio son negativos, deben establecerse en 0.

Aplicación de prueba:
Crea una clase PruebaProductoInventario que cree dos objetos ProductoInventario, muestre sus datos
y el valor total de inventario para cada uno.
*/

public class Main {
    public static void main(String[] args) {
        /** Declaración de Objetos */
        ProductoInventario producto1 = new ProductoInventario("P001", "Laptop", 10, 750.50);
        ProductoInventario producto2 = new ProductoInventario();

        /** Lectura de Datos */
        producto2.leerDatos();

        /** Presentación de Resultados */
        producto1.mostrarDatos();
        producto2.mostrarDatos();

    }
}