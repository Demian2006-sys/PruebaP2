package udla.mcastillo.pooherencia.p1;

public class Profesor extends Persona {
    /** Atributos de Profesor */
    private Materia materia;

    /** Constructores & Destructores */
    public Profesor(String nombre, String apellido, int edad, Genero genero, Materia materia) {
        super(nombre, apellido, edad, genero);
        this.materia = materia;
    }

    public Profesor(String nombre, String apellido, int edad, Genero genero) {
        super(nombre, apellido, edad, genero);
    }

    public Profesor() {
    }

    /** Setters and Getters*/
    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    /** Metodos del programador */
}
