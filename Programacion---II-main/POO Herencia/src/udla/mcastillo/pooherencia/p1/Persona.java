package udla.mcastillo.pooherencia.p1;

// Si se usa final en la clase, no se puede heredar de ella


public class Persona {
    /** Atributos de Clase */
    private String nombre;
    private String apellido;
    private int edad;
    private Genero genero;

    /** Constantes */
    // No se pueden cambiar los valores de las constantes
    // deben estar en mayusculas, por buenas practicas

    public static final String CORREO = "na@dominio.com.ec";
    // static indica que es una variable de clase, no de instancia, es decir, es compartida por todas las instancias
    // final indica que es una constante

    /** Constructores & Desctructores */
    public Persona(String nombre, String apellido, int edad, Genero genero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
    }

    public Persona() {
    }


    /** Getters & Setters */
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    /** Metodos del programador*/
}
