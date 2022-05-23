package tp04_ag.src.tp02.ejercicio2;

import tp02.ejercicio2.ListaGenerica;
import tp04_ag.src.tp04.ejercicio1.*;

public class TestArbolGeneral {

	public static void main(String[] args) {

		ArbolGeneral<String> a1 = new ArbolGeneral<String>("1");
		ArbolGeneral<String> a2 = new ArbolGeneral<String>("2");
		ArbolGeneral<String> a3 = new ArbolGeneral<String>("3");

		a1.agregarHijo(a2); a1.agregarHijo(a3);
		
		ArbolGeneral<String> a21 = new ArbolGeneral<String>("0");
		ArbolGeneral<String> a22 = new ArbolGeneral<String>("11");
		ArbolGeneral<String> a31 = new ArbolGeneral<String>("12");
		ArbolGeneral<String> a32 = new ArbolGeneral<String>("8");
		ArbolGeneral<String> a33 = new ArbolGeneral<String>("16");
		ArbolGeneral<String> a34 = new ArbolGeneral<String>("24");
		ArbolGeneral<String> a341 = new ArbolGeneral<String>("22");
		ArbolGeneral<String> a342 = new ArbolGeneral<String>("23");
		ArbolGeneral<String> a343 = new ArbolGeneral<String>("40");
		a34.agregarHijo(a341); a34.agregarHijo(a342); a34.agregarHijo(a343);
		
		a2.agregarHijo(a21); a2.agregarHijo(a22); a3.agregarHijo(a31); a3.agregarHijo(a32); a3.agregarHijo(a33); a3.agregarHijo(a34); 
		
		System.out.println(a1.postOrden().toString());
		System.out.println(a1.preOrden().toString());
//		System.out.println(a1.inOrden().toString());
		System.out.println(a1.recorridoPorNiveles().toString());
		System.out.println(a1.recorridoPorNiveles().toString());
		System.out.println("La altura del arbol es: " + a1.altura());
		System.out.println("El dato 1 se encuentra en el nivel: " + a1.nivel("1"));
		System.out.println("El ancho del arbol es: " + a1.ancho());
		
		
		
	}

}
