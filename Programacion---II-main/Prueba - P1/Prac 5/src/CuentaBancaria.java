import javax.swing.*;

public class CuentaBancaria {
    /** Declaración de Atributos */
    private String numeroCuenta;
    private String nombreTitular;
    private double saldoActual;
    private String tipoCuenta; // "Ahorro" o "Corriente"

    /** Declaración de Constructores & Destructores*/
    public CuentaBancaria() {
    }

    public CuentaBancaria(String numeroCuenta, String nombreTitular, double saldoActual, String tipoCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.nombreTitular = nombreTitular;
        this.saldoActual = saldoActual;
        this.tipoCuenta = tipoCuenta;
    }

    /** Métodos propios de Java (Getters & Setters)*/
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public double getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(double saldoActual) {
        this.saldoActual = saldoActual;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    /** Métodos propios del Programador */
    public void leerDatos(){
        String cuenta = JOptionPane.showInputDialog("Introduzca el número de cuenta:");
        setNumeroCuenta(cuenta);

        String titular = JOptionPane.showInputDialog("Introduzca el nombre del titular:");
        setNombreTitular(titular);

        double saldo;
        do {
            saldo = Double.parseDouble(JOptionPane.showInputDialog("Introduzca el saldo actual:"));
            if (saldo < 0) {
                JOptionPane.showMessageDialog(null, "El saldo no puede ser negativo. Inténtelo de nuevo.");
            } else {
                setSaldoActual(saldo);
            }
        } while (saldo < 0);

        String tipo = JOptionPane.showInputDialog("Introduzca el tipo de cuenta (Ahorro/Corriente):");
        setTipoCuenta(tipo);
    }

    public void depositar(double monto){
        if (monto > 0){
            setSaldoActual(getSaldoActual() + monto);
        } else {
            JOptionPane.showMessageDialog(null, "El monto a depositar debe ser positivo.");
        }
    }

    public void retirar(double monto){
        if (monto > 0 && monto <= getSaldoActual()){
            setSaldoActual(getSaldoActual() - monto);
        } else {
            JOptionPane.showMessageDialog(null, "El monto a retirar debe ser positivo y no mayor al saldo actual.");
        }
    }

    public double obtenerSaldo(){
        return getSaldoActual();
    }
}
