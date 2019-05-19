package clases;

public class Barco implements Comparable<Barco>{
	
	private String codigo, nombre, clase;
	private Faccion faccion;
	private TipoBarco tipo;
	private int[] stats;//vida, firepoer, antiaereo, torpedo, aviacion, reload, evasion
	private TipoEquipamiento[] tipoSlot;//2 slots siempre seran para equipamiento auxiliar
	private Equipamiento[] slot;
	
	//cod, nombre, clase, faccion, tipo, hp, fp, aa, trp, avi, rld, eva, tSlot1, tSlot2, Tslot3
	public Barco(String cod, String nombre, String clase, Faccion faccion, TipoBarco tipo, 
				int hp, int fp, int aa, int trp, int avi, int rld, int eva, 
				TipoEquipamiento tSlot1, TipoEquipamiento tSlot2, TipoEquipamiento tSlot3) {
		this.codigo = cod;
		this.nombre = nombre;
		this.clase = clase;
		this.faccion = faccion;
		this.tipo = tipo;
		this.stats = new int[7];
		this.stats[0] = hp;
		this.stats[1] = fp;
		this.stats[2] = aa;
		this.stats[3] = trp;
		this.stats[4] = avi;
		this.stats[5] = rld;
		this.stats[6] = eva;
		this.tipoSlot = new TipoEquipamiento[5];
		this.tipoSlot[0] = tSlot1;
		this.tipoSlot[1] = tSlot2;
		this.tipoSlot[2] = tSlot3;
		this.tipoSlot[3] = TipoEquipamiento.AUXILIAR;
		this.tipoSlot[4] = TipoEquipamiento.AUXILIAR;
		this.slot = new Equipamiento[5];
		this.slot[0] = null;
		this.slot[1] = null;
		this.slot[2] = null;
		this.slot[3] = null;
		this.slot[4] = null;
	}
	
	public boolean equipar(int nSlot, Equipamiento eq) {
		boolean f = false;
		if(eq.getBarco()==null&&this.tipoSlot[nSlot]==eq.getTipo()) {
			this.slot[nSlot]=eq;
			eq.setBarco(this);
			f=true;
		}
		return f;
	}
	
	public boolean desEquipar(int nSlot) {
		boolean f = false;
		if(this.slot[nSlot]!=null) {
			this.slot[nSlot].setBarco(null);
			this.slot[nSlot]=null;
			f=true;
		}
		return f;
	}
	
	public String toStringFile() {
		return this.codigo+"*"+this.nombre+"*"+this.clase+"*"+this.faccion+"*"+this.tipo+"*"+this.stats[0]+","+this.stats[1]+","+
				this.stats[2]+","+this.stats[3]+","+this.stats[4]+","+this.stats[5]+","+this.stats[6]+"*"+
				this.tipoSlot[0]+","+this.tipoSlot[1]+","+this.tipoSlot[2];
	}
	
	public String toString(){
		return this.codigo+": "+this.nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getClase() {
		return clase;
	}

	public TipoBarco getTipo() {
		return tipo;
	}

	public int[] getStats() {
		return stats;
	}

	public TipoEquipamiento[] getTipoSlot() {
		return tipoSlot;
	}

	public Equipamiento[] getSlot() {
		return slot;
	}

	public Faccion getFaccion() {
		return faccion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Barco other = (Barco) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	public int compareTo(Barco otro) {
		// TODO Auto-generated method stub
		return this.codigo.compareTo(otro.codigo);
	}

	
	
}
