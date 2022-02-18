package tp03_ab.tp03.ejercicio1;
import tp02.ColaYPilaGenerica.*;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;   
	private ArbolBinario<T> hijoDerecho; 

	
	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	
	/**
	 * Preguntar antes de invocar si tieneHijoIzquierdo()
	 * @return
	 */
	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	 
	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo!=null;
	}

	 
	public boolean tieneHijoDerecho() {
		return this.hijoDerecho!=null;
	}

	

	public boolean esLleno() {
		return false;
	}

	 boolean esCompleto() {
		return false;
	}

	
	// imprime el Arbol en preorden  
	public void printPreorden() {
		if (!this.esVacio()) {
			System.out.print(this.getDato() + " - ");			
		}
		if(this.tieneHijoIzquierdo()) {
			this.getHijoIzquierdo().printPreorden();			
		}
		if(this.tieneHijoDerecho()) {
			this.getHijoDerecho().printPreorden();
		}
	}

	// imprime el Arbol en postorden
	public void printPostorden() {
		if(this.tieneHijoIzquierdo()) {
			this.getHijoIzquierdo().printPostorden();			
		}
		if(this.tieneHijoDerecho()) {
			this.getHijoDerecho().printPostorden();
		}
		if (!this.esVacio()) {
			System.out.print(this.getDato() + " - ");			
		}
	}


	public void recorridoPorNiveles() {
		ArbolBinario<T> arbol = null;
		ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>();
		cola.encolar(this);
		cola.encolar(null);
		
		while (!cola.esVacia()) {
			arbol = cola.desencolar();
			if (arbol != null && !cola.esVacia()) {
				
				System.out.print(arbol.getDato() + " | ");
				
				if (arbol.tieneHijoIzquierdo()) {
					cola.encolar(arbol.getHijoIzquierdo());
				}
				
				if (arbol.tieneHijoDerecho()) {
					cola.encolar(arbol.getHijoDerecho());
				}
				
			} else {
				if (!cola.esVacia()) {
					System.out.println();
					cola.encolar(null);
				}
			}
		}
	}

	

	public ListaGenerica<T> frontera() {
		ListaGenerica<T> l = new ListaEnlazadaGenerica<T>();
		return l;
	}

	
	public int contarHojas() { // Ver alternativas
		if (this.esVacio()) {
			return 0;
		} else {
			if (this.esHoja()) {
				return 1;
			} else {
				if (this.tieneHijoIzquierdo() && this.tieneHijoDerecho() ) {
					return this.getHijoIzquierdo().contarHojas() + this.getHijoDerecho().contarHojas();
				} else {
					if (this.tieneHijoDerecho()) {
						return this.getHijoDerecho().contarHojas();
					} else {
						return this.getHijoIzquierdo().contarHojas();
					}
				}
			}			
		}
	}
	
	public ArbolBinario<T> espejo(){
//		ArbolBinario<T> arbolEspejo = new ArbolBinario<T>();
		ArbolBinario<T> arbolEspejo = this;
		return this.espejo(arbolEspejo);
	}
	
	private ArbolBinario<T> espejo(ArbolBinario<T> unArbol){
		if (unArbol == null) {
			return unArbol;
		}
			
		ArbolBinario<T> izquierdo = this.espejo(unArbol.getHijoIzquierdo());
		
		ArbolBinario<T> derecho =  this.espejo(unArbol.getHijoDerecho());
		
		unArbol.agregarHijoIzquierdo(derecho);
		unArbol.agregarHijoDerecho(izquierdo);
		
		return unArbol;
	}
	
	

	

}
