package ec.edu.udla.empresa.clases;

public class Empleado {
    /** Declaración de Atributos */
    private int id;
    private String nombre;
    private Departamento departamento;
    private TipoContrato tipoContrato;
    private static int ContadorId = 1;

    /** COnstrcutores & Destrcutores*/
    public Empleado(String nombre, Departamento departamento, TipoContrato tipoContrato) {
        this.id = ContadorId++;
        this.nombre = nombre;
        this.departamento = departamento;
        this.tipoContrato = tipoContrato;
    }

    public Empleado() {
    }

    /** Setters & Getters*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public TipoContrato getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(TipoContrato tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public static int getContadorId() {
        return ContadorId;
    }

    public static void setContadorId(int contadorId) {
        ContadorId = contadorId;
    }

    /** Metodos del programador*/



}
