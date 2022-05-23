package Prueba;

public class Main {

	public static void main(String[] args) {
		
		ClaseA a = new ClaseA(5);
		ClaseA b = new ClaseA(9);
		
		System.out.println(b.getNum());
		System.out.println(reemplazar(a,b));
		System.out.println(b.getNum());
		modificar(a,b);
		System.out.println(a.getNum());
	}
	
	public static int reemplazar(ClaseA a, ClaseA b) {
		b = a;
		return b.getNum();
	}
	
	public static void modificar(ClaseA a, ClaseA b) {
		a.setNum(b.getNum());
	}

}
