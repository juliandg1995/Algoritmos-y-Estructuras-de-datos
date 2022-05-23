package DragonesYPrincesas;

public abstract class Personaje {
	
	private String nombre;

	public Personaje(String nombre) {
		this.nombre = nombre;
	}
	
	public abstract boolean soyUnaPrincesa();
	public abstract boolean soyUnDragon();
	public abstract boolean soyUnAnimal();
	
}
