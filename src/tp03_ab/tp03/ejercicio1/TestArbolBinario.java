package tp03_ab.tp03.ejercicio1;
import tp02.ColaYPilaGenerica.*;

public class TestArbolBinario {

	public static void main(String[] args) {
		
		ArbolBinario<Integer> nodoRaiz = new ArbolBinario<Integer>(40);
		nodoRaiz.agregarHijoIzquierdo(new ArbolBinario<Integer>(2));
		nodoRaiz.agregarHijoDerecho(new ArbolBinario<Integer>(15));
		nodoRaiz.getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<Integer>(24));
		nodoRaiz.getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<Integer>(37));
		nodoRaiz.getHijoDerecho().agregarHijoDerecho(new ArbolBinario<Integer>(22));
		
		
		System.out.println("La cantidad de hojas del arbol es: " + nodoRaiz.contarHojas());
		
		System.out.println("\n");
		
		nodoRaiz.printPostorden();
		
		System.out.println("\n");
		
		ArbolBinario<Integer> arbolEspejo = nodoRaiz.espejo();
		arbolEspejo.printPreorden();
		
		System.out.println("\n");
		
//		ColaGenerica<Integer> unaCola = new ColaGenerica<Integer>();
//		unaCola.encolar(22);
//		unaCola.encolar(33);
//		unaCola.encolar(44);
//		unaCola.encolar(55);
//		
//		while (!unaCola.esVacia()) {
//			System.out.print(unaCola.desencolar() + " - ");
//		}
		
		nodoRaiz.recorridoPorNiveles();
		
		System.out.println("\n");
		
		// Test del contador de numeros pares
		
		ContadorArbol contador = new ContadorArbol();
		contador.setArbol(nodoRaiz);
		contador.numerosPares().toString();
		
		contador.numerosPares().imprimirLista();
		
		System.out.println("\n\nEl mayor retardo del recorrido es de: " + contador.retardoEnvio());
	
		System.out.println("El total de nodos en el nivel 1 es de: " + contador.profundidadDeArbolBinario(1));

	}

}
