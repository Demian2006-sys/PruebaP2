package edu.udla.hospital.clases;

public class Medico extends PersonalMedico {
    /** Declaracion de Atributos*/
    private String especialidad;
    private int añosExperiencia;
    private String licenciaMedica;

    /** Constructores & Destructores*/
    public Medico() {
    }

    public Medico(String nombre, String apellido) {
        super(nombre, apellido);
    }

    public Medico(String nombre, String apellido, String especialidad, int añosExperiencia, String licenciaMedica) {
        super(nombre, apellido);
        this.especialidad = especialidad;
        this.añosExperiencia = añosExperiencia;
        this.licenciaMedica = licenciaMedica;
    }

    /** Getters & Setters*/
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getAñosExperiencia() {
        return añosExperiencia;
    }

    public void setAñosExperiencia(int añosExperiencia) {
        this.añosExperiencia = añosExperiencia;
    }

    public String getLicenciaMedica() {
        return licenciaMedica;
    }

    public void setLicenciaMedica(String licenciaMedica) {
        this.licenciaMedica = licenciaMedica;
    }

    /** Metodos del Programador*/

    // Info del Medico
    public void mostrarInfoMedico() {
        System.out.println("ID Medico: " + this.getIdPersonal());
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Apellido: " + this.getApellido());
        System.out.println("Especialidad: " + this.especialidad);
        System.out.println("Años de Experiencia: " + this.añosExperiencia);
        System.out.println("Licencia Medica: " + this.licenciaMedica);
    }


}
