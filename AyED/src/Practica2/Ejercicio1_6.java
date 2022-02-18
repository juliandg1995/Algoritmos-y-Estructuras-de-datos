package Practica2;
import java.util.Scanner;

import tp02.ListaDeEnteros.*;

public class Ejercicio1_6 {
	
	public ListaDeEnterosEnlazada calcularSucesion(int i) {
		ListaDeEnterosEnlazada lista = new ListaDeEnterosEnlazada();
		return this.calcularSucesion(lista, i);
	}
	
	private ListaDeEnterosEnlazada calcularSucesion(ListaDeEnterosEnlazada unaLista, int n) {
		unaLista.agregarFinal(n);
		unaLista.comenzar();
		if(n != 1) {
			if ( n % 2 == 0) {
				n = n/2;
			} else {
				n = (n*3) + 1;
			}
			this.calcularSucesion(unaLista, n);
		}
		return unaLista;
	}

	public static void main(String[] args) {
		
		Ejercicio1_6 f = new Ejercicio1_6();
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Ingrese un numero para iniciar la sucesion: ");
		
		f.calcularSucesion(s.nextInt()).imprimirLista();;
		
		s.close();
		// Funciona de 10 rey
		
		
	}

}
