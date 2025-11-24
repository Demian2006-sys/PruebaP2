package ec.edu.udla.empresa.clases;

import java.util.ArrayList;

public class EmpleadoRegular extends Empleado{
    /** Atributos de la Clase Empleado Regular*/
    private int nivelExperiencia;
    private java.util.ArrayList<String> habilidades; //Lista de habilidades

    /** Constructores & Destructores*/
    public EmpleadoRegular(String nombre, Departamento departamento, TipoContrato tipoContrato, int nivelExperiencia, ArrayList<String> habilidades) {
        super(nombre, departamento, tipoContrato);
        this.nivelExperiencia = nivelExperiencia;
        this.habilidades = habilidades;
    }

    public EmpleadoRegular(String nombre, Departamento departamento, TipoContrato tipoContrato) {
        super(nombre, departamento, tipoContrato);
    }

    public EmpleadoRegular() {
    }

    /** Setters & Getters*/
    public int getNivelExperiencia() {
        return nivelExperiencia;
    }

    public void setNivelExperiencia(int nivelExperiencia) {
        this.nivelExperiencia = nivelExperiencia;
    }

    public ArrayList<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList<String> habilidades) {
        this.habilidades = habilidades;
    }

    /**Metodos del programador*/

    // Calcular Salario
    //salarioBase + (nivelExperiencia * 100000)
    public double calcularSalario(double salarioBase) {
        return salarioBase + (this.nivelExperiencia * 100000);
    }

    // Agregar Habilidad
    public void agregarHabilidad(String habilidad) {
        if (this.habilidades == null) {
            this.habilidades = new ArrayList<>();
        }
        this.habilidades.add(habilidad);
    }

    // Evaluar Desempeño
    public String evaluarDesempenho() {
        if (this.nivelExperiencia >= 5) {
            return "Excelente";
        } else if (this.nivelExperiencia >= 3) {
            return "Bueno";
        } else {
            return "Necesita Mejorar";
        }
    }

}
