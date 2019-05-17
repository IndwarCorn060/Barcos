package clases;

public class Equipamiento {
	
	private String cod, nombre;
	private TipoEquipamiento tipo;
	private int dmg;
	private float cd;//damage, cooldown
	private int[] stats;
	private TipoAmmo ammo;
	private Barco barco;
	
	//cod, nombre, tipo, dmg, cd, hp, fp, aa, trp, avi, rld, eva, ammo
	public Equipamiento(String cod, String nombre, TipoEquipamiento tipo, int dmg, float cd, int hp, int fp, int aa, 
						int trp, int avi, int rld, int eva, TipoAmmo ammo) {
		this.cod = cod;
		this.nombre = nombre;
		this.tipo = tipo;
		this.dmg = dmg;
		this.cd = cd;
		this.stats = new int[7];
		this.stats[0] = hp;
		this.stats[1] = fp;
		this.stats[2] = aa;
		this.stats[3] = trp;
		this.stats[4] = avi;
		this.stats[5] = rld;
		this.stats[6] = eva;
		this.ammo = ammo;
		this.barco = null;
	}
	
	public String toString() {
		return this.cod+"*"+this.nombre+"*"+this.tipo+"*"+this.dmg+"*"+this.cd+"*"+this.stats[0]+","+this.stats[1]+","+
				this.stats[2]+","+this.stats[3]+","+this.stats[4]+","+this.stats[5]+","+this.stats[6]+"*"+this.ammo;
	}

	public String getCod() {
		return cod;
	}

	public String getNombre() {
		return nombre;
	}

	public TipoEquipamiento getTipo() {
		return tipo;
	}

	public int getDmg() {
		return dmg;
	}

	public float getCd() {
		return cd;
	}

	public int[] getStats() {
		return stats;
	}

	public TipoAmmo getAmmo() {
		return ammo;
	}
	
	public Barco getBarco() {
		return barco;
	}

	public void setBarco(Barco barco) {
		this.barco = barco;
	}
	
	

}