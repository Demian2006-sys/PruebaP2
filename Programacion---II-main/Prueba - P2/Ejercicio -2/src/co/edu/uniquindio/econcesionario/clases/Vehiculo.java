package co.edu.uniquindio.econcesionario.clases;

public class Vehiculo {
    /** Declaracion de Atributos */
    private String placa;
    private String marca;
    private int modelo;
    private double precio;

    /** Constructores & Destrcutores*/
    public Vehiculo(String placa, String marca, int modelo, double precio) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    public Vehiculo() {
    }

    /** Setters & Getters*/
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /** Metodos del programador*/

}
