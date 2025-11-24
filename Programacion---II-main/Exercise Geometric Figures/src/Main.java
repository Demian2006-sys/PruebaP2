// Ejercicio 1
/* Necesito calcular el aerea y el primetro de un triangulo, cuadrado, circulo, rombo
   no se validan las entradas de caracteres especiales*/


import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /** Declaracion de Objetos */
        FigurasG triangulo = new FigurasG();
        FigurasG cuadrado = new FigurasG();
        FigurasG rombo = new FigurasG();
        FigurasG círculo = new FigurasG();
        Scanner sc = new Scanner(System.in);


        /** Lectura de Datos */
        int opc;
        boolean val;
        do {
            System.out.println("1. Cuadrado");
            System.out.println("2. Triangulo");
            System.out.println("3. Rombo");
            System.out.println("4. Circulo");
            System.out.println("5. Salir");
            opc = Integer.parseInt(sc.nextLine());
            switch (opc) {
                case 1:
                    float l;
                    System.out.println("============Cuadrado============");
                    l = FigurasG.validarPositivo(sc, "Ingrese el lado: ");
                    cuadrado.setLado1(l);
                    cuadrado.cuadradoA();
                    cuadrado.cuadradoP();
                    break;

                case 2:
                    float b, h, l1, l2, l3;
                    do {
                        System.out.println("============Triangulo============");
                        b = FigurasG.validarPositivo(sc, "Ingrese la base (Lado 1): ");
                        // Se llama al metodo validarPositivo de la clase FigurasG

                        l1 = b; // Asigno el valor de la base a l1 para usarlo en el perimetro
                        h = FigurasG.validarPositivo(sc, "Ingrese la altura: ");
                        l2 = FigurasG.validarPositivo(sc, "Ingrese el lado 2: ");
                        l3 = FigurasG.validarPositivo(sc, "Ingrese el lado 3: ");

                        val = FigurasG.validarTriangulo(l1, l2, l3);
                        if (!val) {
                            System.out.println("Por favor, ingrese nuevamente los datos.");
                        } else {
                            triangulo.setBase(b);
                            triangulo.setAltura(h);
                            triangulo.setLado1(l1);
                            triangulo.setLado2(l2);
                            triangulo.setLado3(l3);
                            triangulo.trianguloA();
                            triangulo.trianguloP();
                            // Se asignan los valores a los atributos del objeto triangulo
                            // Se llaman a los metodos del objeto triangulo
                        }
                    } while (!val);
                    break;

                case 3:
                    float D, d, lado = 0; // Se inicializa lado en 0 para evitar error de variable no inicializada
                    do {
                        System.out.println("============Rombo============");
                        D = FigurasG.validarPositivo(sc, "Ingrese la diagonal mayor: ");
                        d = FigurasG.validarPositivo(sc, "Ingrese la diagonal menor: ");

                        val = FigurasG.validarRombo(D, d);
                        if (!val) {
                            System.out.println("Por favor, ingrese nuevamente los datos.");
                        } else {
                            lado = FigurasG.validarPositivo(sc, "Ingrese el lado: ");
                            rombo.setD(D);
                            rombo.setD(d);
                            rombo.setLado1(lado);
                            rombo.romboA();
                            rombo.romboP();
                        }
                    } while (!val);
                    break;
                case 4:
                    float r;
                    System.out.println("============Círculo============");
                    r = FigurasG.validarPositivo(sc, "Ingrese el radio: ");
                    círculo.setRadio(r);
                    círculo.circuloA();
                    círculo.circuloP();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Gracias por usar el programa");
                    break;
            }
        } while (opc != 5);
    }
}