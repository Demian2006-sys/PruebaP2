import javax.swing.*;

public class Estudiante {
    /** Declaración de Atributos */
    private String nombreCompleto;
    private String numeroMatricula;
    private String carrera;
    private double promedioAcumulado;

    /** Declaración de Constructores & Destructores*/
    public Estudiante() {
    }

    public Estudiante(String nombreCompleto, String numeroMatricula, String carrera, double promedioAcumulado) {
        this.nombreCompleto = nombreCompleto;
        this.numeroMatricula = numeroMatricula;
        this.carrera = carrera;
        this.promedioAcumulado = promedioAcumulado;
    }

    /** Métodos propios de Java (Getters & Setters)*/
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public double getPromedioAcumulado() {
        return promedioAcumulado;
    }

    public void setPromedioAcumulado(double promedioAcumulado) {
        this.promedioAcumulado = promedioAcumulado;
    }

    /** Métodos propios del Programador */
    public void validarPromedio() {
        if (getPromedioAcumulado() < 0.0 || getPromedioAcumulado() > 10.0) {
            setPromedioAcumulado(0.0);
        }
    }

    public String obtenerEstadoAcademico(double promedioAcumulado){
        validarPromedio();
        if (promedioAcumulado >= 9.0) {
            return "Excelente";
        } else if (promedioAcumulado >= 8.0) {
            return "Sobresaliente";
        } else if (promedioAcumulado >= 7.0) {
            return "Bueno";
        } else if (promedioAcumulado >= 6.0) {
            return "Regular";
        } else {
            return "Reprobado";
        }
    }

    public void mostrarEstadoAcademico(){
        String mensaje = obtenerEstadoAcademico(getPromedioAcumulado());
        JOptionPane.showMessageDialog(null,
                "Nombre: " + getNombreCompleto() + "\n" +
                "Matrícula: " + getNumeroMatricula() + "\n" +
                "Carrera: " + getCarrera() + "\n" +
                "Promedio Acumulado: " + getPromedioAcumulado() + "\n" +
                "Estado Académico: " + mensaje);
    }
}
