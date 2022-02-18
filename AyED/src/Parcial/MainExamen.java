package Parcial;

import tp02.ejercicio2.ListaGenerica;

public class MainExamen {

	public static void main(String[] args) {
		
		ArbolGeneral<Integer> a1 = new ArbolGeneral<Integer>(-1);
		ArbolGeneral<Integer> a2 = new ArbolGeneral<Integer>(2);
		ArbolGeneral<Integer> a3 = new ArbolGeneral<Integer>(-3);

		a1.agregarHijo(a2); a1.agregarHijo(a3);
		
		ArbolGeneral<Integer> a21 = new ArbolGeneral<Integer>(0);
		ArbolGeneral<Integer> a22 = new ArbolGeneral<Integer>(11);
		ArbolGeneral<Integer> a31 = new ArbolGeneral<Integer>(12);
		ArbolGeneral<Integer> a32 = new ArbolGeneral<Integer>(8);
		ArbolGeneral<Integer> a33 = new ArbolGeneral<Integer>(-16);
		ArbolGeneral<Integer> a34 = new ArbolGeneral<Integer>(24);
		ArbolGeneral<Integer> a341 = new ArbolGeneral<Integer>(-22);
		ArbolGeneral<Integer> a342 = new ArbolGeneral<Integer>(-23);
		ArbolGeneral<Integer> a343 = new ArbolGeneral<Integer>(-40);
		a34.agregarHijo(a341); a34.agregarHijo(a342); a34.agregarHijo(a343);
		
		a2.agregarHijo(a21); a2.agregarHijo(a22); a3.agregarHijo(a31); a3.agregarHijo(a32); a3.agregarHijo(a33); a3.agregarHijo(a34); 
		
		Parcial parcial = new Parcial();
		
		ListaGenerica<ListaGenerica<Integer>> caminos = parcial.resolver(a1);
		
		System.out.println(caminos.elemento(1).toString());		
//		a1.recorridoPorNiveles();	
//		System.out.println(a1.recorridoPorNiveles().toString());	

	}

}
