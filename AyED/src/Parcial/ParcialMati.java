package Parcial;
import tp02.ColaYPilaGenerica.ColaGenerica;
import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class ParcialMati {
	
	    public ListaEnlazadaGenerica<Integer> resolver(ArbolGeneral<Integer>arbol){
	    	
	        //Instancio las variables necesarias
	        System.out.println("Entro");
	        int total = 0;
	        int min = 9999;
	        ListaEnlazadaGenerica<Integer> listaMinima = new ListaEnlazadaGenerica<Integer>();
	        ListaEnlazadaGenerica<Integer> listaNivelActual = new ListaEnlazadaGenerica<Integer>();
	        int nivelActual = 0;
	        int nivelMinimo = 0;
	        
	        //Creo una cola en la que meteré el arbol entero con el encolar
	        ColaGenerica<ArbolGeneral<Integer>> cola = new ColaGenerica<ArbolGeneral<Integer>>();
	        cola.encolar(arbol);
	        
	        //Creo la variable sobre la cual desencolaré cada nodo del arbol previamente encolado
	        ArbolGeneral<Integer> arbolAuxiliar = null;
	        
	        //Encolo un null para marcar el fin del primer nivel
	        cola.encolar(null);
	        
	        //Itero mientras la cola no esté vacia
	        while(!cola.esVacia()) {
	        	
	            System.out.println("Entro al primer while");
	            //Desencolo un nodo sobre la variable
	            arbolAuxiliar = cola.desencolar();
	            
	            //Si el nodo no es null y la cola no es vacia significa que terminó el nivel
	            if(arbolAuxiliar == null && !cola.esVacia()) {
	            	
	                cola.encolar(null);
	                
	                //Empiezo a procesar las cosas en el cambio de nivel
	                if(total < min) {
	                	
	                    listaMinima.comenzar();
	                    while(!listaMinima.fin()) {
	                        listaMinima.eliminar(listaMinima.proximo());
	                    }
	                    min = total;
	                    nivelMinimo = nivelActual;
	                    listaMinima = listaNivelActual;
	                    
	                }
	                
	                // Reseteo de valores
	                total = 0;
	                nivelActual++;                
	            }
	            else {
	                //Acá significa que aún no terminó el nivel
	                if(arbolAuxiliar != null) {
	                	
	                    //Realizar acciones que se deban hacer a lo largo del nivel
	                    if(arbolAuxiliar.getDato() != null) {
	                        total += arbolAuxiliar.getDato();
	                        listaNivelActual.agregarFinal(arbolAuxiliar.getDato());
	                    }
	                    if(!arbolAuxiliar.esHoja()) {
	                        //Si no es hoja obtenemos los hijos
	                        ListaGenerica<ArbolGeneral<Integer>>hijos = arbolAuxiliar.getHijos();
	                        //Reacomodamos el puntero de la lista
	                        hijos.comenzar();
	                        //Mientras no se terminen los hijos, encolamos el próximo
	                        while (!hijos.fin()) {
	                            //Encolamos todos los hijos 1 por 1, pasando al siguiente con el metodo proximo
	                            cola.encolar(hijos.proximo());
	                        }
	                    }
	                }    
	            }
	        }
	        
	        //Acá va el retorno
	        System.out.println("El nivel minimo es: "+ nivelMinimo);
	        return listaMinima;
	    }    

}


