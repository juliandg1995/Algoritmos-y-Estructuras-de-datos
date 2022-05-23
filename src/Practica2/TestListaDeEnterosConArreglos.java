package Practica2;
import java.util.Scanner;

import tp02.ListaDeEnteros.*;

public class TestListaDeEnterosConArreglos {

	public static void main(String[] args) {
		
		ListaDeEnteros lista = new ListaDeEnterosConArreglos();
		
		Scanner s = new Scanner(System.in);
		
		for(int i = 0; i < 6; i++) {
			System.out.print("Ingrese un numero a la lista: ");
			lista.agregarFinal(s.nextInt());
		}
		s.close();
		
		System.out.println("\n");
		
		lista.imprimirLista();
		
		
	}

}
