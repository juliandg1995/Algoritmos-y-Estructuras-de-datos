package Parcial2;

public class MainExamen2 {

	public static void main(String[] args) {
		
		ArbolBinario<Integer> arbolDegIzq = new ArbolBinario<Integer>(0);
		
		for (int i = 0; i < 10; i++) {
			arbolDegIzq.agregarHijoIzquierdo(new ArbolBinario<Integer>(1));
		}
		
		ArbolBinario<Integer> arbolDegDer = new ArbolBinario<Integer>(0);
		
		for (int i = 0; i < 10; i++) {
			arbolDegDer.agregarHijoDerecho(new ArbolBinario<Integer>(2));
		}
		
		ArbolBinario<Integer> arbolQueNoCumple = new ArbolBinario<Integer>(0);
		
		for (int i = 0; i < 10; i++) {
			arbolQueNoCumple.agregarHijoDerecho(new ArbolBinario<Integer>(3));
		}
		
		arbolQueNoCumple.agregarHijoIzquierdo(new ArbolBinario<Integer>(3));
		
		arbolQueNoCumple.agregarHijoDerecho(new ArbolBinario<Integer>(3));
		
		
		
		Parcial parcial = new Parcial();
		
		if (parcial.resolver(arbolQueNoCumple)) {
			System.out.println("El arbol es degenerado hacia izquierda o derecha");
		} else {
			System.out.println("El arbol no cumple con la condición");
		}

	}

}