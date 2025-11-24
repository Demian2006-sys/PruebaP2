package edu.udla.hospital.main;

import edu.udla.hospital.clases.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Enunciado:
 *
 * Se requiere desarrollar un sistema de gestión para un hospital que maneje diferentes tipos de personal médico
 * y pacientes. El sistema debe permitir administrar citas, historiales médicos y calcular costos de servicios.
 *
 * Requisitos del Sistema:
 *
 *     Personal Médico:
 *
 *         Médico: Tiene especialidad, añosExperiencia, licenciaMedica. Puede diagnosticar pacientes
 *         y prescribir medicamentos.
 *
 *         Enfermero: Tiene turno (MAÑANA, TARDE, NOCHE) y áreaAsignada. Puede administrar medicamentos
 *         y tomar signos vitales.
 *
 *     Pacientes:
 *
 *         Tienen historial médico con consultas previas.
 *
 *         Pueden ser atendidos en consulta externa o emergencia.
 *
 *         Tienen un tipo de afiliación (POS, PREPAGADA, PARTICULAR).
 *
 *     Citas Médicas:
 *
 *         Cada cita tiene fecha, hora, médico asignado, paciente y estado (PROGRAMADA, COMPLETADA, CANCELADA).
 *
 *     Funcionalidades:
 *
 *         Programar citas verificando disponibilidad
 *
 *         Calcular costo de consulta según especialidad y afiliación
 *
 *         Generar reporte de pacientes por médico
 *
 *         Buscar personal médico por especialidad/turno
 *
 *         Calcular ingresos totales del hospital
 *
 * Reglas de Negocio:
 *
 *     Los cirujanos no atienden citas los fines de semana
 *
 *     Las citas de emergencia tienen prioridad
 *
 *     Los pacientes POS tienen 20% de descuento
 *
 *     Los enfermeros no pueden diagnosticar, solo los médicos
 *
 * */

public class Hospital {
    /** Declaracion de Objetos*/
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Enfermero> listaEnfermeros = new ArrayList<>();
    private static ArrayList<Medico> listaMedicos = new ArrayList<>();
    private static ArrayList<Paciente> listaPacientes = new ArrayList<>();
    private static ArrayList<CitaMedica> listaCitasMedicas = new ArrayList<>();

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 0:
                    crearPaciente();
                    crearMedico();
                    crearEnfermero();
                    break;
                case 1:
                    programarCitaMedica();
                    break;
                case 2:
                    calcularCostoConsulta();
                    break;
                case 3:
                    generarReportePacientesPorMedico();
                    break;
                case 4:
                    buscarPersonalMedico();
                    break;
                case 5:
                    calcularIngresosTotales();
                    break;
                case 6:
                    cambiarEstadoCitaMedica();
                    break;
                case 7:
                    infoCitasMedicas();
                    break;
                case 8:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }

            System.out.println();

        } while (opcion != 8);

    }

    /** Metodos del main*/

    // menu
    private static void mostrarMenu() {
        System.out.println("=== Sistema de Gestión Hospitalaria ===");
        System.out.println("0. Registrar Personal Médico y Pacientes");
        System.out.println("1. Programar Cita Médica");
        System.out.println("2. Calcular Costo de Consulta");
        System.out.println("3. Generar Reporte de Pacientes por Médico");
        System.out.println("4. Buscar Personal Médico por Especialidad/Turno");
        System.out.println("5. Calcular Ingresos Totales del Hospital");
        System.out.println("6. Cambiar Estado de Cita Médica");
        System.out.println("7. Info de las Citas Médicas");
        System.out.println("8. Salir");
        System.out.print("Seleccione una opción: ");
    }

    // Crear paciente
    private static void crearPaciente(){
        System.out.println("--- Crear Nuevo Paciente ---");
        System.out.print("Ingrese Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese Apellido: ");
        String apellido = sc.nextLine();

        Paciente nuevoPaciente = new Paciente(nombre, apellido);
        listaPacientes.add(nuevoPaciente);
        System.out.println("Paciente creado con ID: " + nuevoPaciente.getIdPaciente());
    }

    // Crear medico
    private static void crearMedico(){
        System.out.println("--- Crear Nuevo Médico ---");
        System.out.print("Ingrese Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese Apellido: ");
        String apellido = sc.nextLine();
        System.out.print("Ingrese Especialidad: ");
        String especialidad = sc.nextLine();
        System.out.print("Ingrese Años de Experiencia: ");
        int añosExperiencia = Integer.parseInt(sc.nextLine());
        System.out.print("Ingrese Licencia Médica: ");
        String licenciaMedica = sc.nextLine();

        Medico nuevoMedico = new Medico(nombre, apellido, especialidad, añosExperiencia, licenciaMedica);
        listaMedicos.add(nuevoMedico);
        System.out.println("Médico creado con ID: " + nuevoMedico.getIdPersonal());
    }

    // Crear enfermero
    private static void crearEnfermero(){
        System.out.println("--- Crear Nuevo Enfermero ---");
        System.out.print("Ingrese Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese Apellido: ");
        String apellido = sc.nextLine();
        System.out.print("Ingrese Turno (1.MAÑANA, 2.TARDE, 3.NOCHE): ");
        int opcionTurno = Integer.parseInt(sc.nextLine());
        Turno turno;
        switch (opcionTurno){
            case 1:
                turno = Turno.MANANA;
                break;
            case 2:
                turno = Turno.TARDE;
                break;
            case 3:
                turno = Turno.NOCHE;
                break;
            default:
                System.out.println("Opción inválida. Se asignará turno MAÑANA por defecto.");
                turno = Turno.MANANA;
        }

        System.out.print("Ingrese Área Asignada: ");
        String areaAsignada = sc.nextLine();

        Enfermero nuevoEnfermero = new Enfermero(nombre, apellido, turno, areaAsignada);
        listaEnfermeros.add(nuevoEnfermero);
        System.out.println("Enfermero creado con ID: " + nuevoEnfermero.getIdPersonal());
    }

    // Programar cita medica
    private static void programarCitaMedica(){
        System.out.println("--- Cita Médica Programada ---");

        // Datos de la cita
        System.out.print("Ingrese Fecha (DD/MM/AAAA): ");
        String fecha = sc.nextLine();
        System.out.print("Ingrese Hora (HH:MM): ");
        String hora = sc.nextLine();

        // Solicitar id de paciente y medico
        System.out.print("Ingrese el id del paciente: ");
        int idPaciente = Integer.parseInt(sc.nextLine());
        System.out.print("Ingrese el id del medico: ");
        int idMedico = Integer.parseInt(sc.nextLine());

        // Variables para almacenar las referencias encontradas
        Medico medicoEncontrado = null;
        Paciente pacienteEncontrado = null;

        // Buscar médico
        for (Medico medico : listaMedicos) {
            if (medico.getIdPersonal() == idMedico) {
                medicoEncontrado = medico;
                System.out.println("Info del medico asignado:");
                medico.mostrarInfoMedico();
                break;
            }
        }

        if (medicoEncontrado == null) {
            System.out.println("Medico no encontrado.");
            return;
        }

        // Buscar paciente
        for (Paciente paciente : listaPacientes) {
            if (paciente.getIdPaciente() == idPaciente) {
                pacienteEncontrado = paciente;
                System.out.println("Info del paciente:");
                paciente.mostrarInfo();
                break;
            }
        }

        if (pacienteEncontrado == null) {
            System.out.println("Paciente no encontrado.");
            return;
        }

        // Crear la cita médica
        CitaMedica citaMedica = new CitaMedica(pacienteEncontrado, medicoEncontrado, Estado.PROGRAMADA, fecha, hora);
        listaCitasMedicas.add(citaMedica);
        System.out.println("Cita médica programada con éxito.");
        System.out.println("Id Cita Médica: " + citaMedica.getIdCita());

    }


    // Calcular costo de consulta
    private static void calcularCostoConsulta(){
        System.out.println("--- Calcular Costo de Consulta ---");
        System.out.println("Ingrese el ID de la cita médica: ");
        int idCita = Integer.parseInt(sc.nextLine());

        for (CitaMedica citaMedica : listaCitasMedicas) {
            if (citaMedica.getIdCita() == idCita) {
                double costo = citaMedica.calcularCostoConsulta();
                System.out.println("El costo de la consulta es: $" + costo);
                return;
            }
        }

    }

    // Generar reporte de pacientes por medico
    private static void generarReportePacientesPorMedico(){
        System.out.println("--- Reporte de Pacientes por Médico ---");
        for (Medico medico : listaMedicos) {
            System.out.println("Médico: " + medico.getNombre() + " " + medico.getApellido() + " (ID: "
                    + medico.getIdPersonal() + ")");
            System.out.println("Pacientes asignados:");
            for (CitaMedica citaMedica : listaCitasMedicas) {
                if (citaMedica.getMedico().getIdPersonal() == medico.getIdPersonal()) {
                    Paciente paciente = citaMedica.getPaciente();
                    System.out.println("- " + paciente.getNombre() + " " + paciente.getApellido()
                            + " (ID: " + paciente.getIdPaciente() + ")");
                }
            }
            System.out.println();
        }
    }

    // Buscar personal medico por especialidad/turno
    private static void buscarPersonalMedico(){
        System.out.println("--- Buscar Personal Médico por Especialidad/Turno ---");
        System.out.print("Ingrese Especialidad o Turno a buscar: ");
        String criterio = sc.nextLine();

        System.out.println("Médicos encontrados:");
        for (Medico medico : listaMedicos) {
            if (medico.getEspecialidad().contains(criterio)) { // Revisar si la especialidad contiene el criterio
                System.out.println("- " + medico.getNombre() + " " + medico.getApellido()
                        + " (ID: " + medico.getIdPersonal() + ", Especialidad: " + medico.getEspecialidad() + ")");
            }
        }

        System.out.println("Enfermeros encontrados:");
        for (Enfermero enfermero : listaEnfermeros) {
            if (enfermero.getTurno().toString().contains(criterio)) {
                System.out.println("- " + enfermero.getNombre() + " " + enfermero.getApellido()
                        + " (ID: " + enfermero.getIdPersonal() + ", Turno: " + enfermero.getTurno() + ")");
            }
        }
    }

    // Calcular ingresos totales del hospital
    private static void calcularIngresosTotales(){
        System.out.println("--- Calcular Ingresos Totales del Hospital ---");
        double ingresosTotales = 0.0;

        for (CitaMedica citaMedica : listaCitasMedicas) {
            if (citaMedica.getEstado() == Estado.COMPLETADA) {
                ingresosTotales += citaMedica.calcularCostoConsulta();
            }
        }

        System.out.println("Los ingresos totales del hospital son: $" + ingresosTotales);
    }

    // Cambiar estado de cita medica
    private static void cambiarEstadoCitaMedica(){
        System.out.println("--- Cambiar Estado de Cita Médica ---");
        System.out.print("Ingrese el ID de la cita médica: ");
        int idCita = Integer.parseInt(sc.nextLine());

        for (CitaMedica citaMedica : listaCitasMedicas) {
            if (citaMedica.getIdCita() == idCita) {
                System.out.print("Ingrese nuevo estado (1.PROGRAMADA, 2.COMPLETADA, 3.CANCELADA): ");
                int opcionEstado = Integer.parseInt(sc.nextLine());
                Estado nuevoEstado;
                switch (opcionEstado){
                    case 1:
                        nuevoEstado = Estado.PROGRAMADA;
                        break;
                    case 2:
                        nuevoEstado = Estado.COMPLETADA;
                        break;
                    case 3:
                        nuevoEstado = Estado.CANCELADA;
                        break;
                    default:
                        System.out.println("Opción inválida. No se realizó ningún cambio.");
                        return;
                }
                citaMedica.setEstado(nuevoEstado);
                System.out.println("El estado de la cita médica ha sido actualizado a: " + nuevoEstado);
                return;
            }
        }

        System.out.println("Cita médica no encontrada.");
    }

    // Info de las citas medicas
    private static void infoCitasMedicas(){
        System.out.println("--- Info de las Citas Médicas ---");
        for (CitaMedica citaMedica : listaCitasMedicas) {
            citaMedica.mostrarInfoCita();
            System.out.println();
        }
    }


}