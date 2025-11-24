package co.edu.uniquindio.biblioteca.clases;

public class Tesis extends material{
    /**Declaracion de atributos de la clase Tesis*/
    private String autor;
    private String universidad;
    private Grado estado1;

    /**Constructores & Destructores*/
    public Tesis(String titulo, int anoPublicacion, Estado estado, String autor, String universidad, Grado estado1) {
        super(titulo, anoPublicacion, estado);
        this.autor = autor;
        this.universidad = universidad;
        this.estado1 = estado1;
    }

    public Tesis(String titulo, int anoPublicacion, Estado estado) {
        super(titulo, anoPublicacion, estado);
    }

    public Tesis() {
    }

    /**Setters & Getters*/
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public Grado getEstado1() {
        return estado1;
    }

    public void setEstado1(Grado estado1) {
        this.estado1 = estado1;
    }

    /** Metodos del Programador */

    // Método para imprimir la información de la tesis
    public void imprimirInfo(){
        super.imprimirInfo();
        System.out.println("Autor: " + this.autor);
        System.out.println("Universidad: " + this.universidad);
        System.out.println("Grado: " + this.estado1);
    }
}
