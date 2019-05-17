package clases;

public enum Faccion {
	
	USS("America"),
	HMS("Inglaterra"),
	IJN("Japon"),
	KMS("Alemania"),
	OTRO("Otro");
	
	private String nacionalida;
	
	private Faccion(String nacionalidad) {
		this.nacionalida = nacionalidad;
	}
	
	public String getNacionalidad() {
		return this.nacionalida;
	}

}
