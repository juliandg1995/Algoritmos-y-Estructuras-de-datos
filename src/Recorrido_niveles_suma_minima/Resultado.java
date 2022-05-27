package Recorrido_niveles_suma_minima;
import tp02.ejercicio2.*;

public class Resultado {
	
	private ListaGenerica<Integer> lista;
	private int nivel;
	
	public Resultado(ListaGenerica<Integer> unaLista, int unNivel) {
		lista = unaLista;
		nivel = unNivel;
	}

	public ListaGenerica<Integer> getLista() {
		return lista;
	}

	public int getNivel() {
		return nivel;
	}
	
	
}
