package tp02.ColaYPilaGenerica;
import tp02.ListaGenerica.*;

public class ColaGenerica<T> {
	
	private ListaGenerica<T> datos;
	
	public ColaGenerica (){
		this.datos = new ListaEnlazadaGenerica<T>();
		this.datos.comenzar();
	}
	
	public void encolar(T elem) {
		this.datos.agregarFinal(elem);
	}
	
	public T desencolar() {
        T primero = this.datos.elemento(1);
        this.datos.eliminarEn(1);
        return primero;
    }
	
	public T tope() {
		return this.datos.elemento(1);
	}
	
	public boolean esVacia() {
		return this.datos.esVacia();
	}
}
