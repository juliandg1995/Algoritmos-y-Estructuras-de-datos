package Practica2;

import Ejercicio3.Estudiante;
import java.util.Scanner;
import tp02.ListaGenerica.*;

public class TestListaEnlazadaGenerica {
	

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		ListaEnlazadaGenerica<Estudiante> lista = new ListaEnlazadaGenerica<Estudiante>();

		for (int i= 0; i < 2; i++) {
			
			System.out.print(" \nNombre: "); String nombre= s.nextLine();
			
			System.out.print(" \nApellido: "); String apellido = s.nextLine();
			
			System.out.print(" \nComision: "); String  comision = s.nextLine();
			
			System.out.print(" \nEmail: "); String  mail = s.nextLine();
			
			System.out.print(" \nDireccion: "); String  direccion = s.nextLine();
			
			Estudiante unEstudiante = new Estudiante(nombre, apellido, comision, mail, direccion);
			
			lista.agregarFinal(unEstudiante);
			
		}
		
		s.close();
		
		lista.comenzar();
			
		System.out.println();
		
		System.out.print("Los datos de los estudiantes son los siguientes: \n\n");
		while(!lista.fin()) {
			System.out.print(lista.proximo().tusDatos());
		}
		
		
	}

}
