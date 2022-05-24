package ParcialDeNumerosNegativos;

import Parcial.ArbolGeneral;
import tp02.ejercicio2.*;

public class Parcial {

	public ListaGenerica<ListaGenerica<Integer>> resolver(ArbolGeneral<Integer> arbol){
		
		ListaGenerica<ListaGenerica<Integer>> listaResultado = new ListaEnlazadaGenerica<ListaGenerica<Integer>>();
		ListaGenerica<Integer> caminoActual = new ListaEnlazadaGenerica<Integer>();
		
		if (!arbol.esVacio()) {
			return resolverEjercicio(arbol,caminoActual,listaResultado);
		}
		return null;
	}
	
	private ListaGenerica<ListaGenerica<Integer>> resolverEjercicio(ArbolGeneral<Integer> arbol,
			ListaGenerica<Integer> caminoActual, ListaGenerica<ListaGenerica<Integer>> listaResultado){
		Integer dato = arbol.getDato();
		if (dato < 0) {
			caminoActual.agregarFinal(dato);
			if (arbol.esHoja()) {
				listaResultado.agregarFinal(caminoActual.clonar());
				return listaResultado;
			}
			
			ListaGenerica<ArbolGeneral<Integer>> hijos = arbol.getHijos();
			while (!hijos.fin()) {
				listaResultado = resolverEjercicio(hijos.proximo(), caminoActual, listaResultado);
				caminoActual.eliminarEn(caminoActual.tamanio());
				
			}
		}
		return listaResultado;
	}
	 
}
