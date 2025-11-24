import javax.swing.*;

public class Libro {
    /** Declaración de Atributos */
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private int numeroPaginas;

    /** Declaración de Constructores & Destructores*/
    public Libro() {
    }

    public Libro(String titulo, String autor, int anioPublicacion, int numeroPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.numeroPaginas = numeroPaginas;
    }

    /** Métodos propios de Java (Getters & Setters)*/
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    /** Métodos propios del Programador */
    public void leerDatos (){
        String titulo = JOptionPane.showInputDialog("Ingrese el título del libro:");
        setTitulo(titulo);
        String autor = JOptionPane.showInputDialog("Ingrese el autor del libro:");
        setAutor(autor);

        do {
            int anioPublicacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de publicación del libro:"));
            if (anioPublicacion < -3500 || anioPublicacion > 2025) {
                JOptionPane.showMessageDialog(null, "Año de publicación inválido. Por favor, ingrese un año entre -3500 y 2025.");
            } else {
                setAnioPublicacion(anioPublicacion);
            }
        }while (getAnioPublicacion() < -3500 || getAnioPublicacion() > 2025);

        do {
            int numpaginas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de páginas del libro:"));
            if (numpaginas <= 0) {
                JOptionPane.showMessageDialog(null, "Número de páginas inválido. Por favor, ingrese un número mayor a 0.");
            } else {
                setNumeroPaginas(numpaginas);
            }
        }while(getNumeroPaginas() <= 0);
    }

    // Metodo con boolean para saber si el libro es largo
    public boolean esLibroLargo() {
        return getNumeroPaginas() > 300;
    }

    // Metodo con String para mostrar si el libro es largo o no
    public String eslargoS() {
        String mensaje;
        if (getNumeroPaginas() > 300) {
            mensaje = "El libro \"" + getTitulo() + "\" es un libro largo.";
        } else {
            mensaje = "El libro \"" + getTitulo() + "\" no es un libro largo.";
        }
        return mensaje;
    }

    public void mostrarDatos() {
        JOptionPane.showMessageDialog(null,
                "Título: " + getTitulo() +
                "\nAutor: " + getAutor() +
                "\nAño de Publicación: " + getAnioPublicacion() +
                "\nNúmero de Páginas: " + getNumeroPaginas() +
                "\n" + esLibroLargo() +
                "\n" + eslargoS()
        );
    }
}
