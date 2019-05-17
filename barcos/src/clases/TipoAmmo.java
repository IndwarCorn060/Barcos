package clases;

public enum TipoAmmo {
	
	NORMAL("Normal"),
	AP("Penetracion de armadura"),
	HE("Explosivo");
	
	private String descripcion;
	
	private TipoAmmo(String des) {
		this.descripcion = des;
	}
	
	public String getDescipcion() {
		return this.descripcion;
	}

}
