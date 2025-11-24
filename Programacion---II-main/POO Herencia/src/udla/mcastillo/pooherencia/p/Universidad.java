package udla.mcastillo.pooherencia.p;
// Es buena practica en la vida laboral usar una base de datos para guardar la informacion de las clases
// servidor pesado - cliente ligero

// Se debe definir desde un inicio los enum necesarios, para evitar
// problemas en el futuro o grandes modificaciones

import udla.mcastillo.pooherencia.p1.*;

public class Universidad {
    public static void main(String[] args) {
        /** Creación de Objetos */
        Persona persona1 = new Persona();
        Profesor profesor1 = new Profesor();

        // Llamar a la sub clase
        Alumno alumno1 = new Alumno();
        alumno1.setNombre("mini juan");

        System.out.println("Nombre del alumno: " + alumno1.getNombre());
        System.out.println("Correo del alumno: " + alumno1.CORREO);
        //  Se llama a la constante declarada en la super clase Persona

        // Prueba de las contantes a traves de los enum
        // los enum son vectores y matrices en java
        // permiten agrupar constantes relacionadas
        alumno1.setGenero(Genero.LGTBQ);
        profesor1.setMateria(Materia.ESTADISTICA);

        System.out.println("Genero del alumno: " + alumno1.getGenero());
        System.out.println("Materia del profesor: " + profesor1.getMateria());


    }
}