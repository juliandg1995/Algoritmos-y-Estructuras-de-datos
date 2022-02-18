package tp02.ColaYPilaGenerica;

import tp02.ListaGenerica.ListaEnlazadaGenerica;
import tp02.ListaGenerica.ListaGenerica;

public class PilaGenerica<T> {
	
	private ListaGenerica<T> datos;

	public PilaGenerica() {
		this.datos = new ListaEnlazadaGenerica<T>();
		this.datos.comenzar();
	}
	
	public void apilar(T elem) {
		this.datos.agregarFinal(elem);
	}
	
	public T desapilar() {
        T ultimo = this.datos.elemento(this.datos.tamanio());
        this.datos.eliminarEn(this.datos.tamanio());
        return ultimo;
    }
	
	public T tope() {
		return this.datos.elemento(this.datos.tamanio());
	}
	
	public boolean esVacia() {
		return this.datos.esVacia();
	}
	
	
}
