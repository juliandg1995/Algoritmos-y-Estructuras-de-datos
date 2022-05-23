package tp02.ejercicio4;
import tp02.ColaYPilaGenerica.PilaGenerica;
import java.util.Scanner;

public class TestBalanceo {
	
	PilaGenerica<Character> pila = new PilaGenerica<Character>();
	
	public boolean esDeApertura(char caracter) {
		switch(caracter) {
			case ')': break;
			case ']': break;
			case '}': break;
			default: return true;
		}
		return false;
	}
	
	public boolean consultarTopeDePila(Character caracter) { // ) ] }
		if((caracter == ')' && this.pila.tope() == '(') ||
		   (caracter == ']' && this.pila.tope() == '[') ||
		   (caracter == '}' && this.pila.tope() == '{')){
			return true;
		}
		return false;
	}
	
	public boolean esBalanceado(String str) {
		for (int i=0;i<str.length();i++) {
			if(esDeApertura(str.charAt(i))) {
				push(str.charAt(i));
			}
			else {
				if(!this.pila.esVacia() && consultarTopeDePila(str.charAt(i))){
					pop();
				}
				else {
					return false;
				}
			}
		}
		if(this.pila.esVacia()) {
			return true;
		}
		return false;
	}
	
	public void push(Character caracter) {
		pila.apilar(caracter);
	}
	
	public void pop() {
		pila.desapilar();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TestBalanceo test = new TestBalanceo();
		System.out.print("Ingrese el string: ");
		if(test.esBalanceado(sc.nextLine())) {
			System.out.print("Está balanceado");
		}
		else {
			System.out.print("Está desbalanceado");
		}
		sc.close();
	}
}