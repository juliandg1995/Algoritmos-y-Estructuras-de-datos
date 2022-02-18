package tp04_ag.src.tp04.ejercicio1;


import tp02.ColaYPilaGenerica.ColaGenerica;
import tp02.ejercicio2.*;

public class AreaEmpresa {
	
	private String nombreEmpresa;
	private int retardo;
	
	public AreaEmpresa(String unNombre, int unRetardo) {
		this.nombreEmpresa = unNombre;
		this.retardo = unRetardo;
	}
	
	
	public int getRetardo() {
		return retardo;
	}
	
	public static int devolverMaximopromedio(ArbolGeneral<AreaEmpresa> unArbol) {
		
			ColaGenerica<ArbolGeneral<AreaEmpresa>> cola = new ColaGenerica<ArbolGeneral<AreaEmpresa>>();
			ArbolGeneral<AreaEmpresa> arbol = null;
			int nodosNivel = 0;
			int max = -1;
			int contador = 0;
			
			cola.encolar(unArbol);
			cola.encolar(null);
			
			while (!cola.esVacia()) {

				arbol = cola.desencolar();
				
				if (arbol == null && !cola.esVacia()) {
					
					
//					System.out.println("Contador = " + contador + " nodosNivel = " + nodosNivel );
					if ((contador / nodosNivel) > max) {
						max = contador / nodosNivel;
					}
					cola.encolar(null);
					contador = 0;
					nodosNivel = 0;
					
				} else {
					if (arbol != null) {
						
						if (arbol.getDato() != null) {
							contador += arbol.getDato().getRetardo();
						}						
						nodosNivel++;
						System.out.println("Contador = " + contador + " nodosNivel = " + nodosNivel );
						
						if (!arbol.esHoja()) {
							ListaGenerica<ArbolGeneral<AreaEmpresa>> hijos = arbol.getHijos();
//							hijos.comenzar();
//							while (!hijos.fin()) {
//								cola.encolar(hijos.proximo());
//							}
							for(int i = 1; i <= hijos.tamanio(); i++) {
								cola.encolar(hijos.elemento(i));
							}
						}
					}
				}
			}		
		
		return max;
	}
	

	public static void main(String[] args) {
		
		AreaEmpresa unaEmpresa;
		unaEmpresa = new AreaEmpresa("Pepsi", 15);
		ArbolGeneral<AreaEmpresa> arbol0 = new ArbolGeneral<AreaEmpresa>(unaEmpresa);
		unaEmpresa = new AreaEmpresa("CocaCola", 27);
		ArbolGeneral<AreaEmpresa> arbol1_1 = new ArbolGeneral<AreaEmpresa>(unaEmpresa);
		unaEmpresa = new AreaEmpresa("McDonalds", 16);
		ArbolGeneral<AreaEmpresa> arbol1_2 = new ArbolGeneral<AreaEmpresa>(unaEmpresa);
		arbol0.agregarHijo(arbol1_1); ; arbol0.agregarHijo(arbol1_2);
		
		System.out.println("El promedio maximo de retardo es de: " + devolverMaximopromedio(arbol0));
//		System.out.println(arbol0.getHijos().tamanio());
		
	}

}
