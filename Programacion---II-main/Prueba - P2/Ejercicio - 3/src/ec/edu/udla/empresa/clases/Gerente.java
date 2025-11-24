/*
 * ==============================
 * Regla Mnemotécnica UML
 * ==============================
 *
 * | Relación      | Frase                         | Flecha UML           |
 * |---------------|-------------------------------|----------------------|
 * | Herencia      | "Soy como tú"                 | ◁ triángulo blanco   |
 * | Composición   | "No existo sin ti"            | ◆ diamante negro     |
 * | Agregación    | "Te necesito pero sobrevivo"  | ◇ diamante blanco    |
 * | Dependencia   | "Te uso temporalmente"        | ─> flecha punteada   |
 *
 * ------------------------------
 * Checklist Rápido para detectar relaciones:
 * ------------------------------
 * 1. ¿Hay uso de 'extends'? → Herencia ◁
 * 2. ¿Hay List<> o atributo de otra clase? → Composición ◆
 * 3. ¿Se pasa como parámetro solamente? → Dependencia ─>
 *
 * Esta guía ayuda a identificar visualmente las relaciones entre clases en diagramas UML.
 */


package ec.edu.udla.empresa.clases;

import java.util.ArrayList;

public class Gerente extends Empleado{
    /** Atributos de la Clase Gerente*/
    private double bonoGerencia;
    private java.util.ArrayList<EmpleadoRegular> equipo; // Lista de empleados a cargo

    public Gerente(String nombre, Departamento departamento, TipoContrato tipoContrato, double bonoGerencia, ArrayList<EmpleadoRegular> equipo) {
        super(nombre, departamento, tipoContrato);
        this.bonoGerencia = bonoGerencia;
        this.equipo = equipo;
    }

    /** Constructores & Destructores*/

    public Gerente(String nombre, Departamento departamento, TipoContrato tipoContrato) {
        super(nombre, departamento, tipoContrato);
    }

    public Gerente() {
    }

    /** Setters & Getters*/
    public double getBonoGerencia() {
        return bonoGerencia;
    }

    public void setBonoGerencia(double bonoGerencia) {
        this.bonoGerencia = bonoGerencia;
    }

    public ArrayList<EmpleadoRegular> getEquipo() {
        return equipo;
    }

    public void setEquipo(ArrayList<EmpleadoRegular> equipo) {
        this.equipo = equipo;
    }

    /**Metodos del Programador*/

    // Calcular Salario
    // salarioBase + bonoGerencia + (equipo.size() * 50000)
    public double calcularSalario(double salarioBase) {
        return salarioBase + this.bonoGerencia + (this.equipo.size() * 50000);
    }

    // Agregar Empleado al Equipo
    public void agregarEmpleado(EmpleadoRegular emp) {
        if (this.equipo == null) {
            this.equipo = new ArrayList<>();
        }
        this.equipo.add(emp);
    }

    // Calcular Productividad
    public double calcularProductividad() {
        if (this.equipo == null || this.equipo.isEmpty()) {
            return 0.0;
        }
        double totalExperiencia = 0.0;
        for (EmpleadoRegular emp : this.equipo) {
            totalExperiencia += emp.getNivelExperiencia();
        }
        return totalExperiencia / this.equipo.size();
    }

}
