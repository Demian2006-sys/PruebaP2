import javax.swing.*;

public class Fecha {
    /**Declaración de atributos*/
    private int mes;
    private int dia;
    private int anio;

    /**Declaración del constructor*/
    public Fecha() {
    }

    public Fecha(int mes, int dia, int anio) {
        this.mes = mes;
        this.dia = dia;
        this.anio = anio;
    }

    /**Declaración de los métodos set y get*/
    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    /**Métodos de programador*/

    public void obtenerfecha() {

        do {
            int dia = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el día"));
            if (dia < 1 || dia > 31){
                JOptionPane.showMessageDialog(null, "Día inválido, ingrese un día entre 1 y 31" );
            } else {
                setDia(dia);
            }
        } while (dia < 1 || dia > 31);

        do {
            int mes = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el mes"));
            if(mes < 1 || mes > 12){
                JOptionPane.showMessageDialog(null, "Mes inválido, ingrese un mes entre 1 y 12" );
            } else {
                setMes(mes);
            }
        }while (mes < 1 || mes > 12);

        do {
            int ani = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el año"));
            if(ani < 0){
                JOptionPane.showMessageDialog(null, "Año inválido, ingrese un año mayor o igual a 0" );
            } else {
                setAnio(ani);
            }
        } while (anio < 0);
    }

    public String mostrarFecha(){
        return getDia() + "/" + getMes() + "/" + getAnio();
    }

}