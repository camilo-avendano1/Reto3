/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reto3;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Reto3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);//creamos el objeto Scanner
        int opcion = 5;
        while (opcion != 0) {
            System.out.println("\nBienvenido\n"
                    + "1) Notas\n"
                    + "2) Producto escalar de dos vectores\n"
                    + "3) Creación de matriz MxN\n"
                    + "0) Salir\n"
                    + "Ingrese la opción que desee:\n");

            opcion = lectura.nextInt();
            if (opcion == 3) {

                boolean aprobado = false;//creamos una variable bool que se usara para corroborar que el usuario ingresara un número natural mayor a cero
                while (aprobado == false) { //while booleano para comprobar que el numero no sea menor a 1
                    System.out.println("Por favor ingrese el número de columnas que desea en su matriz: "); //pedimos al usuario amablemente que nos de la cantidad de columnas

                    int m = lectura.nextInt(); //capturamos el número que ingreso el usuario
                    System.out.println("Por favor ingrese el número de filas que desea en su matriz: ");//pedimos al usuario amablemente que nos de la cantidad de filas
                    int n = lectura.nextInt(); //capturamos el número que ingreso el usuario
                    if (m >= 1 && n >= 1) { //comprobar que los números sean enteros positvos 
                        double[][] matriz = new double[n][m]; //creamos la matriz con los número ingreados por el usuario
                        aprobado = true; //cambia de estado la variable bool cuando se comprueba que se ingrearon numeros validos al tamaño de la matriz 
                        for (int j = 0; j < n; j++) { //ciclo para recorrer columnas
                            for (int i = 0; i < m; i++) { //ciclo interno para recorrer filas, cuando termine de recorrer toda la fila sigue con la siguiente columna
                                System.out.println("Ingrese el valor de la matriz ubicado en la posición:" + (j + 1) + "," + (i + 1)); //le solicita al usuario ingresar el numero en la matriz en la posición indicada, siendo (columna, fila) 
                                double num = lectura.nextDouble(); //captura el numero 
                                matriz[j][i] = num; //lo guarda en la matriz
                            }
                        }
                        System.out.println("\n La matriz ingresada fue la siguiente: \n");
                        for (int j = 0; j < n; j++) {        //recorre e imprime la matriz 
                            System.out.println(Arrays.toString(matriz[j]));
                        }
                    } else {
                        System.out.println("El tamaño ingresado de la matriz debe ser mayor a 0, por favor intente de nuevo.\n"); //en caso de que el usuario ingrese un numero menor a 1 arroja este anuncio

                    }
                }
            }
            if (opcion == 1) {
                System.out.println("ingrese las notas separadas por comas");
                String notasEntradas = lectura.next();
                String[] notas = notasEntradas.split(",");
                double[] notasDouble = new double[notas.length];
                // transformamos las entradas a double y las guardamos en un nuevo array y
                //verificamos que los datos cumplan los requisitos
                int contador = 0;
                while (contador < notasDouble.length) {
                    notasDouble[contador] = Double.parseDouble(notas[contador]);
                    double correccion;
                    if (notasDouble[contador] <= 5 && notasDouble[contador] >= 1) {
                        contador++;
                    } else { // si hay alguna nota que no es valida pedimos que se corrija
                        int leerContadorUsuario = contador + 1;
                        System.out.println("la nota en la posicion " + leerContadorUsuario + " no esvalida, por favor ingresa una nota valida ");
                        correccion = lectura.nextDouble();
                        notasDouble[contador] = correccion;
                        if (correccion <= 5 && contador >= 1) {
                            contador++;
                        }
                    }
                }
                // buscamos el valor mayor
                System.out.println("a)");
                double mayor = notasDouble[0];
                for (int i = 1; i < notasDouble.length; i++) {
                    if (notasDouble[i] > mayor) {
                        mayor = notasDouble[i];
                    }
                }
                System.out.println("la mayor nota es: " + mayor);
                //buscamos el valor menor 
                System.out.println("b)");
                double menor = notasDouble[0];
                for (int i = 1; i < notasDouble.length; i++) {
                    if (notasDouble[i] < menor) {
                        menor = notasDouble[i];
                    }
                }
                System.out.println("la menor nota es: " + menor);
                // hacemos la variaicon estandar 
                //sumatoria de todos los datos
                System.out.println("C)");
                double sumatoria = 0.0;
                for (int i = 0; i < notasDouble.length; i++) {
                    sumatoria = sumatoria + notasDouble[i];
                }
                // calculamos la media 
                double media;
                media = sumatoria / notasDouble.length;
                //se hace la suma de las diferencias respecto ala media
                double varianza = 0;
                for (int i = 0; i < notasDouble.length; i++) {
                    double rango;
                    rango = Math.pow(notasDouble[i] - media, 2f);
                    varianza = varianza + rango;
                }
                varianza = varianza / notasDouble.length;

                // ahora a varianza se le saca raiz y tendremos la desviacion estandar
                double desviacion = 0.0;

                desviacion = Math.sqrt(varianza);

                System.out.println("desviacion estandar " + desviacion);

            }
            if (opcion == 2) {
                System.out.println("escriba la dimension de los vectores");
                int dimension = lectura.nextInt();
                double vector1[];
                vector1 = new double[dimension];
                double vector2[];
                vector2 = new double[dimension];
                System.out.println("vector 1:" + Arrays.toString(vector1));
                System.out.println("vector 2:" + Arrays.toString(vector2));
                //ingresamos los valores del vector 1 y los convertimos
                System.out.println("escriba los valores del vector 1 separados por comas");
                String entradaV1 = lectura.next();
                String[] entradaArrayV1 = entradaV1.split(",");
                int contadorV1 = 0;
                while (contadorV1 < vector1.length) {
                    vector1[contadorV1] = Double.parseDouble(entradaArrayV1[contadorV1]);
                    contadorV1++;
                }
                //ingresamos los valores del vector 2 y los convertimos
                System.out.println("escriba los valores del vector 2 separados por comas");
                String entradaV2 = lectura.next();
                String[] entradaArrayV2 = entradaV2.split(",");
                int contadorV2 = 0;
                while (contadorV2 < vector2.length) {
                    vector2[contadorV2] = Double.parseDouble(entradaArrayV2[contadorV2]);
                    contadorV2++;
                }
                System.out.println("sus vectores son ");
                System.out.println("vector 1:" + Arrays.toString(vector1));
                System.out.println("vector 2:" + Arrays.toString(vector2));

                //producto escalar de los vectores
                double suma = 0;
                String textoSuma = "";
                System.out.println("productor escalar entre " + Arrays.toString(vector1) + " y "
                        + Arrays.toString(vector2) + " es ");
                for (int i = 0; i < vector1.length; i++) {
                    suma = suma + (vector1[i] * vector2[i]);
                    if (i != (vector1.length - 1)) {
                        textoSuma = textoSuma + (vector1[i] + "x" + vector2[i] + "  +  ");
                    } else {
                        textoSuma = textoSuma + (vector1[i] + "x" + vector2[i]);
                    }
                }
                System.out.println(textoSuma + " = " + suma);
            }
        }
    }
}
