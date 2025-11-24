package edu.udla.hospital.clases;

public class Enfermero extends PersonalMedico{
    /** Declaracion de Atributos*/
    private Turno turno;
    private String areaAsig;

    /** Constructores & Destructores*/
    public Enfermero() {
    }

    public Enfermero(String nombre, String apellido) {
        super(nombre, apellido);
    }

    public Enfermero(String nombre, String apellido, Turno turno, String areaAsig) {
        super(nombre, apellido);
        this.turno = turno;
        this.areaAsig = areaAsig;
    }

    /** Getters & Setters*/
    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public String getAreaAsig() {
        return areaAsig;
    }

    public void setAreaAsig(String areaAsig) {
        this.areaAsig = areaAsig;
    }

    /** Metodos del Programador*/

}
