public class Tiempo {
    /** Declaración de Atributos */
    private int hora;
    private int minuto;
    private int segundo;

    /** Declaración de Constructores & Destructores*/
    public Tiempo() {
    }

    public Tiempo(int hora, int minuto, int segundo) {
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }

    /** Métodos propios de Java (Getters & Setters)*/
    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public int getSegundo() {
        return segundo;
    }

    public void setSegundo(int segundo) {
        this.segundo = segundo;
    }

    /** Métodos propios del Programador */
    public void mostrarTiempo24() {
        // String format para mostrar en formato 24 horas
        System.out.println(getHora() + ":" + getMinuto() + ":" + getSegundo());
    }

    public void mostratTiempo12(){
        // % es el operador modulo
        // y sirve para transformar el formato 24 horas a 12 horas
        // por ejemplo 13 % 12 = 1

        if (getHora() >= 12) {
            System.out.println((getHora() % 12) + ":" + getMinuto() + ":" + getSegundo() + " PM");
        } else if (getHora() == 0) {
            System.out.println(12 + ":" + getMinuto() + ":" + getSegundo() + " AM");
        }else {
            System.out.println(getHora() + ":" + getMinuto() + ":" + getSegundo() + " AM");

        }
    }

    public int convertirASegundos() {
        return (getHora() * 3600) + (getMinuto() * 60) + getSegundo();
    }

    public void agregarSegundos(int segundos) {
        int totalSegundos = convertirASegundos() + segundos;

        int nuevaHora = (totalSegundos / 3600) % 24;
        // Tranformar a horas y despues se hace el modulo 24 para que no pase de 24 horas
        int nuevoMinuto = (totalSegundos % 3600) / 60;
        // Se hace modulo de 3600 para obtener los segundos restantes y despues se divide entre 60 para obtener los minutos
        int nuevoSegundo = totalSegundos % 60;
        // Se hace modulo 60 para obtener los segundos restantes
        // Es decir que primero se obtiene el total de segundos, despues se obtiene la nueva hora, nuevo minuto y nuevo segundo
        // dependiendo del residuo de cada operacion

        setHora(nuevaHora);
        setMinuto(nuevoMinuto);
        setSegundo(nuevoSegundo);
    }

    public void agregarMinutos(int minutos) {
        int totalSegundos = convertirASegundos() + (minutos * 60);

        int nuevaHora = (totalSegundos / 3600) % 24;
        int nuevoMinuto = (totalSegundos % 3600) / 60;
        int nuevoSegundo = totalSegundos % 60;

        setHora(nuevaHora);
        setMinuto(nuevoMinuto);
        setSegundo(nuevoSegundo);
    }

    public void agregarHoras(int horas) {
        int totalSegundos = convertirASegundos() + (horas * 3600);

        int nuevaHora = (totalSegundos / 3600) % 24;
        int nuevoMinuto = (totalSegundos % 3600) / 60;
        int nuevoSegundo = totalSegundos % 60;

        setHora(nuevaHora);
        setMinuto(nuevoMinuto);
        setSegundo(nuevoSegundo);
    }
}
