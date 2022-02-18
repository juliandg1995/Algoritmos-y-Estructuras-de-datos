package Practica2;
import java.util.Scanner;

import tp02.ListaDeEnteros.*;


public class TestListaDeEnterosEnlazada {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("Ingrese un numero a la lista: ");
		ListaDeEnterosEnlazada lista = new ListaDeEnterosEnlazada(s.nextInt());
		
		for(int i = 0; i < 3; i++) {
			System.out.print("Ingrese un numero a la lista: ");
			lista.agregarFinal(s.nextInt());
		}
		s.close();
		
		System.out.println("\n Lista en Orden: \n");
		
		lista.imprimirLista();
		
		System.out.println("\n\nLista en Orden inverso: \n");
		
		lista.imprimirInversa(lista); // Funciona con el método custom definido

	}

}
