import javax.swing.*;

public class ProductoInventario {
    /** Declaración de Atributos */
    private String codigoProducto;
    private String nombreProducto;
    private int cantidadDisponible;
    private double precioUnitario;

    /** Declaración de Constructores & Destructores*/
    public ProductoInventario() {
    }

    public ProductoInventario(String codigoProducto, String nombreProducto, int cantidadDisponible, double precioUnitario) {
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.cantidadDisponible = cantidadDisponible;
        this.precioUnitario = precioUnitario;
    }

    /** Métodos propios de Java (Getters & Setters)*/
    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    /** Métodos propios del Programador */
    public void leerDatos ()
    {
        String codigo = JOptionPane.showInputDialog("Ingrese el código del producto:");
        setCodigoProducto(codigo);
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto:");
        setNombreProducto(nombre);

        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad disponible:"));
        if (cantidad < 0) {
            JOptionPane.showMessageDialog(null, "Ajustando valor a 0");
            setCantidadDisponible(0);
        }else{
            setCantidadDisponible(cantidad);
        }

        double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio unitario:"));
        if (precio < 0) {
            JOptionPane.showMessageDialog(null, "Ajustando valor a 0");
            setPrecioUnitario(0);
        } else {
            setPrecioUnitario(precio);
        }

    }

    public double calcularValorTotal() {
        return getCantidadDisponible() * getPrecioUnitario();
    }

    public void mostrarDatos(){
        JOptionPane.showMessageDialog(null,
                "Código del Producto: " + getCodigoProducto() + "\n" +
                "Nombre del Producto: " + getNombreProducto() + "\n" +
                "Cantidad Disponible: " + getCantidadDisponible() + "\n" +
                "Precio Unitario: $" + getPrecioUnitario() + "\n" +
                "Valor Total del Inventario: $" + calcularValorTotal()
        );
    }
}

