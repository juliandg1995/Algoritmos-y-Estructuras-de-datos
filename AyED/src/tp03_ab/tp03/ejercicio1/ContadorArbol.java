package tp03_ab.tp03.ejercicio1;
import tp02.ColaYPilaGenerica.ColaGenerica;
import tp03_ab.tp02.ejercicio2.*;

public class ContadorArbol {
	
	ArbolBinario<Integer> arbol;
	
	// Constructor	
	public ContadorArbol() {
		
		arbol = new ArbolBinario<Integer>();
				
	}
	
	// Getters y setters
	public ArbolBinario<Integer> getArbol(){
		return this.arbol;
	}
	
	public void setArbol(ArbolBinario<Integer> unArbol) {
		this.arbol = unArbol;
	}
	
	// Devuelve todos los nros pares de un arbol
	public ListaGenerica<Integer> numerosPares(){
		
		 ListaGenerica<Integer> unaLista = new ListaEnlazadaGenerica<Integer>();
		 
		 if (this.arbol.esVacio()) {
			 return null;
		 }
		 return numerosPares(unaLista, this.getArbol());			 
	}
	
	private ListaGenerica<Integer> numerosPares(ListaGenerica<Integer> lista, ArbolBinario<Integer> unArbol){
		
		// Solucion InOrden: 
		
		if (unArbol.tieneHijoIzquierdo()){
			 this.numerosPares(lista, unArbol.getHijoIzquierdo());
		 }
		 
		 if (unArbol.getDato() % 2 == 0) {
			 lista.agregarInicio(unArbol.getDato());
		 }
		 
		 if (unArbol.tieneHijoDerecho()) {
			 this.numerosPares(lista, unArbol.getHijoDerecho());
		 }	 
		 
		 // Solucion PostOrden 
		 
//		 if (unArbol.tieneHijoIzquierdo()) {
//			 this.numerosPares(lista, unArbol.getHijoIzquierdo());
//		 }
//		 
//		 if (unArbol.tieneHijoDerecho()) {
//			 this.numerosPares(lista, unArbol.getHijoDerecho());
//		 }
//		 
//		 if (unArbol.getDato() % 2 == 0) {
//			 lista.agregarInicio(unArbol.getDato());
//		 }
		 
		 	return lista;
		 
		}
	
	public  Integer retardoEnvio() {
		if (this.arbol.esVacio()){
			
			return 0;
		} else
			return posOrden(this.arbol);
	}
	
	private  Integer posOrden(ArbolBinario<Integer> arbol) {
		if (arbol.esHoja())
			return arbol.getDato();
		else {
			int izq = 0;
			int der = 0;
			if (arbol.tieneHijoIzquierdo()) {
				izq = posOrden(arbol.getHijoIzquierdo());
			}
			if(arbol.tieneHijoDerecho()) {
				der = posOrden(arbol.getHijoDerecho());
			}
			if (izq > der)
				return izq + arbol.getDato();
			else
				return der + arbol.getDato();
		}		
	}
	
	public int profundidadDeArbolBinario(int unNivel) {
		
		ArbolBinario<Integer> arbol = null;
		ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<ArbolBinario<Integer>>();
		cola.encolar(this.arbol);
		cola.encolar(null);
		int nivel = 0;
		int total = 0;
		
		while (!cola.esVacia() && nivel <= unNivel) {
			arbol = cola.desencolar();
			
			if (nivel == unNivel && arbol != null) {
				total += arbol.getDato();
			}
			
			if (arbol != null && !cola.esVacia()) {
				
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
					nivel++;
				}
			}
		}
		
		return total;
		
	}
	
	

}

