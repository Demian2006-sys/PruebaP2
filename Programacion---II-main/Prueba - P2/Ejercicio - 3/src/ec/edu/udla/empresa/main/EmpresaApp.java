package ec.edu.udla.empresa.main;

import ec.edu.udla.empresa.clases.Departamento;
import ec.edu.udla.empresa.clases.EmpleadoRegular;
import ec.edu.udla.empresa.clases.Gerente;
import ec.edu.udla.empresa.clases.TipoContrato;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ┌─────────────────────────────────────────────────────────────┐
 * │                          <<enum>>                           │
 * │                       TipoContrato                          │
 * ├─────────────────────────────────────────────────────────────┤
 * │ FIJO_TIEMPO_COMPLETO : String                               │
 * │ FIJO_MEDIO_TIEMPO : String                                  │
 * │ TEMPORAL : String                                           │
 * │ PRACTICANTE : String                                        │
 * └─────────────────────────────────────────────────────────────┘
 *
 * ┌─────────────────────────────────────────────────────────────┐
 * │                          <<enum>>                           │
 * │                         Departamento                        │
 * ├─────────────────────────────────────────────────────────────┤
 * │ DESARROLLO : String                                         │
 * │ VENTAS : String                                             │
 * │ RECURSOS_HUMANOS : String                                   │
 * │ FINANZAS : String                                           │
 * │ MARKETING : String                                          │
 * └─────────────────────────────────────────────────────────────┘
 *
 * ┌─────────────────────────────────────────────────────────────┐
 * │                          Empleado                           │
 * ├─────────────────────────────────────────────────────────────┤
 * │ - id : String                                               │
 * │ - nombre : String                                           │
 * │ - salarioBase : double                                      │
 * │ - departamento : Departamento                               │
 * │ - tipoContrato : TipoContrato                               │
 * ├─────────────────────────────────────────────────────────────┤
 * │ + Empleado(id:String, nombre:String, salarioBase:double,    │
 * │   departamento:Departamento, tipoContrato:TipoContrato)     │
 * │ + calcularSalario() : double                                │
 * │ + asignarProyecto(proyecto:Proyecto) : void                │
 * └─────────────────────────────────────────────────────────────┘
 *                                 △
 *                                 |
 *              ┌───────────────────┴───────────────────┐
 *              │                                       │
 * ┌─────────────────────────┐             ┌─────────────────────────┐
 * │     EmpleadoRegular     │             │        Gerente          │
 * ├─────────────────────────┤             ├─────────────────────────┤
 * │ - nivelExperiencia : int│             │ - bonoGerencia : double │
 * │ - habilidades : ArrayList<String>     │ - equipo : ArrayList<Empleado> │
 * ├─────────────────────────┤             ├─────────────────────────┤
 * │ + calcularSalario() : double          │ + calcularSalario() : double │
 * │ + agregarHabilidad(habilidad:String)  │ + agregarEmpleado(emp:Empleado)│
 * │ + evaluarDesempenho() : String        │ + calcularProductividad() : double│
 * └─────────────────────────┘             └─────────────────────────┘
  *
 *     Cálculo de salarios:
 *
 *         EmpleadoRegular: salarioBase + (nivelExperiencia * 100000)
 *
 *         Gerente: salarioBase + bonoGerencia + (equipo.size() * 50000)
 *
 *         GerenteSenior: salarioBase + bonoGerencia + (equipo.size() * 75000) + (presupuesto * 0.01)
 *
 *     Funcionalidades:
 *
 *         Contratar empleados
 *
 *         Asignar empleados a proyectos
 *
 *         Calcular nómina total
 *
 *         Buscar empleados por departamento
 *
 *         Promover empleado regular a gerente
 *
 *         Generar reporte de productividad por gerente
 *
 * */


public class EmpresaApp {

    /** Declaracion de Objetos*/
    private static Scanner sc = new Scanner(System.in);
    private static List<EmpleadoRegular> listaempleadosregulares = new ArrayList<>();
    private static List<Gerente> listagerentes = new ArrayList<>();

    public static void main(String[] args) {
        int opcion;
        do {
            menu();
            opcion = sc.nextInt();
            sc.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1:
                    contratarEmpleadoRegular();
                    break;
                case 2:
                    contratarGerente();
                    break;
                case 3:
                    agregarHabilidadEmpleadoRegular();
                    break;
                case 4:
                    calcularNominaTotal();
                    break;
                case 5:
                    buscarEmpleadosPorDepartamento();
                    break;
                case 6:
                    promoverEmpleadoRegularAGerente();
                    break;
                case 7:
                    generarReporteProductividadPorGerente();
                    break;
                case 8:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }
        } while (opcion != 8);

    }

    /**Metodos de la Clase*/

    // menu
    private static void menu(){
        System.out.println("===== Sistema de Gestión de Empleados =====");
        System.out.println("1. Contratar Empleado Regular");
        System.out.println("2. Contratar Gerente");
        System.out.println("3. Agregar más habilidades a Empleado Regular");
        System.out.println("3. Asignar Empleado a Proyecto");
        System.out.println("4. Calcular Nómina Total");
        System.out.println("5. Buscar Empleados por Departamento");
        System.out.println("6. Promover Empleado Regular a Gerente");
        System.out.println("7. Generar Reporte de Productividad por Gerente");
        System.out.println("8. Salir");
        System.out.print("Seleccione una opción: ");
    }

    // contratarEmpleadoRegular
    private static void contratarEmpleadoRegular(){
        System.out.println("----- Contratar Empleado Regular -----");
        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = sc.nextLine();

        System.out.println("Seleccione el departamento:");
        System.out.println("1. DESARROLLO, 2. VENTAS, 3. RECURSOS_HUMANOS, 4. FINANZAS, 5. MARKETING");
        int opcionDept = sc.nextInt();
        sc.nextLine(); // Consumir salto de línea
        Departamento departamento;
        switch (opcionDept){
            case 1:
                departamento = Departamento.DESARROLLO;
                break;
            case 2:
                departamento = Departamento.VENTAS;
                break;
            case 3:
                departamento = Departamento.RECURSOS_HUMANOS;
                break;
            case 4:
                departamento = Departamento.FINANZAS;
                break;
            case 5:
                departamento = Departamento.MARKETING;
                break;
            default:
                System.out.println("Opción inválida. Asignando DESARROLLO por defecto.");
                departamento = Departamento.DESARROLLO;
        }

        System.out.println("Seleccione el tipo de contrato:");
        System.out.println("1. FIJO_TIEMPO_COMPLETO, 2. FIJO_MEDIO_TIEMPO, 3. TEMPORAL, 4. PRACTICANTE");
        int opcionContrato = sc.nextInt();
        sc.nextLine(); // Consumir salto de línea
        TipoContrato tipoContrato;
        switch (opcionContrato){
            case 1:
                tipoContrato = TipoContrato.FIJO_TIEMPO_COMPLETO;
                break;
            case 2:
                tipoContrato = TipoContrato.FIJO_MEDIO_TIEMPO;
                break;
            case 3:
                tipoContrato = TipoContrato.TEMPORAL;
                break;
            case 4:
                tipoContrato = TipoContrato.PRACTICANTE;
                break;
            default:
                System.out.println("Opción inválida. Asignando FIJO_TIEMPO_COMPLETO por defecto.");
                tipoContrato = TipoContrato.FIJO_TIEMPO_COMPLETO;
        }

        System.out.println("Ingrese el nivel de experiencia (1-10): ");
        int nivelExperiencia = sc.nextInt();
        sc.nextLine(); // Consumir salto de línea

        System.out.println("Ingrese las habilidades del empleado");
        ArrayList<String> habilidades = new ArrayList<>();
        int opcHab;
        do {
            System.out.println("Habiliad:");
            String habilidadesInput = sc.nextLine();
            habilidades.add(habilidadesInput);
            System.out.println("¿Desea agregar otra habilidad? (0 = No, 1 = Sí)");
            opcHab = sc.nextInt();
            sc.nextLine(); // Consumir salto de línea
        }while (opcHab == 1);

        EmpleadoRegular nuevoEmpleado = new EmpleadoRegular(nombre, departamento, tipoContrato, nivelExperiencia, habilidades);
        listaempleadosregulares.add(nuevoEmpleado);
        System.out.println("Empleado Regular contratado exitosamente.");
        System.out.println("Codigo de Empleado Regular: " + nuevoEmpleado.getId());
    }

    // contratarGerente
    private static void contratarGerente(){
        System.out.println("----- Contratar Gerente -----");
        System.out.print("Ingrese el nombre del gerente: ");
        String nombre = sc.nextLine();

        System.out.println("Seleccione el departamento:");
        System.out.println("1. DESARROLLO, 2. VENTAS, 3. RECURSOS_HUMANOS, 4. FINANZAS, 5. MARKETING");
        int opcionDept = sc.nextInt();
        sc.nextLine(); // Consumir salto de línea
        Departamento departamento;
        switch (opcionDept){
            case 1:
                departamento = Departamento.DESARROLLO;
                break;
            case 2:
                departamento = Departamento.VENTAS;
                break;
            case 3:
                departamento = Departamento.RECURSOS_HUMANOS;
                break;
            case 4:
                departamento = Departamento.FINANZAS;
                break;
            case 5:
                departamento = Departamento.MARKETING;
                break;
            default:
                System.out.println("Opción inválida. Asignando DESARROLLO por defecto.");
                departamento = Departamento.DESARROLLO;
        }

        System.out.println("Seleccione el tipo de contrato:");
        System.out.println("1. FIJO_TIEMPO_COMPLETO, 2. FIJO_MEDIO_TIEMPO, 3. TEMPORAL, 4. PRACTICANTE");
        int opcionContrato = sc.nextInt();
        sc.nextLine(); // Consumir salto de línea
        TipoContrato tipoContrato;
        switch (opcionContrato){
            case 1:
                tipoContrato = TipoContrato.FIJO_TIEMPO_COMPLETO;
                break;
            case 2:
                tipoContrato = TipoContrato.FIJO_MEDIO_TIEMPO;
                break;
            case 3:
                tipoContrato = TipoContrato.TEMPORAL;
                break;
            case 4:
                tipoContrato = TipoContrato.PRACTICANTE;
                break;
            default:
                System.out.println("Opción inválida. Asignando FIJO_TIEMPO_COMPLETO por defecto.");
                tipoContrato = TipoContrato.FIJO_TIEMPO_COMPLETO;
        }

        Gerente nuevoGerente = new Gerente(nombre, departamento, tipoContrato);
        listagerentes.add(nuevoGerente);
        System.out.println("Gerente contratado exitosamente.");
        System.out.println("Codigo de Gerente: " + nuevoGerente.getId());
    }

    // agregarHabilidadEmpleadoRegular
    private static void agregarHabilidadEmpleadoRegular(){
        System.out.println("----- Agregar Habilidad a Empleado Regular -----");
        if (listaempleadosregulares.isEmpty()) {
            System.out.println("No hay empleados regulares contratados.");
            return;
        }

        System.out.println("Seleccione el empleado regular al que desea agregar una habilidad:");
        for (int i = 0; i < listaempleadosregulares.size(); i++) {
            System.out.println((i + 1) + ". " + listaempleadosregulares.get(i).getNombre());
        }
        int opcionEmp = sc.nextInt();
        sc.nextLine(); // Consumir salto de línea

        if (opcionEmp < 1 || opcionEmp > listaempleadosregulares.size()) {
            System.out.println("Opción inválida.");
            return;
        }

        EmpleadoRegular empleadoSeleccionado = listaempleadosregulares.get(opcionEmp - 1);
        System.out.print("Ingrese la habilidad a agregar: ");
        String nuevaHabilidad = sc.nextLine();
        empleadoSeleccionado.agregarHabilidad(nuevaHabilidad);
        System.out.println("Habilidad agregada exitosamente a " + empleadoSeleccionado.getNombre() + ".");
    }

    // calcularNominaTotal
    private static void calcularNominaTotal(){
        System.out.println("----- Calcular Nómina Total -----");
        double nominaTotal = 0.0;

        for (EmpleadoRegular empReg : listaempleadosregulares) {
            nominaTotal += empReg.calcularSalario(500000); // Suponiendo un salario base de 500000
        }

        for (Gerente gerente : listagerentes) {
            nominaTotal += gerente.calcularSalario(800000); // Suponiendo un salario base de 800000
        }

        System.out.println("La nómina total de la empresa es: " + nominaTotal);
    }

    // buscarEmpleadosPorDepartamento
    private static void buscarEmpleadosPorDepartamento(){
        System.out.println("----- Buscar Empleados por Departamento -----");
        System.out.println("Seleccione el departamento:");
        System.out.println("1. DESARROLLO, 2. VENTAS, 3. RECURSOS_HUMANOS, 4. FINANZAS, 5. MARKETING");
        int opcionDept = sc.nextInt();
        sc.nextLine(); // Consumir salto de línea
        Departamento departamento;
        switch (opcionDept){
            case 1:
                departamento = Departamento.DESARROLLO;
                break;
            case 2:
                departamento = Departamento.VENTAS;
                break;
            case 3:
                departamento = Departamento.RECURSOS_HUMANOS;
                break;
            case 4:
                departamento = Departamento.FINANZAS;
                break;
            case 5:
                departamento = Departamento.MARKETING;
                break;
            default:
                System.out.println("Opción inválida. Asignando DESARROLLO por defecto.");
                departamento = Departamento.DESARROLLO;
        }

        System.out.println("Empleados en el departamento de " + departamento + ":");
        for (EmpleadoRegular empReg : listaempleadosregulares) {
            if (empReg.getDepartamento() == departamento) {
                System.out.println("- " + empReg.getNombre());
            }
        }

        for (Gerente gerente : listagerentes) {
            if (gerente.getDepartamento() == departamento) {
                System.out.println("- " + gerente.getNombre());
            }
        }
    }

    // promoverEmpleadoRegularAGerente
    private static void promoverEmpleadoRegularAGerente(){
        System.out.println("----- Promover Empleado Regular a Gerente -----");
        if (listaempleadosregulares.isEmpty()) {
            System.out.println("No hay empleados regulares contratados.");
            return;
        }

        System.out.println("Seleccione el empleado regular que desea promover:");
        for (int i = 0; i < listaempleadosregulares.size(); i++) {
            System.out.println((i + 1) + ". " + listaempleadosregulares.get(i).getNombre());
        }
        int opcionEmp = sc.nextInt();
        sc.nextLine(); // Consumir salto de línea

        if (opcionEmp < 1 || opcionEmp > listaempleadosregulares.size()) {
            System.out.println("Opción inválida.");
            return;
        }

        EmpleadoRegular empleadoSeleccionado = listaempleadosregulares.get(opcionEmp - 1);
        Gerente nuevoGerente = new Gerente(empleadoSeleccionado.getNombre(), empleadoSeleccionado.getDepartamento(),
                empleadoSeleccionado.getTipoContrato());
        listagerentes.add(nuevoGerente);
        listaempleadosregulares.remove(empleadoSeleccionado);
        System.out.println("Empleado " + empleadoSeleccionado.getNombre() + " promovido a Gerente exitosamente.");
    }

    // generarReporteProductividadPorGerente
    private static void generarReporteProductividadPorGerente(){
        System.out.println("----- Reporte de Productividad por Gerente -----");
        for (Gerente gerente : listagerentes) {
            double productividad = gerente.calcularProductividad();
            System.out.println("Gerente: " + gerente.getNombre() + " - Productividad: " + productividad);
        }
    }
}