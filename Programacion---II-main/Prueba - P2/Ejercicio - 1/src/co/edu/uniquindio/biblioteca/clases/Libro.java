package co.edu.uniquindio.biblioteca.clases;

public class Libro  extends material {
    /**
     * Atributos de la clase material
     */
    private String autor;
    private int ISBNN;
    private int pags;

    /**
     * Constructores & Destructores
     */
    public Libro(String titulo, int anoPublicacion, Estado estado, String autor, int ISBNN, int pags) {
        super(titulo, anoPublicacion, estado);
        this.autor = autor;
        this.ISBNN = ISBNN;
        this.pags = pags;
    }

    public Libro(String titulo, int anoPublicacion, Estado estado) {
        super(titulo, anoPublicacion, estado);
    }

    public Libro() {
    }

    /**Setters & Getters*/
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getISBNN() {
        return ISBNN;
    }

    public void setISBNN(int ISBNN) {
        this.ISBNN = ISBNN;
    }

    public int getPags() {
        return pags;
    }

    public void setPags(int pags) {
        this.pags = pags;
    }

    /** Metodos del programador*/

    // Método para imprimir la información del libro
    public void imprimirInfo(){
        super.imprimirInfo();
        System.out.println("Autor: " + this.autor);
        System.out.println("ISBN: " + this.ISBNN);
        System.out.println("Número de Páginas: " + this.pags);
    }

}
