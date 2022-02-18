package tp06.ejercicio5;

import tp06.*;
import tp02.ejercicio2.*;

public class Parcial {
	
	
	ListaGenerica<String> resolver (Grafo<String> ciudades, String origen, String destino, String noPasar1, String noPasar2){
		boolean marca[] = new boolean[ciudades.listaDeVertices().tamanio() + 1];
		Integer total = 0;
		Integer min = 9999999;
		Camino<String> caminoMin = new Camino<String>();
		Camino<String> camino = new Camino<>();
		ListaGenerica<Vertice<String>> lisVertices = ciudades.listaDeVertices();
		lisVertices.comenzar();
		while (!lisVertices.fin()) {
			Vertice<String> v = lisVertices.proximo();
			if (v.dato().equals(origen)) {
				devolverCaminoMinimoExceptuando(v.getPosicion(), ciudades, camino, caminoMin, marca, destino, noPasar1, noPasar2, total, min);
				break;
			}
		}
		return caminoMin.getCamino();
	}
	
	private boolean devolverCaminoMinimoExceptuando(int i, Grafo<String> grafo, Camino<String> camino, Camino<String> caminoMin,
											  		boolean[] marca, String ciudad2, String except1, String except2, Integer total, Integer min){
		marca[i] = true;
		Arista <String> arista = null;
		int j = 0;
		
		// Identification of actual node of traversal
		Vertice<String> v = grafo.listaDeVertices().elemento(i);
		camino.agregar(v.dato());
		ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
		ady.comenzar();
		
		if (v.dato().equals(ciudad2)) {
			if (total < min) {
				min = total;
				ListaGenerica<String> aux = camino.getCamino().clonar();
				caminoMin.guardarCamino(aux);
			}
			total = 0;
			return true;
		}
		
		boolean parar = false;
		
		while(!ady.fin()){
			arista = ady.proximo();
			j = arista.verticeDestino().getPosicion();
			total += arista.peso();
			String dato = arista.verticeDestino().dato();
			if(!marca[j] && !except1.equals(dato) && !except2.equals(dato)) {
				parar = devolverCaminoMinimoExceptuando(j, grafo, camino, caminoMin, marca, ciudad2, except1, except2, total, min);				
			}
		}
		
		if (!parar) {
			camino.eliminarUltimo();
			marca[j] = false;			
		}
		return parar;
	}
	
}
