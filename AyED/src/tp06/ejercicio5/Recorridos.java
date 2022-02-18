package tp06.ejercicio5;
import tp06.*;
import tp02.ejercicio2.*;

public class Recorridos<T>  {
	
	public ListaGenerica<Vertice<T>> dfs(Grafo<T> grafo) {
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
		ListaGenerica<Vertice<T>> listaV = new ListaEnlazadaGenerica<Vertice<T>>();
		for (int i=0; i<grafo.listaDeVertices().tamanio(); i++){
			if (!marca[i]) 										  // si no está marcado
				this.dfs(i, grafo, marca, listaV);
		}
		return listaV;
	}
	
	private void dfs(int i, 
					 Grafo<T> grafo, 
					 boolean[] marca, 
					 ListaGenerica<Vertice<T>> listaV) {
		marca[i] = true;		// marco el vértice como visitado
		Arista <T> arista = null;
		int j = 0;
		Vertice<T> v = grafo.listaDeVertices().elemento(i);		// identifico el vertice procesado
		listaV.agregarFinal(v);									// proceso el vértice
		ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
		ady.comenzar();
		while(!ady.fin()){
			arista=ady.proximo();
			j = arista.verticeDestino().getPosicion();	// j identifica la pos del vertice destino correspondiente a cada arista
			if(!marca[j])								// si el vertice en pos j no fue visitado
				this.dfs(j, grafo, marca, listaV);		// ejecuta la recursion de este metodo
			}
	}
}
