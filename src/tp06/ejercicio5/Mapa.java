package tp06.ejercicio5;
import tp06.*;
import tp02.ejercicio2.*;

public class Mapa {

	private Grafo<String> mapaCiudades;
	
	public Mapa(Grafo<String> mapaCiudades) {
		this.setMapaCiudades(mapaCiudades);
	}
	
	public Grafo<String> getMapaCiudades() {
		return mapaCiudades;
	}

	public void setMapaCiudades(Grafo<String> mapaCiudades) {
		this.mapaCiudades = mapaCiudades;
	}
	
// ------------------------------------ Devolver Camino ---------------------------------------------------------//	
	
	public ListaGenerica<String> devolverCamino(String ciudad1, String ciudad2){
		// Array of flags initialized
		boolean[] marca = new boolean[mapaCiudades.listaDeVertices().tamanio() + 1];
		
		// Needed object definition (the one that will be returned):
		ListaGenerica<String> ciudades = new ListaEnlazadaGenerica<String>();
		
		// Save nodes of graph in list for traversal:
		ListaGenerica<Vertice<String>> vertices = this.getMapaCiudades().listaDeVertices();
		vertices.comenzar();
		
		boolean termino = false;
		
		while (!vertices.fin() && !termino ) {
			Vertice<String> v = vertices.proximo();
			// If starting point is found, graph traversal begins
			if (v.dato().equals(ciudad1)) {				
				termino = devolverCamino(v.getPosicion(), this.getMapaCiudades(), ciudades, marca, ciudad2);
				break;
			}  
		}
		return ciudades;
	}
	
	private boolean devolverCamino(int i, Grafo<String> grafo,
				 				ListaGenerica<String> ciudades, boolean[] marca, String ciudad2) {
		// Mark the node as visited & set auxiliary variables
		marca[i] = true;		
		Arista <String> arista = null;
		int j = 0;
		
		// Identification of actual node of traversal
		Vertice<String> v = grafo.listaDeVertices().elemento(i);
		ciudades.agregarFinal(v.dato());
		// Initialize adjacent nodes list
		ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
		ady.comenzar();
		
		// Base case
		if (v.dato().equals(ciudad2)) {
			return true;
		}									
		
		boolean parar = false;
		
		// While there are non visited adjacent nodes inside list...
		while(!ady.fin()){
			arista = ady.proximo();
			j = arista.verticeDestino().getPosicion();	
			if(!marca[j]) {
				parar = devolverCamino(j, grafo, ciudades, marca, ciudad2);		// Recursive call				
			}
		}
		// If 'parar' = false, delete the last city added to traversal list, to try another path 
		if (!parar) {
			ciudades.eliminarEn(ciudades.tamanio());	// Deletes the last added city to the path list
		}
		return parar;
	}
		
// ----------------------------------------- Caminos Exceptuando -----------------------------------------------------------//
	
	ListaGenerica<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, ListaGenerica<String> exceptuadas) {
		boolean marca[] = new boolean[this.getMapaCiudades().listaDeVertices().tamanio() + 1];
		
		ListaGenerica<String> lisCiudades = new ListaEnlazadaGenerica<>();
		ListaGenerica<Vertice<String>> lisVertices = this.getMapaCiudades().listaDeVertices();
		lisVertices.comenzar();
		while (!lisVertices.fin()) {
			Vertice<String> v = lisVertices.proximo();
			if (v.dato().equals(ciudad1)) {
				devolverCaminoExceptuando(v.getPosicion(), this.getMapaCiudades(), lisCiudades, marca, ciudad2, exceptuadas);
				break;
			}
		}
		return lisCiudades;
	}
	
	private boolean devolverCaminoExceptuando(int i, Grafo<String> grafo, ListaGenerica<String>ciudades,
															boolean[] marca, String ciudad2, ListaGenerica<String> exceptuadas){
		marca[i] = true;
		Arista <String> arista = null;
		int j = 0;
		
		// Identification of actual node of traversal
		Vertice<String> v = grafo.listaDeVertices().elemento(i);
		ciudades.agregarFinal(v.dato());
		ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
		ady.comenzar();

		if (v.dato().equals(ciudad2)) {
			return true;
		}

		boolean parar = false;
		
		while(!ady.fin() && !parar){
			arista = ady.proximo();
			j = arista.verticeDestino().getPosicion();
			if(!marca[j] && !exceptuadas.incluye(arista.verticeDestino().dato())) {
				parar = devolverCaminoExceptuando(j, grafo, ciudades, marca, ciudad2, exceptuadas);		// Recursive call				
			}
		}
		
		if (!parar) {
			ciudades.eliminarEn(ciudades.tamanio());	//Se elimina por camino incorrecto
			marca[j] = false;							//Para camino futuro
		}
		return parar;
    }
	
// ------------------------------------------------ Camino Mas Corto -----------------------------------------------------------------//
  
	public ListaGenerica<String> caminoMasCorto(String ciudad1, String ciudad2){

		boolean marca[] = new boolean[this.getMapaCiudades().listaDeVertices().tamanio() + 1];
		
		Camino<String> caminoMin = new Camino<String>();
		Camino<String> camino = new Camino<>();
		ListaGenerica<Vertice<String>> lisVertices = this.getMapaCiudades().listaDeVertices();
		lisVertices.comenzar();
		while (!lisVertices.fin()) {
			Vertice<String> v = lisVertices.proximo();
			if (v.dato().equals(ciudad1)) {
				caminoMasCorto(v.getPosicion(), this.getMapaCiudades(), camino, caminoMin, marca, ciudad2);
				break;
			}
		}
		return caminoMin.getCamino();
    }
    
    private void caminoMasCorto(int i, Grafo<String> grafo, Camino<String> camino,
    							Camino<String> caminoMin, boolean[] marca, String finCamino){
    	marca[i] = true;
		Arista <String> arista = null;
		int j = 0;
		
		// Identification of actual node of traversal
		Vertice<String> v = grafo.listaDeVertices().elemento(i);
		camino.agregar(v.dato());
		ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
		ady.comenzar();
		
		if (v.dato().equals(finCamino)){
			if (caminoMin.estaVacio() || caminoMin.getTamanio() > camino.getTamanio()) {
				ListaGenerica<String> aux = camino.getCamino().clonar();
				caminoMin.guardarCamino(aux);
			}
		}
		
		while(!ady.fin()){
			arista = ady.proximo();
			j = arista.verticeDestino().getPosicion();
			if(!marca[j]) {
				caminoMasCorto(j, grafo, camino, caminoMin, marca, finCamino);		// Recursive call				
			}
		}
		camino.eliminarUltimo();
		marca[j] = false;
    }
    
 // ------------------------------------------------ Camino Sin Cargar Combustible -----------------------------------------------------------------//

    public ListaGenerica<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto){
		boolean marca[] = new boolean[this.getMapaCiudades().listaDeVertices().tamanio() + 1];
		
		Camino<String> caminoSinCargar = new Camino<>();
		ListaGenerica<Vertice<String>> lisVertices = this.getMapaCiudades().listaDeVertices();
		lisVertices.comenzar();
		boolean exito = false;
		while (!lisVertices.fin()) {
			Vertice<String> v = lisVertices.proximo();
			if (v.dato().equals(ciudad1)) {
				exito = caminoSinCargarCombustible(v.getPosicion(), this.getMapaCiudades(), caminoSinCargar, marca, ciudad2, tanqueAuto);
				break;
			}
		}
		if (exito) {
			return caminoSinCargar.getCamino();			
		} else {
			return null;
		}
    }
    
    private boolean caminoSinCargarCombustible(int i, Grafo<String> grafo, Camino<String> camino,
    							  boolean[] marca, String finCamino, int tanqueAuto){
		marca[i] = true;
		Arista <String> arista = null;
		int j = 0;
		
		// Identification of actual node of traversal
		Vertice<String> v = grafo.listaDeVertices().elemento(i);
		camino.agregar(v.dato());
		ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
		ady.comenzar();
		
		if (v.dato().equals(finCamino)){
			return true;
		}
		
		boolean parar = false;
		
		while(!ady.fin() && !parar){
			arista = ady.proximo();
			j = arista.verticeDestino().getPosicion();
			if(!marca[j]) {
				if (tanqueAuto > arista.peso()) {
					parar = caminoSinCargarCombustible(j, grafo, camino, marca, finCamino, tanqueAuto - arista.peso());		// Recursive call									
				}
			}
		}
		
		if (!parar) {
			camino.eliminarUltimo();
			marca[j] = false;
		}
		
		return parar;
}

    public ListaGenerica<String> caminoConMenorCargaDeCombustible(String ciudad1,String ciudad2,int tanqueAuto){

        return null;
    }
	
}
