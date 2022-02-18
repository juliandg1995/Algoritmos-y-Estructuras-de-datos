package Parcial;
import tp02.ColaYPilaGenerica.ColaGenerica;
import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}
	
	public boolean tieneHijos() {
		return !this.hijos.esVacia();
	}
	
	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}
	
	// Devuelve una lista en preorden:
	public ListaEnlazadaGenerica<T> preOrden() {
	
		ListaEnlazadaGenerica<T> lista = new ListaEnlazadaGenerica<T>();
		lista.comenzar();
		ArbolGeneral<T> auxiliar = this;
		
		return this.preOrden(lista, auxiliar);
		
	}
		
	private ListaEnlazadaGenerica<T> preOrden( ListaEnlazadaGenerica<T> unaLista, ArbolGeneral<T> arbol){
		
		if (arbol == null) {
			return null;
		}
		
		unaLista.agregarFinal(arbol.getDato());
		
		arbol.getHijos().comenzar();
		while (!arbol.getHijos().fin()) {
			preOrden (unaLista, arbol.getHijos().proximo());
		}
		return unaLista;
	}
	
	// Devuelve una lista en Postorden:
	public ListaEnlazadaGenerica<T> postOrden() {
		
		ListaEnlazadaGenerica<T> lista = new ListaEnlazadaGenerica<T>();
		ArbolGeneral<T> auxiliar = this;
		lista.comenzar();
		
		return this.postOrden(lista, auxiliar);
	}
	
	private ListaEnlazadaGenerica<T> postOrden( ListaEnlazadaGenerica<T> unaLista, ArbolGeneral<T> arbol){
		
		if (arbol == null) {
			return null;
		}
		
		arbol.getHijos().comenzar();
		while (!arbol.getHijos().fin()) {
			postOrden (unaLista, arbol.getHijos().proximo());
		}
		unaLista.agregarFinal(arbol.getDato());
		return unaLista;
	}
	
	// Devuelve una lista en inorden:
	public ListaEnlazadaGenerica<T> inOrden() {
		
		ListaEnlazadaGenerica<T> lista = new ListaEnlazadaGenerica<T>();
		lista.comenzar();
		ArbolGeneral<T> auxiliar = this;
		
		return this.inOrden(lista, auxiliar);
	}
	
	private ListaEnlazadaGenerica<T> inOrden( ListaEnlazadaGenerica<T> unaLista, ArbolGeneral<T> arbol){
		
		if (arbol == null) {
			return null;
		}
		
		inOrden (unaLista, arbol.getHijos().proximo());
		
		unaLista.agregarFinal(arbol.getDato());
		
		arbol.getHijos().comenzar();
		while (!arbol.getHijos().fin()) {
			inOrden (unaLista, arbol.getHijos().proximo());
		}
		return unaLista;
	}
	
	public ListaEnlazadaGenerica<T> recorridoPorNiveles(){
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
		ListaEnlazadaGenerica<T> lista = new ListaEnlazadaGenerica<T>();
		ArbolGeneral<T> arbol = null;
		cola.encolar(this);
		cola.encolar(null);
		
		while (!cola.esVacia()) {
			
			arbol = cola.desencolar();
			
			if (arbol == null && !cola.esVacia()) {
				cola.encolar(null);
			} else {
				if (arbol != null) {
					if (arbol.getDato() != null) {
						lista.agregarFinal(arbol.getDato());						
					}
					if (!arbol.esHoja()) {
						ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();
						hijos.comenzar();
						while (!hijos.fin()) {
							cola.encolar(hijos.proximo());
						}						
					}
				}
			}
		}
			
		return lista;
		
	}
	
	
	public Integer altura() {
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
		ArbolGeneral<T> arbol = null;
		int altura = 0;
		
		cola.encolar(this);
		cola.encolar(null);
		
		while (!cola.esVacia()) {
			
			arbol = cola.desencolar();
			
			if (arbol == null && !cola.esVacia()) {
				cola.encolar(null);
				altura++;
			} else {
				if (arbol != null) {
					if (!arbol.esHoja()) {
						ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();
						hijos.comenzar();
						while (!hijos.fin()) {
							cola.encolar(hijos.proximo());
						}						
					}
				}
			}
		}		
		return altura;
	}

	public Integer nivel(T dato) {
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
		ArbolGeneral<T> arbol = null;
		int nivel = 0;
		
		cola.encolar(this);
		cola.encolar(null);
		
		while (!cola.esVacia()) {
			
			arbol = cola.desencolar();
			
			if (arbol == null && !cola.esVacia()) {
				cola.encolar(null);
				nivel++;
			} else {
				if (arbol != null) {
					if (arbol.getDato() == dato) {					
						return nivel;
					}
					if (!arbol.esHoja()) {
						ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();
						hijos.comenzar();
						while (!hijos.fin()) {
							cola.encolar(hijos.proximo());
						}						
					}
				}
			}
		}		
		return -1;
	}

	public Integer ancho() {
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
		ArbolGeneral<T> arbol = null;
		int nivel = 0;
		int contador = 0;
		int max = -1;
		
		cola.encolar(this);
		cola.encolar(null);
		
		while (!cola.esVacia()) {
			
			arbol = cola.desencolar();
			
			if (arbol == null && !cola.esVacia()) {
				if (contador > max) {
					max = contador;
				}
				cola.encolar(null);
				nivel++;
				contador = 0;
			} else {
				if (arbol != null) {
					
					if (!arbol.esHoja()) {
						ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();
						hijos.comenzar();
						while (!hijos.fin()) {
							cola.encolar(hijos.proximo());
							contador++;
						}						
					}
				}
			}
		}		
		return max;
	}
	

}