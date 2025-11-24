// Si no se escribe public, se asume que la clase es pùblica
// Pero no se debe de asumir

public class Automovil {

    //Cuando es en mayusculas es un tipo de objetivo
    String marca;
    String modelo;
    String color = "blanco";
    double cilindraje;

    // El constructor crea un espacio de memoria

    public Automovil() {
    }

    public Automovil(double cilindraje, String modelo, String marca) {
        this.cilindraje = cilindraje;
        this.modelo = modelo;
        this.marca = marca;
    }

    //System.out.println("Info del metodo");
    public void detalle(){
        // Solo se deja los valores ingresados, es decir sus atributos
        // Se crea el metodo

        //Concepto de polimorfismo, pueden tener mismo nombre, pero diferentes clases
        String modelo = "AUDI";

        System.out.println("marca : " + this.marca); //La palabra reservada this, toma los valores de los atributos
        System.out.println("modelo : " + this.modelo); // no se toma los valores asignado en el metodo
        System.out.println("color : " + this.color); // como en el caso de modelo en este metodo
        System.out.println("cilindraje : " + this.cilindraje);
        System.out.println("===================================================");
    }

}

