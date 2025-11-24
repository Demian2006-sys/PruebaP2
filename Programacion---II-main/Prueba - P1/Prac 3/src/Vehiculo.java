import javax.swing.*;

public class Vehiculo {
    /** Declaración de Atributos */
    private String marca;
    private String modelo;
    private int anioFabricacion;
    private double kilometraje;

    /** Declaración de Constructores & Destructores*/
    public Vehiculo() {
    }

    public Vehiculo(String marca, String modelo, int anioFabricacion, double kilometraje) {
        this.marca = marca;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
        this.kilometraje = kilometraje;
    }

    /** Métodos propios de Java (Getters & Setters)*/
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    public double getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(double kilometraje) {
        this.kilometraje = kilometraje;
    }

    /** Métodos propios del Programador */
    public int calcularAntiguedad(int anioActual)
    {
        return anioActual - getAnioFabricacion();
    }

    public boolean mantenimiento(int anioActual)
    {
        if (calcularAntiguedad(anioActual) > 10 || getKilometraje() > 150000)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void mostrarDatos(){
        JOptionPane.showMessageDialog(null,
                "Marca: " + getMarca() + "\n" +
                "Modelo: " + getModelo() + "\n" +
                "Año de Fabricación: " + getAnioFabricacion() + "\n" +
                "Kilometraje Actual: " + getKilometraje() + " km" +
                "\n-----------------------------");
    }
}
