package udla.mcastillo.ejercicio4.objetos;

public class CtaCorriente  extends Cuenta{
    /** Atributos de CtaCorriente*/
    private double lineaCredito;

    /** Constructores & Destructores */
    public CtaCorriente(int numeroCuenta, double saldo, Inversion tipoInversion, double lineaCredito) {
        super(numeroCuenta, saldo, tipoInversion);
        this.lineaCredito = lineaCredito;
    }

    public CtaCorriente(int numeroCuenta, double saldo, Inversion tipoInversion) {
        super(numeroCuenta, saldo, tipoInversion);
    }

    public CtaCorriente() {
    }

    /** Setters & Getters*/
    public double getLineaCredito() {
        return lineaCredito;
    }

    public void setLineaCredito(double lineaCredito) {
        this.lineaCredito = lineaCredito;
    }

    /** Métodos del Programador */
    public void consultarLineaCredito(){
        super.consultarDatos();
        System.out.println("Línea de Crédito: " + getLineaCredito());
    }

   public double depositarCorriente(double monto){
        double cobro4x1000 = monto * 0.004;
        monto = monto - cobro4x1000;
        setSaldo(getSaldo() + monto);
        return getSaldo();
    }

    public double retirarCorriente(double monto){
        double cobro4x1000 = monto * 0.004;
        monto = monto + cobro4x1000;

        if(monto <= getSaldo()){
            setSaldo(getSaldo()-monto);
            System.out.println("Retiro exitoso. Se cobró un 0.4% por el retiro: " + cobro4x1000);
            return getSaldo();
        } else if ((monto - getSaldo()) <= 300000) {
            // Se usa la linea de credito
            double sobregiro = monto - getSaldo();
            setLineaCredito(getLineaCredito()-sobregiro);
            setSaldo(0);
            System.out.println("Retiro exitoso usando línea de crédito. Se cobró un 0.4% por el retiro: " + cobro4x1000);
            return getSaldo();
        }else{
            System.out.println("Fondos insuficientes, incluso con línea de crédito.");
            return getSaldo();
        }
    }
}
