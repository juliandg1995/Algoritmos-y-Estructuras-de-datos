package Parcial2;

public class Parcial {
	
	public boolean resolver(ArbolBinario<Integer> arbol) {
		
		if (arbol == null || arbol.esHoja()) {
			return true;
		}
		
		if (arbol.getHijoIzquierdo() != null && arbol.getHijoDerecho() == null) {
			
			return this.resolverIzquierda(arbol);
			
		} else {
			
			if (arbol.getHijoIzquierdo() == null && arbol.getHijoDerecho() != null) {
				
				return this.resolverDerecha(arbol);
				
			}
		}
		
		return false;
		
	}
	
	private boolean resolverIzquierda(ArbolBinario<Integer> arbol) {
		
		if (arbol == null || arbol.esHoja()) {
			return true;
		}
		
		if (arbol.getHijoIzquierdo() != null && arbol.getHijoDerecho() == null) {
			return this.resolverIzquierda(arbol.getHijoIzquierdo());
		} else {
			return false;
		}
	}
	
	private boolean resolverDerecha(ArbolBinario<Integer> arbol) {
		
		if (arbol == null || arbol.esHoja()) {
			return true;
		}
		
		if (arbol.getHijoIzquierdo() == null && arbol.getHijoDerecho() != null) {
			return this.resolverDerecha(arbol.getHijoDerecho());
		} else {
			return false;
		}
	}

}
