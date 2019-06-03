package clases;

public enum TipoBarco {
	
	DESTROYER("Destructor",TipoArmor.LIGHT),
	LIGHT_CRUISER("Crucero Ligero",TipoArmor.MEDIUM),
	HEAVY_CRUISER("Crucero Pesado",TipoArmor.HEAVY),
	AIRCRAFT_CARRIER("Portaaviones",TipoArmor.MEDIUM),
	BATTLESHIP("Barco de Guerra",TipoArmor.HEAVY);

	private String nombre;
	private TipoArmor armor;
	
	private TipoBarco(String nombre, TipoArmor armor) {
		this.nombre = nombre;
		this.armor = armor;
	}
	
	public TipoArmor getTipoArmor() {
		return this.armor;
	}
	
	public String getNombre() {
		return this.nombre;
	}
}
