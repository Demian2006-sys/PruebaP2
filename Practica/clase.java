package src;

// Clase Recurso (padre)
public class Recurso {
    private String titulo;
    private String autor;
    private String isbn;
    private double precio;
    private boolean disponible;

    public Recurso(String titulo, String autor, String isbn, double precio, boolean disponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.precio = precio;
        this.disponible = disponible;
    }

    // Getters y Setters
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    @Override
    public String toString() {
        return "Titulo: " + titulo + ", Autor: " + autor + ", ISBN: " + isbn + 
               ", Precio: $" + precio + ", Disponible: " + (disponible ? "Si" : "No");
    }
}
