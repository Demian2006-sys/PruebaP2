import javax.swing.*;

public class Proveedor {
    /** Declaracion de Atributos*/
    // Deben ser privados y se deben acceder por medio de los métodos
    private String RUC;
    private String razonSocial;
    private String direccion;
    private float  precioProdu;

    /** Decalrcion de Constructores y Destructores*/
    // Los constructores son metodos especiales que se ejecutan al momento de crear un objeto
    // y empiezan con la primera letra en mayuscula y no retornan ningun valor
    public Proveedor() {
    }

    public Proveedor(String RUC, String razonSocial) {
        this.RUC = RUC;
        this.razonSocial = razonSocial;
    }

    public Proveedor(String RUC, String razonSocial, String direccion) {
        this.RUC = RUC;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
    }

    /** Metodos propios de Java */
    // Set -> Asigna
    // Get -> Obtiene


    public String getRUC() {
        return RUC;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /** Meotodos propios del Programador */
    // Un metodo es una accion que realiza un objeto
    // puede o no retornar un valor
    // puede o no recibir parametros
    // puede o no modificar los atributos de un objeto

    public String detallesProve(String ruc, String razonSocial, String direccion){
        String detcom;
        detcom = "El RUC del proveedor es: " +  ruc + "\nRazon Social del Proveedor es: " + razonSocial +
                "\nLa Direccion del proveedor es: " + direccion;

        return detcom;
    }

    public void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public void detalle2(){
        System.out.println("RUC: " + this.getRUC());
        // Encapsulamiento con el principio de encapsulamiento
    }

    // Parametros por valor es cuando se pasa una copia del valor
    // Parametros por referencia es cuando se pasa la direccion de memoria del valor
    // En Java todos los parametros son por valor, pero los objetos se comportan como si
    // fueran por referencia, ya que se pasa la direccion de memoria del objeto
    // y cualquier cambio que se haga en el objeto dentro del metodo, se refleja en el
    // objeto original

}

