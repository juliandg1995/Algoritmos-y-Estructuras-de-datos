package DragonesYPrincesas;

import Parcial.ArbolGeneral;
import tp02.ejercicio2.*;

public class Juego {
	
	public ListaEnlazadaGenerica<Personaje> encontrarPrincesa(ArbolGeneral<Personaje> arbol){
		ListaEnlazadaGenerica<Personaje> lista = new ListaEnlazadaGenerica<Personaje>();
		Personaje p = arbol.getDato();
		if (p.soyUnaPrincesa() || p.soyUnDragon() || arbol.esHoja()) {
			if (p.soyUnaPrincesa()) {
				lista.agregarInicio(p);
			}
			return lista;
		}
		
		ListaGenerica<ArbolGeneral<Personaje>> lHijos = arbol.getHijos();
		lHijos.comenzar();
		while (!lHijos.fin() && lista.esVacia()) {
			ArbolGeneral<Personaje> aux = lHijos.proximo();
			lista = this.encontrarPrincesa(aux);
			if (!lista.esVacia()) {
				lista.agregarInicio(p);
				// Break para cuando encuentra la princesa. Agrega todo el recorrido a la lista
			}
		}
		return lista;
	}

}
