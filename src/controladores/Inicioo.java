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
	static String rutaArchivo = "C:\\Users\\Usuario\\eclipse-workspace\\ejercicio4FicherosJava\\" + "ficheros4.txt";

	public static void main(String[] args) {
		//////////////////////////////////////////////
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
			
			lineaYposicion();

		} catch (IOException e) {
			System.out.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
			e.printStackTrace();
		}

	}

	public static void lineaYposicion() {

		try {
			System.out.println("Indique la linea que desea modificar");
			int numeroDeLinea = sc.nextInt();
			System.out.println("Indique la posicion que desea modificar");
			int posicionDeInicio = sc.nextInt();
			System.out.println("Indique el texto que desea añadir");
			String textoAInsertar = sc.nextLine();
			
			BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo));
			StringBuilder nuevo = new StringBuilder();
			String lineaActual;
			int contador = 0;
			while ((lineaActual = lector.readLine()) != null) {
				contador++;
				if (contador == numeroDeLinea) {
					// Modificar la línea deseada
					nuevo.append(lineaActual.substring(0, posicionDeInicio)).append(textoAInsertar)
							.append(lineaActual.substring(posicionDeInicio));
				} else {
					nuevo.append(lineaActual);
				}
				nuevo.append(System.lineSeparator());
			}
			lector.close();
			BufferedWriter escritor2 = new BufferedWriter(new FileWriter(rutaArchivo));
			escritor2.write(nuevo.toString());
			escritor2.close();
		}
		catch (IOException e) {
			System.out.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
			e.printStackTrace();
		}
		
	}

}
