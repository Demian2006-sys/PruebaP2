public class PerfilMedico {
    /** Declaración de Atributos */
    private String nombre;
    private String apellido;
    private String sexo;
    private int diaNacimiento;
    private int mesNacimiento;
    private int anioNacimiento;
    private int alturaCm;
    private double pesoKg;

    /** Declaración de Constructores & Destructores*/
    public PerfilMedico() {
    }

    public PerfilMedico(String nombre, String apellido, String sexo, int diaNacimiento, int mesNacimiento, int anioNacimiento, int alturaCm, double pesoKg) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.diaNacimiento = diaNacimiento;
        this.mesNacimiento = mesNacimiento;
        this.anioNacimiento = anioNacimiento;
        this.alturaCm = alturaCm;
        this.pesoKg = pesoKg;
    }

    /** Métodos propios de Java (Getters & Setters)*/
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getDiaNacimiento() {
        return diaNacimiento;
    }

    public void setDiaNacimiento(int diaNacimiento) {
        this.diaNacimiento = diaNacimiento;
    }

    public int getMesNacimiento() {
        return mesNacimiento;
    }

    public void setMesNacimiento(int mesNacimiento) {
        this.mesNacimiento = mesNacimiento;
    }

    public int getAnioNacimiento() {
        return anioNacimiento;
    }

    public void setAnioNacimiento(int anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }

    public int getAlturaCm() {
        return alturaCm;
    }

    public void setAlturaCm(int alturaCm) {
        this.alturaCm = alturaCm;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(double pesoKg) {
        this.pesoKg = pesoKg;
    }

    /** Métodos propios del Programador */
    public int calcularEdad(int anioActual) {
        return anioActual - this.anioNacimiento;
    }

    public int frecuenciaCardiacaMax(int anioActual){
        return 220 - calcularEdad(anioActual);
    }

    public double frecuenciaCardiacaEsperada(int frecCardaicaMax){
        return ((frecCardaicaMax*0.5) + (frecCardaicaMax*0.85))/2;
    }

    public double indiceMasaCorporal(double altura){
        double alturaM = altura /100;
        return this.pesoKg / (alturaM * alturaM);
    }

    public String clasificacionIMC(double imc){
        if (imc < 18.5) {
            return "Bajo Peso";
        } else if (imc >= 18.5 && imc < 24.9) {
            return "Normal";
        } else if (imc >= 25 && imc < 29.9) {
            return "Sobrepeso";
        } else {
            return "Obesidad";
        }
    }
}