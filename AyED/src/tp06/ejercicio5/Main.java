package tp06.ejercicio5;

import tp06.*;
import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class Main{

	public static void main(String[] args) {
		Grafo<String> grafo = new GrafoImplListAdy<>();
		Vertice<String> [] ArVer= new Vertice [9];
		ArVer[1]= new VerticeImplListAdy<>("La Plata");
		grafo.agregarVertice(ArVer[1]);
		ArVer[2]= new VerticeImplListAdy<>("Arana");
		grafo.agregarVertice(ArVer[2]);
		ArVer[3]= new VerticeImplListAdy<>("Los Hornos");
		grafo.agregarVertice(ArVer[3]);
		ArVer[4]= new VerticeImplListAdy<>("Quilmes");
		grafo.agregarVertice(ArVer[4]);
		ArVer[5]= new VerticeImplListAdy<>("Abasto");
		grafo.agregarVertice(ArVer[5]);
		ArVer[6]= new VerticeImplListAdy<>("Villa Elisa");
		grafo.agregarVertice(ArVer[6]);
		ArVer[7]= new VerticeImplListAdy<>("Domselaar");
		grafo.agregarVertice(ArVer[7]);
		ArVer[8]= new VerticeImplListAdy<>("Pereyra");
		grafo.agregarVertice(ArVer[8]);
		
		
		//--------------------V0--------------------//
		grafo.conectar(ArVer[1], ArVer[2], 30);//V0 - V1
		//--------------------V1--------------------//
		grafo.conectar(ArVer[1], ArVer[3], 10);//V1 - V2
//		grafo.conectar(ArVer[1], ArVer[4], 5);//V1 - V2
//		grafo.conectar(ArVer[1], ArVer[4], 55);//V1 - V4
		grafo.conectar(ArVer[1], ArVer[8], 30);//V1 - V2
		
		//--------------------V2--------------------//
		grafo.conectar(ArVer[2], ArVer[5], 20);//V2 - V3
		
		//--------------------V3--------------------//
		grafo.conectar(ArVer[3], ArVer[5], 25);//V3 - V4
		grafo.conectar(ArVer[3], ArVer[6], 15);//V3 - V4
		
		//--------------------V4--------------------//
		grafo.conectar(ArVer[4], ArVer[6], 32);//V4 - V5
		
		//--------------------V5--------------------//
		grafo.conectar(ArVer[5], ArVer[7], 40);//V5 - V2
		
		grafo.conectar(ArVer[6], ArVer[7], 35);//V5 - V6
		
		//--------------------V8--------------------//
		grafo.conectar(ArVer[8], ArVer[4], 10);//V1 - V2
		//--------------------Fin--------------------//
		
//		Mapa unMapa = new Mapa(grafo);
//		ListaGenerica<String> lisCiudades = new ListaEnlazadaGenerica<>();
//		lisCiudades = unMapa.caminoSinCargarCombustible("La Plata", "Quilmes", 30);
////		System.out.println(lisCiudades.toString());
//		if (lisCiudades != null) {
//			while(!lisCiudades.fin()) {
//				System.out.println(lisCiudades.proximo());
//			}			
//		}
		
		ParcialMati p = new ParcialMati();
		ListaGenerica<String> lisPar = new ListaEnlazadaGenerica<>();
		lisPar = p.resolver(grafo, "La Plata", "Quilmes", "", "Bernal");
		if (lisPar != null) {
			while(!lisPar.fin()) {
				System.out.println(lisPar.proximo());
			}			
		}
	}

}

