package edu.udla.hospital.clases;

public class Paciente {
    /** Declaracion de Atributos*/
    private String nombre;
    private String apellido;
    private int idPaciente;
    private static int contId = 1;

    /** Constructores & Destructores*/
    public Paciente() {
    }

    public Paciente(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.idPaciente = contId++;
    }

    /** Getters & Setters*/
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public static int getContId() {
        return contId;
    }

    public static void setContId(int contId) {
        Paciente.contId = contId;
    }

    /** Metodos del Programador*/
    // Info del Paciente
    public void mostrarInfo() {
        System.out.println("ID Paciente: " + this.idPaciente);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Apellido: " + this.apellido);
    }
}
