package controladores;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Inicioo {
	static Scanner sc = new Scanner(System.in);
	static String rutaArchivo = "C:\\Users\\Usuario\\eclipse-workspace\\ejercicio4FicherosJava\\" + "ficheros4.csv";

	public static void main(String[] args) {
		textoInicial();
		lineaYposicion();

	}
	public static void textoInicial() {
		try {
			FileWriter escritor = new FileWriter(rutaArchivo);

			System.out.println("Añada contenido al archivo");
			String contenido = sc.nextLine();
			escritor.write(contenido + "\n");
			escritor.write("Este es un ejemplo de escritura en un archivo utilizando Java.\n");
			escritor.close();

			FileWriter escritorNuevo = new FileWriter(rutaArchivo, true);

			System.out.println("Añada más contenido al archivo");
			String contenidoNuevo = sc.nextLine();
			escritorNuevo.write(contenidoNuevo);

			// Cerrar el FileWriter
			escritorNuevo.close();
			

		} catch (IOException e) {
			System.out.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
			e.printStackTrace();
		}
	}
	public static void lineaYposicion() {

		System.out.println("Indique la linea que desea modificar");
			int numeroDeLinea = sc.nextInt();
    	 System.out.println("Introduce la posicion en la que deseas añadir el texto");
         int posicionDeInicio =sc.nextInt();
         System.out.println("Introduce el texto que deseas añadir");
         String textoAInsertar = sc.next();

         try {
             // Leer el archivo línea por línea y guardar cada línea en un StringBuilder
             BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo));
             StringBuilder contenido = new StringBuilder();
             String lineaActual;
             int contador = 0;
             while ((lineaActual = lector.readLine()) != null) {
                 contador++;
                 if (contador == numeroDeLinea) {
                     // Modificar la línea deseada
                     contenido.append(lineaActual.substring(0, posicionDeInicio)).append(textoAInsertar)
                             .append(lineaActual.substring(posicionDeInicio));
                 } else {
                     contenido.append(lineaActual);
                 }
                 contenido.append(System.lineSeparator());
             }
             lector.close();

             // Escribir el contenido modificado en el archivo
             BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaArchivo));
             escritor.write(contenido.toString());
             escritor.close();

             System.out.println("Se ha escrito en la posición específica de la línea exitosamente.");
         } catch (IOException e) {
             System.out.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
             e.printStackTrace();
         }
}
	}


