package co.edu.uniquindio.biblioteca.clases;

import java.util.PrimitiveIterator;

public class material {
    /** Declaracion de Atributos*/
    private int codigo;
    private String titulo;
    private int anoPublicacion;
    private Estado estado;
    private static int contadorCodigo = 1;

    /** Constrcutores & Destructores*/
    public material(String titulo, int anoPublicacion, Estado estado) {
        this.codigo = contadorCodigo++;
        this.titulo = titulo;
        this.anoPublicacion = anoPublicacion;
        this.estado = estado;
    }

    public material() {
    }

    /** Setters & Getters*/
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoPublicacion() {
        return anoPublicacion;
    }

    public void setAnoPublicacion(int anoPublicacion) {
        this.anoPublicacion = anoPublicacion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /** Métodos del Programador */

    public void imprimirInfo(){
        System.out.println("Código: " + this.codigo);
        System.out.println("Título: " + this.titulo);
        System.out.println("Año de Publicación: " + this.anoPublicacion);
        System.out.println("Estado: " + this.estado);
    }
}
