package tp06.ejercicio5;
import tp02.ejercicio2.*;
import tp06.*;

public class Camino<T> {
	
	private ListaGenerica<T> listaDeElementos;
	private int costo;
	

	public Camino() {
		this.listaDeElementos = new ListaEnlazadaGenerica<T>();
		listaDeElementos.comenzar();
		this.costo = 0;
	}
	
	public void agregar(T dato) {
		listaDeElementos.agregarFinal(dato);
	}
	
	public void eliminarUltimo() {
		listaDeElementos.eliminarEn(listaDeElementos.tamanio());
	}
	
	public void sumarCosto(int unCosto) {
		costo += unCosto;
	}
	
	public int getCosto() {
		return costo;
	}
	
	public ListaGenerica<T> getCamino(){
		return listaDeElementos;
	}
	
	public boolean incluye(T unElemento) {
		return listaDeElementos.incluye(unElemento);
	}
	
	public boolean estaVacio() {
		return listaDeElementos.esVacia();
	}
	
	public void vaciarCamino() {
		listaDeElementos = new ListaEnlazadaGenerica<T>();
		Runtime.getRuntime().gc();
	}
	
	public int getTamanio(){
		return listaDeElementos.tamanio();
	}
	
	public void guardarCamino(ListaGenerica<T> unCamino) {
		listaDeElementos = unCamino;
	}

}
