package Parcial;
import tp02.ejercicio2.ListaEnlazadaGenerica;  // Usar este import -> Es el mismo que el que usa el arbol
import tp02.ejercicio2.ListaGenerica;


public class Parcial {
	
	public ListaGenerica<ListaGenerica<Integer>> resolver(ArbolGeneral<Integer> arbol){
		
		ListaGenerica<ListaGenerica<Integer>> listaDeCaminos = new ListaEnlazadaGenerica<ListaGenerica<Integer>>();
		
		if(!arbol.esVacio()) {
						
			ListaGenerica<Integer> caminosParciales = new ListaEnlazadaGenerica<Integer>();
			
			this.recorrer(listaDeCaminos, caminosParciales, arbol);
			
		}
		
		return listaDeCaminos;
		
	}
	
	private ListaGenerica<ListaGenerica<Integer>> recorrer(ListaGenerica<ListaGenerica<Integer>> listaDeListas, 
														   ListaGenerica<Integer> caminosParciales,
														   ArbolGeneral<Integer> arbol){
			if (arbol == null) {
				return listaDeListas;
			}
			
			// Checkeo si se cumple la condición para procesar el dato del camino
			if (arbol.getDato() < 0) {
				
				//Proceso el dato
				caminosParciales.agregarFinal(arbol.getDato());  
				
				// Como debo continuar el recorrido, consulto si tiene hijos
				if (arbol.tieneHijos()) {
					
					//Si el arbol tiene hijos, creo una variable auxiliar para almacenarlos (recibe una COPIA desde el getter)
					ListaGenerica<ArbolGeneral<Integer>> hijos = arbol.getHijos();
					
					// Como estoy en recursión utilizando siempre la misma estructura auxiliar, uso el comenzar
					hijos.comenzar();
					
					// Llamo recursivamente al método para que recorra todos los hijos
					while (!hijos.fin()) {
						
						// Creo variable auxiliar para obtener el proximo hijo
						ArbolGeneral<Integer> aux = hijos.proximo();
						// Recorro los hijos solo si el dato del proximo cumple la condición de procesado
						if (aux.getDato() < 0) {
							recorrer(listaDeListas, caminosParciales, aux);							
						}
					}
				} else {
					
					// Si es una hoja, y se cumple la condición < 0, agrego el camino a la lista.
					listaDeListas.agregarFinal((ListaEnlazadaGenerica<Integer>)(caminosParciales.clonar()));
				}	
			} else {
				
				return listaDeListas;
				// caminosParciales.eliminarEn(caminosParciales.tamanio());
			}	
			
		return listaDeListas;
	
	}
	
}