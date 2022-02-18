package tp06.ejercicio5;
import tp06.*;
import tp02.ejercicio2.*;

public class ParcialMati {
	
	public ListaGenerica<String>resolver(Grafo<String> ciudades,String origen,String destino,String noPasar1,String noPasar2){	
		boolean marca[] = new boolean[ciudades.listaDeVertices().tamanio() + 1];
		ListaGenerica<String> exceptuadas = new ListaEnlazadaGenerica<String>();
		exceptuadas.agregarFinal(noPasar1);
		exceptuadas.agregarFinal(noPasar2);
		Camino<String> caminoMin = new Camino<String>();
		Camino<String> camino = new Camino<>();
		ListaGenerica<Vertice<String>> lisVertices = ciudades.listaDeVertices();
		int total = 0;
		int min = 99999;
		
		lisVertices.comenzar();
		while (!lisVertices.fin()) {
			Vertice<String> v = lisVertices.proximo();
			if (v.dato().equals(origen)) {
				devolverCaminoExceptuando(v.getPosicion(),ciudades,marca,destino,exceptuadas,camino,caminoMin,total,min);
				break;
			}
		}
		return caminoMin.getCamino();
	}
	
	
	
	
	private boolean devolverCaminoExceptuando(int i, Grafo<String> grafo,boolean[] marca, String ciudad2, ListaGenerica<String>exceptuadas,Camino<String> camino,Camino<String> caminoMin,int total,int min){
		marca[i] = true;
		Arista <String> arista = null;
		int j = 0;
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
			total = total + arista.peso();
			j = arista.verticeDestino().getPosicion();
			if(!marca[j] && !exceptuadas.incluye(arista.verticeDestino().dato())) {
				parar = devolverCaminoExceptuando(j,grafo,marca,ciudad2,exceptuadas,camino,caminoMin,total,min);				
			}
		}
		if (!parar) {
			camino.eliminarUltimo();
			marca[j] = false;			
		}
		return parar;
	}
}
