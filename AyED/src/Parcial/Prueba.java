package Parcial;

public class Prueba {

	public char charCounter(String cadena){
		cadena = cadena.toLowerCase();
		int max = 0;
		int diff;
		char maxChar = '\0';
		for(char c = 'a'; c <= 'z'; c++) {
			diff = cadena.length() - cadena.replace("" + c, "").length();
			if(diff > max) {
				maxChar = c;
				max = diff;
			}
		}
		return maxChar;
	}
	public static void main(String[] args) {
		
		Prueba unaPrueba = new Prueba();
		
		System.out.print("El caracter con mayor numero de ocurrencias es: " + unaPrueba.charCounter("AAAnnn55555555555555555555555555555bbbl12354jljlollol    oooooo  jla55555ksdjkl oooooooLLaAaAaAa"));


	}

}
