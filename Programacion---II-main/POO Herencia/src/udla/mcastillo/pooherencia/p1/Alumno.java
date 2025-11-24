package udla.mcastillo.pooherencia.p1;

public class Alumno extends Persona { // extends indica herencia
    /** Atributo de Alumno */
    // En java *no* hay herencia multiple
    private String materia;
    private double notap1;
    private double notap2;
    private double notap3;

    /** Constructores & Destructores */
    public Alumno(String nombre, String apellido, int edad, Genero genero, String materia, double notap1, double notap2, double notap3) {
        super(nombre, apellido, edad, genero);
        this.materia = materia;
        this.notap1 = notap1;
        this.notap2 = notap2;
        this.notap3 = notap3;
    }

    public Alumno(String nombre, String apellido, int edad, Genero genero) {
        super(nombre, apellido, edad, genero);
    }

    public Alumno() {
        // Constructor vacio puede recibir valores de la clase heredada, y no de la clase hija
        // en este constructor, puede recibir tanto valores de la clase padre como de la clase hija
    }

    /** Setters and Getters*/
    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public double getNotap1() {
        return notap1;
    }

    public void setNotap1(double notap1) {
        this.notap1 = notap1;
    }

    public double getNotap2() {
        return notap2;
    }

    public void setNotap2(double notap2) {
        this.notap2 = notap2;
    }

    public double getNotap3() {
        return notap3;
    }

    public void setNotap3(double notap3) {
        this.notap3 = notap3;
    }

    /** Metodos del programador */
}
