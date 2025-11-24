package udla.mcastillo.ejercicio4.objetos;

public class CtaAhorro extends Cuenta{
    /** Atributos de CtaAhorro*/
    private double tasaInteres;

    /** Constructores & Destructores */
    public CtaAhorro(int numeroCuenta, double saldo, Inversion tipoInversion, double tasaInteres) {
        super(numeroCuenta, saldo, tipoInversion);
        this.tasaInteres = tasaInteres;
    }

    public CtaAhorro(int numeroCuenta, double saldo, Inversion tipoInversion) {
        super(numeroCuenta, saldo, tipoInversion);
    }

    public CtaAhorro() {
    }

    /** Setters & Getters*/
    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    /** Métodos del Programador */
    public double calcularInteres(){
        double interes = getSaldo() * tasaInteres / 100;
        setSaldo(getSaldo() + interes);
        return interes;
    }

    public void consultarInteres(){
        super.consultarDatos();
        System.out.println("Tasa de Interés: " + getTasaInteres() + "%");
    }
}
