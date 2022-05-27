package Recorrido_niveles_suma_minima;
import Parcial.ArbolGeneral;
import tp02.ColaYPilaGenerica.ColaGenerica;
import tp02.ejercicio2.*;


//ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
//ListaEnlazadaGenerica<T> lista = new ListaEnlazadaGenerica<T>();
//ArbolGeneral<T> arbol = null;
//cola.encolar(this);
//cola.encolar(null);
//
//while (!cola.esVacia()) {
//	
//	arbol = cola.desencolar();
//	
//	if (arbol == null && !cola.esVacia()) {
//		cola.encolar(null);
//	} else {
//		if (arbol != null) {
//			if (arbol.getDato() != null) {
//				lista.agregarFinal(arbol.getDato());						
//			}
//			if (!arbol.esHoja()) {
//				ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();
//				hijos.comenzar();
//				while (!hijos.fin()) {
//					cola.encolar(hijos.proximo());
//				}						
//			}
//		}
//	}
//}
//	
//return lista;

public class SumaDeNiveles<T> {
	
	public Resultado resolver(ArbolGeneral<Integer> arbol) {
		
		int nivel = 0; int nivelMin = 0;
		int sumaNivelActual = 0;
		int sumaMinima = Integer.MAX_VALUE;
		ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
		lista.comenzar();
		ListaGenerica<Integer> listaResultado = new ListaEnlazadaGenerica<Integer>();
		ColaGenerica<ArbolGeneral<Integer>> cola = new ColaGenerica<ArbolGeneral<Integer>>();
		ArbolGeneral<Integer> actual;
		cola.encolar(arbol);
		cola.encolar(null);
		
		while (!cola.esVacia()) {
			
			actual = cola.desencolar();
			
			if (actual == null && !cola.esVacia()) {
				cola.encolar(null);
				nivel++;
				if (sumaNivelActual < sumaMinima) {
					sumaMinima = sumaNivelActual;
					nivelMin = nivel;
					listaResultado = lista.clonar();
				}
				lista = new ListaEnlazadaGenerica<Integer>();
				sumaNivelActual = 0;
			} else {
				if (actual != null) {
					if (actual.getDato() != null) {
						lista.agregarFinal(actual.getDato());
						sumaNivelActual += actual.getDato();
					}
					if (!actual.esHoja()) {
						ListaGenerica<ArbolGeneral<Integer>> hijos = arbol.getHijos();
						hijos.comenzar();
						while (!hijos.fin()) {
							cola.encolar(hijos.proximo());
						}						
					}
				}
			}	
		}
		return new Resultado(listaResultado, nivelMin);
	}
	
	

}
