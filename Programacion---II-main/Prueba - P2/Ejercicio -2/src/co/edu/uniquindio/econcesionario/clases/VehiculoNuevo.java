package co.edu.uniquindio.econcesionario.clases;

public class VehiculoNuevo extends Vehiculo{
    /**Declaracion de atributos de la clase vehiculo nuevo*/
    private int granatia;
    private boolean incluyeSeguro;

    /** Constructores & Destructores*/
    public VehiculoNuevo(String placa, String marca, int modelo, double precio, int granatia, boolean incluyeSeguro) {
        super(placa, marca, modelo, precio);
        this.granatia = granatia;
        this.incluyeSeguro = incluyeSeguro;
    }

    public VehiculoNuevo(String placa, String marca, int modelo, double precio) {
        super(placa, marca, modelo, precio);
    }

    public VehiculoNuevo() {
    }

    /** Setters & Getters*/
    public int getGranatia() {
        return granatia;
    }

    public void setGranatia(int granatia) {
        this.granatia = granatia;
    }

    public boolean isIncluyeSeguro() {
        return incluyeSeguro;
    }

    public void setIncluyeSeguro(boolean incluyeSeguro) {
        this.incluyeSeguro = incluyeSeguro;
    }

    /** Metodo del Programador*/

    // Calcular impuesto para vehiculo nuevo
    //Nuevo: precio * 0.10 (si incluyeSeguro: -50000)
    public double calcularImpuesto(){
        double impuesto = getPrecio() * 0.10;
        if(this.incluyeSeguro == true){
            impuesto -= 50000;
        }
        return impuesto;
    }
}
