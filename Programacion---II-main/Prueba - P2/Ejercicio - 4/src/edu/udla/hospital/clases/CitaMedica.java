package edu.udla.hospital.clases;

public class CitaMedica {
    /** Declaracion de Atributos*/
    private Paciente paciente;
    private Medico medico;
    private Estado estado;
    private String fecha;
    private String hora;
    private int idCita;
    private static int contId = 1;

    /** Constructores & Destructores*/
    public CitaMedica(Paciente paciente, Medico medico, Estado estado, String fecha, String hora) {
        this.paciente = paciente;
        this.medico = medico;
        this.estado = estado;
        this.fecha = fecha;
        this.hora = hora;
        this.idCita = contId++;
    }

    public CitaMedica() {
    }

    /** Getters & Setters*/
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public static int getContId() {
        return contId;
    }

    public static void setContId(int contId) {
        CitaMedica.contId = contId;
    }

    /** Metodos del programador*/
    // obtener info de la cita medica
    public void mostrarInfoCita() {
        System.out.println("----- Info Cita Medica -----");
        System.out.println("Fecha: " + this.fecha);
        System.out.println("Hora: " + this.hora);
        System.out.println("Estado: " + this.estado);
        System.out.println("----- Info Paciente -----");
        this.paciente.mostrarInfo();
        System.out.println("----- Info Medico -----");
        System.out.println("ID Medico: " + this.medico.getIdPersonal());
        System.out.println("Nombre: " + this.medico.getNombre());
        System.out.println("Apellido: " + this.medico.getApellido());
        System.out.println("Especialidad: " + this.medico.getEspecialidad());
    }

    // Calcular costo de la consulta
    // Calcular costo de consulta según especialidad y afiliación
    public double calcularCostoConsulta() {
        System.out.println("--- Calcular Costo de Consulta ---");
        double costoBase = 50.0; // Costo base de la consulta
        String especialidad = this.medico.getEspecialidad();
        double costoFinal = costoBase;

        // Ajustar costo según especialidad
        switch (especialidad.toLowerCase()) {
            case "cardiologia":
                costoFinal += 100.0;
                break;
            case "dermatologia":
                costoFinal += 80.0;
                break;
            case "pediatria":
                costoFinal += 60.0;
                break;
            case "neurologia":
                costoFinal += 120.0;
                break;
            default:
                costoFinal += 50.0; // Especialidad general
                break;
        }
        return costoFinal;
    }
}
