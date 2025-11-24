package co.edu.uniquindio.biblioteca.clases;

public class Revista extends material {
    /**Declaracion de Atributos de la clase Revista*/
    private int volumen;
    private int ISNN;
    private int pags;

    /**Constructores & Destructores*/
    public Revista(String titulo, int anoPublicacion, Estado estado, int volumen, int ISNN, int pags) {
        super(titulo, anoPublicacion, estado);
        this.volumen = volumen;
        this.ISNN = ISNN;
        this.pags = pags;
    }

    public Revista(String titulo, int anoPublicacion, Estado estado) {
        super(titulo, anoPublicacion, estado);
    }

    public Revista() {
    }

    /**Setters & Getters*/
    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    public int getISNN() {
        return ISNN;
    }

    public void setISNN(int ISNN) {
        this.ISNN = ISNN;
    }

    public int getPags() {
        return pags;
    }

    public void setPags(int pags) {
        this.pags = pags;
    }

    /** Metodos del Programador */

    // Método para imprimir la información de la revista
    public void imprimirInfo() {
        super.imprimirInfo();
        System.out.println("Volumen: " + this.volumen);
        System.out.println("ISNN: " + this.ISNN);
        System.out.println("Número de Páginas: " + this.pags);
    }
}
