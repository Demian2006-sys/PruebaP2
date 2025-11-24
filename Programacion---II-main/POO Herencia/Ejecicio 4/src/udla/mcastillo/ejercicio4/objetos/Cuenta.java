package udla.mcastillo.ejercicio4.objetos;

public class Cuenta {
    /** Atributos de la Clase */
    private int numeroCuenta;
    private double saldo;
    private Inversion tipoInversion;

    /** Constructores & Destructores */
    public Cuenta(int numeroCuenta, double saldo, Inversion tipoInversion) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.tipoInversion = tipoInversion;
    }

    public Cuenta() {
    }

    /** Setters & Getters*/
    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Inversion getTipoInversion() {
        return tipoInversion;
    }

    public void setTipoInversion(Inversion tipoInversion) {
        this.tipoInversion = tipoInversion;
    }

    /** Métodos del Programador */
    public void consultarDatos(){
        System.out.println("Número de Cuenta: " + getNumeroCuenta());
        System.out.println("Saldo: " + getSaldo());
        System.out.println("Tipo de Inversión: " + getTipoInversion());
    }

    public double depositar(double monto){
        setSaldo(getSaldo() + monto);
        return getSaldo();
    }

    public double retirar(double monto){
        if(monto > getSaldo()){
            System.out.println("Fondos insuficientes");
            return getSaldo();
        } else {
            setSaldo(getSaldo() - monto);
            return getSaldo();
        }
    }


}
