package udla.mcastillo.ejercicio4.objetos;

public class Cliente {
    /** Atributos de Cliente*/
    private String nombre;
    private Cuenta cuenta;
    // Es una composicion porque un cliente "tiene una" cuenta bancaria
    // ademas puede tener varias cuentas bancarias

    // No se necesita crear un enum para esto, solo se debe llamar a la clase Cuenta
    // con Cuenta como tipo de dato, asegura que cada cliente tenga una cuenta bancaria.

    /** Constructores & Destructores */
    public Cliente(String nombre, Cuenta cuenta) {
        this.nombre = nombre;
        this.cuenta = cuenta;
    }

    public Cliente() {
    }

    /** Setters & Getters*/
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    /** Métodos del Programador */
}
